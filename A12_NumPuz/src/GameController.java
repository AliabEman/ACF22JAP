/*
 *  ---------------------------------------------------------------------
 JAP COURSE - SCRIPT
 ASSIGNMENTS - CST8221 - Fall 2022
 ---------------------------------------------------------------------
 Begin of Script (Assignments - F22)
 ---------------------------------------------------------------------
students: Aliab Eman & Matthew Vecchio
Student number : 041000420 & 041004137
 * 
 */

//import javax.swing.JFrame;
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import javax.swing.JRadioButton;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javafx.scene.layout.GridPane;


public class GameController extends JPanel {
	private JFrame mainFrame;
	private JLabel radioHeader;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private static final String image= "src/numpuz-a12-images/gamelogo.png";

	public GameController() {
		prepareGame();
		gameButtons();
		gameRadioButton();
	}

	int dimension[]= {3,4,5,6,7,8,9};
	String gameType[] = {"Number", "Text"};
	
	ImageIcon icon = new ImageIcon(image);
	
	JButton numPuzButton = new JButton("", icon);
	JButton gameChoice = new JButton("Selection");
	JButton show = new JButton("Show");
	JButton hide = new JButton("Hide");
	JButton save = new JButton("Save");
	JButton load = new JButton("Load");
	JButton random = new JButton("Rand");
	JButton finish = new JButton("Finish");

	private void prepareGame() {
		mainFrame = new JFrame();
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(1,3));

		radioHeader = new JLabel();
		statusLabel = new JLabel();
		controlPanel = new JPanel();

		mainFrame.add(radioHeader);
		mainFrame.add(statusLabel);
		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);
	}
	
	
	void gameButtons() {
		controlPanel.setLayout(new FlowLayout());
		controlPanel.add(numPuzButton);
		controlPanel.add(gameChoice);
		controlPanel.add(show);
		controlPanel.add(hide);
		controlPanel.add(save);
		controlPanel.add(load);
		controlPanel.add(random);
		controlPanel.add(finish);
		controlPanel.setVisible(true);
	}

	void gameRadioButton() {
		radioHeader.setText("Mode:");
		final JRadioButton designRadioButton = new JRadioButton("Design", true);
		final JRadioButton playRadioButton = new JRadioButton("Play");

		designRadioButton.setMnemonic(KeyEvent.VK_C);
		playRadioButton.setMnemonic(KeyEvent.VK_M);

		designRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {         
				statusLabel.setText((e.getStateChange()==1?"checked":"unchecked"));
			}           
		});
		playRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {             
				statusLabel.setText((e.getStateChange()==1?"checked":"unchecked"));
			}           
		});


		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(designRadioButton);
		radioGroup.add(playRadioButton);
		controlPanel.add(radioHeader);
		controlPanel.add(designRadioButton);
		controlPanel.add(playRadioButton);
		mainFrame.setVisible(true);
	}

}