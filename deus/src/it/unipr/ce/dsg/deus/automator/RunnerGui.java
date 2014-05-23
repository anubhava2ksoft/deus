package it.unipr.ce.dsg.deus.automator;

import it.unipr.ce.dsg.deus.automator.gui.SimulationSummaryFrame;


import java.io.IOException;

import javax.swing.JProgressBar;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


/**
 * 
 * @author Marco Picone (picone.m@gmail.com)
 * @author Marco Pigoni
 * 
 * @author Stefano Sebastio (stefano.sebastio@imtlucca.it) [only Runner refactoring]
 * 
 */
public class RunnerGui extends Runner {

	private JProgressBar simulationProgressBar = null;
	
	public RunnerGui(String originalXml, String automatorXml) {
		super(originalXml, automatorXml);
	}

	/**
	 * This method starts Deus
	 * 
	 * @param originalXml
	 *            , name of the base configuration file
	 * @param automatorXml
	 *            , name of the file that automates the simulations
	 * @throws ParserConfigurationException
	 */
	public int start(String originalXml, String automatorXml)
			throws DeusAutomatorException, JAXBException, SAXException,
			IOException, ParserConfigurationException {

		int result = super.start(originalXml, automatorXml);
		
		String summary = new String(cbuf);

		// Execute the GUI showing the summary of the simulation
		SimulationSummaryFrame simulationsummary = new SimulationSummaryFrame(
				this);
		simulationsummary.getSimulationSummaryTextArea().setText(summary);
		simulationsummary.setVisible(true);

		return result;
	}

	/**
	 * 
	 */
	public void runSimulations() {
		if (simulationProgressBar != null) {
			simulationProgressBar.setMaximum(files.size());
			simulationProgressBar.setMinimum(0);
		}

		//System.out.println("runSimulations()");
		
		simulationProgressBar.setValue(0);

		super.runSimulations();

	}
	
	public JProgressBar getSimulationProgressBar() {
		return simulationProgressBar;
	}

	public void setSimulationProgressBar(JProgressBar simulationProgressBar) {
		this.simulationProgressBar = simulationProgressBar;
	}

}