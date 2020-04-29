package Implementation;

import Implementation.Client.Client;
import Implementation.Server.Server;

public class Main {

    public static void main(String[] args) {

        if(args.length < 1) throw new IllegalArgumentException();

        if(args[0].toUpperCase().equals("SRV")){
            new Server();
        }
        if(args[0].toUpperCase().equals("CL")){
            new Client();
        }
    }

}
