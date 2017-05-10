package com.sofac.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TIERS")
public class Tiers {

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "CODE", unique = true, nullable = false)
	private String code;

	@Column(name = "NOM", nullable = false)
	private String nom;
	
	@Column(name = "CIN")
	private String cin;
	
	@Column(name = "RC")
	private String rc;
	
	@Column(name = "DATE_N")
	@Temporal(TemporalType.DATE)
	private Date dateN;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public Date getDateN() {
		return dateN;
	}

	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}

	@Override
	public String toString() {
		return "Tiers [id=" + id + ", code=" + code + ", nom=" + nom + ", cin=" + cin + ", rc=" + rc + ", dateN="
				+ dateN + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((dateN == null) ? 0 : dateN.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((rc == null) ? 0 : rc.hashCode());
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
		Tiers other = (Tiers) obj;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (dateN == null) {
			if (other.dateN != null)
				return false;
		} else if (!dateN.equals(other.dateN))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (rc == null) {
			if (other.rc != null)
				return false;
		} else if (!rc.equals(other.rc))
			return false;
		return true;
	}
}