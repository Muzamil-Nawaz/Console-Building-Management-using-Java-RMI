
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Building extends UnicastRemoteObject implements BuildingInterface{
    // declare the attributes
    private String name;
    private ArrayList <Room> rough;

    public Building() throws RemoteException{
        super();
    }
    // create a constructor
    Building (String name) throws RemoteException {
//        super();
        this.name = name;
        // a new list of Rooms is created for each building
        this.rough = new ArrayList<> ();

    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public ArrayList<Room> getRaueme () {
        return rough;
    }

    @Override
    public RoomInterface searchRoom (String RoomName) throws RemoteException {
        // go through the Room list
        for (Room r: rough) {
            // compare there whether there is Room (parameter) in the list
            if (r.getName().equals(RoomName)) {
                // if so, I'll give it back
                return r;
            }
        }
        // otherwise return zero
        return null;
    }

    @Override
    public boolean addRaum (String name, String bottom, double size) throws RemoteException{

        try {
            // a Room object is created with the parameters passed and
            // added directly to the list
            this.rough.add (new Room (name, bottom, size));
            
        } catch (RemoteException ex) {
            Logger.getLogger(Building.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    //
    @Override
    public String outputDerRäume () throws RemoteException{
        String str = "";
        for(Room r: rough){
            str+=r.toString2();
        }
        return str;
    }

    @Override
    public double calculateTotalSizeAllSpaces () throws RemoteException{
        double total = 0.0;
        for (Room r: rough) {
            // add the size of all Rooms to the variable total in each run
            total += r.getSize();
        }
        return total;
    }
 

}