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

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonAreaLayout;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;


public class GameController extends JPanel {
	private static final String gameLogo= "src/numpuz-a12-images/gamelogo.png";
	private static final String newGameLogo= "src/numpuz-a12-images/iconnew.png";
	private static final String solutionGameLogo= "src/numpuz-a12-images/iconsol.png";
	private static final String exitGameLogo= "src/numpuz-a12-images/iconext.png";
	private static final String colorsGameLogo= "src/numpuz-a12-images/iconcol.png";
	private static final String aboutGameLogo= "src/numpuz-a12-images/iconabt.png";
	int WIDTH = 1;
	int HEIGHT = 1;	
	ImageIcon gameLogoIcon;
	ImageIcon newLogoIcon;
	ImageIcon solutionLogoIcon;
	ImageIcon exitLogoIcon;
	ImageIcon colorsLogoIcon;
	ImageIcon aboutLogoIcon;
	JFrame mainFrame; //frame for entire game
	GridBagConstraints controlPanelGridBag;
	JLabel radioHeader;
	JLabel statusLabel;
	JLabel movesLabel;
	JLabel pointsLabel;
	JLabel dimLabel;
	JLabel typeLabel;
	JPanel controlPanel; //game control settings
	JPanel gamePanel; //game puzzle
	JMenuBar menuBar; //menu bar
	JMenu gameMenu, helpMenu;
	JMenuItem helpMenuItem1, helpMenuItem2;
	JMenuItem gameMenuItem1, gameMenuItem2, gameMenuItem3;
	JButton gameBoard[]; //goes inside gamePanel


	JButton numPuzButton;
	JButton gameChoice;
	JButton show;
	JButton hide;
	JButton save;
	JButton load;
	JButton random;
	JButton finish;
	JRadioButton designRadioButton, playRadioButton;
	JComboBox dimensionChoices;
	int dimension[]= {3,4,5,6,7,8,9}; //affects size of puzzle pieces
	String gameType[] = {"Number", "Text"};


	public GameController() {

	}


	boolean instantiateGamePieces() {
		mainFrame = new JFrame();
		controlPanel = new JPanel(new BorderLayout());
		gamePanel = new JPanel(new GridLayout(dimension[3], dimension[3])); //need to replace with dynamic array for sizing


		controlPanelGridBag = new GridBagConstraints();

		radioHeader = new JLabel("Mode:");
		radioHeader.setSize(WIDTH, HEIGHT);
		statusLabel = new JLabel("Time:");
		radioHeader.setSize(WIDTH, HEIGHT);
		movesLabel = new JLabel("Moves:");
		radioHeader.setSize(WIDTH, HEIGHT);
		pointsLabel = new JLabel("Points:");
		radioHeader.setSize(WIDTH, HEIGHT);
		dimLabel = new JLabel("Dim:");
		radioHeader.setSize(WIDTH, HEIGHT);
		typeLabel = new JLabel("Type:");

		gameLogoIcon = new ImageIcon(gameLogo);
		newLogoIcon = new ImageIcon(newGameLogo);
		solutionLogoIcon = new ImageIcon(solutionGameLogo);
		exitLogoIcon = new ImageIcon(exitGameLogo);
		colorsLogoIcon = new ImageIcon(colorsGameLogo);
		aboutLogoIcon = new ImageIcon(aboutGameLogo);

		menuBar = new JMenuBar();

		gameMenu = new JMenu("Game");		
		gameMenuItem1 = new JMenuItem("New", newLogoIcon);
		gameMenuItem2 = new JMenuItem("Solution", solutionLogoIcon);
		gameMenuItem3 = new JMenuItem("Exit", exitLogoIcon);

		helpMenu = new JMenu("Help");
		helpMenuItem1 = new JMenuItem("Colors", colorsLogoIcon);
		helpMenuItem2 = new JMenuItem("About", aboutLogoIcon);

		numPuzButton = new JButton(gameLogoIcon);
		gameChoice = new JButton("Selection");
		show = new JButton("Show");
		hide = new JButton("Hide");
		save = new JButton("Save");
		load = new JButton("Load");
		random = new JButton("Rand");
		finish = new JButton("Finish");

		return true;
	}

	//Frame for entire UI
	JFrame preparePanelLayouts() {
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(650,600);
		mainFrame.getPreferredSize();
		mainFrame.setBackground(Color.GREEN); 
		mainFrame.setResizable(false);

		controlPanel.setSize(100,400);
		controlPanel.setBackground(Color.YELLOW);	
		controlPanel.setLayout(new GridBagLayout());

		mainFrame.add(controlPanel, BorderLayout.EAST);
		mainFrame.add(gamePanel, BorderLayout.WEST);
		mainFrame.add(menuBar);

		mainFrame.setVisible(true);

		return mainFrame;
	}
	
	void dimensionChoicesButton(){
		String dimensionsComboBox[] = {"3","4","5","6","7","8","9"};
		dimensionChoices = new JComboBox(dimensionsComboBox);
		dimensionChoices.setBounds(50,50,90,20);
		dimensionChoices.setSelectedIndex(0);
		controlPanelGridBag.gridx = 1;
		controlPanel.add(dimensionChoices, controlPanelGridBag);
		String choice = (String) dimensionChoices.getItemAt(dimensionChoices.getSelectedIndex());
		gameButtons(choice);
	}

