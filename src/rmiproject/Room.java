
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Room class is extending UnicastRemoteObject to act as a remote abject and implementing RoomInterface we created already to implement it's methods
 * 
 * @author 
 */
public class Room extends UnicastRemoteObject implements RoomInterface{

    private String name;
    private String floor;
    private double large;

    
    // default constructor which is mandatory
    public Room() throws RemoteException{
        super();
    }
    // Constructor for creating room objects with paramters name, floor, and size
    public Room (final String name, String floor, double large) throws RemoteException{
        // The attributes are set by the aprameter
        this.name = name;
        this.floor = floor;
        this.large = large;
    }

    // method to get name of the room
    public String getName() throws RemoteException{
        return name;

    }
    // method to get floor value of room
    public String getetage () throws RemoteException{
        return floor;
    }

    
    public double getSize () throws RemoteException{
        return large;
    }

    public double groeßeAendern (double newlarge) throws RemoteException{
        // the old large is overwritten by the new one
        this.large = newlarge;
        return large;
    }

    @Override
    public String toString2() throws RemoteException  {
        try {
            RoomInterface r = (RoomInterface) this;
            return "room:" + r.getName () + ", floor:" + r.getetage () + ", large:" + r.getSize () + "square meters \n";
        } catch (RemoteException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }



}