import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NumPuzServer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private static final String gameLogo= "C:\\Users\\aliab\\eclipse-workspace\\A32-CS_Architecture\\src\\numpuz-a12-images\\server.png";
	public static ImageIcon gameIcon;


	private static JFrame mainFrame;
	private static JPanel mainPanel;
	private static JLabel numPuzSplash;
	private static JTextField textField;
	private static JButton submit;
	private static JButton results;
	private static JCheckBox finalize;
	private static JButton end;
	private static JTextArea textArea;


	static int DEFAULT_PORT = 12345;

	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream dataInputStream = null;

	// label to display text
	private static JLabel textLabel;



	public NumPuzServer(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("Server started.");

			System.out.println("Waiting for a client");

			socket = server.accept();
			System.out.println("Client accepted");

			dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

			String line = "";

			while(!line.equals("Connection closed.")) {
				try {
					line = dataInputStream.readUTF();
					System.out.println(line);
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			System.out.println("Closing connection");
			dataInputStream.close();
			socket.close();
		} catch(IOException e) {
			System.out.println(e);
		}
	}

	//View
	private static void showGUI() {
		mainFrame = new JFrame("Game Server - JAP (FALL 2022)");
		mainPanel = new JPanel();
		mainFrame.setSize(540,600);

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		gameIcon = new ImageIcon(gameLogo);
		textLabel = new JLabel("Port:");
		textField = new JTextField(10);
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			System.out.println("clicked submit");
			}
		});
		results = new JButton("Results");
		end = new JButton("End");
		results.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			System.out.println("clicked results");
			}
		});
		
		finalize = new JCheckBox("Finalize");
		
		textArea = new JTextArea(100, 50);
		
		numPuzSplash = new JLabel(gameIcon);
		numPuzSplash.setSize(100, 100);


		mainPanel.setLayout(new FlowLayout());
		mainPanel.add(numPuzSplash, BorderLayout.NORTH);
		mainPanel.add(textLabel, BorderLayout.CENTER);
		mainPanel.add(textField, BorderLayout.CENTER);
		mainPanel.add(submit, BorderLayout.CENTER);
		mainPanel.add(results, BorderLayout.CENTER);
		mainPanel.add(finalize, BorderLayout.CENTER);
		mainPanel.add(end, BorderLayout.CENTER);
		mainPanel.add(textArea, BorderLayout.SOUTH);
		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);

	}


	public static void main(String[] args) throws IOException{
		// TODO Auto-generated constructor stub
		showGUI();
		ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
		int count = 1;

		while(true) {
			Socket newSocket = null;

			try {

				newSocket = serverSocket.accept();
				System.out.println("New player has entered the game: " + newSocket);

				DataInputStream dataInputStream = new DataInputStream(newSocket.getInputStream());
				DataOutputStream dataOutputStream = new DataOutputStream(newSocket.getOutputStream());

				System.out.println("Assinging new thread for player[" + count + "]");

				Thread t = new ClientHandler(newSocket, dataInputStream, dataOutputStream, count);

				t.start();
				count++;
			} catch (Exception e) {
				serverSocket.close();
				newSocket.close();
				e.printStackTrace();
			}
		}
	}

}

class ClientHandler extends Thread {

	final DataInputStream dataInputStream;
	final DataOutputStream dataOutputStream;
	final Socket socket;
	final int playerCount;

	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, int player) {
		this.socket = s;
		this.dataInputStream = dis;
		this.dataOutputStream = dos;
		this.playerCount = player;
	}

	@Override
	public void run() {

		String received;
		//String toReturn;

		while(true) {
			try {

				dataOutputStream.writeUTF("Hello Player[" + this.playerCount + "]\n(Type Exit to terminate the connection!)");
				received = dataInputStream.readUTF();

				if (received.equals("Connection closed.")) {
					System.out.println("Player[" + this.playerCount + "] has left the game...");
					System.out.println("Closing the connection.");
					this.socket.close();
					System.out.println("Connection Closed");
					break;
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
