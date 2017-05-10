package com.sofac.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sofac.model.Profile;
import com.sofac.services.ProfileService;

@ManagedBean
@ViewScoped
public class GestionProfileView {

	private ProfileService profileService;
	private List<Profile> profiles;

	@PostConstruct
	public void init(){
		profileService = new ProfileService();
		profiles = profileService.getAll();
	}
	
	public void ajouter(){
		profiles.add(new Profile());
	}
	
	public void save(){
		profileService.update(profiles);
	}
	
	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
}
