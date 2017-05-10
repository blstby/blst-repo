package com.sofac.util;

public class Codiff {

	private String code;
	private String libelle;
	private String type;

	public Codiff() {
		super();
	}

	public Codiff(String code, String libelle, String type) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
