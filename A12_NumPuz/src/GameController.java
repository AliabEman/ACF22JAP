/*
 *  ---------------------------------------------------------------------
  JAP COURSE - SCRIPT
 ASSIGNMENTS - CST8221 - Fall 2022
 ---------------------------------------------------------------------
 Begin of Script (Assignments - F22)
 ---------------------------------------------------------------------
students: Aliab Eman & Matthew Vecchio
Student numbers : 041000420 & 041004137
 * 
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonAreaLayout;
import java.util.*;
//import javafx.scene.effect.ColorAdjust;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.*;


public class GameController extends JPanel implements ItemListener, ActionListener{
	private static final String gameLogo= "src/numpuz-a12-images/gamelogo.png";
	private static final String newGameLogo= "src/numpuz-a12-images/iconnew.png";
	private static final String solutionGameLogo= "src/numpuz-a12-images/iconsol.png";
	private static final String exitGameLogo= "src/numpuz-a12-images/iconext.png";
	private static final String colorsGameLogo= "src/numpuz-a12-images/iconcol.png";
	private static final String aboutGameLogo= "src/numpuz-a12-images/iconabt.png";
	private static final String splashGameLogo= "src/numpuz-a12-images/game.png";
	int WIDTH = 1;
	int HEIGHT = 1;	
	ImageIcon gameLogoIcon;
	ImageIcon newLogoIcon;
	ImageIcon solutionLogoIcon;
	ImageIcon exitLogoIcon;
	ImageIcon colorsLogoIcon;
	ImageIcon aboutLogoIcon;
	JFrame mainFrame; //frame for entire game

	JTextField designTextField;
	JFrame designMessageBox;
	JButton designSetButton;
	JLabel displayTextDesign1;
	JLabel displayTextDesign2;

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
	String dimensionsComboBox[] = {"3","4","5","6","7","8","9"}; 

	int dimension[]= {3,4,5,6,7,8,9}; //affects size of puzzle pieces
	String gameType[] = {"Number", "Text"};




	public GameController() {
		splashScreen();
		instantiateGamePieces();
		//game.gameButtons();
		preparePanelLayouts();
		gameControlPanel();
		gameRadioButton();
	}

	public Runnable splashScreen() {
		JFrame window = new JFrame("Algonquin College - NumPuz");
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setName("Algonquin College - NumPuz");
		window.getContentPane().add(new JLabel("NumPuz", new ImageIcon(splashGameLogo), SwingConstants.CENTER));
		window.setBounds(0, 0, 500, 500);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		window.setVisible(true);
		window.dispose();
		return null;
	}

	boolean instantiateGamePieces() {
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


		controlPanel = new JPanel(new BorderLayout());
		gamePanel = new JPanel(new GridLayout(3, 3)); //need to replace with dynamic array for sizing

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
		gameMenuItem1.addActionListener(this);
		gameMenuItem2 = new JMenuItem("Solution", solutionLogoIcon);
		gameMenuItem2.addActionListener(this);
		gameMenuItem3 = new JMenuItem("Exit", exitLogoIcon);
		gameMenuItem3.addActionListener(this);

		helpMenu = new JMenu("Help");
		helpMenuItem1 = new JMenuItem("Colors", colorsLogoIcon);
		helpMenuItem1.addActionListener(this);
		helpMenuItem2 = new JMenuItem("About", aboutLogoIcon);
		helpMenuItem2.addActionListener(this);

		numPuzButton = new JButton("NumPuz!", gameLogoIcon);
		numPuzButton.addActionListener(this);
		gameChoice = new JButton("Selection");
		gameChoice.addActionListener(this);

		show = new JButton("Show");
		show.addActionListener(this);
		hide = new JButton("Hide");
		hide.addActionListener(this);
		save = new JButton("Save");
		save.addActionListener(this);
		load = new JButton("Load");
		load.addActionListener(this);
		random = new JButton("Rand");
		random.addActionListener(this);
		finish = new JButton("Finish");
		finish.addActionListener(this);
		return true;
	}

	//Frame for entire UI
	JFrame preparePanelLayouts() {
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(950,650);
		mainFrame.setLocationRelativeTo(null);
		//mainFrame.getPreferredSize();
		mainFrame.setBackground(Color.GREEN); 
		mainFrame.setResizable(false);

		controlPanel.setLayout(new GridBagLayout());
		controlPanel.setSize(200,600);
		controlPanel.setBackground(Color.YELLOW);	

		gamePanel.setLayout(new BorderLayout());
		gamePanel.setSize(600, 600);
		gamePanel.setBackground(Color.MAGENTA);

		mainFrame.add(controlPanel, BorderLayout.EAST);
		mainFrame.add(gamePanel, BorderLayout.WEST);
		mainFrame.add(menuBar);

		mainFrame.setVisible(true);

		return mainFrame;
	}

	public void dimensionChoicesButton(){

		dimensionChoices = new JComboBox(dimensionsComboBox);
		dimensionChoices.setBounds(50,50,90,20);
		dimensionChoices.setSelectedIndex(0);
		controlPanelGridBag.gridx = 1;
		controlPanel.add(dimensionChoices, controlPanelGridBag);
		gameButtons((String) dimensionChoices.getItemAt(dimensionChoices.getSelectedIndex()));
		System.out.println("Started a game");
		dimensionChoices.addItemListener( new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("Changed dimension Choice to " + (String) dimensionChoices.getItemAt(dimensionChoices.getSelectedIndex()) + 
							"x" + (String) dimensionChoices.getItemAt(dimensionChoices.getSelectedIndex()) + " Game Board");
					gamePanel.removeAll();
					gameButtons((String) dimensionChoices.getItemAt(dimensionChoices.getSelectedIndex()));

					//					mainFrame.remove(gamePanel);
					//					mainFrame.add(gamePanel, BorderLayout.WEST);
					//					gameButtons((String) dimensionChoices.getItemAt(dimensionChoices.getSelectedIndex()));	
					//gamePanel.revalidate();
					//gamePanel.repaint();
				}		
				else {
					gamePanel.setVisible(true);
				}
				gamePanel.setVisible(true);
				gamePanel.revalidate();
				gamePanel.repaint();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("New")){
			System.out.println("Clicked New");
		}
		if (action.equals("Solution")){
			System.out.println("Clicked Solution");

		}
		if (action.equals("Exit")){
			System.out.println("Clicked Exit");
			System.out.println("GOODBYE!!!");
			System.exit(0);

		}
		if (action.equals("Help")){
			System.out.println("Clicked Help");

		}
		if (action.equals("Colors")){
			System.out.println("Clicked Colors");

		}
		if (action.equals("About")){
			System.out.println("Clicked About");

		}
		if (action.equals("NumPuz!")){
			System.out.println("Clicked NumPuz!");
			//Thread t1 = new Thread(splashScreen());
			Thread getSplash = new Thread(new Runnable() {
				public void run() {
					/*try {
						Thread.sleep(x);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					splashScreen();

				}
			});
		}

		if (action.equals("Selection")){
			System.out.println("Clicked Selection");

		}
		if (action.equals("Show")){
			System.out.println("Clicked Show");
			gamePanel.setVisible(true);
			gamePanel.revalidate();
			gamePanel.repaint();


		}
		if (action.equals("Hide")){
			System.out.println("Clicked Hide");
			gamePanel.setVisible(false);
			gamePanel.revalidate();
			gamePanel.repaint();

		}
		if (action.equals("Save")){
			System.out.println("Clicked Save");

		}		
		if (action.equals("Load")){
			System.out.println("Clicked Load");

		}
		if (action.equals("Rand")){
			System.out.println("Clicked Rand");
			gameButtons((String) dimensionChoices.getItemAt(dimensionChoices.getSelectedIndex()));
			gamePanel.setVisible(true);
			gamePanel.revalidate();
			gamePanel.repaint();

		}		
		if (action.equals("Finish")){
			System.out.println("Clicked Finish");

		}
		if (action.equals("Design")){
			System.out.println("Clicked Design Mode");
			designMode();

		}		
		if (action.equals("Play")){
			System.out.println("Clicked Play Mode");

		}


	}

	void designMode() {
		designMessageBox = new JFrame("Design!");
		designMessageBox.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

		designTextField = new JTextField(16);
		designTextField.setSize(getMaximumSize());

		designSetButton = new JButton("Submit");
		designSetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String message = designTextField.getText();
				System.out.println(designTextField.getText());
				char [] msg = message.toCharArray();
				gameToDesign((String) dimensionChoices.getItemAt(dimensionChoices.getSelectedIndex()), msg);
			}
		});
		displayTextDesign1 = new JLabel("Please enter your design...");
		displayTextDesign2 = new JLabel("Design must fix game size constraints");

		JPanel designPanel = new JPanel();
		designPanel.add(designTextField);
		designPanel.add(designSetButton);
		designPanel.add(displayTextDesign1);
		designPanel.add(displayTextDesign2);
		designMessageBox.add(designPanel);

		designMessageBox.setSize(300,150);
		designMessageBox.show();



	}

	void gameToDesign(String dimensionChosen, char[] msg) {
		int n = 3; //default size
		int count;
		JButton button;


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

		count = n*n;


		mainFrame.remove(gamePanel);
		gamePanel = new JPanel(new GridLayout(n,n));
		mainFrame.add(gamePanel);

		String[][] gameButtons = new String[n][n];

		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (k < msg.length) {
					gameButtons[i][j] = msg[k] + "";
					k++;
				}
				else {
					gameButtons[i][j] = "";
				}
				button = new JButton(gameButtons[i][j]);	
				System.out.println(gameButtons[i][j]);

				button.setSize(1/n, 1/n);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						System.out.println("Clicked Designed-Game button");
					}
				});

				gamePanel.add(button);
				gamePanel.revalidate();
				gamePanel.repaint();
				//gamePanel.setVisible(false);
			}		


		}


	}

	JFrame gameControlPanel() {
		//setup for NumPuz icon-button
		controlPanelGridBag.fill = GridBagConstraints.HORIZONTAL;
		controlPanelGridBag.gridx = 0;
		controlPanelGridBag.gridy = 0;
		controlPanelGridBag.weightx = 2;
		controlPanelGridBag.gridheight = 1;
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
		gamePanel.setVisible(false);
		mainFrame.setVisible(true);
		//gamePanel.add(numPuzSizes.numPuzComboBox);
		return mainFrame;
	}

	void gameRadioButton() {
		//		radioHeader.setText("Mode:");
		designRadioButton = new JRadioButton("Design", true);
		playRadioButton = new JRadioButton("Play");

		designRadioButton.setMnemonic(KeyEvent.VK_C);
		designRadioButton.addActionListener(this);
		playRadioButton.setMnemonic(KeyEvent.VK_M);
		playRadioButton.addActionListener(this);

		//		designRadioButton.addItemListener(new ItemListener() {
		//			public void itemStateChanged(ItemEvent e) {         
		//				statusLabel.setText((e.getStateChange()==1?"checked":"unchecked"));
		//			}           
		//		});
		//		playRadioButton.addItemListener(new ItemListener() {
		//			public void itemStateChanged(ItemEvent e) {             
		//				statusLabel.setText((e.getStateChange()==1?"checked":"unchecked"));
		//			}           
		//		});

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
		int n = 3; //default size
		int count;
		Random randomNum = new Random();	


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

		final JButton[][] button = new JButton[n][n];
		count = n*n;


		mainFrame.remove(gamePanel);
		gamePanel = new JPanel(new GridLayout(n,n));
		mainFrame.add(gamePanel);

		String[][] gameButtons = new String[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == n-1 && j == n-1) {
					gameButtons[i][j] = "";
					button[i][j] = new JButton(gameButtons[i][j]);	
					button[i][j].setBackground(Color.BLACK);
					System.out.println(gameButtons[i][j]);
				}
				else {				
					gameButtons[i][j] = randomNum.nextInt(count) +1 + "";
					button[i][j] = new JButton(gameButtons[i][j]);
					button[i][j].setBackground(Color.WHITE);
					button[i][j].addActionListener(new Controller());					
					System.out.println(gameButtons[i][j]);
				}

				gamePanel.add(button[i][j]);

				button[i][j].setSize(1/n, 1/n);
  
				gamePanel.setVisible(true);
			}
		}
	}		


	//
	//	void gameButtons(String dimensionChosen) {
	//		int n = 3; //default size
	//		int count;
	//		JButton button;
	//		Random randomNum = new Random();	
	//
	//
	//		if (dimensionChosen == "3") {
	//			n = dimension[0];
	//		}
	//		else if (dimensionChosen == "4") {
	//			n = dimension[1];
	//		}		
	//		else if (dimensionChosen == "5") {
	//			n = dimension[2];
	//		}		
	//		else if (dimensionChosen == "6") {
	//			n = dimension[3];
	//		}		
	//		else if (dimensionChosen == "7") {
	//			n = dimension[4];
	//		}		
	//		else if (dimensionChosen == "8") {
	//			n = dimension[5];
	//		}	
	//		else if (dimensionChosen == "9") {
	//			n = dimension[6];
	//		}	
	//
	//		count = n*n;
	//
	//
	//		mainFrame.remove(gamePanel);
	//		gamePanel = new JPanel(new GridLayout(n,n));
	//		mainFrame.add(gamePanel);
	//		final JButton[] buttonArray = new JButton[count];
	//		for (int i = 0; i < count; i++) {
	//
	//			if (i == count-1){
	//				button = new JButton();
	//				buttonArray[i] = button;
	//				//buttonArray[i].setText(Integer.toString(randomNum.nextInt(10)));
	//				buttonArray[i].addActionListener(this);
	//				gamePanel.add(buttonArray[i]);
	//				button.setBackground(Color.BLACK);
	//			}
	//			else{
	//				button = new JButton();
	//				buttonArray[i] = button;
	//				buttonArray[i].setText(Integer.toString(randomNum.nextInt(10)));
	//				buttonArray[i].addActionListener(this);
	//				gamePanel.add(buttonArray[i]);
	//			}
	//			button.addActionListener(new ActionListener() {
	//				public void actionPerformed(ActionEvent ae) {
	//					System.out.println("Clicked game button");
	//					//System.out.println(((JButton)ae.getSource()).getText());
	//					if(((JButton)ae.getSource()).getText() == buttonArray[0].getText()){
	//						System.out.println("Clicked button 1");
	//						if(buttonArray[3].getBackground() == Color.BLACK){
	//							buttonArray[0].setBackground(Color.BLACK);
	//							buttonArray[3].setBackground(Color.WHITE);
	//							buttonArray[3].setText(buttonArray[0].getText());
	//							buttonArray[0].setText("");
	//
	//						}
	//						else if(buttonArray[1].getBackground() == Color.BLACK){
	//							buttonArray[0].setBackground(Color.BLACK);
	//							buttonArray[1].setBackground(Color.WHITE);
	//							buttonArray[1].setText(buttonArray[0].getText());
	//							buttonArray[0].setText("");
	//						}
	//						else if(((JButton)ae.getSource()).getText() == buttonArray[1].getText()){
	//							System.out.println("Clicked button 2");
	//							if(buttonArray[0].getBackground() == Color.BLACK){
	//								buttonArray[1].setBackground(Color.BLACK);
	//								buttonArray[0].setBackground(Color.WHITE);
	//								buttonArray[0].setText(buttonArray[1].getText());
	//								buttonArray[1].setText("");
	//							}
	//							else if(buttonArray[2].getBackground() == Color.BLACK){
	//								buttonArray[1].setBackground(Color.BLACK);
	//								buttonArray[2].setBackground(Color.WHITE);
	//								buttonArray[2].setText(buttonArray[1].getText());
	//								buttonArray[1].setText("");
	//							}
	//							else if(buttonArray[4].getBackground() == Color.BLACK){
	//								buttonArray[1].setBackground(Color.BLACK);
	//								buttonArray[4].setBackground(Color.WHITE);
	//								buttonArray[4].setText(buttonArray[1].getText());
	//								buttonArray[1].setText("");
	//							}
	//						}
	//						else if(((JButton)ae.getSource()).getText() == buttonArray[2].getText()){
	//							System.out.println("Clicked button 3");
	//							if(buttonArray[1].getBackground() == Color.BLACK){
	//								buttonArray[2].setBackground(Color.BLACK);
	//								buttonArray[1].setBackground(Color.WHITE);
	//								buttonArray[1].setText(buttonArray[2].getText());
	//								buttonArray[2].setText("");
	//							}
	//							else if(buttonArray[5].getBackground() == Color.BLACK){
	//								buttonArray[2].setBackground(Color.BLACK);
	//								buttonArray[5].setBackground(Color.WHITE);
	//								buttonArray[5].setText(buttonArray[2].getText());
	//								buttonArray[2].setText("");
	//							}	
	//
	//						}
	//						else if(((JButton)ae.getSource()).getText() == buttonArray[3].getText()){
	//							System.out.println("Clicked button 4");
	//							if(buttonArray[0].getBackground() == Color.BLACK){
	//								buttonArray[3].setBackground(Color.BLACK);
	//								buttonArray[0].setBackground(Color.WHITE);
	//								buttonArray[0].setText(buttonArray[3].getText());
	//								buttonArray[3].setText("");
	//							}
	//							else if(buttonArray[4].getBackground() == Color.BLACK){
	//								buttonArray[3].setBackground(Color.BLACK);
	//								buttonArray[4].setBackground(Color.WHITE);
	//								buttonArray[4].setText(buttonArray[3].getText());
	//								buttonArray[3].setText("");
	//							}
	//							else if(buttonArray[6].getBackground() == Color.BLACK){
	//								buttonArray[3].setBackground(Color.BLACK);
	//								buttonArray[6].setBackground(Color.WHITE);
	//								buttonArray[6].setText(buttonArray[3].getText());
	//								buttonArray[3].setText("");
	//							}
	//						}
	//						else if(((JButton)ae.getSource()).getText() == buttonArray[4].getText()){
	//							System.out.println("Clicked button 5");
	//							if(buttonArray[1].getBackground() == Color.BLACK){
	//								buttonArray[4].setBackground(Color.BLACK);
	//								buttonArray[1].setBackground(Color.WHITE);
	//								buttonArray[1].setText(buttonArray[4].getText());
	//								buttonArray[4].setText("");
	//							}
	//							else if(buttonArray[3].getBackground() == Color.BLACK){
	//								buttonArray[4].setBackground(Color.BLACK);
	//								buttonArray[3].setBackground(Color.WHITE);
	//								buttonArray[3].setText(buttonArray[4].getText());
	//								buttonArray[4].setText("");
	//							}
	//							else if(buttonArray[5].getBackground() == Color.BLACK){
	//								buttonArray[4].setBackground(Color.BLACK);
	//								buttonArray[5].setBackground(Color.WHITE);
	//								buttonArray[5].setText(buttonArray[4].getText());
	//								buttonArray[4].setText("");
	//							}
	//							else if(buttonArray[7].getBackground() == Color.BLACK){
	//								buttonArray[4].setBackground(Color.BLACK);
	//								buttonArray[7].setBackground(Color.WHITE);
	//								buttonArray[7].setText(buttonArray[4].getText());
	//								buttonArray[4].setText("");
	//							}
	//						}
	//						else if(((JButton)ae.getSource()).getText() == buttonArray[5].getText()){
	//							System.out.println("Clicked button 6");
	//							if(buttonArray[2].getBackground() == Color.BLACK){
	//								buttonArray[5].setBackground(Color.BLACK);
	//								buttonArray[2].setBackground(Color.WHITE);
	//								buttonArray[2].setText(buttonArray[5].getText());
	//								buttonArray[5].setText("");
	//							}
	//							else if(buttonArray[4].getBackground() == Color.BLACK){
	//								buttonArray[5].setBackground(Color.BLACK);
	//								buttonArray[4].setBackground(Color.WHITE);
	//								buttonArray[4].setText(buttonArray[5].getText());
	//								buttonArray[5].setText("");
	//							}
	//							else if(buttonArray[8].getBackground() == Color.BLACK){
	//								buttonArray[5].setBackground(Color.BLACK);
	//								buttonArray[8].setBackground(Color.WHITE);
	//								buttonArray[8].setText(buttonArray[5].getText());
	//								buttonArray[5].setText("");
	//							}
	//						}
	//						else if(((JButton)ae.getSource()).getText() == buttonArray[6].getText()){
	//							System.out.println("Clicked button 7");
	//							if(buttonArray[3].getBackground() == Color.BLACK){
	//								buttonArray[6].setBackground(Color.BLACK);
	//								buttonArray[3].setBackground(Color.WHITE);
	//								buttonArray[3].setText(buttonArray[6].getText());
	//								buttonArray[6].setText("");
	//							}
	//							else if(buttonArray[7].getBackground() == Color.BLACK){
	//								buttonArray[6].setBackground(Color.BLACK);
	//								buttonArray[7].setBackground(Color.WHITE);
	//								buttonArray[7].setText(buttonArray[6].getText());
	//								buttonArray[6].setText("");
	//							}
	//						}
	//						else if(((JButton)ae.getSource()).getText() == buttonArray[7].getText()){
	//							System.out.println("Clicked button 8");
	//							if(buttonArray[4].getBackground() == Color.BLACK){
	//								buttonArray[7].setBackground(Color.BLACK);
	//								buttonArray[4].setBackground(Color.WHITE);
	//								buttonArray[4].setText(buttonArray[7].getText());
	//								buttonArray[7].setText("");
	//							}
	//							else if(buttonArray[6].getBackground() == Color.BLACK){
	//								buttonArray[7].setBackground(Color.BLACK);
	//								buttonArray[6].setBackground(Color.WHITE);
	//								buttonArray[6].setText(buttonArray[7].getText());
	//								buttonArray[7].setText("");
	//
	//							}}
	//						else if(((JButton)ae.getSource()).getText() == buttonArray[8].getText()){
	//							System.out.println("Clicked button 9");
	//							if(buttonArray[5].getBackground() == Color.BLACK){
	//								buttonArray[8].setBackground(Color.BLACK);
	//								buttonArray[5].setBackground(Color.WHITE);
	//								buttonArray[5].setText(buttonArray[8].getText());
	//								buttonArray[8].setText("");
	//							}
	//							else if(buttonArray[7].getBackground() == Color.BLACK){
	//								buttonArray[8].setBackground(Color.BLACK);
	//								buttonArray[7].setBackground(Color.WHITE);
	//								buttonArray[7].setText(buttonArray[8].getText());
	//								buttonArray[8].setText("");
	//							}
	//						}
	//						
	//					}		
	//		}});
	//		}
	//		
	//		mainFrame.setVisible(true);}
	//

	//	}







	//		for (int i = 0; i < n; i++) {
	//			for (int j = 0; j < n; j++) {
	//
	//
	//				if (buttonCounter == count) {
	//					break;
	//				}
	//				buttonCounter++;
	//			}
	//		}
	//}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

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
