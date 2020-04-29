package Implementation.Client;

import Implementation.Add.AddRequest;
import Implementation.Add.AddResponce;
import Implementation.Add.IAdd;
import Implementation.Echo.EchoRequest;
import Implementation.Echo.EchoResponce;
import Implementation.Echo.IEcho;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public Client(){
        try {
            IEcho echo = (IEcho) Naming.lookup("ECHO");
            EchoRequest echoRequest = new EchoRequest("HELLO RMI");
            EchoResponce echoResponce = echo.echo(echoRequest);
            System.out.println("SENT: \"" + echoRequest.getMessage() + "\"\nRECEIVED: \"" + echoResponce.getMessage() + "\"");

            IAdd add = (IAdd) Naming.lookup("ADD");
            AddRequest addRequest = new AddRequest("55555","55555");

            AddResponce addResponce = add.add(addRequest);
            System.out.println("SENT: \"" + addRequest.getNumber1() + " : " + addRequest.getNumber2() + "\"\nRECEIVED: \"" + addResponce.getSum() + "\"");

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }

}
