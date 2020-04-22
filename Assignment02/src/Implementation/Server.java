package Implementation;

import Protocols.IProtocol;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Server{

private ByteBuffer _bytebuffer;
private ServerSocketChannel _serverChanel;
private Selector _selector;
private IProtocol _protocol;
private SelectionKey  _serverkey;

public Server(int port, IProtocol protocol){
    try {
        //1
        _serverChanel = ServerSocketChannel.open();
        SocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(),port);
        _serverChanel.socket().bind(address);
        //2
        _serverChanel.configureBlocking(false);
        //3
        _selector = Selector.open();
        //4
        _serverkey = _serverChanel.register(_selector,SelectionKey.OP_ACCEPT);
        //etc
        _protocol = protocol;
        _bytebuffer = ByteBuffer.allocate(protocol.getBufferSize());

    }catch (Exception e){
        e.printStackTrace();
    }
}

public void handle(){
    try{

        while (true){
            //5
            _selector.select();
            //Set keys = _selector.selectedKeys();
            //Iterator iter = keys.iterator();
            Iterator<SelectionKey> iterator = _selector.selectedKeys().iterator();
            while(iterator.hasNext()){

                SelectionKey key = iterator.next();
                iterator.remove();

                if(key.isAcceptable()){
                    //System.out.println("acceptable");
                    SocketChannel clientChannel = _serverChanel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(_selector, SelectionKey.OP_READ  | SelectionKey.OP_WRITE);
                    System.out.println("Key registered successfully");
                     continue;
                }
                if(key.isReadable() && key.isWritable()){
                    _bytebuffer.clear();
                    SocketChannel channel = (SocketChannel)key.channel();
                    //handling client request
                    channel.read(_bytebuffer);
                    _bytebuffer.flip();
                    String request = new String(_bytebuffer.array(), 0, _bytebuffer.limit());
                    String responce = _protocol.calcResponce_Srv(request);
                    _bytebuffer.clear();
                    _bytebuffer.put(responce.getBytes());
                    _bytebuffer.flip();
                    int written = channel.write(_bytebuffer);
                    channel.close();
                    System.out.println("responce sent successfully: " + written + " bytes");
                     continue;
                }if(key.isWritable()){
                    //System.out.println("writable");
                }

            }

        }
    }catch (Exception e){
        e.printStackTrace();
    }
}

}


