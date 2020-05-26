package implementation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService( //
        name = "IPersonBase", //
        targetNamespace = "http://assignment10/person" //
)
public interface IPersonBase {

    public static final String URI= "http://localhost:8080/person?wsdl";

    @WebMethod(action = "http://glowacki.eu/personController/filterBySurname")
    List<Person> filterBySurname(List<Person> list, String surname);

    @WebMethod(action = "http://glowacki.eu/personController/sortByBirthDate")
    List<Person> filterByDate(List<Person> list, Date date);

}
