package Assignment11;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

@XmlType( //
        namespace = "http://Darth_C0mp1ler" //
)
public final class FileModel {

    public int _size;
    public byte[] _rawData;
    public String[] _keyWords;
    public String _name;

    public FileModel() {
    }

    public FileModel(String name,byte[] rawData,String[] keyWords) {
        _rawData = rawData;
        _size = rawData.length;
        _keyWords = Arrays.copyOf(keyWords,keyWords.length);
        _name = name;
    }

    @Override
    public String toString() {
        return "<<Name="+_name +"; Size=" +_size+ "; Keywords="+Arrays.toString(_keyWords)+">>";
    }
}