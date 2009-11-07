package it.unipr.ce.dsg.deus.example.hierarchical.streaming;

import it.unipr.ce.dsg.deus.core.Engine;
import it.unipr.ce.dsg.deus.core.InvalidParamsException;
import it.unipr.ce.dsg.deus.core.Resource;
import it.unipr.ce.dsg.deus.impl.resource.AllocableResource;
import it.unipr.ce.dsg.deus.p2p.node.Peer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

/**
 * 
 * @author Picone Marco
 * 
 */
public class ServerPeer extends Peer {

	private static final String MAX_ACCEPTED_CONNECTION = "maxAcceptedConnection";
	private static final String UPLOAD_SPEED = "uploadSpeed";
	private static final String DOWNLOAD_SPEED = "downloadSpeed";
	private static final String CHUNK_SIZE = "chunkSize";
	private static final String NUMBER_OF_LAYER = "numberOfLayer";
	private static final String MAX_NUMBER_OF_LAYER = "maxNumberOfLayer";
	
	private int maxAcceptedConnection = 0;
	private int activeConnection = 0;
	private int chunkSize = 0;	
	private double uploadSpeed = 0.0;
	private double downloadSpeed = 0.0;
	//private int nodeDepth = 0;
	
	private int numberOfLayer = 0;
	private int maxNumberOfLayer = 0;
	
	
	private double TotalLayerPlayedPc = 0;
	private double TotalChunkPlayedPc = 0;
	private double TotalLayerPlayedMobile = 0;
	private double TotalChunkPlayedMobile = 0;
	private double TotalLayerPlayed3G = 0;
	private double TotalChunkPlayed3G = 0;
	
	
	public double getTotalLayerPlayedPc() {
		return TotalLayerPlayedPc;
	}

	public void setTotalLayerPlayedPc(double totalLayerPlayedPc) {
		TotalLayerPlayedPc = totalLayerPlayedPc;
	}

	public double getTotalChunkPlayedPc() {
		return TotalChunkPlayedPc;
	}

	public void setTotalChunkPlayedPc(double totalChunkPlayedPc) {
		TotalChunkPlayedPc = totalChunkPlayedPc;
	}

	public double getTotalLayerPlayedMobile() {
		return TotalLayerPlayedMobile;
	}

	public void setTotalLayerPlayedMobile(double totalLayerPlayedMobile) {
		TotalLayerPlayedMobile = totalLayerPlayedMobile;
	}

	public double getTotalChunkPlayedMobile() {
		return TotalChunkPlayedMobile;
	}

	public void setTotalChunkPlayedMobile(double totalChunkPlayedMobile) {
		TotalChunkPlayedMobile = totalChunkPlayedMobile;
	}

	public double getTotalLayerPlayed3G() {
		return TotalLayerPlayed3G;
	}

	public void setTotalLayerPlayed3G(double totalLayerPlayed3G) {
		TotalLayerPlayed3G = totalLayerPlayed3G;
	}

	public double getTotalChunkPlayed3G() {
		return TotalChunkPlayed3G;
	}

	public void setTotalChunkPlayed3G(double totalChunkPlayed3G) {
		TotalChunkPlayed3G = totalChunkPlayed3G;
	}

	private double missingChunkNumber   = 0.0; 
	private double totalChunkReceived   = 0.0; 
	private double totalLayerReceived = 0.0;
	private double duplicateLayerNumber = 0.0;
	private double totalDeadine = 0.0;
	private double disconnectedNodes = 0;

	private ArrayList<Integer> missingLayerNumber = null;
	
	//Array per le statistiche dei tempi di ricezione dei nodi che si sono disconnessi
	private ArrayList<Float> arrivalTimesPcNode = new ArrayList<Float>();
	private ArrayList<Float> arrivalTimesMobileWifiNode = new ArrayList<Float>();
	private ArrayList<Float> arrivalTimesMobile3GNode = new ArrayList<Float>();
	
	
	
	public double getTotalDeadine() {
		return totalDeadine;
	}

	public void setTotalDeadine(double totalDeadine) {
		this.totalDeadine = totalDeadine;
	}

	private ArrayList<ServedPeer> servedPeers = new ArrayList<ServedPeer>();
	
