import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{

	public static void main(String[] args) {
		JFrame main = new JFrame();
		JPanel gameFrame = new JPanel();
		JPanel sideFrame = new JPanel();
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
		main.setVisible(true);
		//sideFrame.add(numPuzSizes.numPuzComboBox);
	}

}
