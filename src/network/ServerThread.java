package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Dean Cook<deanrobertcook@gmail.com>
 */
public class ServerThread extends Thread {
	
	private final Socket clientSocket;
	
	public ServerThread(Socket clientSocket) {
		super("Server");
		this.clientSocket = clientSocket;	
	}
	
	@Override
	public void run() {
		try {
			PrintWriter out
					= new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Client sent: " + inputLine);
				out.println(inputLine);
			}
		} catch (IOException e) {
			System.out.println("Failed printing client message ");
		}
	}
}
