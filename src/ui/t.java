package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class t extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public t() {
		setTitle("Results");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		outputArea = new JTextArea();
		outputArea.setEditable(false);
		// TODO
		outputArea.setText("Sample Output");

		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				export();
			}

		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_contentPane.createSequentialGroup()
								.addComponent(btnExport).addContainerGap())
				.addComponent(outputArea, GroupLayout.DEFAULT_SIZE, 490,
						Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(outputArea, GroupLayout.DEFAULT_SIZE,
								241, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnExport).addGap(8)));
		contentPane.setLayout(gl_contentPane);
	}

	public void display(ArrayList<String> output) {
		for (String s : output) {
			outputArea.append(s + "\n");
		}
	}

	private void export() {
		// TODO export to pdf file, doc file or excel file, notify user of
		// successful save
		int returnVal = fc.showSaveDialog(t.this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fc.getSelectedFile();
			writeToFile(fileToSave);
			// log.append("Opening: " + file.getName() + "." + newline);
		} else {
			// log.append("Open command cancelled by user." + newline);
		}
	}

	private void writeToFile(File f) {
		try {
			PrintWriter writer = new PrintWriter(f);
			writer.append(outputArea.getText());
			writer.close();
		} catch (Exception e) {

		}
	}

	final JFileChooser fc = new JFileChooser();
	private JTextArea outputArea;
}
