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

import com.sofac.model.AffaireInfo;
import com.sofac.model.TiersInfo;
import com.sofac.services.AffaireService;
import com.sofac.services.TieidenService;
import com.sofac.services.TiersService;
import com.sofac.util.Tab;

@ManagedBean
@ViewScoped
public class TierSynthView {

	private List<TiersInfo> openedTiersInfo;
	@ManagedProperty("#{homeView}")
	private HomeView home;
	@ManagedProperty("#{affSynthView}")
	private AffSynthView affSynth;
	@ManagedProperty("#{loginView}")
	private LoginView loginView;
	private AffaireService affaireService;
	private TiersService tiersService;
	private TieidenService tieidenService;

	@PostConstruct
	public void init() {
		System.out.println("---------- Instantiating TierSynthcontroller --------");
		setOpenedTiersInfo(new ArrayList<TiersInfo>());
		affaireService = new AffaireService();
		tiersService = new TiersService();
		tieidenService = new TieidenService();
		loginView.loadPiece();
	}
	
	public String getLibId(String code){
		return tieidenService.getLibId(loginView.getCodiffs(), code);
	}
	
	public String getCodiff(String code,String type){
		return tiersService.getCoddif(loginView.getCodiffs(), code, type);
	}
	
	public String getDateFromJulian(Long date) throws ParseException{
		return tiersService.getDateFromJulian(date);
	}
	
	public Long nbAffaire(String tiers){
		return affaireService.nbAffaire(tiers);
	}

	public void afficherAff(String tier) {
		ArrayList<AffaireInfo> aff = affaireService.getByTiers(tier);
		if (affSynth.getLstA().indexOf(aff) == -1) {
			affSynth.getTiers().add(tier);
			affSynth.getLstA().add(aff);
			for (int i = 0; i < home.getTabs().size(); i++) {
				if (home.getTabs().get(i).getTitle().equals("+Affs. " + tier)) {
					home.getTabs().remove(i);
				}
			}
			Tab tab = new Tab("+Affs. " + tier, "/WEB-INF/secure/AffSynth.xhtml", "-" + tier,
					affSynth.getLstA().size() - 1);
			tab.setOpen(false);
			home.getTabs().add(tab);
		}
		home.addTab("+Affs. " + tier);
	}
	
	public void test() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Titre du message", "Contenu du message"));
	}

	public AffSynthView getAffSynth() {
		return affSynth;
	}

	public void setAffSynth(AffSynthView affSynth) {
		this.affSynth = affSynth;
	}

	public HomeView getHome() {
		return home;
	}

	public void setHome(HomeView home) {
		this.home = home;
	}

	public List<TiersInfo> getOpenedTiersInfo() {
		return openedTiersInfo;
	}

	public void setOpenedTiersInfo(List<TiersInfo> openedTiersInfo) {
		this.openedTiersInfo = openedTiersInfo;
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}
}
