
package person.proxy;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PersonBaseImplementationService", targetNamespace = "http://assignment10/person", wsdlLocation = "http://localhost:8080/person?wsdl")
public class PersonBaseImplementationService
    extends Service
{

    private final static URL PERSONBASEIMPLEMENTATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException PERSONBASEIMPLEMENTATIONSERVICE_EXCEPTION;
    private final static QName PERSONBASEIMPLEMENTATIONSERVICE_QNAME = new QName("http://assignment10/person", "PersonBaseImplementationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/person?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PERSONBASEIMPLEMENTATIONSERVICE_WSDL_LOCATION = url;
        PERSONBASEIMPLEMENTATIONSERVICE_EXCEPTION = e;
    }

    public PersonBaseImplementationService() {
        super(__getWsdlLocation(), PERSONBASEIMPLEMENTATIONSERVICE_QNAME);
    }

    public PersonBaseImplementationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PERSONBASEIMPLEMENTATIONSERVICE_QNAME, features);
    }

    public PersonBaseImplementationService(URL wsdlLocation) {
        super(wsdlLocation, PERSONBASEIMPLEMENTATIONSERVICE_QNAME);
    }

    public PersonBaseImplementationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PERSONBASEIMPLEMENTATIONSERVICE_QNAME, features);
    }

    public PersonBaseImplementationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PersonBaseImplementationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IPersonBase
     */
    @WebEndpoint(name = "IPersonBasePort")
    public IPersonBase getIPersonBasePort() {
        return super.getPort(new QName("http://assignment10/person", "IPersonBasePort"), IPersonBase.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns IPersonBase
     */
    @WebEndpoint(name = "IPersonBasePort")
    public IPersonBase getIPersonBasePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://assignment10/person", "IPersonBasePort"), IPersonBase.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PERSONBASEIMPLEMENTATIONSERVICE_EXCEPTION!= null) {
            throw PERSONBASEIMPLEMENTATIONSERVICE_EXCEPTION;
        }
        return PERSONBASEIMPLEMENTATIONSERVICE_WSDL_LOCATION;
    }

}
