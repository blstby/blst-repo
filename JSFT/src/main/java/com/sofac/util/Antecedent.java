package com.sofac.util;

public class Antecedent {
	
	private String tCode;
	private String tNom;
	private String tRc;
	private String tCin;
	private String tDate;
	
	public Antecedent(String tCode, String tNom, String tRc, String tCin, String tDate) {
		super();
		this.tCode = tCode;
		this.tNom = tNom;
		this.tRc = tRc;
		this.tCin = tCin;
		this.tDate = tDate;
	}

	public String gettCode() {
		return tCode;
	}

	public void settCode(String tCode) {
		this.tCode = tCode;
	}

	public String gettNom() {
		return tNom;
	}

	public void settNom(String tNom) {
		this.tNom = tNom;
	}

	public String gettRc() {
		return tRc;
	}

	public void settRc(String tRc) {
		this.tRc = tRc;
	}

	public String gettCin() {
		return tCin;
	}

	public void settCin(String tCin) {
		this.tCin = tCin;
	}

	public String gettDate() {
		return tDate;
	}

	public void settDate(String tDate) {
		this.tDate = tDate;
	}	
}
