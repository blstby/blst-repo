
package com.hibernatews.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour NewAffaire complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="NewAffaire">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_Tier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codeProduit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Montant" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewAffaire", propOrder = {
    "idTier",
    "codeProduit",
    "montant"
})
public class NewAffaire {

    @XmlElement(name = "id_Tier")
    protected int idTier;
    @XmlElement(required = true)
    protected String codeProduit;
    @XmlElement(name = "Montant")
    protected float montant;

    /**
     * Obtient la valeur de la propri�t� idTier.
     * 
     */
    public int getIdTier() {
        return idTier;
    }

    /**
     * D�finit la valeur de la propri�t� idTier.
     * 
     */
    public void setIdTier(int value) {
        this.idTier = value;
    }

    /**
     * Obtient la valeur de la propri�t� codeProduit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeProduit() {
        return codeProduit;
    }

    /**
     * D�finit la valeur de la propri�t� codeProduit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeProduit(String value) {
        this.codeProduit = value;
    }

    /**
     * Obtient la valeur de la propri�t� montant.
     * 
     */
    public float getMontant() {
        return montant;
    }

    /**
     * D�finit la valeur de la propri�t� montant.
     * 
     */
    public void setMontant(float value) {
        this.montant = value;
    }

}
