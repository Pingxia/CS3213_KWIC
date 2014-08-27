package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListPanel() {

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int returnVal = fc.showOpenDialog(ListPanel.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					// log.append("Opening: " + file.getName() + "." + newline);
					feedbackPane.setText("Opening: " + file.getName() + ".");
					loadFile(file);
					displayContent();
				} else {
					// log.append("Open command cancelled by user." + newline);
					feedbackPane.setText("Open command cancelled by user.");
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		feedbackPane = new JTextPane();
		feedbackPane.setEditable(false);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				deleteSelectedRows();
			}

		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addComponent(btnBrowse)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnDelete)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(feedbackPane,
										GroupLayout.DEFAULT_SIZE, 302,
										Short.MAX_VALUE).addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 493,
						Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addComponent(scrollPane,
												GroupLayout.DEFAULT_SIZE, 152,
												Short.MAX_VALUE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				btnBrowse)
																		.addComponent(
																				btnDelete))
														.addComponent(
																feedbackPane,
																GroupLayout.PREFERRED_SIZE,
																24,
																GroupLayout.PREFERRED_SIZE))
										.addGap(5)));

		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable( model );
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}

	private void deleteSelectedRows() {
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		int[] rows = table.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			model.removeRow(rows[i] - i);
		}
		//delete selected string from input
		
	}

	private void loadFile(File f) {
		// TODO load file input inside arraylist
	}

	private void displayContent() {

	}

	public ArrayList<String> getInputFromFile() {
		return inputFromFile;
	}

	final JFileChooser fc = new JFileChooser();
	private ArrayList<String> inputFromFile = new ArrayList<String>();
	private JTextPane feedbackPane;
	private JTable table;
	private String[] columnNames = { "Content", "Select" };
	private Object[][] data = { { "lala", "lll" } };
}
