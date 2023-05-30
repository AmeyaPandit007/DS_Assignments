import java.rmi.*;
public interface circleInterface extends Remote{
    public double Area(int radius) throws RemoteException;
    public double perimeter(int radius) throws RemoteException;
}