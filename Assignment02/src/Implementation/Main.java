package Implementation;

import Protocols.Add;
import Protocols.Echo;
import Protocols.IProtocol;

public class Main {

    //args: SRV|CL ADD|ECHO EchoString|int-int
    public static void main(String[] args) {
        if(args.length >= 1 && args.length != 3 && !args[0].equals("SRV")){
            System.out.println("Wrong quantity of arguments");
            return;
        }
        int port = 55555;

        switch (args[0].toUpperCase()){
            case"SRV":
                IProtocol protocolSrv = null;
                if(args[1].toUpperCase().equals("ADD")){
                    protocolSrv = new Add();
                }else if(args[1].toUpperCase().equals("ECHO")){
                    protocolSrv = new Echo();

                }
                Server server = new Server(port,protocolSrv);
                server.handle();
                break;
            case"CL":
                IProtocol protocolCl = null;
                if(args[1].toUpperCase().equals("ADD")){
                    protocolCl = new Add(args[2]);
                }else if(args[1].toUpperCase().equals("ECHO")){
                    protocolCl = new Echo(args[2]);

                }
                Client client = new Client(port,protocolCl);
                client.connect(protocolCl);
                break;
        }
    }

}
