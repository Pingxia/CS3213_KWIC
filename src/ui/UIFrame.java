package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class UIFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtAddToThe;

	/**
	 * Create the frame.
	 */
	public UIFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		txtAddToThe = new JTextField();
		txtAddToThe.setText("Add to the list. Press Enter to add.");
		txtAddToThe.setToolTipText("\n");
		txtAddToThe.setColumns(10);
		
		JLabel lblInput = new JLabel("Input:");
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showOutputPanel();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblInput)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtAddToThe, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRun)
					.addContainerGap())
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInput)
						.addComponent(txtAddToThe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRun))
					.addGap(18))
		);
		
		ignoreWordsPanel = new ListPanel();
		tabbedPane.addTab("IngoreWords", null, ignoreWordsPanel, null);
		
		titlesPanel = new ListPanel();
		tabbedPane.addTab("Titles", null, titlesPanel, null);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void showOutputPanel(){
		outputPanel.setVisible(true);
	}
	
	public ArrayList<String> getWordsToIgnore(){
		return ignoreWordsPanel.getInputFromFile();
	}
	
	public ArrayList<String> getTitlesToAdd(){
		return titlesPanel.getInputFromFile();
	}
	
	private OutputPanel outputPanel = new OutputPanel();
	private ListPanel ignoreWordsPanel;
	private ListPanel titlesPanel;
	private ArrayList<String> wordsToIgnore = new ArrayList<String>();
	private ArrayList<String> titlesToDelete = new ArrayList<String>();
	private ArrayList<String> titlesToAdd = new ArrayList<String>();
}
