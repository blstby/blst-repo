
package com.hibernatews.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Affaires", targetNamespace = "http://service.hibernate.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Affaires {


    /**
     * 
     * @return
     *     returns java.util.List<com.hibernatews.service.Tiers>
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "AllTiers")
    @WebResult(name = "Tier", targetNamespace = "")
    @RequestWrapper(localName = "AllTiers", targetNamespace = "http://service.hibernate.com/", className = "com.hibernatews.service.AllTiers")
    @ResponseWrapper(localName = "AllTiersResponse", targetNamespace = "http://service.hibernate.com/", className = "com.hibernatews.service.AllTiersResponse")
    public List<Tiers> allTiers()
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<com.hibernatews.service.Affaire>
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "AllAffaire")
    @WebResult(name = "Affaire", targetNamespace = "")
    @RequestWrapper(localName = "AllAffaire", targetNamespace = "http://service.hibernate.com/", className = "com.hibernatews.service.AllAffaire")
    @ResponseWrapper(localName = "AllAffaireResponse", targetNamespace = "http://service.hibernate.com/", className = "com.hibernatews.service.AllAffaireResponse")
    public List<Affaire> allAffaire()
        throws Exception_Exception
    ;

    /**
     * 
     * @param tier
     * @param nom
     * @return
     *     returns com.hibernatews.service.ResultMsg
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "NewTiers")
    @WebResult(name = "Message", targetNamespace = "")
    @RequestWrapper(localName = "NewTiers", targetNamespace = "http://service.hibernate.com/", className = "com.hibernatews.service.NewTiers")
    @ResponseWrapper(localName = "NewTiersResponse", targetNamespace = "http://service.hibernate.com/", className = "com.hibernatews.service.NewTiersResponse")
    public ResultMsg newTiers(
        @WebParam(name = "Tier", targetNamespace = "")
        String tier,
        @WebParam(name = "Nom", targetNamespace = "")
        String nom)
        throws Exception_Exception
    ;

    /**
     * 
     * @param idTier
     * @return
     *     returns java.util.List<com.hibernatews.service.Affaire>
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "AffaireByTiers")
    @WebResult(name = "Affaire", targetNamespace = "")
    @RequestWrapper(localName = "AffaireByTiers", targetNamespace = "http://service.hibernate.com/", className = "com.hibernatews.service.AffaireByTiers")
    @ResponseWrapper(localName = "AffaireByTiersResponse", targetNamespace = "http://service.hibernate.com/", className = "com.hibernatews.service.AffaireByTiersResponse")
    public List<Affaire> affaireByTiers(
        @WebParam(name = "id_Tier", targetNamespace = "")
        int idTier)
        throws Exception_Exception
    ;

    /**
     * 
     * @param idTier
     * @param montant
     * @param codeProduit
     * @return
     *     returns com.hibernatews.service.ResultMsg
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "NewAffaire")
    @WebResult(name = "Message", targetNamespace = "")
    @RequestWrapper(localName = "NewAffaire", targetNamespace = "http://service.hibernate.com/", className = "com.hibernatews.service.NewAffaire")
    @ResponseWrapper(localName = "NewAffaireResponse", targetNamespace = "http://service.hibernate.com/", className = "com.hibernatews.service.NewAffaireResponse")
    public ResultMsg newAffaire(
        @WebParam(name = "id_Tier", targetNamespace = "")
        int idTier,
        @WebParam(name = "codeProduit", targetNamespace = "")
        String codeProduit,
        @WebParam(name = "Montant", targetNamespace = "")
        float montant)
        throws Exception_Exception
    ;

}
