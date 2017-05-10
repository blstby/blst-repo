package com.sofac.model;

import com.sofac.models.Affaire;
import com.sofac.models.Afftiers;

public class AffaireInfo {

	private Affaire affaire;
	private Afftiers afftiers;
	
	public AffaireInfo(Affaire affaire, Afftiers afftiers) {
		super();
		this.affaire = affaire;
		this.afftiers = afftiers;
	}

	public AffaireInfo() {
		super();
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
}
