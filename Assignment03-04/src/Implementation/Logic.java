package Implementation;

import java.math.BigInteger;

public class Logic {

    public static Model add(BigInteger operand, BigInteger operand2){
        if(operand == null || operand2 == null) return null;
        return new Model(operand.add(operand2));
    }
}
