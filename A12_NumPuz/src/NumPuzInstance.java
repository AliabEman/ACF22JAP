import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NumPuzInstance {

	/**
	 * Default constructor.
	 */
	public NumPuzInstance() {
		; // No commands
	}
	
	/**
	 * Execute method.
	 */
	public void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				NumPuzFrame frame = new NumPuzFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setMinimumSize(new Dimension(300, 250));
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
			}
		});
	}
}

class NumPuzFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String gameLogo= "src/numpuz-a12-images/gamelogo.png";

	JFrame numPuz;

	JTextField userText;
	JTextField serverText;
	
	JButton newGame;
	JButton sendGame;
	JButton receiveGame;
	JButton sendData;
	JButton play;
	JButton connect;
	JButton end;
	JTextArea creatingNewMVCgame;
	
	public void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				NumPuzFrame frame = new NumPuzFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setMinimumSize(new Dimension(300, 250));
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
			}
		});
	}
	
	public void run() {
		
	}
}

