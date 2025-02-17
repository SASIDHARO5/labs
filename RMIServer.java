import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Server implementation of the remote interface
public class RMIServer extends UnicastRemoteObject implements MyInterface {

    // Constructor
    protected RMIServer() throws RemoteException {
        super();
    }

    // Implement the remote method
    @Override
    public int countInput(String input) throws RemoteException {
        return input.length();
    }

    public static void main(String[] args) {
        try {
            // Create and bind the server instance to the RMI registry
            RMIServer server = new RMIServer();
            Naming.rebind("myRMIService", server);
            System.out.println("RMI Server is running and waiting for client requests...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
