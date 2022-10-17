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

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main{

	public static void main(String[] args) {
		GameController game = new GameController();
		game.instantiateGamePieces();
		//game.gameButtons();
		game.preparePanelLayouts();
		game.gameControlPanel();
		game.gameRadioButton();
	}
}
