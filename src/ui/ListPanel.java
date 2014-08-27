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

public class ListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListPanel() {
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int returnVal = fc.showOpenDialog(ListPanel.this);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
//		            log.append("Opening: " + file.getName() + "." + newline);
		            feedbackPane.setText("Opening: " + file.getName() + ".");
		            loadFile(file);
		            displayContent();
		        } else {
//		            log.append("Open command cancelled by user." + newline);
		        	feedbackPane.setText("Open command cancelled by user.");
		        }
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		feedbackPane = new JTextPane();
		feedbackPane.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnBrowse)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(feedbackPane, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBrowse)
						.addComponent(feedbackPane, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(5))
		);
		
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}
	
	private void loadFile(File f){
		//TODO load file input inside arraylist
	}
	
	private void displayContent(){
		
	}
	
	public ArrayList<String> getInputFromFile(){
		return inputFromFile;
	}
	
	final JFileChooser fc = new JFileChooser();
	private ArrayList<String> inputFromFile = new ArrayList<String>();
	private JTextPane feedbackPane;
	private JTable table;
	private String[] columnNames = {"Content","Select"};
	private Object[][] data = {{"",""}
	};
}
