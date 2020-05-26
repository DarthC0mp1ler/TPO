package implementation;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class Person {

   public String _name;
    public String _surname;
    public Date _birthDate;

    public Person(String name, String surname, Date birthDate)
    {
        _name = name;
        _surname = surname;
        _birthDate = birthDate;
    }
    public Person()
    {
    }



    public String toString() {
        return _name + " " + _surname + " born on " + _birthDate;
    }

}
