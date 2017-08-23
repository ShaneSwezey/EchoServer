
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Created by: Shane Swezey

/*
 * Client class creates a socket which is used to connect to an echo server.
 */
public class Client {
    public static void main(String[] args) {

        final int PORT = 9001;

        try {
            Socket socket = new Socket("localhost", PORT); // Socket that connects to the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println(in.readLine());
            System.out.println(in.readLine());

            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.print("Client: ");
                String statement = input.nextLine();
                out.println(statement);             // Sends client message to server
                String line = in.readLine();        // Stores returned message from the server
                if (statement.equals("..")) {
                    System.out.println("Exiting..");
                    break;
                } else {
                    System.out.println(line);
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
