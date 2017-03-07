
package com.hibernatews.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour NewTiers complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="NewTiers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewTiers", propOrder = {
    "tier",
    "nom"
})
public class NewTiers {

    @XmlElement(name = "Tier", required = true)
    protected String tier;
    @XmlElement(name = "Nom", required = true)
    protected String nom;

    /**
     * Obtient la valeur de la propriété tier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTier() {
        return tier;
    }

    /**
     * Définit la valeur de la propriété tier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTier(String value) {
        this.tier = value;
    }

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

}
