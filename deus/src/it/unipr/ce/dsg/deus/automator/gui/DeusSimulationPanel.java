package it.unipr.ce.dsg.deus.automator.gui;

import java.net.InetAddress;
import java.util.ArrayList;

/**
 * 
 * @author Marco Picone (picone.m@gmail.com)
 * 
 */
@SuppressWarnings("serial")
public class DeusSimulationPanel extends javax.swing.JPanel {

	public static ArrayList<ArrayList<Object>> simulations = new ArrayList<ArrayList<Object>>();
	private NodeParameterTableModel nodeParameterTableModel;
	private NodeResourceTableModel nodeResourceTableModel;
	private ProcessParameterTableModel processParameterTableModel;
	private EngineParameterTableModel engineParameterTableModel;
	private ArrayList<NodeParameter> nodeParameterList;
	private ArrayList<NodeResource> nodeResourceList;
	private ArrayList<ProcessParameter> processParameterList;
	private ArrayList<EngineParameter> engineParameterList;
	private javax.swing.JTabbedPane simulationTabbedPane;
	private GnuPlotFileTableModel gnuPlotFileTableModel;
	private ArrayList<GnuPlotFileElement> gnuPlotFileList;

	/** Creates new form DeusSimulationPanel */
	public DeusSimulationPanel(javax.swing.JTabbedPane simulationTabbedPane) {
		this.simulationTabbedPane = simulationTabbedPane;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		nodeParameterTableModel = new NodeParameterTableModel();
		nodeResourceTableModel = new NodeResourceTableModel();
		processParameterTableModel = new ProcessParameterTableModel();
		engineParameterTableModel = new EngineParameterTableModel();
		gnuPlotFileTableModel = new GnuPlotFileTableModel();

		nodeParameterList = new ArrayList<NodeParameter>();
		nodeResourceList = new ArrayList<NodeResource>();
		processParameterList = new ArrayList<ProcessParameter>();
		engineParameterList = new ArrayList<EngineParameter>();
		gnuPlotFileList = new ArrayList<GnuPlotFileElement>();

		nodeParameterLabel = new javax.swing.JLabel();
		nodeResourceScrollPane = new javax.swing.JScrollPane();
		nodeResourceTable = new javax.swing.JTable();
		nodeResourceLabel = new javax.swing.JLabel();
		nodeParameterScrollPane = new javax.swing.JScrollPane();
		nodeParameterTable = new javax.swing.JTable();
		simulationNameLabel = new javax.swing.JLabel();
		simulationNameField = new javax.swing.JTextField();
		setSimulationNameButton = new javax.swing.JButton();
		processScrollPane = new javax.swing.JScrollPane();
		processTable = new javax.swing.JTable();
		processLabel = new javax.swing.JLabel();
		engineLabel = new javax.swing.JLabel();
		engineScrollPane = new javax.swing.JScrollPane();
		engineTable = new javax.swing.JTable();
		gnuPlotFileScrollPane = new javax.swing.JScrollPane();
		gnuPlotFileTable = new javax.swing.JTable();
		removeNodeParameterLabel = new javax.swing.JLabel();
		addNodeParameterLabel = new javax.swing.JLabel();
		removeProcessLabel = new javax.swing.JLabel();
		addProcessLabel = new javax.swing.JLabel();
		removeNodeResourceLabel = new javax.swing.JLabel();
		addNodeResourceLabel = new javax.swing.JLabel();
		removeEngineLabel = new javax.swing.JLabel();
		addEngineLabel = new javax.swing.JLabel();
		gnuPlotLabel = new javax.swing.JLabel();
		removeGnuPlotLabel = new javax.swing.JLabel();
		addGnuPlotLabel = new javax.swing.JLabel();

		nodeParameterLabel.setText("Node Parameter");

		nodeParameterTableModel.set_FileTableModel(nodeParameterList);

		nodeParameterTable.setModel(nodeParameterTableModel);
		nodeParameterScrollPane.setViewportView(nodeParameterTable);

		nodeResourceLabel.setText("Node Resource");

		nodeResourceTableModel.set_FileTableModel(nodeResourceList);
		nodeResourceTable.setModel(nodeResourceTableModel);
		nodeResourceScrollPane.setViewportView(nodeResourceTable);

		simulationNameLabel.setText("Simulation Name");

		simulationNameField.setText("Simulation Name");

		setSimulationNameButton.setText("Set");
		setSimulationNameButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						setSimulationNameButtonActionPerformed(evt);
					}
				});

		processLabel.setText("Process");
		processParameterTableModel.set_FileTableModel(processParameterList);
		processTable.setModel(processParameterTableModel);
		processScrollPane.setViewportView(processTable);

		engineLabel.setText("Engine");
		engineParameterTableModel.set_FileTableModel(engineParameterList);
		engineTable.setModel(engineParameterTableModel);
		engineScrollPane.setViewportView(engineTable);

		gnuPlotFileTableModel.set_FileTableModel(gnuPlotFileList);
		gnuPlotFileTable.setModel(gnuPlotFileTableModel);
		gnuPlotFileScrollPane.setViewportView(gnuPlotFileTable);

		removeNodeParameterLabel.setIcon(new javax.swing.ImageIcon(
				("res/remove.png"))); // NOI18N
		removeNodeParameterLabel
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mousePressed(java.awt.event.MouseEvent evt) {
						removeNodeParameterLabelMousePressed(evt);
					}

					public void mouseReleased(java.awt.event.MouseEvent evt) {
						removeNodeParameterLabelMouseReleased(evt);
					}

					public void mouseClicked(java.awt.event.MouseEvent evt) {
						removeNodeParameterLabelMouseClicked(evt);
					}
				});

		addNodeParameterLabel
				.setIcon(new javax.swing.ImageIcon(("res/add.png"))); // NOI18N
		addNodeParameterLabel
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mousePressed(java.awt.event.MouseEvent evt) {
						addNodeParameterLabelMousePressed(evt);
					}

					public void mouseReleased(java.awt.event.MouseEvent evt) {
						addNodeParameterLabelMouseReleased(evt);
					}

					public void mouseClicked(java.awt.event.MouseEvent evt) {
						addNodeParameterLabelMouseClicked(evt);
					}
				});

		removeProcessLabel
				.setIcon(new javax.swing.ImageIcon(("res/remove.png"))); // NOI18N
		removeProcessLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				removeProcessLabelMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				removeProcessLabelMouseReleased(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				removeProcessLabelMouseClicked(evt);
			}
		});

		addProcessLabel.setIcon(new javax.swing.ImageIcon(("res/add.png"))); // NOI18N
		addProcessLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				addProcessLabelMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				addProcessLabelMouseReleased(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				addProcessLabelMouseClicked(evt);
			}
		});

		removeNodeResourceLabel.setIcon(new javax.swing.ImageIcon(
				("res/remove.png"))); // NOI18N
		removeNodeResourceLabel
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mousePressed(java.awt.event.MouseEvent evt) {
						removeNodeResourceLabelMousePressed(evt);
					}

					public void mouseReleased(java.awt.event.MouseEvent evt) {
						removeNodeResourceLabelMouseReleased(evt);
					}

					public void mouseClicked(java.awt.event.MouseEvent evt) {
						removeNodeResourceLabelMouseClicked(evt);
					}
				});

		addNodeResourceLabel
				.setIcon(new javax.swing.ImageIcon(("res/add.png"))); // NOI18N
		addNodeResourceLabel
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mousePressed(java.awt.event.MouseEvent evt) {
						addNodeResourceLabelMousePressed(evt);
					}

					public void mouseReleased(java.awt.event.MouseEvent evt) {
						addNodeResourceLabelMouseReleased(evt);
					}

					public void mouseClicked(java.awt.event.MouseEvent evt) {
						addNodeResourceLabelMouseClicked(evt);
					}
				});

		removeEngineLabel
				.setIcon(new javax.swing.ImageIcon(("res/remove.png"))); // NOI18N
		removeEngineLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				removeEngineLabelMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				removeEngineLabelMouseReleased(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				removeEngineLabelMouseClicked(evt);
			}
		});

		addEngineLabel.setIcon(new javax.swing.ImageIcon(("res/add.png"))); // NOI18N
		addEngineLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				addEngineLabelMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				addEngineLabelMouseReleased(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				addEngineLabelMouseClicked(evt);
			}
		});

		gnuPlotLabel.setText("GnuPlot File");

		removeGnuPlotLabel
				.setIcon(new javax.swing.ImageIcon(("res/remove.png"))); // NOI18N
		removeGnuPlotLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				removeGnuPlotLabelMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				removeGnuPlotLabelMouseReleased(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				removeGnuPlotLabelMouseClicked(evt);
			}
		});

		addGnuPlotLabel.setIcon(new javax.swing.ImageIcon(("res/add.png"))); // NOI18N
		addGnuPlotLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				addGnuPlotLabelMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				addGnuPlotLabelMouseReleased(evt);
			}

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				addGnuPlotLabelMouseClicked(evt);
			}
		});

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout
						.createSequentialGroup()
						.addContainerGap()
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.LEADING)
								.add(layout
										.createSequentialGroup()
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(layout
														.createSequentialGroup()
														.add(addNodeParameterLabel)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.RELATED)
														.add(removeNodeParameterLabel)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.RELATED)
														.add(nodeParameterLabel))
												.add(nodeParameterScrollPane,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(layout
														.createSequentialGroup()
														.add(addNodeResourceLabel)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.RELATED)
														.add(removeNodeResourceLabel)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.UNRELATED)
														.add(nodeResourceLabel))
												.add(nodeResourceScrollPane,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														454, Short.MAX_VALUE)))
								.add(layout
										.createSequentialGroup()
										.add(gnuPlotFileScrollPane,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.add(8, 8, 8)
										.add(simulationNameField,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												241,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(setSimulationNameButton))
								.add(layout
										.createSequentialGroup()
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(processScrollPane,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(layout
														.createSequentialGroup()
														.add(addProcessLabel)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.RELATED)
														.add(removeProcessLabel)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.RELATED)
														.add(processLabel))
												.add(layout
														.createSequentialGroup()
														.add(addGnuPlotLabel)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.RELATED)
														.add(removeGnuPlotLabel)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.UNRELATED)
														.add(gnuPlotLabel)))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(simulationNameLabel)
												.add(layout
														.createSequentialGroup()
														.add(addEngineLabel)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.RELATED)
														.add(removeEngineLabel)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.UNRELATED)
														.add(engineLabel))
												.add(engineScrollPane,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														454, Short.MAX_VALUE))))
						.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout
						.createSequentialGroup()
						.add(30, 30, 30)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(nodeParameterLabel)
								.add(addNodeParameterLabel)
								.add(removeNodeParameterLabel)
								.add(addNodeResourceLabel)
								.add(removeNodeResourceLabel)
								.add(nodeResourceLabel))
						.add(8, 8, 8)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.LEADING,
										false)
								.add(nodeResourceScrollPane, 0, 0,
										Short.MAX_VALUE)
								.add(nodeParameterScrollPane,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										106, Short.MAX_VALUE))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(addProcessLabel).add(removeProcessLabel)
								.add(processLabel).add(addEngineLabel)
								.add(removeEngineLabel).add(engineLabel))
						.add(8, 8, 8)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.LEADING,
										false)
								.add(engineScrollPane, 0, 0, Short.MAX_VALUE)
								.add(processScrollPane,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										106,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.UNRELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(addGnuPlotLabel).add(removeGnuPlotLabel)
								.add(gnuPlotLabel).add(simulationNameLabel))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.LEADING)
								.add(gnuPlotFileScrollPane,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										106,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(layout
										.createParallelGroup(
												org.jdesktop.layout.GroupLayout.BASELINE)
										.add(simulationNameField,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.add(setSimulationNameButton)))
						.addContainerGap()));
	}// </editor-fold>//GEN-END:initComponents

	private void addNodeParameterLabelMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addNodeParameterLabelMouseClicked
		addNodeParameter(new NodeParameter());
	}// GEN-LAST:event_addNodeParameterLabelMouseClicked

	private void addNodeParameterLabelMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addNodeParameterLabelMousePressed
		addNodeParameterLabel.setIcon(new javax.swing.ImageIcon(
				("res/add_BN.png")));
	}// GEN-LAST:event_addNodeParameterLabelMousePressed

	private void addNodeParameterLabelMouseReleased(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addNodeParameterLabelMouseReleased
		addNodeParameterLabel
				.setIcon(new javax.swing.ImageIcon(("res/add.png")));
	}// GEN-LAST:event_addNodeParameterLabelMouseReleased

	private void removeNodeParameterLabelMouseClicked(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeNodeParameterLabelMouseClicked
		int tableRow = this.nodeParameterTable.getSelectedRow();

		int totalTableRow = this.nodeParameterTable.getSelectedRowCount();

		if (totalTableRow == this.nodeParameterList.size()) {
			nodeParameterList.clear();

			nodeParameterTableModel = new NodeParameterTableModel();
			nodeParameterTableModel.set_FileTableModel(nodeParameterList);

			nodeParameterTable.setModel(nodeParameterTableModel);

			tableRow = -1;

		}

		if (tableRow != -1) {
			nodeParameterList.remove(tableRow);

			nodeParameterTableModel = new NodeParameterTableModel();
			nodeParameterTableModel.set_FileTableModel(nodeParameterList);

			nodeParameterTable.setModel(nodeParameterTableModel);
		}
	}// GEN-LAST:event_removeNodeParameterLabelMouseClicked

	private void removeNodeParameterLabelMousePressed(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeNodeParameterLabelMousePressed
		removeNodeParameterLabel.setIcon(new javax.swing.ImageIcon(
				("res/remove_BN.png")));
	}// GEN-LAST:event_removeNodeParameterLabelMousePressed

	private void removeNodeParameterLabelMouseReleased(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeNodeParameterLabelMouseReleased
		removeNodeParameterLabel.setIcon(new javax.swing.ImageIcon(
				("res/remove.png")));
	}// GEN-LAST:event_removeNodeParameterLabelMouseReleased

	private void addNodeResourceLabelMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addNodeResourceLabelMouseClicked
		addNodeResource(new NodeResource());
	}// GEN-LAST:event_addNodeResourceLabelMouseClicked

	private void addNodeResourceLabelMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addNodeResourceLabelMousePressed
		addNodeResourceLabel.setIcon(new javax.swing.ImageIcon(
				("res/add_BN.png")));
	}// GEN-LAST:event_addNodeResourceLabelMousePressed

	private void addNodeResourceLabelMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addNodeResourceLabelMouseReleased
		addNodeResourceLabel
				.setIcon(new javax.swing.ImageIcon(("res/add.png")));
	}// GEN-LAST:event_addNodeResourceLabelMouseReleased

	private void removeNodeResourceLabelMouseClicked(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeNodeResourceLabelMouseClicked
		int tableRow = this.nodeResourceTable.getSelectedRow();

		int totalTableRow = this.nodeResourceTable.getSelectedRowCount();

		if (totalTableRow == this.nodeResourceList.size()) {
			nodeResourceList.clear();

			nodeResourceTableModel = new NodeResourceTableModel();
			nodeResourceTableModel.set_FileTableModel(nodeResourceList);

			nodeResourceTable.setModel(nodeResourceTableModel);

			tableRow = -1;

		}

		if (tableRow != -1) {
			nodeResourceList.remove(tableRow);

			nodeResourceTableModel = new NodeResourceTableModel();
			nodeResourceTableModel.set_FileTableModel(nodeResourceList);

			nodeResourceTable.setModel(nodeResourceTableModel);
		}
	}// GEN-LAST:event_removeNodeResourceLabelMouseClicked

	private void removeNodeResourceLabelMousePressed(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeNodeResourceLabelMousePressed
		removeNodeResourceLabel.setIcon(new javax.swing.ImageIcon(
				("res/remove_BN.png")));
	}// GEN-LAST:event_removeNodeResourceLabelMousePressed

	private void removeNodeResourceLabelMouseReleased(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeNodeResourceLabelMouseReleased
		removeNodeResourceLabel.setIcon(new javax.swing.ImageIcon(
				("res/remove.png")));
	}// GEN-LAST:event_removeNodeResourceLabelMouseReleased

	private void addProcessLabelMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addProcessLabelMouseClicked
		addProcessParameter(new ProcessParameter());
	}// GEN-LAST:event_addProcessLabelMouseClicked

	private void addProcessLabelMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addProcessLabelMousePressed
		addProcessLabel.setIcon(new javax.swing.ImageIcon(("res/add_BN.png")));
	}// GEN-LAST:event_addProcessLabelMousePressed

	private void addProcessLabelMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addProcessLabelMouseReleased
		addProcessLabel.setIcon(new javax.swing.ImageIcon(("res/add.png")));
	}// GEN-LAST:event_addProcessLabelMouseReleased

	private void removeProcessLabelMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeProcessLabelMouseClicked
		int tableRow = this.processTable.getSelectedRow();

		int totalTableRow = this.processTable.getSelectedRowCount();

		if (totalTableRow == this.processParameterList.size()) {
			processParameterList.clear();

			processParameterTableModel = new ProcessParameterTableModel();
			processParameterTableModel.set_FileTableModel(processParameterList);

			processTable.setModel(processParameterTableModel);

			tableRow = -1;

		}

		if (tableRow != -1) {
			processParameterList.remove(tableRow);

			processParameterTableModel = new ProcessParameterTableModel();
			processParameterTableModel.set_FileTableModel(processParameterList);

			processTable.setModel(processParameterTableModel);
		}
	}// GEN-LAST:event_removeProcessLabelMouseClicked

	private void removeProcessLabelMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeProcessLabelMousePressed
		removeProcessLabel.setIcon(new javax.swing.ImageIcon(
				("res/remove_BN.png")));
	}// GEN-LAST:event_removeProcessLabelMousePressed

	private void removeProcessLabelMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeProcessLabelMouseReleased
		removeProcessLabel
				.setIcon(new javax.swing.ImageIcon(("res/remove.png")));
	}// GEN-LAST:event_removeProcessLabelMouseReleased

	private void addEngineLabelMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addEngineLabelMouseClicked
		addEngineParameter(new EngineParameter());
	}// GEN-LAST:event_addEngineLabelMouseClicked

	private void addEngineLabelMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addEngineLabelMousePressed
		addEngineLabel.setIcon(new javax.swing.ImageIcon(("res/add_BN.png")));
	}// GEN-LAST:event_addEngineLabelMousePressed

	private void addEngineLabelMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addEngineLabelMouseReleased
		addEngineLabel.setIcon(new javax.swing.ImageIcon(("res/add.png")));
	}// GEN-LAST:event_addEngineLabelMouseReleased

	private void removeEngineLabelMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeEngineLabelMouseClicked

		int tableRow = this.engineTable.getSelectedRow();

		int totalTableRow = this.engineTable.getSelectedRowCount();

		if (totalTableRow == this.engineParameterList.size()) {
			engineParameterList.clear();

			engineParameterTableModel = new EngineParameterTableModel();
			engineParameterTableModel.set_FileTableModel(engineParameterList);

			engineTable.setModel(engineParameterTableModel);

			tableRow = -1;

		}

		if (tableRow != -1) {
			engineParameterList.remove(tableRow);

			engineParameterTableModel = new EngineParameterTableModel();
			engineParameterTableModel.set_FileTableModel(engineParameterList);

			engineTable.setModel(engineParameterTableModel);
		}

	}// GEN-LAST:event_removeEngineLabelMouseClicked

	private void removeEngineLabelMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeEngineLabelMousePressed
		removeEngineLabel.setIcon(new javax.swing.ImageIcon(
				("res/remove_BN.png")));
	}// GEN-LAST:event_removeEngineLabelMousePressed

	private void removeEngineLabelMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeEngineLabelMouseReleased
		removeEngineLabel
				.setIcon(new javax.swing.ImageIcon(("res/remove.png")));
	}// GEN-LAST:event_removeEngineLabelMouseReleased

	private void addGnuPlotLabelMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addGnuPlotLabelMouseClicked
		addGnuPlotFileElement(new GnuPlotFileElement());
	}// GEN-LAST:event_addGnuPlotLabelMouseClicked

	private void addGnuPlotLabelMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addGnuPlotLabelMousePressed
		addGnuPlotLabel.setIcon(new javax.swing.ImageIcon(("res/add_BN.png")));
	}// GEN-LAST:event_addGnuPlotLabelMousePressed

	private void addGnuPlotLabelMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addGnuPlotLabelMouseReleased
		addGnuPlotLabel.setIcon(new javax.swing.ImageIcon(("res/add.png")));
	}// GEN-LAST:event_addGnuPlotLabelMouseReleased

	private void removeGnuPlotLabelMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeGnuPlotLabelMouseClicked
		int tableRow = this.gnuPlotFileTable.getSelectedRow();

		int totalTableRow = this.gnuPlotFileTable.getSelectedRowCount();

		if (totalTableRow == this.gnuPlotFileList.size()) {
			gnuPlotFileList.clear();

			gnuPlotFileTableModel = new GnuPlotFileTableModel();
			gnuPlotFileTableModel.set_FileTableModel(gnuPlotFileList);

			gnuPlotFileTable.setModel(gnuPlotFileTableModel);

			tableRow = -1;

		}

		if (tableRow != -1) {
			gnuPlotFileList.remove(tableRow);

			gnuPlotFileTableModel = new GnuPlotFileTableModel();
			gnuPlotFileTableModel.set_FileTableModel(gnuPlotFileList);

			gnuPlotFileTable.setModel(gnuPlotFileTableModel);
		}
	}// GEN-LAST:event_removeGnuPlotLabelMouseClicked

	private void removeGnuPlotLabelMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeGnuPlotLabelMousePressed
		removeGnuPlotLabel.setIcon(new javax.swing.ImageIcon(
				("res/remove_BN.png")));
	}// GEN-LAST:event_removeGnuPlotLabelMousePressed

	private void removeGnuPlotLabelMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_removeGnuPlotLabelMouseReleased
		removeGnuPlotLabel
				.setIcon(new javax.swing.ImageIcon(("res/remove.png")));
	}// GEN-LAST:event_removeGnuPlotLabelMouseReleased

	private void setSimulationNameButtonActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_setSimulationNameButtonActionPerformed

		int index = this.simulationTabbedPane.getSelectedIndex();
		String title = this.simulationNameField.getText().trim();

		this.simulationTabbedPane.setTitleAt(index, title);

	}// GEN-LAST:event_setSimulationNameButtonActionPerformed

	public String createSimulationXML(String simulationTitle, int i) {

		String xmlString = "";

		// <simulation simulationNumberSeed="6"
		// simulationName="speedSimulation">
		xmlString = xmlString + "<simulation simulationNumberSeed=\""
				+ this.engineParameterList.size() + "\" simulationName=\""
				+ simulationTitle + "\">\n";

		// Creo l'arrayList per i nodi da scrivere sul file XML
		nodeList = new ArrayList<Node>();

		// Analizzo i NodeParameter Presenti
		for (int index = 0; index < this.nodeParameterList.size(); index++) {

			NodeParameter nodeParameter = this.nodeParameterList.get(index);
			Node appNode = new Node(nodeParameter.getNodeId());

			int position = this.nodeList.indexOf(appNode);

			// Se non presente in lista un nodo con lo stesso ID
			if (position == -1) {
				appNode.getNodeParameterList().add(nodeParameter);
				this.nodeList.add(appNode);
			} else {
				this.nodeList.get(position).getNodeParameterList()
						.add(nodeParameter);
			}
		}

		// Analizzo i NodeResource Presenti
		for (int index = 0; index < this.nodeResourceList.size(); index++) {

			NodeResource nodeResource = this.nodeResourceList.get(index);
			Node appNode = new Node(nodeResource.getNodeId());

			int position = this.nodeList.indexOf(appNode);

			// Se non presente in lista un nodo con lo stesso ID
			if (position == -1) {
				appNode.getNodeResourceList().add(nodeResource);
				this.nodeList.add(appNode);
			} else {
				this.nodeList.get(position).getNodeResourceList()
						.add(nodeResource);
			}
		}

		ArrayList<Object> app = new ArrayList<Object>();

		// Stampo i nodi ottenuti
		for (int index = 0; index < this.nodeList.size(); index++) {
			app.add(this.nodeList.get(index));
			xmlString = xmlString + this.nodeList.get(index).getXMLTag();
		}

		/**
		 * Scrittura dei Processi
		 * 
		 * <process id="serverPoisson1"> <paramName name="meanArrival">
		 * <initialValue>10</initialValue> <finalValue>60</finalValue>
		 * <stepValue>10</stepValue> </paramName> </process>
		 */
		for (int index = 0; index < this.processParameterList.size(); index++) {
			app.add(this.processParameterList.get(index));
			ProcessParameter processParameter = this.processParameterList
					.get(index);
			xmlString = xmlString + "\n" + "<process id=\""
					+ processParameter.getProcessId() + "\">";
			xmlString = xmlString + "\n\t" + "<paramName name=\""
					+ processParameter.getParamName() + "\">";
			xmlString = xmlString + "\n\t\t" + "<initialValue>"
					+ processParameter.getInitialValue() + "</initialValue>";
			xmlString = xmlString + "\n\t\t" + "<finalValue>"
					+ processParameter.getFinalValue() + "</finalValue>";
			xmlString = xmlString + "\n\t\t" + "<stepValue>"
					+ processParameter.getStepValue() + "</stepValue>";
			xmlString = xmlString + "\n\t" + "</paramName>" + "\t";
			xmlString = xmlString + "\n" + "</process>" + "\n\t";
		}

		/**
		 * Scrittura dei valori dell Engine
		 * 
		 * <engine startVT="20000" endVT="20000" stepVT="0"> <seed>
		 * <seedValue>023456789</seedValue> <seedValue>023456788</seedValue>
		 * <seedValue>023456787</seedValue> <seedValue>023456786</seedValue>
		 * <seedValue>023456785</seedValue> </seed> </engine>
		 * 
		 */
		xmlString = xmlString + "\n" + "<engine>";
		xmlString = xmlString + "\n\t" + "<seed>";
		for (int index = 0; index < this.engineParameterList.size(); index++) {
			app.add(this.engineParameterList.get(index));
			EngineParameter engineParameter = this.engineParameterList
					.get(index);
			xmlString = xmlString + "\n\t\t" + "<seedValue>"
					+ engineParameter.getSeedValue() + "</seedValue>";
		}
		xmlString = xmlString + "\n\t" + "</seed>";
		xmlString = xmlString + "\n" + "</engine>" + "\n\n";

		/*
		 * 
		 * <!-- Elaborazione Risultati --> <resultVT
		 * outputLogFile="logger.dat"/> <resultXYFile fileName="prova"
		 * axisX="VT" axisY="Continuity Index" /> </simulation>
		 */

		String computerName = "";
		try {
			computerName = InetAddress.getLocalHost().getHostName();
			// System.out.println(computerName);
		} catch (Exception e) {
			System.out.println("Exception caught =" + e.getMessage());
		}
		String simulationName = this.simulationNameField.getText();
		xmlString = xmlString + "<resultVT outputLogFile=\"./temp/"
				+ computerName + "-" + simulationName + "-" + "logger\"/>"
				+ "\n\n";
		// xmlString = xmlString + "<resultVT outputLogFile=\"./temp/logger\"/>"
		// + "\n\n"; originale

		// System.out.println("Simulation name = " +
		// this.simulationNameField.getText());

		// Inserimento File Grafici GnuPlot
		for (int index = 0; index < this.gnuPlotFileList.size(); index++) {
			GnuPlotFileElement gnuElem = this.gnuPlotFileList.get(index);
			xmlString = xmlString + "<resultXYFile fileName=\""
					+ gnuElem.getFileName() + "\" axisX=\""
					+ gnuElem.getXLabel() + "\" axisY=\"" + gnuElem.getYLabel()
					+ "\" />\n";
		}

		// xmlString = xmlString +
		// "<resultXYFile fileName=\"prova\" axisX=\"VT\" axisY=\"Continuity Index\" />\n";
		// xmlString = xmlString +
		// "<resultXYFile fileName=\"prova\" axisX=\"VT\" axisY=\"Duplicate %\" />\n";

		xmlString = xmlString + "\n" + "</simulation>\n";

		simulations.add(i, app);

		return xmlString;
	}

	/**
	 * Aggiunge un nuovo NodeParameter alla Tabella
	 * 
	 * @param nodeParameter
	 */
	public void addNodeParameter(NodeParameter nodeParameter) {
		nodeParameterList.add(nodeParameter);

		nodeParameterTableModel = new NodeParameterTableModel();
		nodeParameterTableModel.set_FileTableModel(nodeParameterList);

		nodeParameterTable.setModel(nodeParameterTableModel);
	}

	/**
	 * Aggiunge un nuovo NodeResource alla tabella
	 * 
	 * @param nodeResource
	 */
	public void addNodeResource(NodeResource nodeResource) {
		nodeResourceList.add(nodeResource);

		nodeResourceTableModel = new NodeResourceTableModel();
		nodeResourceTableModel.set_FileTableModel(nodeResourceList);

		nodeResourceTable.setModel(nodeResourceTableModel);
	}

	/**
	 * Aggiunge un nuovo ProcessParameter alla tabella
	 * 
	 * @param processParameter
	 */
	public void addProcessParameter(ProcessParameter processParameter) {
		processParameterList.add(processParameter);

		processParameterTableModel = new ProcessParameterTableModel();
		processParameterTableModel.set_FileTableModel(processParameterList);

		processTable.setModel(processParameterTableModel);
	}

	/**
	 * Aggiunge un nuovo EngineParameter alla tabella
	 * 
	 * @param engineParameter
	 */
	public void addEngineParameter(EngineParameter engineParameter) {
		engineParameterList.add(engineParameter);

		engineParameterTableModel = new EngineParameterTableModel();
		engineParameterTableModel.set_FileTableModel(engineParameterList);

		engineTable.setModel(engineParameterTableModel);
	}

	/**
	 * Aggiunge un GnuPlotFileElement alla tabella
	 * 
	 * @param gnuPlotFileElement
	 */
	public void addGnuPlotFileElement(GnuPlotFileElement gnuPlotFileElement) {
		gnuPlotFileList.add(gnuPlotFileElement);

		gnuPlotFileTableModel = new GnuPlotFileTableModel();
		gnuPlotFileTableModel.set_FileTableModel(gnuPlotFileList);

		gnuPlotFileTable.setModel(gnuPlotFileTableModel);
	}

	/**
	 * Rimuove tutti gli elementi presenti nel Panel e nelle table
	 */
	public void clearAllData() {
		this.gnuPlotFileList.clear();
		// this.nodeList.clear();
		this.nodeParameterList.clear();
		this.processParameterList.clear();
		this.engineParameterList.clear();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel addEngineLabel;
	private javax.swing.JLabel addGnuPlotLabel;
	private javax.swing.JLabel addNodeParameterLabel;
	private javax.swing.JLabel addNodeResourceLabel;
	private javax.swing.JLabel addProcessLabel;
	private javax.swing.JLabel engineLabel;
	private javax.swing.JScrollPane engineScrollPane;
	private javax.swing.JTable engineTable;
	private javax.swing.JScrollPane gnuPlotFileScrollPane;
	private javax.swing.JTable gnuPlotFileTable;
	private javax.swing.JLabel gnuPlotLabel;
	private javax.swing.JLabel nodeParameterLabel;
	private javax.swing.JScrollPane nodeParameterScrollPane;
	private javax.swing.JTable nodeParameterTable;
	private javax.swing.JLabel nodeResourceLabel;
	private javax.swing.JScrollPane nodeResourceScrollPane;
	private javax.swing.JTable nodeResourceTable;
	private javax.swing.JLabel processLabel;
	private javax.swing.JScrollPane processScrollPane;
	private javax.swing.JTable processTable;
	private javax.swing.JLabel removeEngineLabel;
	private javax.swing.JLabel removeGnuPlotLabel;
	private javax.swing.JLabel removeNodeParameterLabel;
	private javax.swing.JLabel removeNodeResourceLabel;
	private javax.swing.JLabel removeProcessLabel;
	private javax.swing.JButton setSimulationNameButton;
	private javax.swing.JTextField simulationNameField;
	private javax.swing.JLabel simulationNameLabel;
	private ArrayList<Node> nodeList;
	// End of variables declaration//GEN-END:variables

}
