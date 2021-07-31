
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.Registry;


/**
 ** Building Server class to provide building object which will be performing all operations
 * @author Muzamil
 */
public class BuildingServer {
    static Registry registry;
    public static void main(String[] args) {
        try{
            
            // Creating a building object on server for clients to access
            BuildingInterface b = new Building("Building one");
             

            // Putting above building object out there at specific url for clients to operate on
            Naming.rebind("rmi://localhost:5000/building", b);
            // Printing, that server is successfully running
            System.out.println("Server running...");
            
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
