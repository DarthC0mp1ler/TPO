package Implementation.Server;

import Implementation.Transmission.Remoter;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;

public class Server {

    public Server(){
        try {
            LocateRegistry.createRegistry(1099);
            Remoter remoter = new Remoter();
            Naming.bind("ADD",remoter);
            Naming.bind("ECHO",remoter);
            //サーバーがしどうしました
            System.out.println(">>>サーバーが起動しました: " + LocalDateTime.now());
        } catch (RemoteException | AlreadyBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
