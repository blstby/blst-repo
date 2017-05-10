package com.sofac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROFILE")
public class Profile {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "NOM")
	private String Nom;
	
	@Column(name = "EXPLOITABLE", nullable = false)
	private boolean exploitable;

	public Profile() {
		super();
	}

	public Profile(String nom, boolean exploitable) {
		super();
		Nom = nom;
		this.exploitable = exploitable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public boolean isExploitable() {
		return exploitable;
	}

	public void setExploitable(boolean exploitable) {
		this.exploitable = exploitable;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", Nom=" + Nom + ", exploitable=" + exploitable + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nom == null) ? 0 : Nom.hashCode());
		result = prime * result + (exploitable ? 1231 : 1237);
		result = prime * result + id;
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
		Profile other = (Profile) obj;
		if (Nom == null) {
			if (other.Nom != null)
				return false;
		} else if (!Nom.equals(other.Nom))
			return false;
		if (exploitable != other.exploitable)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
