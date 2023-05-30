import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server{
    public Server() throws RemoteException{
        super();
    }

    public static void main(String args[]) throws RemoteException{
        Registry reg = LocateRegistry.createRegistry(101);
        circleImpl ci = new circleImpl();
        reg.rebind("circle", ci);
        System.out.println("Server is waiting...");        
    }
}