	JFrame gameControlPanel() {
		//setup for NumPuz icon-button
		controlPanelGridBag.fill = GridBagConstraints.NORTH;
		controlPanelGridBag.gridx = 0;
		controlPanelGridBag.gridy = 0;
		controlPanelGridBag.gridheight = 2;
		controlPanel.add(numPuzButton, controlPanelGridBag);


		//setup for Radio Buttons/ Label:
		controlPanelGridBag.fill = GridBagConstraints.HORIZONTAL;
		controlPanelGridBag.gridheight = 1;
		controlPanelGridBag.gridwidth = 1;
		gameRadioButton();

		//setup for Dimension
		controlPanelGridBag.fill = GridBagConstraints.HORIZONTAL;
		controlPanelGridBag.gridx = 0;
		controlPanelGridBag.gridy = 3;
		controlPanel.add(dimLabel, controlPanelGridBag);
		dimensionChoicesButton();
		//	//	//	//	//	//	//	//	//	//	//	//	//	//	//	//	//
		//	need to add the selection drop-down menu for the dimension	//
		//	//	//	//	//	//	//	//	//	//	//	//	//	//	//	//	//
		controlPanelGridBag.gridx = 2;
		controlPanelGridBag.gridy = 3;
		controlPanel.add(show, controlPanelGridBag);

		controlPanelGridBag.gridx = 3;
		controlPanelGridBag.gridy = 3;
		controlPanel.add(hide, controlPanelGridBag);

		//setup for Save/ Load/ Rand
		controlPanelGridBag.fill = GridBagConstraints.HORIZONTAL;
		controlPanelGridBag.gridx = 0;
		controlPanelGridBag.gridy = 4;
		controlPanel.add(save, controlPanelGridBag);

		controlPanelGridBag.gridx = 1;
		controlPanelGridBag.gridy = 4;
		controlPanel.add(load, controlPanelGridBag);

		controlPanelGridBag.gridx = 2;
		controlPanelGridBag.gridy = 4;
		controlPanel.add(random, controlPanelGridBag);

		//setup for gameType drop-down menu
		controlPanelGridBag.fill = GridBagConstraints.HORIZONTAL;
		controlPanelGridBag.gridx = 0;
		controlPanelGridBag.gridy = 5;
		//Control Panel for game
		controlPanelGridBag.fill = GridBagConstraints.HORIZONTAL;

		controlPanel.add(gameChoice, controlPanelGridBag);
		controlPanel.add(finish, controlPanelGridBag);
		controlPanel.add(radioHeader, controlPanelGridBag);
		controlPanel.add(statusLabel, controlPanelGridBag);
		//Menu for game
		gameMenu.add(gameMenuItem1);
		gameMenu.addSeparator();
		gameMenu.add(gameMenuItem2);
		gameMenu.addSeparator();
		gameMenu.add(gameMenuItem3);

		helpMenu.add(helpMenuItem1);
		helpMenu.addSeparator();
		helpMenu.add(helpMenuItem2);		

		menuBar.add(gameMenu);
		menuBar.add(helpMenu);


		controlPanel.setVisible(true);
		menuBar.setVisible(true);
		mainFrame.setJMenuBar(menuBar);
		mainFrame.setVisible(true);
		gamePanel.setVisible(true);
		mainFrame.setVisible(true);
		//gamePanel.add(numPuzSizes.numPuzComboBox);
		return mainFrame;
	}

	void gameRadioButton() {
//		radioHeader.setText("Mode:");
		designRadioButton = new JRadioButton("Design", true);
		playRadioButton = new JRadioButton("Play");

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
		controlPanelGridBag.gridy = 2;
		controlPanelGridBag.weightx = 0.5;
		controlPanelGridBag.gridx = 0;
		controlPanel.add(radioHeader, controlPanelGridBag);
		controlPanelGridBag.weightx = 0.5;
		controlPanelGridBag.gridx = 1;
		controlPanel.add(designRadioButton, controlPanelGridBag);
		controlPanelGridBag.weightx = 0.5;
		controlPanelGridBag.gridx = 2;
		controlPanel.add(playRadioButton, controlPanelGridBag);
		mainFrame.setVisible(true);
	}

	void gameButtons(String dimensionChosen) {
		int n = 3;
		
		if (dimensionChosen == "3") {
			n = dimension[0];
		}
		else if (dimensionChosen == "4") {
			n = dimension[1];
		}		
		else if (dimensionChosen == "5") {
			n = dimension[2];
		}		
		else if (dimensionChosen == "6") {
			n = dimension[3];
		}		
		else if (dimensionChosen == "7") {
			n = dimension[4];
		}		
		else if (dimensionChosen == "8") {
			n = dimension[5];
		}	
		else if (dimensionChosen == "9") {
			n = dimension[6];
		}	

		gamePanel = new JPanel(new GridLayout(dimension[n], dimension[n])); //need to replace with dynamic array for sizing
		int count = 1;
		mainFrame.add(gamePanel);
		for (int i = 0; i < dimension[n]; i++) {
			for (int j = 0; j < dimension[n]; j++) {
				gamePanel.add(new JButton(""+count++), BorderLayout.CENTER);
			}
		}
	}









	//	//JButton gameBoard[][] = null;
	//	//int dimChoice;
	//	//dimChoice=2;
	//
	//
	//	//NumPuzSizeOptions numPuzSizes = new NumPuzSizeOptions();
	//
	//	for (int i = 0; i<dim[dimChoice]; i++) {
	//		for (int j=0; j<dim[dimChoice]; j++) {
	//			gameBoard[i]= new JButton(i + "");
	//		}
	//	}


}
