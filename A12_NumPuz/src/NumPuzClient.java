import java.io.DataOutputStream;
import java.net.*;
import java.io.*;
import java.util.*;

public class NumPuzClient {
	
	static final String PROTOCOL_SEPARATOR = "#";
	static final String FIELD_SEPARATOR = ",";
	static final String PROTOCOL_END = "P0";
	static final String PROTOCOL_SENDGAME = "P1";
	static final String PROTOCOL_RECVGAME = "P2";
	static final String PROTOCOL_DATA = "P3";
	
	static final String IMAGE_NAME = "numpuz-a12-images/game.png";
	
	static String DEFAULT_USER = "NumPuzHero ";
	static String DEFAULT_ADDR = "localhost";
	static int DEFAULT_PORT = 12345;
	//Purpose: Once connected by Socket, client is responsible to start a game
	//with a defined configuration.

	public NumPuzClient() {

	}

	public void execute() {	
		Socket soc;
		try {
			soc = new Socket(InetAddress.getLocalHost(), 13);
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			System.out.println(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}
