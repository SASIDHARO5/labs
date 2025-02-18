import java.util.Scanner;
import java.net.*;
public class IP 
{
    public static void main(String [] args)
    {
        Scanner cs= new Scanner (System.in);
        System.out.println("Enter dns name:");
        String name=cs.nextLine();
        try{
            InetAddress add= InetAddress.getByName(name);
            System.out.println(add.getHostName());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        cs.close();
    }
}