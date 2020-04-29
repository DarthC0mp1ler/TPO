package Implementation.Echo;

import java.io.Serializable;

public class EchoRequest implements Serializable {

    private String _message;

    public EchoRequest(String message){
        _message = message;
    }

    //GETTERS


    public String getMessage() {
        return _message;
    }
}
