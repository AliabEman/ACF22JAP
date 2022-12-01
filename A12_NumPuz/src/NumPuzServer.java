import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;

public class NumPuzServer extends JFrame  {
	//Goal: to start the ServerSocket and perform communication with clients

	public NumPuzServer() {

	}
	public void execute() {
		int numRequest = 0;
		try (ServerSocket s = new ServerSocket(10)) {
			while(true) {
				System.out.println("Current request: " + numRequest++);
				Socket soc = s.accept();
				System.out.println("Current request: " + numRequest++);
				DataOutputStream out = new DataOutputStream(soc.getOutputStream());
				out.writeBytes("Server Date: " + (new Date()).toString() + "\n");
				out.close();
				soc.close();
			}
		} catch (Exception e) {
			System.out.println("Error on server!");
		}

		class Player {
			String name;
			int id;
			int points;
			int time;
		}

	}
}
