import java.rmi.Remote;
import java.rmi.RemoteException;

// Define a remote interface
public interface MyInterface extends Remote {
    int countInput(String input) throws RemoteException;
}
