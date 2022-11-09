/*https://stackoverflow.com/questions/37448311/looping-to-make-jbuttons-that-hold-their-name-values
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


public class GameController extends JPanel implements ItemListener {
	private static final String gameLogo= "A12_NumPuzz/src/numpuz-a12-images/gamelogo.png";
	private static final String newGameLogo= "A12_NumPuzz/src/numpuz-a12-images/iconnew.png";
	private static final String solutionGameLogo= "A12_NumPuzz/src/numpuz-a12-images/iconsol.png";
	private static final String exitGameLogo= "A12_NumPuzz/src/numpuz-a12-images/iconext.png";
	private static final String colorsGameLogo= "A12_NumPuzz/src/numpuz-a12-images/iconcol.png";
	private static final String aboutGameLogo= "A12_NumPuzz/src/numpuz-a12-images/iconabt.png";
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
		JButton x0y0 = new JButton("0:0");
		JButton x0y1 = new JButton("0:1");
		JButton x0y2 = new JButton("0:2");
		JButton x0y3 = new JButton("0:3");
		JButton x0y4 = new JButton("0:4");
		JButton x0y5 = new JButton("0:5");
		JButton x0y6 = new JButton("0:6");
		JButton x0y7 = new JButton("0:7");
		JButton x0y8 = new JButton("0:8");
		JButton x1y0 = new JButton("1:0");
		JButton x1y1 = new JButton("1:1");
		JButton x1y2 = new JButton("1:2");
		JButton x1y3 = new JButton("1:3");
		JButton x1y4 = new JButton("1:4");
		JButton x1y5 = new JButton("1:5");
		JButton x1y6 = new JButton("1:6");
		JButton x1y7 = new JButton("1:7");
		JButton x1y8 = new JButton("1:8");
		JButton x2y0 = new JButton("2:0");
		JButton x2y1 = new JButton("2:1");
		JButton x2y2 = new JButton("2:2");
		JButton x2y3 = new JButton("2:3");
		JButton x2y4 = new JButton("2:4");
		JButton x2y5 = new JButton("2:5");
		JButton x2y6 = new JButton("2:6");
		JButton x2y7 = new JButton("2:7");
		JButton x2y8 = new JButton("2:8");
		JButton x3y0 = new JButton("3:0");
		JButton x3y1 = new JButton("3:1");
		JButton x3y2 = new JButton("3:2");
		JButton x3y3 = new JButton("3:3");
		JButton x3y4 = new JButton("3:4");
		JButton x3y5 = new JButton("3:5");
		JButton x3y6 = new JButton("3:6");
		JButton x3y7 = new JButton("3:7");
		JButton x3y8 = new JButton("3:8");
		JButton x4y0 = new JButton("4:0");
		JButton x4y1 = new JButton("4:1");
		JButton x4y2 = new JButton("4:2");
		JButton x4y3 = new JButton("4:3");
		JButton x4y4 = new JButton("4:4");
		JButton x4y5 = new JButton("4:5");
		JButton x4y6 = new JButton("4:6");
		JButton x4y7 = new JButton("4:7");
		JButton x4y8 = new JButton("4:8");
		JButton x5y0 = new JButton("5:0");
		JButton x5y1 = new JButton("5:1");
		JButton x5y2 = new JButton("5:2");
		JButton x5y3 = new JButton("5:3");
		JButton x5y4 = new JButton("5:4");
		JButton x5y5 = new JButton("5:5");
		JButton x5y6 = new JButton("5:6");
		JButton x5y7 = new JButton("5:7");
		JButton x5y8 = new JButton("5:8");
		JButton x6y0 = new JButton("6:0");
		JButton x6y1 = new JButton("6:1");
		JButton x6y2 = new JButton("6:2");
		JButton x6y3 = new JButton("6:3");
		JButton x6y4 = new JButton("6:4");
		JButton x6y5 = new JButton("6:5");
		JButton x6y6 = new JButton("6:6");
		JButton x6y7 = new JButton("6:7");
		JButton x6y8 = new JButton("6:8");
		JButton x7y0 = new JButton("7:0");
		JButton x7y1 = new JButton("7:1");
		JButton x7y2 = new JButton("7:2");
		JButton x7y3 = new JButton("7:3");
		JButton x7y4 = new JButton("7:4");
		JButton x7y5 = new JButton("7:5");
		JButton x7y6 = new JButton("7:6");
		JButton x7y7 = new JButton("7:7");
		JButton x7y8 = new JButton("7:8");
		JButton x8y0 = new JButton("8:0");
		JButton x8y1 = new JButton("8:1");
		JButton x8y2 = new JButton("8:2");
		JButton x8y3 = new JButton("8:3");
		JButton x8y4 = new JButton("8:4");
		JButton x8y5 = new JButton("8:5");
		JButton x8y6 = new JButton("8:6");
		JButton x8y7 = new JButton("8:7");
		JButton x8y8 = new JButton("8:8");






		JButton[] s3 = new JButton[9];
					s3[0] = x0y0;
					s3[1] = x0y1;
					s3[2] = x0y2;
					s3[3] = x1y0;
					s3[4] = x1y1;
					s3[5] = x1y2;
					s3[6] = x2y0;
					s3[7] = x2y1;
					s3[8] = x2y2;

		JButton[] s4 = new JButton[16];
					s4[0] = x0y0;
					s4[1] = x0y1;
					s4[2] = x0y2;
					s4[3] = x0y3;
					s4[4] = x1y0;
					s4[5] = x1y1;
					s4[6] = x1y2;
					s4[7] = x1y3;
					s4[8] = x2y0;
					s4[9] = x2y1;
					s4[10] = x2y2;
					s4[11] = x2y3;
					s4[12] = x3y0;
					s4[13] = x3y1;
					s4[14] = x3y2;
					s4[15] = x3y3;
		JButton[] s5 = new JButton[25];
			s5[0] = x0y0;
			s5[1] = x0y1;
			s5[2] = x0y2;
			s5[3] = x0y3;
			s5[4] = x0y4;
			s5[5] = x1y0;
			s5[6] = x1y1;
			s5[7] = x1y2;
			s5[8] = x1y3;
			s5[9] = x1y4;
			s5[10] = x2y0;
			s5[11] = x2y1;
			s5[12] = x2y2;
			s5[13] = x2y3;
			s5[14] = x2y4;
			s5[15] = x3y0;
			s5[16] = x3y1;
			s5[17] = x3y2;
			s5[18] = x3y3;
			s5[19] = x3y4;
			s5[20] = x4y0;
			s5[21] = x4y1;
			s5[22] = x4y2;
			s5[23] = x4y3;
			s5[24] = x4y4;
		JButton[] s6 = new JButton[36];
		s6[0] = x0y0;
		s6[1] = x0y1;
		s6[2] = x0y2;
		s6[3] = x0y3;
		s6[4] = x0y4;
		s6[5] = x0y5;
		s6[6] = x1y0;
		s6[7] = x1y1;
		s6[8] = x1y2;
		s6[9] = x1y3;
		s6[10] = x1y4;
		s6[11] = x1y5;
		s6[12] = x2y0;
		s6[13] = x2y1;
		s6[14] = x2y2;
		s6[15] = x2y3;
		s6[16] = x2y4;
		s6[17] = x2y5;
		s6[18] = x3y0;
		s6[19] = x3y1;
		s6[20] = x3y2;
		s6[21] = x3y3;
		s6[22] = x3y4;
		s6[23] = x3y5;
		s6[24] = x4y0;
		s6[25] = x4y1;
		s6[26] = x4y2;
		s6[27] = x4y3;
		s6[28] = x4y4;
		s6[29] = x4y5;
		s6[30] = x5y0;
		s6[31] = x5y1;
		s6[32] = x5y2;
		s6[33] = x5y3;
		s6[34] = x5y4;
		s6[35] = x5y5;
		JButton[] s7 = new JButton[49];
		s7[0] = x0y0;
		s7[1] = x0y1;
		s7[2] = x0y2;
		s7[3] = x0y3;
		s7[4] = x0y4;
		s7[5] = x0y5;
		s7[6] = x0y6;
		s7[7] = x1y0;
		s7[8] = x1y1;
		s7[9] = x1y2;
		s7[10] = x1y3;
		s7[11] = x1y4;
		s7[12] = x1y5;
		s7[13] = x1y6;
		s7[14] = x2y0;
		s7[15] = x2y1;
		s7[16] = x2y2;
		s7[17] = x2y3;
		s7[18] = x2y4;
		s7[19] = x2y5;
		s7[20] = x2y6;
		s7[21] = x3y0;
		s7[22] = x3y1;
		s7[23] = x3y2;
		s7[24] = x3y3;
		s7[25] = x3y4;
		s7[26] = x3y5;
		s7[27] = x3y6;
		s7[28] = x4y0;
		s7[29] = x4y1;
		s7[30] = x4y2;
		s7[31] = x4y3;
		s7[32] = x4y4;
		s7[33] = x4y5;
		s7[34] = x4y6;
		s7[35] = x5y0;
		s7[36] = x5y1;
		s7[37] = x5y2;
		s7[38] = x5y3;
		s7[39] = x5y4;
		s7[40] = x5y5;
		s7[41] = x5y6;
		s7[42] = x6y0;
		s7[43] = x6y1;
		s7[44] = x6y2;
		s7[45] = x6y3;
		s7[46] = x6y4;
		s7[47] = x6y5;
		s7[48] = x6y6;
		JButton[] s8 = new JButton[64];
		s8[0] = x0y0;
		s8[1] = x0y1;
		s8[2] = x0y2;
		s8[3] = x0y3;
		s8[4] = x0y4;
		s8[5] = x0y5;
		s8[6] = x0y6;
		s8[7] = x0y7;
		s8[8] = x1y0;
		s8[9] = x1y1;
		s8[10] = x1y2;
		s8[11] = x1y3;
		s8[12] = x1y4;
		s8[13] = x1y5;
		s8[14] = x1y6;
		s8[15] = x1y7;
		s8[16] = x2y0;
		s8[17] = x2y1;
		s8[18] = x2y2;
		s8[19] = x2y3;
		s8[20] = x2y4;
		s8[21] = x2y5;
		s8[22] = x2y6;
		s8[23] = x2y7;
		s8[24] = x3y0;
		s8[25] = x3y1;
		s8[26] = x3y2;
		s8[27] = x3y3;
		s8[28] = x3y4;
		s8[29] = x3y5;
		s8[30] = x3y6;
		s8[31] = x3y7;
		s8[32] = x4y0;
		s8[33] = x4y1;
		s8[34] = x4y2;
		s8[35] = x4y3;
		s8[36] = x4y4;
		s8[37] = x4y5;
		s8[38] = x4y6;
		s8[39] = x4y7;
		s8[40] = x5y0;
		s8[41] = x5y1;
		s8[42] = x5y2;
		s8[43] = x5y3;
		s8[44] = x5y4;
		s8[45] = x5y5;
		s8[46] = x5y6;
		s8[47] = x5y7;
		s8[48] = x6y0;
		s8[49] = x6y1;
		s8[50] = x6y2;
		s8[51] = x6y3;
		s8[52] = x6y4;
		s8[53] = x6y5;
		s8[54] = x6y6;
		s8[55] = x6y7;
		s8[56] = x7y0;
		s8[57] = x7y1;
		s8[58] = x7y2;
		s8[59] = x7y3;
		s8[60] = x7y4;
		s8[61] = x7y5;
		s8[62] = x7y6;
		s8[63] = x7y7;
		JButton[] s9 = new JButton[81];
		s9[0] = x0y0;
		s9[1] = x0y1;
		s9[2] = x0y2;
		s9[3] = x0y3;
		s9[4] = x0y4;
		s9[5] = x0y5;
		s9[6] = x0y6;
		s9[7] = x0y7;
		s9[8] = x0y8;
		s9[9] = x1y0;
		s9[10] = x1y1;
		s9[11] = x1y2;
		s9[12] = x1y3;
		s9[13] = x1y4;
		s9[14] = x1y5;
		s9[15] = x1y6;
		s9[16] = x1y7;
		s9[17] = x1y8;
		s9[18] = x2y0;
		s9[19] = x2y1;
		s9[20] = x2y2;
		s9[21] = x2y3;
		s9[22] = x2y4;
		s9[23] = x2y5;
		s9[24] = x2y6;
		s9[25] = x2y7;
		s9[26] = x2y8;
		s9[27] = x3y0;
		s9[28] = x3y1;
		s9[29] = x3y2;
		s9[30] = x3y3;
		s9[31] = x3y4;
		s9[32] = x3y5;
		s9[33] = x3y6;
		s9[34] = x3y7;
		s9[35] = x3y8;
		s9[36] = x4y0;
		s9[37] = x4y1;
		s9[38] = x4y2;
		s9[39] = x4y3;
		s9[40] = x4y4;
		s9[41] = x4y5;
		s9[42] = x4y6;
		s9[43] = x4y7;
		s9[44] = x4y8;
		s9[45] = x5y0;
		s9[46] = x5y1;
		s9[47] = x5y2;
		s9[48] = x5y3;
		s9[49] = x5y4;
		s9[50] = x5y5;
		s9[51] = x5y6;
		s9[52] = x5y7;
		s9[53] = x5y8;
		s9[54] = x6y0;
		s9[55] = x6y1;
		s9[56] = x6y2;
		s9[57] = x6y3;
		s9[58] = x6y4;
		s9[59] = x6y5;
		s9[60] = x6y6;
		s9[61] = x6y7;
		s9[62] = x6y8;
		s9[63] = x7y0;
		s9[64] = x7y1;
		s9[65] = x7y2;
		s9[66] = x7y3;
		s9[67] = x7y4;
		s9[68] = x7y5;
		s9[69] = x7y6;
		s9[70] = x7y7;
		s9[71] = x7y8;
		s9[72] = x8y0;
		s9[73] = x8y1;
		s9[74] = x8y2;
		s9[75] = x8y3;
		s9[76] = x8y4;
		s9[77] = x8y5;
		s9[78] = x8y6;
		s9[79] = x8y7;
		s9[80] = x8y8;

		dimensionChoices = new JComboBox(dimensionsComboBox);
		//dimensionsComboBox.addItemListener(s);

		dimensionChoices.setBounds(50,50,90,20);
		dimensionChoices.setSelectedIndex(0);
		controlPanelGridBag.gridx = 1;
		controlPanel.add(dimensionChoices, controlPanelGridBag);
		String choice = (String) dimensionChoices.getItemAt(dimensionChoices.getSelectedIndex());
		gameButtons(choice);
		dimensionChoices.addActionListener(new ActionListener() {     
			@Override
			public void actionPerformed(ActionEvent e) {
			   System.out.println("Value: " + dimensionChoices.getSelectedItem().toString());

			   
			   gamePanel.revalidate();
			   gamePanel.repaint();


		  
			   if(dimensionChoices.getSelectedItem().toString().equals("3")){
				   gameButtons("3");
				  
				   int n = 3;
				   int v = 9;
				   gamePanel = new JPanel(new GridLayout(n, n)); //need to replace with dynamic array for sizing
				   int count = 0;
				   mainFrame.add(gamePanel);
				   
				   for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
				   			gamePanel.add(s3[+count++],BorderLayout.CENTER);
							   //Component.setVisible(s3[+count++]);
							for (int q = 1; q == v; q++) {
								gamePanel.setComponentZOrder(s3[i],q);
								s3[q].setVisible(true);
							}
						    gamePanel.revalidate();
							gamePanel.repaint();
							//s3[q].setVisible(true);
							
							
							
				  
						}
				   }
				   
				}

			   else if(dimensionChoices.getSelectedItem().toString().equals("4")){
				   gameButtons("4");
				   gamePanel.removeAll();
				   int n = 4;
				   gamePanel = new JPanel(new GridLayout(n, n)); //need to replace with dynamic array for sizing
				   int count = 0;
				   mainFrame.add(gamePanel);
				   int v = 16;
				   for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							gamePanel.add(s4[+count++],BorderLayout.CENTER);
							for (int q = 1; q == v; q++) {
								gamePanel.setComponentZOrder(s4[i],q);
								s4[q].setVisible(true);
							}
						    gamePanel.revalidate();
							gamePanel.repaint();
							gamePanel.setComponentZOrder(s4[i],j);
				  
						}
				   }
					
			   }
			   else if(dimensionChoices.getSelectedItem().toString().equals("5")){
				   gameButtons("5");
				   //option(5);
				   int n = 5;
				   gamePanel = new JPanel(new GridLayout(n, n)); //need to replace with dynamic array for sizing
				   int count = 0;
				   mainFrame.add(gamePanel);
				   for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							gamePanel.add(s5[+count++],BorderLayout.CENTER);
						    gamePanel.revalidate();
							gamePanel.repaint();
							gamePanel.setComponentZOrder(s5[i],j);
				  
						}
				   }

			   }
			   else if(dimensionChoices.getSelectedItem().toString().equals("6")){
				   gameButtons("6");
				   int n = 6;
				   gamePanel = new JPanel(new GridLayout(n, n)); //need to replace with dynamic array for sizing
				   int count = 0;
				   mainFrame.add(gamePanel);
				   for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							gamePanel.add(s6[+count++],BorderLayout.CENTER);
						    gamePanel.revalidate();
							gamePanel.repaint();
							gamePanel.setComponentZOrder(s6[i],j);
				  
						}
				   }

			   }
			   else if(dimensionChoices.getSelectedItem().toString().equals("7")){
				   gameButtons("7");
				   int n = 7;
				   gamePanel = new JPanel(new GridLayout(n, n)); //need to replace with dynamic array for sizing
				   int count = 0;
				   mainFrame.add(gamePanel);
				   for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							gamePanel.add(s7[+count++],BorderLayout.CENTER);
						    gamePanel.revalidate();
							gamePanel.repaint();
							gamePanel.setComponentZOrder(s7[i],j);
				  
						}
				   }

			   }
			   else if(dimensionChoices.getSelectedItem().toString().equals("8")){
				   gameButtons("8");
				   int n = 8;
				   int t = 64;
				   gamePanel = new JPanel(new GridLayout(n, n)); //need to replace with dynamic array for sizing
				   int count = 0;
				   mainFrame.add(gamePanel);
				   for (int i = 0; i < t; i++) {
						for (int j = 0; j < t; j++) {
							gamePanel.add(s8[i],BorderLayout.CENTER);
						    gamePanel.revalidate();
							gamePanel.repaint();
							
							gamePanel.setComponentZOrder(s8[i],j);
							System.out.print(getComponentZOrder(gamePanel));
						}
				   }

			   }
			   else if(dimensionChoices.getSelectedItem().toString().equals("9")){
				   gameButtons("9");
				   int n = 9;
				   gamePanel = new JPanel(new GridLayout(n, n)); //need to replace with dynamic array for sizing
				   int count = 0;
				   mainFrame.add(gamePanel);
				   for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							gamePanel.add(s9[+count++],BorderLayout.CENTER);
						    gamePanel.revalidate();
							gamePanel.repaint();
							gamePanel.setComponentZOrder(s9[i],j);
				  
						}
				   }

			   }
			   gamePanel.revalidate();
               gamePanel.repaint();
			   //option(dimensionChoices.getSelectedItem());
			}
		});
	}
	/*public void itemStateChanged(ItemEvent e){
		if (e.getSource() == dimensionChoices) {
 
            System.out.print(dimensionChoices.getSelectedItem() + " selected");
        }
 
        // if state of combobox 2 is changed
	}*/

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
		int n = Integer.parseInt(dimensionChosen);

		option(n);
		if (dimensionChosen == "3") {
			n = dimension[0];
			option(n);
		}
		else if (dimensionChosen == "4") {
			n = dimension[1];
			option(n);
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
	}
	void option(int n) {
			
		if (n == 18) {
			gamePanel.removeAll();
            gamePanel.revalidate();
            gamePanel.repaint();
			int count = 1;
			mainFrame.add(gamePanel);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					gamePanel.add(new JButton(""+count++), BorderLayout.CENTER);
				}
			}
		}
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
