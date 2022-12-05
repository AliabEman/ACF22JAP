import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumPuzClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String PROTOCOL_SEPARATOR = "#";
	static final String FIELD_SEPARATOR = ",";
	static final String PROTOCOL_END = "P0";
	static final String PROTOCOL_SENDGAME = "P1";
	static final String PROTOCOL_RECVGAME = "P2";
	static final String PROTOCOL_DATA = "P3";

	static final String IMAGE_NAME = "numpuz-a12-images/game.png";

	static String DEFAULT_USER = "NumPuzHero";
	static String DEFAULT_ADDR = "localhost";
	static int DEFAULT_PORT = 12345;

	private static final String gameLogo= "C:\\Users\\aliab\\eclipse-workspace\\A32-CS_Architecture\\src\\numpuz-a12-images\\client.png";
	public static ImageIcon gameIcon;


	private static JFrame mainFrame;
	private static JPanel mainPanel;
	private static JLabel numPuzSplash;
	private static int playerCount[] = {1,2,3,4,5,6,7,8,9};


	private static void showGUI(Socket socket, DataInputStream dis, DataOutputStream dos, Scanner scn) {
		try {
			mainFrame = new JFrame("Player " + " - JAP (FALL 2022)");
			mainPanel = new JPanel();
			mainFrame.setSize(540,400);

			mainFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent windowEvent) {

					try {
						String toSend = "Connection closed.";
						System.out.println("Exiting game...");
						dos.writeUTF(toSend);
						socket.close();
						dis.close();
						dos.close();
						System.exit(0);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});

			gameIcon = new ImageIcon(gameLogo);

			numPuzSplash = new JLabel(gameIcon);
			numPuzSplash.setSize(100, 100);


			mainPanel.setLayout(new FlowLayout());
			mainPanel.add(numPuzSplash, BorderLayout.NORTH);
			mainFrame.add(mainPanel);
			mainFrame.setVisible(true);

			while(true) {
				System.out.println(dis.readUTF());
				String toSend = scn.nextLine();
				dos.writeUTF(toSend);

				if (toSend.equals("Exit")) {
					socket.close();
					System.out.println("Connection closed.");
					break;
				}
				String received = dis.readUTF();
				System.out.println(received);
			}

			scn.close();
			dis.close();
			dos.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public static void main(String args[]) throws IOException {
		try {
			Scanner scn = new Scanner(System.in);

			Socket socket = new Socket(DEFAULT_ADDR, DEFAULT_PORT);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			showGUI(socket, dis, dos, scn);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

