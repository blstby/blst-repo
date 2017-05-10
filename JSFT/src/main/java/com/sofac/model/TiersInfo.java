package com.sofac.model;

import java.util.List;

import com.sofac.models.Empltiers;
import com.sofac.models.Refcomm;
import com.sofac.models.Tieiden;
import com.sofac.models.Tiers;

public class TiersInfo {
	
	private com.sofac.models.Tiers tiers;
	private List<Refcomm> refcomms;
	private List<Tieiden> tieidens;
	private Empltiers empltiers;
	private String rib;
	private String adresse;
	private String[] situation;

	
	public TiersInfo(Tiers tiers, List<Tieiden> tieidens, String adresse) {
		super();
		this.tiers = tiers;
		this.tieidens = tieidens;
		this.adresse = adresse;
	}

	public TiersInfo(Tiers tiers, List<Refcomm> refcomms, String rib, String adresse, List<Tieiden> tieidens,
			Empltiers empltiers) {
		super();
		this.tiers = tiers;
		this.refcomms = refcomms;
		this.rib = rib;
		this.adresse = adresse;
		this.tieidens = tieidens;
		this.empltiers = empltiers;
	}

	public com.sofac.models.Tiers getTiers() {
		return tiers;
	}

	public void setTiers(com.sofac.models.Tiers tiers) {
		this.tiers = tiers;
	}

	public List<Refcomm> getRefcomms() {
		return refcomms;
	}

	public void setRefcomms(List<Refcomm> refcomms) {
		this.refcomms = refcomms;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public List<Tieiden> getTieidens() {
		return tieidens;
	}

	public void setTieidens(List<Tieiden> tieidens) {
		this.tieidens = tieidens;
	}

	public Empltiers getEmpltiers() {
		return empltiers;
	}

	public void setEmpltiers(Empltiers empltiers) {
		this.empltiers = empltiers;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String[] getSituation() {
		return situation;
	}

	public void setSituation(String[] situation) {
		this.situation = situation;
	}
}
