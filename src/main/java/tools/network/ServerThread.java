package tools.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Dean Cook<deanrobertcook@gmail.com>
 */
public class ServerThread implements Runnable {

	protected final Server server;
	protected final Socket clientSocket;
	protected final int threadId;

	public ServerThread(Server server, Socket clientSocket, int threadId) {
		this.server = server;
		this.clientSocket = clientSocket;
		this.threadId = threadId;
	}

	public PrintWriter getOutStream() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(this.clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return out;
	}

	public BufferedReader getInStream() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(
					new InputStreamReader(this.clientSocket.getInputStream()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return in;
	}

	@Override
	public void run() {
		PrintWriter out = this.getOutStream();
		BufferedReader in = this.getInStream();
		String inputLine;
		try {
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Client " + this.threadId + " sent: " + inputLine);
				out.println(inputLine);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		this.closeConnection();
	}
	
	public void closeConnection() {
		System.out.println("Client connection lost");
		this.server.removeConnection(threadId);
	}
}
