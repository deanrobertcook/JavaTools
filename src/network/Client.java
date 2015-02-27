package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Dean Cook<deanrobertcook@gmail.com>
 */
public class Client {
	
	private final String hostName;
	private final int portNumber;
	
	public Client(String hostname, int portNumber) {
		this.hostName = hostname;
		this.portNumber = portNumber;
	}
	
	public void sendMessage(String message) {
		try (
			Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
        ) {
           out.println(message);
           System.out.println("echo: " + in.readLine());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
			System.out.println(e.getMessage());
            System.exit(1);
        }
	}
	
	public static void main(String[] args) throws IOException {
         
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
 
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
 
		new Client(hostName, portNumber).sendMessage("hello");
        
    }
}
