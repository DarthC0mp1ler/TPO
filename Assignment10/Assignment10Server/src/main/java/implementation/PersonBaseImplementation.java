package implementation;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebService( //
        name = "IPersonBase", //
        targetNamespace = "http://assignment10/person" //
)
public class PersonBaseImplementation implements IPersonBase {


    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public static void main(String... args) {
        Endpoint.publish(URI, new PersonBaseImplementation());
        LOGGER.info("SERVICE STARTED");
    }

    public PersonBaseImplementation() {
    }


    @Override
    public List<Person> filterBySurname(List<Person> list, String surname) {
        return list.stream().filter(p->p._surname.equals(surname)).collect(Collectors.toList());
    }

    @Override
    public List<Person> filterByDate(List<Person> list, Date date) {
        return list.stream().filter(p->p._birthDate.equals(date)).collect(Collectors.toList());
    }
}
