import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class RawUDPReceiver {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket to listen on port 9876
            DatagramSocket socket = new DatagramSocket(9876);
            System.out.println("Receiver is listening...");

            // Buffer to store incoming data
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive data from sender
            socket.receive(receivePacket);

            // Convert received data to string and display
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received data: " + message);

            // Prepare acknowledgment message
            String ackMessage = "Acknowledgment: Data received!";
            byte[] ackData = ackMessage.getBytes();

            // Send acknowledgment back to sender
            DatagramPacket ackPacket = new DatagramPacket(ackData, ackData.length, receivePacket.getAddress(), receivePacket.getPort());
            System.out.println("Sending acknowledgment: " + ackMessage);
            socket.send(ackPacket);

            // Close socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
