
package person.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the person.proxy package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FilterByDate_QNAME = new QName("http://assignment10/person", "filterByDate");
    private final static QName _FilterByDateResponse_QNAME = new QName("http://assignment10/person", "filterByDateResponse");
    private final static QName _FilterBySurname_QNAME = new QName("http://assignment10/person", "filterBySurname");
    private final static QName _FilterBySurnameResponse_QNAME = new QName("http://assignment10/person", "filterBySurnameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: person.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FilterByDate }
     * 
     */
    public FilterByDate createFilterByDate() {
        return new FilterByDate();
    }

    /**
     * Create an instance of {@link FilterByDateResponse }
     * 
     */
    public FilterByDateResponse createFilterByDateResponse() {
        return new FilterByDateResponse();
    }

    /**
     * Create an instance of {@link FilterBySurname }
     * 
     */
    public FilterBySurname createFilterBySurname() {
        return new FilterBySurname();
    }

    /**
     * Create an instance of {@link FilterBySurnameResponse }
     * 
     */
    public FilterBySurnameResponse createFilterBySurnameResponse() {
        return new FilterBySurnameResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByDate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterByDate }{@code >}
     */
    @XmlElementDecl(namespace = "http://assignment10/person", name = "filterByDate")
    public JAXBElement<FilterByDate> createFilterByDate(FilterByDate value) {
        return new JAXBElement<FilterByDate>(_FilterByDate_QNAME, FilterByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByDateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterByDateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://assignment10/person", name = "filterByDateResponse")
    public JAXBElement<FilterByDateResponse> createFilterByDateResponse(FilterByDateResponse value) {
        return new JAXBElement<FilterByDateResponse>(_FilterByDateResponse_QNAME, FilterByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterBySurname }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterBySurname }{@code >}
     */
    @XmlElementDecl(namespace = "http://assignment10/person", name = "filterBySurname")
    public JAXBElement<FilterBySurname> createFilterBySurname(FilterBySurname value) {
        return new JAXBElement<FilterBySurname>(_FilterBySurname_QNAME, FilterBySurname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterBySurnameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterBySurnameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://assignment10/person", name = "filterBySurnameResponse")
    public JAXBElement<FilterBySurnameResponse> createFilterBySurnameResponse(FilterBySurnameResponse value) {
        return new JAXBElement<FilterBySurnameResponse>(_FilterBySurnameResponse_QNAME, FilterBySurnameResponse.class, null, value);
    }

}
