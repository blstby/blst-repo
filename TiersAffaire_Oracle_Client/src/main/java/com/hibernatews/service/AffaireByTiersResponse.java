
package com.hibernatews.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour AffaireByTiersResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="AffaireByTiersResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Affaire" type="{http://service.hibernate.com/}affaire" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AffaireByTiersResponse", propOrder = {
    "affaire"
})
public class AffaireByTiersResponse {

    @XmlElement(name = "Affaire")
    protected List<Affaire> affaire;

    /**
     * Gets the value of the affaire property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the affaire property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAffaire().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Affaire }
     * 
     * 
     */
    public List<Affaire> getAffaire() {
        if (affaire == null) {
            affaire = new ArrayList<Affaire>();
        }
        return this.affaire;
    }

}
