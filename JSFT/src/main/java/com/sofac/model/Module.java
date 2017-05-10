package com.sofac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MODULE")
public class Module {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "NOM_MENU", nullable = false)
	private String nomMenu;
	
	@Column(name = "NOM_TAB")
	private String nomTab;
	
	@Column(name = "CONTENU")
	private String contenu;
	
	@Column(name = "EXPLOITABLE", nullable = false)
	private boolean exploitable;

	public Module() {
		super();
	}

	public Module(String nomMenu, String nomTab, String contenu, boolean exploitable) {
		super();
		this.nomMenu = nomMenu;
		this.nomTab = nomTab;
		this.contenu = contenu;
		this.exploitable = exploitable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomMenu() {
		return nomMenu;
	}

	public void setNomMenu(String nomMenu) {
		this.nomMenu = nomMenu;
	}

	public String getNomTab() {
		return nomTab;
	}

	public void setNomTab(String nomTab) {
		this.nomTab = nomTab;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public boolean isExploitable() {
		return exploitable;
	}

	public void setExploitable(boolean exploitable) {
		this.exploitable = exploitable;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", nomMenu=" + nomMenu + ", nomTab=" + nomTab + ", contenu=" + contenu
				+ ", exploitable=" + exploitable + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contenu == null) ? 0 : contenu.hashCode());
		result = prime * result + (exploitable ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((nomMenu == null) ? 0 : nomMenu.hashCode());
		result = prime * result + ((nomTab == null) ? 0 : nomTab.hashCode());
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
		Module other = (Module) obj;
		if (contenu == null) {
			if (other.contenu != null)
				return false;
		} else if (!contenu.equals(other.contenu))
			return false;
		if (exploitable != other.exploitable)
			return false;
		if (id != other.id)
			return false;
		if (nomMenu == null) {
			if (other.nomMenu != null)
				return false;
		} else if (!nomMenu.equals(other.nomMenu))
			return false;
		if (nomTab == null) {
			if (other.nomTab != null)
				return false;
		} else if (!nomTab.equals(other.nomTab))
			return false;
		return true;
	}
}
