package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Dean Cook<deanrobertcook@gmail.com>
 */
public class Client {

    protected final InetSocketAddress socketAddress;
    protected Socket socket;

    public Client(String hostname, int portNumber) {
        this.socketAddress = new InetSocketAddress(hostname, portNumber);
    }
	
	public void connect() {
		this.connect(-1);
	}
	
    public void connect(int timeout) {
        try {
            System.out.println("Connecting to " + this.socketAddress.getHostName()
                + " at port " + this.socketAddress.getPort());
            this.socket = new Socket();
			if (timeout == -1) {
				this.socket.connect(this.socketAddress);
			} else {
				this.socket.connect(this.socketAddress, timeout);
			}
            System.out.println("Connection established");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void disconnect() {
        try {
            this.socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendMessage(String message) {
        try {
            PrintWriter out =
                    new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(this.socket.getInputStream()));
            out.println(message);
            System.out.println("echo: " + in.readLine());


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
