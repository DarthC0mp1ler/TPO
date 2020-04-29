package Implementation.Transmission;

import Implementation.Add.AddRequest;
import Implementation.Add.AddResponce;
import Implementation.Add.IAdd;
import Implementation.Echo.EchoRequest;
import Implementation.Echo.EchoResponce;
import Implementation.Echo.IEcho;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class Remoter extends UnicastRemoteObject implements IAdd, IEcho {

    public Remoter()throws RemoteException{

    }

    @Override
    public AddResponce add(AddRequest request) throws RemoteException {
        System.out.println(">>リクエスト：add ( " + request.getNumber1() + " & " + request.getNumber2() + " )" + LocalDateTime.now());
        return new AddResponce(request.getNumber1(),request.getNumber2());
    }

    @Override
    public EchoResponce echo(EchoRequest request) throws RemoteException {
        System.out.println(">>リクエスト：echo ( " + request.getMessage() + " )" + LocalDateTime.now());
        return new EchoResponce(request.getMessage());
    }
}
