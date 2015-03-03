package tools.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import tools.utility.Util;

/**
 * @author Dean Cook<deanrobertcook@gmail.com>
 */
public class Server {

	private int portNumber;
	private final ServerSocket serverSocket;
	private boolean listening = true;
	private final int maxThreads;
	private boolean[] threadIds;
	private String ipAddress;

	public Server(int portNumber) {
		this(portNumber, 1);
	}
	
	public Server(int portNumber, int maxThreads) {
		try {
			this.ipAddress = InetAddress.getLocalHost().getHostAddress();
			System.out.println("Current IP Address: " + this.ipAddress);
		} catch (UnknownHostException ex) {
			System.err.println(ex.getMessage());
		}
		this.portNumber = portNumber;
		this.maxThreads = maxThreads;
		this.threadIds = new boolean[this.maxThreads];
		ServerSocket socket = null;
		try {
			socket = new ServerSocket(this.portNumber);
		} catch (IOException e) {
			System.err.println("Could not listen on port " + portNumber);
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		this.serverSocket = socket;
		
	}
	
	

	public void listen() {
		while (listening) {
			try {
				Socket socket = this.serverSocket.accept();
				int nextId = this.nextThreadId();
				ServerThread serverThread = new ServerThread(
						this, socket, nextId);
				this.addConnection(serverThread, nextId);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public void addConnection(ServerThread serverThread, int nextId) {
		System.out.println("Attempting to connect to client: " + nextId);
		if (nextId < this.maxThreads) {
			this.threadIds[nextId] = true;
			new Thread(serverThread).start();
		} else {
			serverThread.closeConnection();
		}
		Util.printArray(threadIds, "Threads free: ");
		System.out.println("Next free thread: " + this.nextThreadId());
	}
	
	public void removeConnection(int threadId) {
		System.out.println("Closing connection to client: " + threadId);
		if (threadId < this.maxThreads) { //if the socket was a full connection
			this.threadIds[threadId] = false;
		}
		Util.printArray(threadIds, "Threads free: ");
		System.out.println("Next free thread: " + this.nextThreadId());
	}
	
	public int nextThreadId() {
		for (int i = 0; i < this.threadIds.length; i++) {
			if (!this.threadIds[i]) {
				return i;
			}
		}
		return this.threadIds.length;
	}

	public void stopListening() {
		this.listening = false;
	}

	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			System.err.println("Usage: java Server <port number>");
			System.exit(1);
		}

		int portNumber = Integer.parseInt(args[0]);
		new Server(portNumber).listen();
	}
}
