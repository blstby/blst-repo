package com.sofac.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sofac.model.Profile;
import com.sofac.model.Utilisateur;
import com.sofac.services.ProfileService;
import com.sofac.services.UtilisateurService;

@ManagedBean
@ViewScoped
public class GestionUtilisateurView {
	
	private List<Utilisateur> utilisateurs;
	private List<Profile> profiles;
	private UtilisateurService utilisateurService;
	private ProfileService profileService;
	
	public enum types{
		Spec,
		BD
	}
	
	@PostConstruct
	public void init(){
		System.out.println("*********************");
		utilisateurService = new UtilisateurService();
		profileService = new ProfileService();
		setProfiles(profileService.getAll());
		setUtilisateurs(utilisateurService.getAll());
	}
	
	public void ajouter(){
		utilisateurs.add(new Utilisateur());
	}
	
	public void save(){
		utilisateurService.update(utilisateurs);
	}
	
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	
	public types[] getStatuses() {
        return types.values();
    }

}
