package ui;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.UIManager;

public class InputPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public InputPanel() {
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = fc.showOpenDialog(InputPanel.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					// log.append("Opening: " + file.getName() + "." + newline);
					feedbackPane.setText("Opening: " + file.getAbsolutePath() + ".");
					loadFile(file);
				} else {
					// log.append("Open command cancelled by user." + newline);
					feedbackPane.setText("Open command cancelled by user.");
				}
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteSelectedRows();
			}
		});
		
		inputTextArea = new JTextArea();
		
		feedbackPane = new JTextPane();
		feedbackPane.setEditable(false);
		feedbackPane.setBackground(UIManager.getColor("Button.background"));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addInputFromKeyboard();
			}
			
		});
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				run();
			}
			
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBrowse)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(feedbackPane, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
					.addGap(9))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(inputTextArea, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAdd)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRun, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnBrowse)
							.addComponent(btnDelete))
						.addComponent(feedbackPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRun)
						.addComponent(btnAdd))
					.addGap(9))
		);
		
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		//TODO enable sort in table?
		table = new JTable( model );
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}
	
	private void run(){
		//TODO get a list of output, pass output to outputPanel
		outputPanel.setVisible(true);
		feedbackPane.setText("Processing lines...");
	}
	
	private void deleteSelectedRows() {
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		int[] rows = table.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			//delete selected string from the list
			String selectedString =  (String) model.getValueAt(rows[i] - i,0);
			inputToDelete.add(selectedString);
			model.removeRow(rows[i] - i);
			feedbackPane.setText("Delete selected items");
		}
	}
	
	private void addInputFromKeyboard(){
		//TODO check for duplication when add in rows
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		String input = inputTextArea.getText();
		String[] inputLines = input.split("\n");
		//add into list and table to display
		for(String s: inputLines){
			inputFromKeyboard.add(s);
			model.addRow(new Object[]{s});
		}
		feedbackPane.setText("New items added");
		inputTextArea.setText("");
	}

	private void loadFile(File f) {
		// TODO load file input, display on table
	}

	public ArrayList<String> getInputFromFile() {
		return inputFromFile;
	}
	
	public ArrayList<String> getInputFromKeyboard() {
		return inputFromKeyboard;
	}
	
	public ArrayList<String> getInputToDelete() {
		return inputToDelete;
	}
	
	public ArrayList<String> getDisplayingList(){
		//TODO simply get all the string on the display screen
		return null;
	}

	final JFileChooser fc = new JFileChooser();
	private ArrayList<String> inputFromFile = new ArrayList<String>();
	private ArrayList<String> inputFromKeyboard = new ArrayList<String>();
	private ArrayList<String> inputToDelete = new ArrayList<String>();
	
	private JTextPane feedbackPane;
	private JTextArea inputTextArea;
	private JTable table;
	private String[] columnNames = { "Content" };
	private Object[][] data = { };
	private OutputPanel outputPanel = new OutputPanel();
	
}
