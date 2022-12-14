import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//hello
public class Main extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame main = new JFrame();
		JPanel gameFrame = new JPanel();
		JPanel sideFrame = new JPanel();
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu, helpMenu;
		
		gameMenu = new JMenu("Game");		
		JMenuItem gameMenuItem1 = new JMenuItem("Game Option 1");
		JMenuItem gameMenuItem2 = new JMenuItem("Game Option 2");
		gameMenu.add(gameMenuItem1);
		gameMenu.addSeparator();
		gameMenu.add(gameMenuItem2);
		gameMenu.addSeparator();

		helpMenu = new JMenu("Help");
		JMenuItem helpMenuItem1 = new JMenuItem("Help Option 1");
		helpMenu.addSeparator();
		JMenuItem helpMenuItem2 = new JMenuItem("Help Option 2");
		helpMenu.addSeparator();

		helpMenu.add(helpMenuItem1);
		helpMenu.add(helpMenuItem2);
		
		

		menuBar.add(gameMenu);
		menuBar.add(helpMenu);
		
		
		//JButton gameBoard[][] = null;
		//int dimChoice;
		
		GameController game = new GameController();
		
	
		
		//dimChoice=2;
		

		//NumPuzSizeOptions numPuzSizes = new NumPuzSizeOptions();

		main.setSize(600,600);

		
		gameFrame.setSize(400,200);
		sideFrame.setSize(200,300);
		
		gameFrame.setLayout(new GridLayout(3,3));
		gameFrame.isPreferredSizeSet();

		main.setLayout(new GridLayout(1,2));
		main.add(gameFrame);
		main.add(sideFrame);
		main.add(game);
		sideFrame.add(game);
		
		

//		for (int i = 0; i<dim[dimChoice]; i++) {
//			for (int j=0; j<dim[dimChoice]; j++) {
//				gameBoard[i][j]= new JButton(i + "");
//				gameFrame.add(gameBoard[i][j]);
//			}
//		}
		JButton button1 = new JButton("1");		
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton(" ");


		gameFrame.add(button1);
		gameFrame.add(button2);
		gameFrame.add(button3);
		gameFrame.add(button4);
		gameFrame.add(button5);
		gameFrame.add(button6);
		gameFrame.add(button7);
		gameFrame.add(button8);
		gameFrame.add(button9);

		game.setVisible(true);
		gameFrame.setVisible(true);
		sideFrame.setVisible(true);
		main.setJMenuBar(menuBar);
		main.setVisible(true);
		//sideFrame.add(numPuzSizes.numPuzComboBox);
	}

}
