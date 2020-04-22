package Protocols;

public class Echo implements IProtocol{

    private int BUFERSIZE;

    private String _str;

    public Echo(String str){
        BUFERSIZE = ("ECHO>>" + str).getBytes().length;
        _str = str;
    }
    public Echo(){
        BUFERSIZE = 36;
    }

    @Override
    public int getBufferSize() {
        return BUFERSIZE;
    }

    @Override
    public String calcResponce_Srv(String r) {
        return "ECHO>>" + r;
    }

    @Override
    public String calcResponce_Cl(String r) {
        return "Received:" + r;
    }

    @Override
    public String getMessg() {
        return _str;
    }
}
