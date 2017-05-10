package com.sofac.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MENU")
public class Menu {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PARENT", nullable = true)
	private Module parent;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MODULE", nullable = false)
	private Module module;
	
	@Column(name = "N_ORDRE")
	private int nOrdre;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PROFILE", nullable = false)
	private Profile profile;
	
	@Column(name = "EXPLOITABLE", nullable = false)
	private boolean exploitable;

	public Menu() {
		super();
	}

	public Menu(Module parent, Module module, int nOrdre, Profile profile, boolean exploitable) {
		super();
		this.parent = parent;
		this.module = module;
		this.nOrdre = nOrdre;
		this.profile = profile;
		this.exploitable = exploitable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Module getParent() {
		return parent;
	}

	public void setParent(Module parent) {
		this.parent = parent;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public int getnOrdre() {
		return nOrdre;
	}

	public void setnOrdre(int nOrdre) {
		this.nOrdre = nOrdre;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isExploitable() {
		return exploitable;
	}

	public void setExploitable(boolean exploitable) {
		this.exploitable = exploitable;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", parent=" + parent + ", module=" + module + ", nOrdre=" + nOrdre + ", profile="
				+ profile + ", exploitable=" + exploitable + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (exploitable ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + nOrdre;
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
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
		Menu other = (Menu) obj;
		if (exploitable != other.exploitable)
			return false;
		if (id != other.id)
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (nOrdre != other.nOrdre)
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		return true;
	}
}
