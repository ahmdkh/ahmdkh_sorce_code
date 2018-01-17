
package com.c_s_center.webserviceinvoce1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.c_s_center.webserviceinvoce1 package. 
 * <p>An ObjectFactory allows you to programatically 
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

    private final static QName _Addcitizen_QNAME = new QName("http://webServiceInvoce1.C_S_Center.com/", "addcitizen");
    private final static QName _Updatecitizen_QNAME = new QName("http://webServiceInvoce1.C_S_Center.com/", "updatecitizen");
    private final static QName _AddcitizenResponse_QNAME = new QName("http://webServiceInvoce1.C_S_Center.com/", "addcitizenResponse");
    private final static QName _GetcitizenList_QNAME = new QName("http://webServiceInvoce1.C_S_Center.com/", "getcitizenList");
    private final static QName _Deletecitizen_QNAME = new QName("http://webServiceInvoce1.C_S_Center.com/", "deletecitizen");
    private final static QName _GetcitizenListResponse_QNAME = new QName("http://webServiceInvoce1.C_S_Center.com/", "getcitizenListResponse");
    private final static QName _UpdatecitizenResponse_QNAME = new QName("http://webServiceInvoce1.C_S_Center.com/", "updatecitizenResponse");
    private final static QName _DeletecitizenResponse_QNAME = new QName("http://webServiceInvoce1.C_S_Center.com/", "deletecitizenResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.c_s_center.webserviceinvoce1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Deletecitizen }
     * 
     */
    public Deletecitizen createDeletecitizen() {
        return new Deletecitizen();
    }

    /**
     * Create an instance of {@link GetcitizenListResponse }
     * 
     */
    public GetcitizenListResponse createGetcitizenListResponse() {
        return new GetcitizenListResponse();
    }

    /**
     * Create an instance of {@link DeletecitizenResponse }
     * 
     */
    public DeletecitizenResponse createDeletecitizenResponse() {
        return new DeletecitizenResponse();
    }

    /**
     * Create an instance of {@link UpdatecitizenResponse }
     * 
     */
    public UpdatecitizenResponse createUpdatecitizenResponse() {
        return new UpdatecitizenResponse();
    }

    /**
     * Create an instance of {@link Addcitizen }
     * 
     */
    public Addcitizen createAddcitizen() {
        return new Addcitizen();
    }

    /**
     * Create an instance of {@link AddcitizenResponse }
     * 
     */
    public AddcitizenResponse createAddcitizenResponse() {
        return new AddcitizenResponse();
    }

    /**
     * Create an instance of {@link Updatecitizen }
     * 
     */
    public Updatecitizen createUpdatecitizen() {
        return new Updatecitizen();
    }

    /**
     * Create an instance of {@link GetcitizenList }
     * 
     */
    public GetcitizenList createGetcitizenList() {
        return new GetcitizenList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addcitizen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce1.C_S_Center.com/", name = "addcitizen")
    public JAXBElement<Addcitizen> createAddcitizen(Addcitizen value) {
        return new JAXBElement<Addcitizen>(_Addcitizen_QNAME, Addcitizen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Updatecitizen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce1.C_S_Center.com/", name = "updatecitizen")
    public JAXBElement<Updatecitizen> createUpdatecitizen(Updatecitizen value) {
        return new JAXBElement<Updatecitizen>(_Updatecitizen_QNAME, Updatecitizen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddcitizenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce1.C_S_Center.com/", name = "addcitizenResponse")
    public JAXBElement<AddcitizenResponse> createAddcitizenResponse(AddcitizenResponse value) {
        return new JAXBElement<AddcitizenResponse>(_AddcitizenResponse_QNAME, AddcitizenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetcitizenList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce1.C_S_Center.com/", name = "getcitizenList")
    public JAXBElement<GetcitizenList> createGetcitizenList(GetcitizenList value) {
        return new JAXBElement<GetcitizenList>(_GetcitizenList_QNAME, GetcitizenList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deletecitizen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce1.C_S_Center.com/", name = "deletecitizen")
    public JAXBElement<Deletecitizen> createDeletecitizen(Deletecitizen value) {
        return new JAXBElement<Deletecitizen>(_Deletecitizen_QNAME, Deletecitizen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetcitizenListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce1.C_S_Center.com/", name = "getcitizenListResponse")
    public JAXBElement<GetcitizenListResponse> createGetcitizenListResponse(GetcitizenListResponse value) {
        return new JAXBElement<GetcitizenListResponse>(_GetcitizenListResponse_QNAME, GetcitizenListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatecitizenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce1.C_S_Center.com/", name = "updatecitizenResponse")
    public JAXBElement<UpdatecitizenResponse> createUpdatecitizenResponse(UpdatecitizenResponse value) {
        return new JAXBElement<UpdatecitizenResponse>(_UpdatecitizenResponse_QNAME, UpdatecitizenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletecitizenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce1.C_S_Center.com/", name = "deletecitizenResponse")
    public JAXBElement<DeletecitizenResponse> createDeletecitizenResponse(DeletecitizenResponse value) {
        return new JAXBElement<DeletecitizenResponse>(_DeletecitizenResponse_QNAME, DeletecitizenResponse.class, null, value);
    }

}
