import java.io.*;
import java.net.*;

class DateClient {
    public static void main(String[] args) throws Exception {
        // Establishing a connection to the server
        Socket soc = new Socket(InetAddress.getLocalHost(), 5217);

        // Reading input from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

        // Printing the server's message
        System.out.println("Received from Server: " + in.readLine());

        // Closing the socket and input stream
        in.close();
        soc.close();
    }
}