	//Array di VideoChunk a sua volra composto da una serie di ChunkLayer
	private ArrayList<VideoChunk> videoResource = new ArrayList<VideoChunk>();
	
	public ServerPeer(String id, Properties params, ArrayList<Resource> resources)
			throws InvalidParamsException {
		super(id, params, resources);
		initialize();
	}

	public void initialize() throws InvalidParamsException {
		
		if (params.containsKey(CHUNK_SIZE))
			chunkSize = Integer.parseInt(params.getProperty(CHUNK_SIZE));
		
		if (params.containsKey(UPLOAD_SPEED))
			uploadSpeed = Double.parseDouble(params.getProperty(UPLOAD_SPEED));
	
		if (params.containsKey(DOWNLOAD_SPEED))
			downloadSpeed = Double.parseDouble(params.getProperty(DOWNLOAD_SPEED));	
		
		if (params.containsKey(NUMBER_OF_LAYER))
			numberOfLayer = Integer.parseInt(params.getProperty(NUMBER_OF_LAYER));
		
		if (params.containsKey(MAX_NUMBER_OF_LAYER))
			this.maxNumberOfLayer = Integer.parseInt(params.getProperty(MAX_NUMBER_OF_LAYER));
		
		for (Iterator<Resource> it = resources.iterator(); it.hasNext(); ) {
			Resource r = it.next();
			if (!(r instanceof AllocableResource))
				continue;
			if ( ((AllocableResource) r).getType().equals(MAX_ACCEPTED_CONNECTION) )
				maxAcceptedConnection = (int) ((AllocableResource) r).getAmount();
		}	
		
		missingLayerNumber = new ArrayList<Integer>();
		for (int i = 0; i<this.getNumberOfLayer(); i++){
			missingLayerNumber.add(0);
		}
		
		this.setConnected(true);
		
	}
	
	public Object clone() {
		
		ServerPeer clone = (ServerPeer) super.clone();
		
		clone.activeConnection = this.activeConnection;
		clone.maxAcceptedConnection = this.maxAcceptedConnection;
		clone.servedPeers = this.servedPeers;
		clone.videoResource = this.videoResource;
		//clone.nodeDepth = 0;
		
		return clone;
	}

	/**
	 * Invia al nodo client di destinazione, la porzione video newResource partendo dal tempo triggerTime
	 * 
	 * @param clientNode
	 * @param newResource
	 * @param triggeringTime
	 */
	
	public void sendChunkLayer(StreamingPeer clientNode,ChunkLayer newResource, float triggeringTime){
		
		//Verifico se devo degradare la velocit� di download del nodo client in base alle sue connessioni in ingresso attive
		double clientDownloadSpeed = 0.0;
		if( clientNode.getDownloadActiveConnection() > 0 )
			clientDownloadSpeed = clientNode.getDownloadSpeed() / (double)clientNode.getDownloadActiveConnection();
		else
			clientDownloadSpeed = clientNode.getDownloadSpeed();
			
		float time = triggeringTime + nextLayerArrivalTime(this.getUploadSpeed(),clientDownloadSpeed,newResource);
			
		//System.out.println("Server Invia: " + newResource.getChunkIndex() + " At: " + time + " To:" + clientNode.getKey());
		
		
	    // TODO: COMMENTATO PER VELOCIZZARE LA SIMULAZIONE
	     
	    StreamingPeerNewVideoResourceEvent newPeerResEvent = (StreamingPeerNewVideoResourceEvent)Engine.getDefault().createEvent(StreamingPeerNewVideoResourceEvent.class,time);	
		newPeerResEvent.setOneShot(true);
		newPeerResEvent.setAssociatedNode(clientNode);
		newPeerResEvent.setResourceValue(newResource);
		Engine.getDefault().insertIntoEventsList(newPeerResEvent);
		
		//TODO: parte aggiunta al posto della precedente per velocizzare simulazione
		/*clientNode.addNewVideoResource(newResource,triggeringTime);
		
		//Innesca per i nodi forniti l'evento di aggiornamento risorsa
		//devi reinviare la risorsa che ho ottenuto a tutti i peer che sto servendo (tenendo conto del layer)
		
		for(int index = 0 ; index < clientNode.getServedPeers().size(); index++)
		{
			
			
			if (clientNode.getServedPeers().get(index).getLayer()== newResource.getLayerIndex()){
			
				getLogger().fine("Sono: " + clientNode.getKey() + " Invio a: " + clientNode.getServedPeers().get(index).getPeer().getKey() + " Layer: " + newResource.getLayerIndex() + " chunk: " + newResource.getChunkIndex());
				//Commentato anche nel codice originale
			  //if (!associatedStreamingNode.getServedPeers().get(index).getPeer().isLayerNeeded(chunkLayer.getChunkIndex(),chunkLayer.getLayerIndex() ) )
			
				
			  //TODO: da rivedere la condizione	
		   	  //if( newResource.getChunkIndex() >  clientNode.getServedPeers().get(index).getPeer().getInitChunk())		
				if (!clientNode.getServedPeers().get(index).getPeer().isLayerNeeded(newResource.getChunkIndex(),newResource.getLayerIndex() ) && newResource.getChunkIndex() >  clientNode.getServedPeers().get(index).getPeer().getInitChunk())
				clientNode.sendChunkLayer(clientNode.getServedPeers().get(index).getPeer(), newResource, triggeringTime);
			}				
			
		}*/
		//END PARTE AGGIUNTA
		
		
	}
		
