package Implementation.Add;

import java.io.Serializable;
import java.math.BigInteger;

public class AddRequest implements Serializable {

    private BigInteger _number1;
    private BigInteger _number2;

    public AddRequest(String s1,String s2)
    {
        _number1 = initialize(s1,_number1);
        _number2 = initialize(s2,_number2);

    }

    BigInteger initialize(String s,BigInteger b)
    {
        if(s.matches("-?[0-9]+"))
        {
            b = new BigInteger(s);
        }
        else b = BigInteger.ZERO;
        return b;
    }

    //GETTERS


    public BigInteger getNumber1() {
        return _number1;
    }

    public BigInteger getNumber2() {
        return _number2;
    }
}
