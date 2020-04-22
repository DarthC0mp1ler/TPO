package Implementation;

import Protocols.IProtocol;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

    private SocketChannel _channel;
    private IProtocol _protocol;
    private ByteBuffer _buffer;

    public Client(int port,IProtocol protocol){
        try{
            _channel = SocketChannel.open();
            _channel.configureBlocking(true);

            SocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(),port);
            _channel.connect(address);
            System.out.println("Connecting...");
            while(!_channel.finishConnect()){
                Thread.sleep(200);
            }
            System.out.println("Connected");
            _protocol = protocol;
            _buffer = ByteBuffer.allocate(protocol.getBufferSize());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void connect(IProtocol req){
        try{
                _buffer.clear();

                _buffer.put(req.getMessg().getBytes());
                _buffer.flip();



                _channel.write(_buffer);
                _buffer.clear();


                while(true) {
                    int read = _channel.read(_buffer);
                    _buffer.flip();
                    if (read == 0) {
                        System.out.println("Waiting...");
                        Thread.sleep(500);
                    } else if (read == -1) {
                        System.out.println("Further access is not feasible");
                        break;
                    }else {
                        String request = new String(_buffer.array(), 0, _buffer.limit());
                        String responce = _protocol.calcResponce_Cl(request);
                        System.out.println(responce);
                        break;
                    }

                }
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
