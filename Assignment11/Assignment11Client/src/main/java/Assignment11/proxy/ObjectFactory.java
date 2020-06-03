
package Assignment11.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Assignment11.proxy package. 
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

    private final static QName _Download_QNAME = new QName("http://Darth_C0mp1ler/mtom", "download");
    private final static QName _DownloadResponse_QNAME = new QName("http://Darth_C0mp1ler/mtom", "downloadResponse");
    private final static QName _Query_QNAME = new QName("http://Darth_C0mp1ler/mtom", "query");
    private final static QName _QueryResponse_QNAME = new QName("http://Darth_C0mp1ler/mtom", "queryResponse");
    private final static QName _UploadFile_QNAME = new QName("http://Darth_C0mp1ler/mtom", "uploadFile");
    private final static QName _UploadFileResponse_QNAME = new QName("http://Darth_C0mp1ler/mtom", "uploadFileResponse");
    private final static QName _UploadFileArg1_QNAME = new QName("", "arg1");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Assignment11.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Download }
     * 
     */
    public Download createDownload() {
        return new Download();
    }

    /**
     * Create an instance of {@link DownloadResponse }
     * 
     */
    public DownloadResponse createDownloadResponse() {
        return new DownloadResponse();
    }

    /**
     * Create an instance of {@link Query }
     * 
     */
    public Query createQuery() {
        return new Query();
    }

    /**
     * Create an instance of {@link QueryResponse }
     * 
     */
    public QueryResponse createQueryResponse() {
        return new QueryResponse();
    }

    /**
     * Create an instance of {@link UploadFile }
     * 
     */
    public UploadFile createUploadFile() {
        return new UploadFile();
    }

    /**
     * Create an instance of {@link UploadFileResponse }
     * 
     */
    public UploadFileResponse createUploadFileResponse() {
        return new UploadFileResponse();
    }

    /**
     * Create an instance of {@link FileModel }
     * 
     */
    public FileModel createFileModel() {
        return new FileModel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Download }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Download }{@code >}
     */
    @XmlElementDecl(namespace = "http://Darth_C0mp1ler/mtom", name = "download")
    public JAXBElement<Download> createDownload(Download value) {
        return new JAXBElement<Download>(_Download_QNAME, Download.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DownloadResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Darth_C0mp1ler/mtom", name = "downloadResponse")
    public JAXBElement<DownloadResponse> createDownloadResponse(DownloadResponse value) {
        return new JAXBElement<DownloadResponse>(_DownloadResponse_QNAME, DownloadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Query }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Query }{@code >}
     */
    @XmlElementDecl(namespace = "http://Darth_C0mp1ler/mtom", name = "query")
    public JAXBElement<Query> createQuery(Query value) {
        return new JAXBElement<Query>(_Query_QNAME, Query.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Darth_C0mp1ler/mtom", name = "queryResponse")
    public JAXBElement<QueryResponse> createQueryResponse(QueryResponse value) {
        return new JAXBElement<QueryResponse>(_QueryResponse_QNAME, QueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFile }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UploadFile }{@code >}
     */
    @XmlElementDecl(namespace = "http://Darth_C0mp1ler/mtom", name = "uploadFile")
    public JAXBElement<UploadFile> createUploadFile(UploadFile value) {
        return new JAXBElement<UploadFile>(_UploadFile_QNAME, UploadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFileResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UploadFileResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Darth_C0mp1ler/mtom", name = "uploadFileResponse")
    public JAXBElement<UploadFileResponse> createUploadFileResponse(UploadFileResponse value) {
        return new JAXBElement<UploadFileResponse>(_UploadFileResponse_QNAME, UploadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "", name = "arg1", scope = UploadFile.class)
    public JAXBElement<byte[]> createUploadFileArg1(byte[] value) {
        return new JAXBElement<byte[]>(_UploadFileArg1_QNAME, byte[].class, UploadFile.class, ((byte[]) value));
    }

}
