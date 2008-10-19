package it.unipr.ce.dsg.deus.example.simpleDataDriven;
import it.unipr.ce.dsg.deus.core.Engine;
import it.unipr.ce.dsg.deus.core.InvalidParamsException;
import it.unipr.ce.dsg.deus.core.NodeEvent;
import it.unipr.ce.dsg.deus.core.Process;
import it.unipr.ce.dsg.deus.core.RunException;

import java.util.Properties;


/**
 * <p>
 * This event is related to the release of a previously 
 * consumed resource, by updating the corresponding value 
 * on the resource owner.
 * </p>
 * 
 * @author Michele Amoretti (michele.amoretti@unipr.it)
 *
 */
public class Streaming3GTo2GEvent extends NodeEvent {

	private static final String NEW_MAX_ACCEPTED_CONNECTION = "newMaxAcceptedConnection";
	private static final String NEW_UPLOAD_SPEED = "newUploadSpeed";
	
	private int newMaxAcceptedConnection = 0;
	private double newUploadSpeed;

	public Streaming3GTo2GEvent(String id, Properties params,
			Process parentProcess) throws InvalidParamsException {
		super(id, params, parentProcess);
		initialize();
		
		System.out.println("Streaming3GTo2GEvent");
	}

	public void initialize() throws InvalidParamsException {
		
		if (params.containsKey(NEW_MAX_ACCEPTED_CONNECTION))
			newMaxAcceptedConnection  = Integer.parseInt(params.getProperty(NEW_MAX_ACCEPTED_CONNECTION));
		
		if (params.containsKey(NEW_UPLOAD_SPEED))
			newUploadSpeed  = Double.parseDouble(params.getProperty(NEW_UPLOAD_SPEED));
	}	
	
	public Object clone() {
		
		Streaming3GTo2GEvent clone = (Streaming3GTo2GEvent) super.clone();
		clone.newMaxAcceptedConnection = this.newMaxAcceptedConnection;
		clone.newUploadSpeed = this.newUploadSpeed;
		return clone;
	}

	public void run() throws RunException {
		
		getLogger().fine("## new 3G --> 2G Event");
		
		StreamingPeer associatedStreamingNode = (StreamingPeer) associatedNode;
		
		associatedStreamingNode.change3GTo2G(StreamingPeer.G2, this.newUploadSpeed, this.newMaxAcceptedConnection,this.triggeringTime);
		
		getLogger().fine("end new 3G --> 2G Event ##");
	}

	public int getNewMaxAcceptedConnection() {
		return newMaxAcceptedConnection;
	}
	
}
