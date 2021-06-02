package octochat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientMessageHandler implements Runnable {

	private Socket client;

	public ClientMessageHandler(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(client.getInputStream());
	        while (scanner.hasNextLine()) {
	            System.out.println(scanner.nextLine());
	        }

	        scanner.close();
	        client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
