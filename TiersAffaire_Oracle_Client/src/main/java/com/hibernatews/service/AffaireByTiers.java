
package com.hibernatews.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour AffaireByTiers complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="AffaireByTiers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_Tier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AffaireByTiers", propOrder = {
    "idTier"
})
public class AffaireByTiers {

    @XmlElement(name = "id_Tier")
    protected int idTier;

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