	/**
	 * Determina  il tempo in cui dovra' essere schedulato il nuovo arrivo di un chunk al destinatario
	 * in base alla velocita' di Upload del fornitore e quella di Downalod del cliente.
	 * @param providerUploadSpeed
	 * @param clientDownloadSpeed
	 * @return
	 */
	private float nextLayerArrivalTime(double providerUploadSpeed, double clientDownloadSpeed, ChunkLayer layer) {
		
		double time = 0.0;
		double uploadSpeed = 0.0;
		if (this.getActiveConnection() > 0)
			uploadSpeed = (providerUploadSpeed  / (double) this.getActiveConnection());
		else
			uploadSpeed = providerUploadSpeed;
			
		double minSpeed = Math.min(  uploadSpeed , clientDownloadSpeed);
		double layerMbitSize = (double)( (double) layer.getLayerSize() / 1024.0 );
		time = (layerMbitSize / minSpeed);
		
		float floatTime = expRandom((float)time);
		
		return floatTime*10;
	}
	
	private float expRandom(float meanValue) {
		float myRandom = (float) (-Math.log(Engine.getDefault().getSimulationRandom().nextFloat()) * meanValue);
		return myRandom;
	}
	
	public void addNewVideoResource(VideoChunk newVideoRes){
		
		this.videoResource.add(newVideoRes);

	}


	public void removeActiveConnection(){
		
		if( this.activeConnection >= 1 )
		 this.activeConnection--;
		else
			System.out.println("ERRORE SERVER PEER ! Connessioni Attive = 0 non posso decrementare");
	}
	
	public void addActiveConnection(){
		
		if( this.activeConnection < this.maxAcceptedConnection )
		 this.activeConnection++;
		else
			System.out.println("ERRORE SERVER PEER ! Connessioni Attive = "+ this.maxAcceptedConnection  +" non posso incrementare");
	}
	
	public void addServedPeer(StreamingPeer peer, int l){
		ServedPeer p = new ServedPeer(peer,l);
		
		if(!this.getServedPeers().contains(p) && !this.equals(p.getPeer()))
			this.getServedPeers().add(p);
	}
	
	//TODO: CONTROLLARE CHE FUNZIONI
	public void removeServedPeer(ServedPeer p){
		this.servedPeers.remove(p);
	}
	
	public VideoChunk getLastChunk() {
		return this.getVideoResource().get(this.getVideoResource().size()-1);
	}
	
	public void setActiveConnection(int activeConnection) {
		this.activeConnection = activeConnection;
	}


	public static String getMAX_ACCEPTED_CONNECTION() {
		return MAX_ACCEPTED_CONNECTION;
	}

	public int getMaxAcceptedConnection() {
		return maxAcceptedConnection;
	}

