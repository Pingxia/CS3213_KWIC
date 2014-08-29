package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import logic.IManager;
import logic.Manager;
import storage.Data;
import storage.IData;

public class MainUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("KWIC");
		frame.setBounds(100, 100, 538, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		titlesPanel = new InputPanel();
		tabbedPane.addTab("Titles", null, titlesPanel, null);
		
		wordsToIgnorePanel = new InputPanel();
		tabbedPane.addTab("IgnoreWords", null, wordsToIgnorePanel, null);
	}
	
	public static void run(){
		outputPanel.setVisible(true);
		data.addWordsToIgnore(wordsToIgnorePanel.getInputToAdd());
		data.deleteWordsToIgnore(wordsToIgnorePanel.getInputToDelete());
		data.addTitles(titlesPanel.getInputToAdd());
		data.deleteTitles(titlesPanel.getInputToDelete());
		manager.run();
		//TODO display output
		outputPanel.display(data.convertTitleListToStringList());
		titlesPanel.resetInputLists();
		wordsToIgnorePanel.resetInputLists();
	}
	
	private static InputPanel wordsToIgnorePanel;
	private static InputPanel titlesPanel;
	private static OutputPanel outputPanel = new OutputPanel();
	private static IData data = Data.getInstance();
	private static IManager manager = new Manager();
}
