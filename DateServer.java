import java.io.*;
import java.net.*;
import java.util.*;

class DateServer {
    public static void main(String[] args) throws Exception {
        // Creating a server socket on port 5217
        ServerSocket serverSocket = new ServerSocket(5217);

        while (true) {
            System.out.println("Waiting For Connection ...");

            // Accepting client connections
            Socket soc = serverSocket.accept();
            System.out.println("Connection Established!");

            // Sending the date to the client
            DataOutputStream out = new DataOutputStream(soc.getOutputStream());
            out.writeBytes("Server Date: " + (new Date()).toString() + "\n");

            // Closing output stream and socket
            serverSocket.close();
            out.close();
            soc.close();
        }
    }
}
