package Implementation;

public enum OperationMode {

    READ(0), WRITE(1),STOP(-1);

    private int _val;

    OperationMode( int val){
        _val = val;
    }

    int getVal(){
        return _val;
    }

}
