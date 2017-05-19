package com.sofac.model;

import com.sofac.models.Affaire;
import com.sofac.models.Afftiers;

public class AffaireInfo {

	private Affaire affaire;
	private Afftiers afftiers;
	private String duree;
	private double montantEch;
	private double crRealise;
	private String datePremEch;
	private String dateDernEch;
	
	public AffaireInfo(Affaire affaire, Afftiers afftiers, String duree, double montantEch, double crRealise, String datePremEch, String dateDernEch) {
		super();
		this.affaire = affaire;
		this.afftiers = afftiers;
		this.duree = duree;
		this.montantEch = montantEch;
		this.datePremEch = datePremEch;
		this.dateDernEch = dateDernEch;
		this.crRealise = crRealise;
	}

	public AffaireInfo() {
		super();
	}

	public AffaireInfo(Affaire affaire, String duree, double montantEch, double crRealise, String datePremEch, String dateDernEch) {
		super();
		this.affaire = affaire;
		this.duree = duree;
		this.montantEch = montantEch;
		this.datePremEch = datePremEch;
		this.dateDernEch = dateDernEch;
		this.crRealise = crRealise;
	}

	public Affaire getAffaire() {
		return affaire;
	}

	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}

	public Afftiers getAfftiers() {
		return afftiers;
	}

	public void setAfftiers(Afftiers afftiers) {
		this.afftiers = afftiers;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public double getMontantEch() {
		return montantEch;
	}

	public void setMontantEch(double montantEch) {
		this.montantEch = montantEch;
	}

	public String getDatePremEch() {
		return datePremEch;
	}

	public void setDatePremEch(String datePremEch) {
		this.datePremEch = datePremEch;
	}

	public String getDateDernEch() {
		return dateDernEch;
	}

	public void setDateDernEch(String dateDernEch) {
		this.dateDernEch = dateDernEch;
	}

	public double getCrRealise() {
		return crRealise;
	}

	public void setCrRealise(double crRealise) {
		this.crRealise = crRealise;
	}
}
