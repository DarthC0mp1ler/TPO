package Assignment11;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;
import java.util.List;

@MTOM
@WebService( //
        name = "FileManager", //
        targetNamespace = "http://Darth_C0mp1ler/mtom" //
)
public interface FileManager {

    public static final String URI = "http://localhost:8080/mtom";

    @WebMethod(action = "http://Darth_C0mp1ler/mtom/uploadFile")
    public boolean uploadFile(String name,byte[] fileData, String[] keyWords);
    @WebMethod(action = "http://Darth_C0mp1ler/mtom/query")
    public List<String> query(String[] keyWords);
    @WebMethod(action = "http://Darth_C0mp1ler/mtom/download")
    public FileModel download(String name);

}