package Implementation.Add;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAdd extends Remote {

    AddResponce add(AddRequest request) throws RemoteException;

}
