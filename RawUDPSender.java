import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class RawUDPSender {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket for sending data
            DatagramSocket socket = new DatagramSocket();
            InetAddress receiverAddress = InetAddress.getByName("localhost");

            // Input message from user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your message: ");
            String message = scanner.nextLine();

            // Convert message to byte array and send as a DatagramPacket
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receiverAddress, 9876);
            System.out.println("Sending data: " + message);
            socket.send(sendPacket);

            // Receive acknowledgment from receiver
            byte[] ackData = new byte[1024];
            DatagramPacket ackPacket = new DatagramPacket(ackData, ackData.length);
            socket.receive(ackPacket);

            // Convert received acknowledgment to string and display
            String ackMessage = new String(ackPacket.getData(), 0, ackPacket.getLength());
            System.out.println("Received acknowledgment: " + ackMessage);

            // Close resources
            socket.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
