
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 * In RMI application, a interface for each remote object is needed, which contains all the necessary methods or operations
 * for that particular remote object. So for implementing Building as remote object in our project, 
 * we are creating this interface to provide required methods.
 * @author 
 */
public interface BuildingInterface  extends Remote{
    public String getName() throws RemoteException;
    public ArrayList<Room> getRaueme() throws RemoteException;
    public RoomInterface searchRoom (String RoomName) throws RemoteException;
    public boolean addRaum (String name, String bottom, double size) throws RemoteException;
    public String outputDerRäume() throws RemoteException;
    public double calculateTotalSizeAllSpaces() throws RemoteException;
   
    
}
