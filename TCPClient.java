import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to the server");

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);

            String message;
            while (true) {
                System.out.print("Enter message to send to server (type 'exit' to quit): ");
                message = scanner.nextLine();
                output.println(message);

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting...");
                    break;
                }
                String serverResponse = input.readLine();
                System.out.println("Received from server: " + serverResponse);
            }

            scanner.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
