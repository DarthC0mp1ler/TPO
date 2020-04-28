package Implementation;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

public class Main {

    private MappedByteBuffer _buffer;

    public Main(File file, OperationMode mode) {
        try {
            if (mode.getVal() == OperationMode.WRITE.getVal()) {
                file.delete();
            }

            RandomAccessFile _file = new RandomAccessFile(file, "rw");
            FileChannel channel = _file.getChannel();
            _buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 12);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void write(int counter) {
        while (counter > 0) {
            _buffer.rewind();   //dunno
            int val = _buffer.getInt();
            if (val == OperationMode.READ.getVal()) {
                int num1 = (int) (Math.random() * 10000),
                        num2 = (int) (Math.random() * 10000);
                _buffer.rewind();
                _buffer.putInt(OperationMode.WRITE.getVal()).putInt(num1).putInt(num2);
                counter--;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        _buffer.rewind();
        _buffer.putInt(OperationMode.STOP.getVal());
    }

    public void read(){
        while(true){
            _buffer.rewind();

            int val = _buffer.getInt();
            if(val == OperationMode.STOP.getVal())break;
            if(val == OperationMode.WRITE.getVal()){
                int num1 = _buffer.getInt(),
                        num2 = _buffer.getInt();
                _buffer.rewind();
                _buffer.putInt(OperationMode.READ.getVal());
                System.out.println("sum: " + (num1 + num2));
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        File FILE = new File("src/Implementation/Resources/file.215");
        if(args.length == 2 && args[0].trim().toUpperCase().equals("WRITE") ){
            Main main = new Main(FILE,OperationMode.WRITE);
            main.write(Integer.parseInt(args[1]));
        }else
        if(args.length == 1 && args[0].trim().toUpperCase().equals("READ")){
            Main main = new Main(FILE,OperationMode.READ);
            main.read();
        } else System.err.println("Incorrect number of arguments or sth else");

    }

}
