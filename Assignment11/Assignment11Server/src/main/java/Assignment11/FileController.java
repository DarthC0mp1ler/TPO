package Assignment11;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.MTOM;
import java.util.*;
import java.util.logging.Logger;

@MTOM
@WebService( //
        name = "FileManager", //
        targetNamespace = "http://Darth_C0mp1ler/mtom" //
)
public final class FileController implements FileManager {

    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private static Map<String,FileModel> dictionary = new HashMap<>();

    public static void main(String... args) {
        Endpoint.publish(FileManager.URI, new FileController());
        LOGGER.info("SERVICE STARTED");
    }

    public FileController() {
    }

    @Override
    public boolean uploadFile(String name,byte[] fileData, String[] keyWords) {
        try {
            FileModel model = new FileModel(name,fileData, keyWords);
            dictionary.put(name, model);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public List<String> query(String[] keyWords) {
        List<String> list = new ArrayList<>();
        for (String s: dictionary.keySet()) {
            for (String key:keyWords) {
                if(Arrays.asList(dictionary.get(s)._keyWords).contains(key)) {
                    list.add(dictionary.get(s).toString());
                    break;
                }
            }
        }
        return list;
    }

    @Override
    public FileModel download(String name) {
        return dictionary.get(name);
    }
}