
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Created by: Shane Swezey

/*
  * Server class creates an echo server by creating a server socket in which a
  * client can connect to. The echo server will send a copy of the client's message
  * back to the client.
 */
public class Server {
    public static void main(String[] args) {

        System.out.println("Looking for clients...");
        final int PORT = 9001;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT); // creates server socket

            Socket socket = serverSocket.accept(); // waits for a client to connect to server

            System.out.println("Client has connected from " + socket.getLocalAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Welcome to the Echo Server! ");
            out.println("Please type the following to exit the server: ..");

            while (true) {
                String line = in.readLine();  // stores a message from the client
                System.out.println("Client: " + line);
                if (line.equals("..")) {
                    break;
                }
                out.println("Server: " + line); // returns the clients message back to the client
            }

            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
