package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author Dean Cook<deanrobertcook@gmail.com>
 */
public class SimpleClient extends Client {

	public SimpleClient(String hostname, int portNumber) {
		super(hostname, portNumber);
	}

    public void sendStringMessage(String message) {
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
