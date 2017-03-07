
package com.hibernatews.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour affaire complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propriété codeProduit.
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
     * Définit la valeur de la propriété codeProduit.
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
     * Obtient la valeur de la propriété id.
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
     * Définit la valeur de la propriété id.
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
     * Obtient la valeur de la propriété montantFin.
     * 
     */
    public float getMontantFin() {
        return montantFin;
    }

    /**
     * Définit la valeur de la propriété montantFin.
     * 
     */
    public void setMontantFin(float value) {
        this.montantFin = value;
    }

    /**
     * Obtient la valeur de la propriété idTier.
     * 
     */
    public int getIdTier() {
        return idTier;
    }

    /**
     * Définit la valeur de la propriété idTier.
     * 
     */
    public void setIdTier(int value) {
        this.idTier = value;
    }

}
