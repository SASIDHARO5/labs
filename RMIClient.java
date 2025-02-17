import java.rmi.Naming;
import java.util.Scanner;

// Client-side program to use the remote service
public class RMIClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote service in the RMI registry
            MyInterface remoteService = (MyInterface) Naming.lookup("myRMIService");
            System.out.println("Connected to RMI Server!");

            // Input text from user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Call the remote method and display the result
            int length = remoteService.countInput(input);
            System.out.println("Length of the input string: " + length);

            // Close resources
            scanner.close();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
