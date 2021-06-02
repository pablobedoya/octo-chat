package octochat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private Socket clientSocket;

	public void start(String host, int port) throws UnknownHostException, IOException {
		System.out.println("Iniciando cliente...");
		clientSocket = new Socket(host, port);

		Scanner scanner = new Scanner(System.in);
		PrintStream out = new PrintStream(clientSocket.getOutputStream());
		System.out.println("Cliente conectado ao servidor.");

		while (scanner.hasNextLine()) {
			out.println(scanner.nextLine());
		}

		out.close();
		scanner.close();
		clientSocket.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		client.start("127.0.0.1", 12345);
	}

}
