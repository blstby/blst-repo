package com.sofac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sofac.model.Tiers;

@Entity
@Table(name="AFFAIRE")
public class Affaire {

	@Id 
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
	public String toString() {
		return "Affaire [id=" + id + ", code_produit=" + code_produit + ", tier=" + tier + ", montant_fin="
				+ montant_fin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code_produit == null) ? 0 : code_produit.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(montant_fin);
		result = prime * result + ((tier == null) ? 0 : tier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affaire other = (Affaire) obj;
		if (code_produit == null) {
			if (other.code_produit != null)
				return false;
		} else if (!code_produit.equals(other.code_produit))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(montant_fin) != Float.floatToIntBits(other.montant_fin))
			return false;
		if (tier == null) {
			if (other.tier != null)
				return false;
		} else if (!tier.equals(other.tier))
			return false;
		return true;
	}
}
