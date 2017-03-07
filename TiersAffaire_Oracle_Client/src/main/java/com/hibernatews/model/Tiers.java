package com.hibernatews.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TIERS")
public class Tiers {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "TIER", unique = true, nullable = false)
	private String tier;

	@Column(name = "NOM", nullable = false)
	private String nom;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Tiers))
			return false;
		Tiers other = (Tiers) obj;
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
		return "Tier [id=" + id + ", tier=" + tier + ", nom=" + nom + "]";
	}

}