	public int getActiveConnection() {
		return activeConnection;
	}

	public ArrayList<ServedPeer> getServedPeers() {
		return servedPeers;
	}

	public void setServedPeers(ArrayList<ServedPeer> servedPeers) {
		this.servedPeers = servedPeers;
	}

	public ArrayList<VideoChunk> getVideoResource() {
		return videoResource;
	}

	public void setVideoResource(ArrayList<VideoChunk> videoResource) {
		this.videoResource = videoResource;
	}

	public int getChunkSize() {
		return chunkSize;
	}

	public void setChunkSize(int chunkSize) {
		this.chunkSize = chunkSize;
	}

	public double getUploadSpeed() {
		return uploadSpeed;
	}

	public void setUploadSpeed(double uploadSpeed) {
		this.uploadSpeed = uploadSpeed;
	}

	public double getDownloadSpeed() {
		return downloadSpeed;
	}

	public void setDownloadSpeed(double downloadSpeed) {
		this.downloadSpeed = downloadSpeed;
	}

	public void setMaxAcceptedConnection(int maxAcceptedConnection) {
		this.maxAcceptedConnection = maxAcceptedConnection;
	}

/*	
 * public int getNodeDepth() {
		return nodeDepth;
	}

	public void setNodeDepth(int nodeDepth) {
		this.nodeDepth = nodeDepth;
	}
*/

	public double getMissingChunkNumber() {
		return missingChunkNumber;
	}

	public void setMissingChunkNumber(double missingChunkNumber) {
		this.missingChunkNumber = missingChunkNumber;
	}

	public double getTotalChunkReceived() {
		return totalChunkReceived;
	}

	public void setTotalChunkReceived(double totalChunkReceived) {
		this.totalChunkReceived = totalChunkReceived;
	}

	public double getDuplicateLayerNumber() {
		return duplicateLayerNumber;
	}

	public void setDuplicateLayerNumber(double duplicateLayerNumber) {
		this.duplicateLayerNumber = duplicateLayerNumber;
	}

	public double getDisconnectedNodes() {
		return disconnectedNodes;
	}

	public void setDisconnectedNodes(double disconnectedNodes) {
		this.disconnectedNodes = disconnectedNodes;
	}
	
	public void addDisconnectedNode(){
		this.disconnectedNodes++;
	}

	public ArrayList<Float> getArrivalTimesPcNode() {
		return arrivalTimesPcNode;
	}

	public void setArrivalTimesPcNode(ArrayList<Float> arrivalTimesPcNode) {
		this.arrivalTimesPcNode = arrivalTimesPcNode;
	}

	public ArrayList<Float> getArrivalTimesMobileWifiNode() {
		return arrivalTimesMobileWifiNode;
	}

	public void setArrivalTimesMobileWifiNode(
			ArrayList<Float> arrivalTimesMobileWifiNode) {
		this.arrivalTimesMobileWifiNode = arrivalTimesMobileWifiNode;
	}

	public ArrayList<Float> getArrivalTimesMobile3GNode() {
		return arrivalTimesMobile3GNode;
	}

	public void setArrivalTimesMobile3GNode(
			ArrayList<Float> arrivalTimesMobile3GNode) {
		this.arrivalTimesMobile3GNode = arrivalTimesMobile3GNode;
	}

	public int getMaxNumberOfLayer() {
		return maxNumberOfLayer;
	}

	public void setMaxNumberOfLayer(int maxNumberOfLayer) {
		this.maxNumberOfLayer = maxNumberOfLayer;
	}

	public int getNumberOfLayer() {
		return numberOfLayer;
	}

	public void setNumberOfLayer(int numberOfLayer) {
		this.numberOfLayer = numberOfLayer;
	}

	public double getTotalLayerReceived() {
		return totalLayerReceived;
	}

	public void setTotalLayerReceived(double totalLayerReceived) {
		this.totalLayerReceived = totalLayerReceived;
	}

	public ArrayList<Integer> getMissingLayerNumber() {
		return missingLayerNumber;
	}

	public void setMissingLayerNumber(ArrayList<Integer> missingLayerNumber) {
		this.missingLayerNumber = missingLayerNumber;
	}
	
	
	
}
