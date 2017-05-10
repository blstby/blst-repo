package com.sofac.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.sofac.model.TiersInfo;
import com.sofac.models.Tieiden;
import com.sofac.services.AffaireService;
import com.sofac.services.TieidenService;
import com.sofac.services.TiersService;
import com.sofac.util.Tab;

@ManagedBean
@ViewScoped
public class AntecedentView {

	private String code;
	private String cin;
	private String cinN;
	private String rc;
	private String nom;
	private TiersService tiersService;
	private TieidenService tieidenService;
	private AffaireService affaireService;
	private List<TiersInfo> tiersInfos;
	private TiersInfo selectedTiersInfo;
	@ManagedProperty("#{homeView}")
	private HomeView home;
	@ManagedProperty("#{tierSynthView}")
	private TierSynthView tSynth;

	@PostConstruct
	public void init() {
		System.out.println("---------- Instantiating AntecedentController --------");
		tiersService = new TiersService();
		tieidenService = new TieidenService();
		affaireService = new AffaireService();
		tiersInfos = new ArrayList<>();
	}
	
	public Tieiden getCIN(List<Tieiden> lst){
		return tieidenService.getCIN(lst);
	}
	
	public String getDateFromJulian(Long date) throws ParseException{
		return tiersService.getDateFromJulian(date);
	}

	public void test() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Titre du message", "Contenu du message"));
	}

	public void afficherTier() {
		if (tSynth.getOpenedTiersInfo().indexOf(selectedTiersInfo) == -1) {
			selectedTiersInfo = tiersService.explorer(selectedTiersInfo);
			selectedTiersInfo.setSituation(affaireService.SituationTier(selectedTiersInfo.getTiers().getTiers()));
			tSynth.getOpenedTiersInfo().add(selectedTiersInfo);
			for(int i = 0; i < home.getTabs().size(); i++){
				if(home.getTabs().get(i).getTitle().equals("-Tier " + selectedTiersInfo.getTiers().getTiers())){
					home.getTabs().remove(i);
				}
			}
			Tab tab = new Tab("-Tier " + selectedTiersInfo.getTiers().getTiers(), "/WEB-INF/secure/TierSynth.xhtml",
					"_" + selectedTiersInfo.getTiers().getTiers());
			tab.setOpen(false);
			tab.setParam(tSynth.getOpenedTiersInfo().size() - 1	);
			home.getTabs().add(tab);
		}
		home.addTab("-Tier " + selectedTiersInfo.getTiers().getTiers());
	}

	public void recherche() {
//		System.out.println(" qwert : " + cinN);
		tiersInfos = tiersService.recherche(code, cin, cinN, rc, nom);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public HomeView getHome() {
		return home;
	}

	public void setHome(HomeView home) {
		this.home = home;
	}

	public TierSynthView gettSynth() {
		return tSynth;
	}

	public void settSynth(TierSynthView tSynth) {
		this.tSynth = tSynth;
	}

	public List<TiersInfo> getTiersInfos() {
		return tiersInfos;
	}

	public void setTiersInfos(List<TiersInfo> tiersInfos) {
		this.tiersInfos = tiersInfos;
	}

	public String getCinN() {
		return cinN;
	}

	public void setCinN(String cinN) {
		this.cinN = cinN;
	}

	public TiersInfo getSelectedTiersInfo() {
		return selectedTiersInfo;
	}

	public void setSelectedTiersInfo(TiersInfo selectedTiersInfo) {
		this.selectedTiersInfo = selectedTiersInfo;
	}
}
