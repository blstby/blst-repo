package com.sofac.controllers;

import java.text.ParseException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.sofac.model.AffaireInfo;
import com.sofac.models.Affaire;
import com.sofac.services.AffaireService;
import com.sofac.services.TiersService;
import com.sofac.util.Tab;

@ManagedBean
@ViewScoped
public class AffSynthView {

	private ArrayList<ArrayList<AffaireInfo>> lstA;
	private ArrayList<String> tiers;
	@ManagedProperty("#{affaireView}")
	private AffaireView affV;
	@ManagedProperty("#{homeView}")
	private HomeView home;
	private TiersService tiersService;
	private AffaireService affaireService;
	
	@PostConstruct
	public void init(){
		System.out.println("---------- Instantiating AffSynthcontroller --------");
		lstA = new ArrayList<>();
		tiersService = new TiersService();
		affaireService = new AffaireService();
		setTiers(new ArrayList<>());
	}
	
	public void afficherAff(Affaire affaire){
//		if(affV.getAffaires().indexOf(affaire) == -1){
//			affV.getAffaires().add(affaire);
//			for (int i = 0; i < home.getTabs().size(); i++) {
//				if (home.getTabs().get(i).getTitle().equals("_Affaire " + affaire.getId())) {
//					home.getTabs().remove(i);
//				}
//			}
//			Tab tab = new Tab("_Affaire " + affaire.getId(), "/WEB-INF/secure/Affaire.xhtml", "Cont"+affaire.getId(),
//					affV.getAffaires().size() - 1);
//			tab.setOpen(false);
//			home.getTabs().add(tab);
//		}
//		home.addTab("_Affaire " + affaire.getId());
	}
	
	public double solde(Long id, String tier){
		return affaireService.soldeAffTiers(id, tier);
	}
	
	public double enCours(Long id){
		return affaireService.encoursAff(id);
	}

	public String getDateFromJulian(Long date) throws ParseException{
		return tiersService.getDateFromJulian(date);
	}
	
	public ArrayList<String> getTypeTiers(String tiers, Long idAff){
		return affaireService.getTypeTiers(tiers, idAff);
	}

	public AffaireView getAffV() {
		return affV;
	}

	public void setAffV(AffaireView affV) {
		this.affV = affV;
	}

	public HomeView getHome() {
		return home;
	}

	public void setHome(HomeView home) {
		this.home = home;
	}

	public ArrayList<ArrayList<AffaireInfo>> getLstA() {
		return lstA;
	}

	public void setLstA(ArrayList<ArrayList<AffaireInfo>> lstA) {
		this.lstA = lstA;
	}

	public ArrayList<String> getTiers() {
		return tiers;
	}

	public void setTiers(ArrayList<String> tiers) {
		this.tiers = tiers;
	}
}
