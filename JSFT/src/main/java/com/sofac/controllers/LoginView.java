package com.sofac.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sofac.model.Utilisateur;
import com.sofac.services.TieidenService;
import com.sofac.services.TiersService;
import com.sofac.services.UtilisateurService;
import com.sofac.util.Codiff;

@ManagedBean
@SessionScoped
public class LoginView {

	private Utilisateur utilisateur;
	private UtilisateurService utilisateurService;
	private TieidenService tieidenService;
	private TiersService tiersService;
	private List<Codiff> codiffs;

	@PostConstruct
	public void init() {
		utilisateurService = new UtilisateurService();
		utilisateur = new Utilisateur();
		tieidenService = new TieidenService();
		tiersService = new TiersService();
	}
	
	public void loadPiece(){
		setCodiffs(tieidenService.getPiece());
		codiffs.addAll(tiersService.getCodiff("PAYS"));
		codiffs.addAll(tiersService.getCodiff("SECT"));
		codiffs.addAll(tiersService.getCodiff("CPRO"));
		codiffs.addAll(tiersService.getCodiff("CREF"));
	}

	public String connect() {
		utilisateur = utilisateurService.connect(utilisateur);
		return utilisateurService.check(utilisateur);
	}

	public String logOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Codiff> getCodiffs() {
		return codiffs;
	}

	public void setCodiffs(List<Codiff> codiffs) {
		this.codiffs = codiffs;
	}
}
