package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AFFAIRE")
public class Affaire {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
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
	
	public Tiers getTier() {
		return tier;
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
