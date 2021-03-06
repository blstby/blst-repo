package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="AFFAIRE")
public class Affaire {

	@Id 
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "affaire_id_Sequence")
	@SequenceGenerator(name = "affaire_id_Sequence", sequenceName = "ID_AFFAIRE_SEQ", initialValue = 1)
	private Integer id;	

	@Column(name="CODE_PRODUIT", nullable = false)
	private String code_produit;
	
	@ManyToOne(optional = false)
	@JoinColumn(name ="TIERS_CLIENT", nullable = false)
	private Tiers tier;
	
	@Column(name="MONTANT_FIN", nullable = false)
	private float montant_fin;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode_produit() {
		return code_produit;
	}

	public void setCode_produit(String code_produit) {
		this.code_produit = code_produit;
	}
	
	public float getMontant_fin() {
		return montant_fin;
	}

	public void setMontant_fin(float montant_fin) {
		this.montant_fin = montant_fin;
	}
	
	@XmlTransient
	public Tiers getTier() {
		return tier;
	}

	@XmlElement(name = "id_tier")
	private int getTiersId(){
		return this.tier.getId();
	}
	
	public void setTier(Tiers tier) {
		this.tier = tier;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Affaire))
			return false;
		Affaire other = (Affaire) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tier == null) {
			if (other.tier != null)
				return false;
		} else if (!tier.equals(other.tier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Affaire [id=" + id + ", tier=" + tier.getNom() + ", code_produit=" + code_produit + 
				", montant=" + montant_fin +"]";
	}

}
