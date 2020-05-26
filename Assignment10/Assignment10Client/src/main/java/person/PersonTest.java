package person;

import org.junit.Assert;
import person.proxy.IPersonBase;
import person.proxy.Person;
import person.proxy.PersonBaseImplementationService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class PersonTest {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
    }

    @org.junit.Test
    public void test() throws MalformedURLException
    {
        URL wsdl = new URL( "http://localhost:8080/person?wsdl");
        PersonBaseImplementationService service = new PersonBaseImplementationService(wsdl);
        Assert.assertNotNull(service);
        IPersonBase proxy = service.getIPersonBasePort();
        Assert.assertNotNull(proxy);

        //creating list
        List<Person> list = new ArrayList<Person>();
        Person petro = new Person();

        final XMLGregorianCalendar date = parseDate(1753,8,15);
        List<Person> dateList = new ArrayList<Person>();

        petro.setName("Petro");
        petro.setSurname("Poroh");
        petro.setBirthDate(date);
        list.add(petro);
        dateList.add(petro);

        Person mykola = new Person();
        mykola.setName("Mykola");
        mykola.setSurname("Hohol");
        mykola.setBirthDate(date);
        list.add(mykola);
        dateList.add(mykola);

        final String surname = "Bulba";
        List<Person> surnamList = new ArrayList<Person>();

        Person andrii = new Person();
        andrii.setName("Andrii");
        andrii.setSurname(surname);
        andrii.setBirthDate(parseDate(1965,8,15));
        list.add(andrii);
        surnamList.add(andrii);

        Person ostap = new Person();
        ostap.setName("Ostap");
        ostap.setSurname(surname);
        ostap.setBirthDate(parseDate(1805,8,15));
        list.add(ostap);
        surnamList.add(ostap);

        ///////////////////////////////////////////////
        LOGGER.info("LIST CREATED\n");
        Assert.assertNotNull(list);
        printList(list);

        List<Person> filteredBySurname = proxy.filterBySurname(list,surname);

        Assert.assertNotNull(list);
        Assert.assertEquals(filteredBySurname.size(),surnamList.size());
        filteredBySurname.forEach(p-> Assert.assertEquals(p.getSurname(), surname));

        LOGGER.info("LIST SORTED BY SURNAME\n");
        printList(filteredBySurname);

        List<Person> filteredByDate = proxy.filterByDate(list,date);
        Assert.assertNotNull(list);
        Assert.assertEquals(filteredByDate.size(),dateList.size());
        filteredByDate.forEach(p->Assert.assertEquals(p.getBirthDate(),date));

        LOGGER.info("LIST SORTED BY DATE\n");
        printList(filteredByDate);
    }

public void printList(List<Person> list)
{
    String s = "\n";
    for (Person p: list) {
        s+=p.getName() + " " + p.getSurname() + " born on " + p.getBirthDate()+"\n";
    }
    LOGGER.info(s);
}



    public static XMLGregorianCalendar parseDate(int y, int m, int d) {
        try {
            GregorianCalendar calendar = new GregorianCalendar(y,m,d);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            return null;
        }
    }
}
