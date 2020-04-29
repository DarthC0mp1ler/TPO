package Implementation.Add;

import java.io.Serializable;
import java.math.BigInteger;

public class AddResponce implements Serializable {

    private BigInteger _sum;

    public AddResponce(BigInteger number1,BigInteger number2){
        _sum = add(number1,number2);
    }


    public static BigInteger add(BigInteger number1,BigInteger number2) {
        if(number1 != null && number2 != null){
            return number1.add(number2);
        }
        else{
            throw new IllegalArgumentException("Parameters are empty");
        }
    }

    //GETTERS


    public BigInteger getSum() {
        return _sum;
    }
}
