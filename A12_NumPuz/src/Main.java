import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Main extends JFrame implements ActionListener{

	public static void main(String[] args) {
		JFrame main = new JFrame();
	
		JPanel mainFrame = new JPanel();
		JPanel sideFrame = new JPanel();
		
		main.setVisible(true);
		main.setSize(400,600);

		mainFrame.setVisible(true);
		mainFrame.setSize(300,300);
		
		sideFrame.setVisible(true);
		sideFrame.setSize(200,300);
		
		main.add(mainFrame);
		main.add(sideFrame);
		
		JButton button1 = new JButton("1");		
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		
		mainFrame.add(button1);
		mainFrame.add(button2);
		mainFrame.add(button3);
		mainFrame.add(button4);
		mainFrame.add(button5);
		mainFrame.add(button6);
		mainFrame.add(button7);
		mainFrame.add(button8);
		mainFrame.add(button9);
		
	    mainFrame.setLayout(new GridLayout(3,3));
	    

	    mainFrame.setSize(300,300);
	    mainFrame.setVisible(true);
	    
	    JTextArea textBox = new JTextArea();
	    
	    sideFrame.add(textBox);
	    textBox.setVisible(true);
	    textBox.setSize(100, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
