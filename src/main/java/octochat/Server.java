package octochat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	private ServerSocket serverSocket;
	private List<Socket> clients;

	public void start(int port) throws IOException {
		System.out.println("Iniciando servidor...");
		serverSocket = new ServerSocket(port);
		clients = new ArrayList<>();

		while (true) {
			Socket client = serverSocket.accept();
			clients.add(client);
			System.out.println("Nova conexão com cliente: " + client.getInetAddress().getHostAddress());

			ClientMessageHandler handler = new ClientMessageHandler(client);
			new Thread(handler).start();
		}
	}

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.start(12345);
	}

}
