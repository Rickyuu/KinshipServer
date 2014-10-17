package com.speed.kinship.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener {
	
	public static void main(String args[]) {
		try {
			System.out.println("server start");
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(Constants.PORT_NUM);
			while(true) {
				Socket clientSocket = serverSocket.accept();
				Runnable clientHandler = new ClientHandler(clientSocket);
				Thread thread = new Thread(clientHandler);
				thread.start();
				System.out.println("got a connection");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
