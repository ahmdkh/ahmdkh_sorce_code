
package com.c_s_center.webserviceinvoce;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.c_s_center.webserviceinvoce package. 
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

    private final static QName _GetcsList_QNAME = new QName("http://webServiceInvoce.C_S_Center.com/", "getcsList");
    private final static QName _AddcsResponse_QNAME = new QName("http://webServiceInvoce.C_S_Center.com/", "addcsResponse");
    private final static QName _DeletecsResponse_QNAME = new QName("http://webServiceInvoce.C_S_Center.com/", "deletecsResponse");
    private final static QName _Updatecs_QNAME = new QName("http://webServiceInvoce.C_S_Center.com/", "updatecs");
    private final static QName _GetcsListResponse_QNAME = new QName("http://webServiceInvoce.C_S_Center.com/", "getcsListResponse");
    private final static QName _Deletecs_QNAME = new QName("http://webServiceInvoce.C_S_Center.com/", "deletecs");
    private final static QName _Addcs_QNAME = new QName("http://webServiceInvoce.C_S_Center.com/", "addcs");
    private final static QName _UpdatecsResponse_QNAME = new QName("http://webServiceInvoce.C_S_Center.com/", "updatecsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.c_s_center.webserviceinvoce
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeletecsResponse }
     * 
     */
    public DeletecsResponse createDeletecsResponse() {
        return new DeletecsResponse();
    }

    /**
     * Create an instance of {@link AddcsResponse }
     * 
     */
    public AddcsResponse createAddcsResponse() {
        return new AddcsResponse();
    }

    /**
     * Create an instance of {@link GetcsList }
     * 
     */
    public GetcsList createGetcsList() {
        return new GetcsList();
    }

    /**
     * Create an instance of {@link UpdatecsResponse }
     * 
     */
    public UpdatecsResponse createUpdatecsResponse() {
        return new UpdatecsResponse();
    }

    /**
     * Create an instance of {@link Addcs }
     * 
     */
    public Addcs createAddcs() {
        return new Addcs();
    }

    /**
     * Create an instance of {@link GetcsListResponse }
     * 
     */
    public GetcsListResponse createGetcsListResponse() {
        return new GetcsListResponse();
    }

    /**
     * Create an instance of {@link Updatecs }
     * 
     */
    public Updatecs createUpdatecs() {
        return new Updatecs();
    }

    /**
     * Create an instance of {@link Deletecs }
     * 
     */
    public Deletecs createDeletecs() {
        return new Deletecs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetcsList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce.C_S_Center.com/", name = "getcsList")
    public JAXBElement<GetcsList> createGetcsList(GetcsList value) {
        return new JAXBElement<GetcsList>(_GetcsList_QNAME, GetcsList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddcsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce.C_S_Center.com/", name = "addcsResponse")
    public JAXBElement<AddcsResponse> createAddcsResponse(AddcsResponse value) {
        return new JAXBElement<AddcsResponse>(_AddcsResponse_QNAME, AddcsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletecsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce.C_S_Center.com/", name = "deletecsResponse")
    public JAXBElement<DeletecsResponse> createDeletecsResponse(DeletecsResponse value) {
        return new JAXBElement<DeletecsResponse>(_DeletecsResponse_QNAME, DeletecsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Updatecs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce.C_S_Center.com/", name = "updatecs")
    public JAXBElement<Updatecs> createUpdatecs(Updatecs value) {
        return new JAXBElement<Updatecs>(_Updatecs_QNAME, Updatecs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetcsListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce.C_S_Center.com/", name = "getcsListResponse")
    public JAXBElement<GetcsListResponse> createGetcsListResponse(GetcsListResponse value) {
        return new JAXBElement<GetcsListResponse>(_GetcsListResponse_QNAME, GetcsListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deletecs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce.C_S_Center.com/", name = "deletecs")
    public JAXBElement<Deletecs> createDeletecs(Deletecs value) {
        return new JAXBElement<Deletecs>(_Deletecs_QNAME, Deletecs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addcs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce.C_S_Center.com/", name = "addcs")
    public JAXBElement<Addcs> createAddcs(Addcs value) {
        return new JAXBElement<Addcs>(_Addcs_QNAME, Addcs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatecsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServiceInvoce.C_S_Center.com/", name = "updatecsResponse")
    public JAXBElement<UpdatecsResponse> createUpdatecsResponse(UpdatecsResponse value) {
        return new JAXBElement<UpdatecsResponse>(_UpdatecsResponse_QNAME, UpdatecsResponse.class, null, value);
    }

}
