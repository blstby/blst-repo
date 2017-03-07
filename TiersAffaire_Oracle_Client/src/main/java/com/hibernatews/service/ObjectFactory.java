
package com.hibernatews.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hibernatews.service package. 
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

    private final static QName _AffaireByTiersResponse_QNAME = new QName("http://service.hibernate.com/", "AffaireByTiersResponse");
    private final static QName _Affaire_QNAME = new QName("http://service.hibernate.com/", "affaire");
    private final static QName _AllAffaire_QNAME = new QName("http://service.hibernate.com/", "AllAffaire");
    private final static QName _NewAffaireResponse_QNAME = new QName("http://service.hibernate.com/", "NewAffaireResponse");
    private final static QName _Exception_QNAME = new QName("http://service.hibernate.com/", "Exception");
    private final static QName _MessageRetour_QNAME = new QName("http://service.hibernate.com/", "Message_retour");
    private final static QName _NewTiers_QNAME = new QName("http://service.hibernate.com/", "NewTiers");
    private final static QName _NewAffaire_QNAME = new QName("http://service.hibernate.com/", "NewAffaire");
    private final static QName _NewTiersResponse_QNAME = new QName("http://service.hibernate.com/", "NewTiersResponse");
    private final static QName _AllTiers_QNAME = new QName("http://service.hibernate.com/", "AllTiers");
    private final static QName _AffaireByTiers_QNAME = new QName("http://service.hibernate.com/", "AffaireByTiers");
    private final static QName _AllAffaireResponse_QNAME = new QName("http://service.hibernate.com/", "AllAffaireResponse");
    private final static QName _AllTiersResponse_QNAME = new QName("http://service.hibernate.com/", "AllTiersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hibernatews.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResultMsg }
     * 
     */
    public ResultMsg createResultMsg() {
        return new ResultMsg();
    }

    /**
     * Create an instance of {@link NewTiers }
     * 
     */
    public NewTiers createNewTiers() {
        return new NewTiers();
    }

    /**
     * Create an instance of {@link NewAffaire }
     * 
     */
    public NewAffaire createNewAffaire() {
        return new NewAffaire();
    }

    /**
     * Create an instance of {@link NewTiersResponse }
     * 
     */
    public NewTiersResponse createNewTiersResponse() {
        return new NewTiersResponse();
    }

    /**
     * Create an instance of {@link AffaireByTiersResponse }
     * 
     */
    public AffaireByTiersResponse createAffaireByTiersResponse() {
        return new AffaireByTiersResponse();
    }

    /**
     * Create an instance of {@link Affaire }
     * 
     */
    public Affaire createAffaire() {
        return new Affaire();
    }

    /**
     * Create an instance of {@link AllAffaire }
     * 
     */
    public AllAffaire createAllAffaire() {
        return new AllAffaire();
    }

    /**
     * Create an instance of {@link NewAffaireResponse }
     * 
     */
    public NewAffaireResponse createNewAffaireResponse() {
        return new NewAffaireResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link AffaireByTiers }
     * 
     */
    public AffaireByTiers createAffaireByTiers() {
        return new AffaireByTiers();
    }

    /**
     * Create an instance of {@link AllAffaireResponse }
     * 
     */
    public AllAffaireResponse createAllAffaireResponse() {
        return new AllAffaireResponse();
    }

    /**
     * Create an instance of {@link AllTiersResponse }
     * 
     */
    public AllTiersResponse createAllTiersResponse() {
        return new AllTiersResponse();
    }

    /**
     * Create an instance of {@link AllTiers }
     * 
     */
    public AllTiers createAllTiers() {
        return new AllTiers();
    }

    /**
     * Create an instance of {@link Tiers }
     * 
     */
    public Tiers createTiers() {
        return new Tiers();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AffaireByTiersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "AffaireByTiersResponse")
    public JAXBElement<AffaireByTiersResponse> createAffaireByTiersResponse(AffaireByTiersResponse value) {
        return new JAXBElement<AffaireByTiersResponse>(_AffaireByTiersResponse_QNAME, AffaireByTiersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Affaire }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "affaire")
    public JAXBElement<Affaire> createAffaire(Affaire value) {
        return new JAXBElement<Affaire>(_Affaire_QNAME, Affaire.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllAffaire }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "AllAffaire")
    public JAXBElement<AllAffaire> createAllAffaire(AllAffaire value) {
        return new JAXBElement<AllAffaire>(_AllAffaire_QNAME, AllAffaire.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewAffaireResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "NewAffaireResponse")
    public JAXBElement<NewAffaireResponse> createNewAffaireResponse(NewAffaireResponse value) {
        return new JAXBElement<NewAffaireResponse>(_NewAffaireResponse_QNAME, NewAffaireResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultMsg }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "Message_retour")
    public JAXBElement<ResultMsg> createMessageRetour(ResultMsg value) {
        return new JAXBElement<ResultMsg>(_MessageRetour_QNAME, ResultMsg.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewTiers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "NewTiers")
    public JAXBElement<NewTiers> createNewTiers(NewTiers value) {
        return new JAXBElement<NewTiers>(_NewTiers_QNAME, NewTiers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewAffaire }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "NewAffaire")
    public JAXBElement<NewAffaire> createNewAffaire(NewAffaire value) {
        return new JAXBElement<NewAffaire>(_NewAffaire_QNAME, NewAffaire.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewTiersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "NewTiersResponse")
    public JAXBElement<NewTiersResponse> createNewTiersResponse(NewTiersResponse value) {
        return new JAXBElement<NewTiersResponse>(_NewTiersResponse_QNAME, NewTiersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllTiers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "AllTiers")
    public JAXBElement<AllTiers> createAllTiers(AllTiers value) {
        return new JAXBElement<AllTiers>(_AllTiers_QNAME, AllTiers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AffaireByTiers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "AffaireByTiers")
    public JAXBElement<AffaireByTiers> createAffaireByTiers(AffaireByTiers value) {
        return new JAXBElement<AffaireByTiers>(_AffaireByTiers_QNAME, AffaireByTiers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllAffaireResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "AllAffaireResponse")
    public JAXBElement<AllAffaireResponse> createAllAffaireResponse(AllAffaireResponse value) {
        return new JAXBElement<AllAffaireResponse>(_AllAffaireResponse_QNAME, AllAffaireResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllTiersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hibernate.com/", name = "AllTiersResponse")
    public JAXBElement<AllTiersResponse> createAllTiersResponse(AllTiersResponse value) {
        return new JAXBElement<AllTiersResponse>(_AllTiersResponse_QNAME, AllTiersResponse.class, null, value);
    }

}
