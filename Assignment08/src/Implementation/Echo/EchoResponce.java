package Implementation.Echo;

import java.io.Serializable;

public class EchoResponce implements Serializable {

    private String _message;

    public EchoResponce(String message){
        _message = "echo " + message + "";
    }

    public String getMessage() {
        return _message;
    }
}
