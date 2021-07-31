
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 * Client class to access BuildingServer object and operate on it
 * @author 
 */
public class BuildingClient {

    public static void main(String[] args) {
        try {
            
            // Getting the building reference from the server
            BuildingInterface b = (BuildingInterface) Naming.lookup("rmi://localhost:5000/building");
            //fügen Räume ins Gebäude eins ein
            // Adding new rooms
            System.out.println("Adding Room: " + b.addRaum("Klasse 1", "Etage 2", 75.5));
            System.out.println("Adding Room: " + b.addRaum("Klasse 2", "Etage 1", 85.5));
            System.out.println("Adding Room: " + b.addRaum("Klasse 3", "Etage 4", 105.5));
            
            // Printing details of exisiting rooms
            System.out.println("Printing existing rooms: \n" + b.outputDerRäume());
            
            ArrayList<Room> rooms = b.getRaueme();
            for (int i = 0; i < rooms.size(); i++) {
                RoomInterface room2 = (RoomInterface) rooms.get(i);
                System.out.println(room2.toString2());
            }
            //Getting reference of particulat room by searching for it
            RoomInterface r = (RoomInterface) b.searchRoom("Klasse 1");
            // Printing it's attributes
            System.out.println(r.getSize());
            System.out.println(r.getetage());
            
            //berechnen die gesamt Größe aller Räume welche im gebäude eins vorhanden sind
            System.out.println("Total sizes :" + b.calculateTotalSizeAllSpaces());

        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            e.printStackTrace();
        }

    }
}
