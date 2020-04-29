package Implementation.Echo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEcho extends Remote {

    EchoResponce echo(EchoRequest request) throws RemoteException;

}
