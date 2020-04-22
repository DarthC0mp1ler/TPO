package Protocols;

public class Add implements IProtocol {

    private String _str;
    private int BUFERSIZE = 36;

    public Add(String str){
        _str = str;
        BUFERSIZE = ("ADD>>" + str).getBytes().length;
    }
    public Add(){
        //
    }

    @Override
    public int getBufferSize() {
        return BUFERSIZE;
    }

    @Override
    public String calcResponce_Srv(String r) {
        String result =  "ADD>>" + (Integer.parseInt(r.split("-")[0]) + Integer.parseInt(r.split("-")[1]));
        return result;
    }

    @Override
    public String calcResponce_Cl(String r) {
        return "Received: " + r;
    }

    @Override
    public String getMessg() {
        return _str;
    }
}
