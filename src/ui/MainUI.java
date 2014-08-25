package ui;

import java.awt.EventQueue;
import java.util.ArrayList;

public class MainUI extends UIFrame implements IMainUI {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	MainUI(){
		super();
	}
	
	@Override
	public void display(ArrayList<String> s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> start(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void writeOutputToFile(ArrayList<String> sortedList) {
		// TODO Auto-generated method stub
		
	}

	
}
