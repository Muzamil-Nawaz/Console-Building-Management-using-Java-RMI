

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * In RMI application, a interface for each remote object is needed, which contains all the necessary methods or operations
 * for that particular remote object. So for implementing Room as remote object in our project, 
 * we are creating this interface to provide required methods.
 * @author 
 */
public interface RoomInterface extends Remote{
    
    String getName() throws RemoteException;
    double getSize() throws RemoteException;
    String getetage() throws RemoteException;
    public double groeßeAendern (double newlarge) throws RemoteException;
    public String toString2() throws RemoteException;
    
}
