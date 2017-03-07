
package com.hibernatews.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour affaire complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="affaire">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code_produit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="montant_fin" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="id_tier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "affaire", propOrder = {
    "codeProduit",
    "id",
    "montantFin",
    "idTier"
})
public class Affaire {

    @XmlElement(name = "code_produit")
    protected String codeProduit;
    protected Integer id;
    @XmlElement(name = "montant_fin")
    protected float montantFin;
    @XmlElement(name = "id_tier")
    protected int idTier;

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
     * Obtient la valeur de la propri�t� id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * D�finit la valeur de la propri�t� id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propri�t� montantFin.
     * 
     */
    public float getMontantFin() {
        return montantFin;
    }

    /**
     * D�finit la valeur de la propri�t� montantFin.
     * 
     */
    public void setMontantFin(float value) {
        this.montantFin = value;
    }

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

}
