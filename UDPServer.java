import java.net.*;
import java.io.*;

public class UDPServer {
    public static void main(String[] args) {
        int port = 8080;
        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Server is listening on port " + port);
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String receivedMessage = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received from client: " + receivedMessage);

                if (receivedMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected");
                    break;
                }

                System.out.print("Enter response to client: ");
                BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
                String response = consoleInput.readLine();

                byte[] responseBytes = response.getBytes();
                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
                DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, clientAddress, clientPort);
                socket.send(responsePacket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
