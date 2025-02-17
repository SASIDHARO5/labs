import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage;
            while ((clientMessage = input.readLine()) != null) {
                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected");
                    break;
                }

                System.out.println("Received from client: " + clientMessage);

                System.out.print("Enter response to client: ");
                String response = consoleInput.readLine();
                output.println(response);
            }

            socket.close();
            System.out.println("Connection closed");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
