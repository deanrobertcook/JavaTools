/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Dean Cook<deanrobertcook@gmail.com>
 */
public class ServerTest {

	Server server;
	String hostName = "localhost";
	int portNumber = 60000;
	int maxClients = 3;

	@Before
	public void newServer() {
		this.server = new Server(portNumber, maxClients);
		new Thread(() -> {
			server.listen();
		}).start();
	}

	@Test
	public void testSingleClient() {
		Client client = new Client(hostName, portNumber);
		new Thread(() -> {
			client.sendMessage("Client's message to server");
		}).start();
	}

	@Test
	public void testSeveralClients() {
		Client[] clients = new Client[maxClients + 1];
		for (int i = 0; i < clients.length; i++) {
			Client client = new Client(hostName, portNumber);
			final int clientId = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					client.sendMessage("Client " + clientId + "'s message to server");
					try {
						this.wait();
					} catch (InterruptedException e) {
						System.out.println("Client " + clientId + " interrupted");
						System.out.println(e.getMessage());
					}
				}
			}, "Client " + clientId).start();
		}
	}

}
