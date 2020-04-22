package Protocols;

public interface IProtocol {

    int getBufferSize();
    String calcResponce_Srv(String r);
    String calcResponce_Cl(String r);
    String getMessg();

}
