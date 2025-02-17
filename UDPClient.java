import java.net.*;
import java.util.Scanner;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(host);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter message to send to server (type 'exit' to quit): ");
                String message = scanner.nextLine();

                byte[] messageBytes = message.getBytes();
                DatagramPacket packet = new DatagramPacket(messageBytes, messageBytes.length, serverAddress, port);
                socket.send(packet);

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting...");
                    break;
                }
                byte[] buffer = new byte[1024];
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(responsePacket);

                String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
                System.out.println("Received from server: " + response);
            }
            scanner.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
