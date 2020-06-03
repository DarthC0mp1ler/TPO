package Assignment11;

import Assignment11.proxy.FileControllerService;
import Assignment11.proxy.FileManager;
import Assignment11.proxy.FileModel;
import org.junit.Assert;
import org.junit.Test;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.logging.Logger;

public final class Main {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }

    @Test
    public void fileTest() throws MalformedURLException {
        URL wsdl = new URL("http://localhost:8080/mtom?wsdl");
        FileControllerService service = new FileControllerService(wsdl);
        FileManager proxy = service.getFileManagerPort();

        try {

            File file = new File("src/Resources/dataset.xml");
            Assert.assertNotNull(file);
            Assert.assertTrue(file.exists());
            Assert.assertTrue(proxy.uploadFile(file.getName(), Files.readAllBytes(file.toPath()), Arrays.asList(file.canRead() + " ", file.canWrite() + " ", file.getAbsolutePath())));
            
            File file1 = new File("src/Resources/dataset1.xml");
            Assert.assertNotNull(file1);
            Assert.assertTrue(file1.exists());
            Assert.assertTrue(proxy.uploadFile(file1.getName(), Files.readAllBytes(file1.toPath()), Arrays.asList(file1.canRead() + " ", file1.canWrite() + " ", file1.getAbsolutePath())));


            Assert.assertEquals(2,proxy.query(Arrays.asList(file.canRead() + " ",file1.getAbsolutePath())).size());

            FileModel model = proxy.download(file.getName());
            Assert.assertArrayEquals(model.getRawData(), Files.readAllBytes(file.toPath()));

            File fileRes = new File("src/Resources/Downloaded/" + model.getName());

            FileOutputStream stream = new FileOutputStream(fileRes);
            FileChannel channel = stream.getChannel();
            ByteBuffer buffer = ByteBuffer.wrap(model.getRawData());
            channel.write(buffer);
            channel.force(true);
            channel.close();

            Assert.assertArrayEquals(model.getRawData(), Files.readAllBytes(fileRes.toPath()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}