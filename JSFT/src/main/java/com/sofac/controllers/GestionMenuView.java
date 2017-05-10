package com.sofac.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.sofac.model.Menu;
import com.sofac.model.Module;
import com.sofac.model.Profile;
import com.sofac.services.MenuService;
import com.sofac.services.ModuleService;
import com.sofac.services.ProfileService;

@ManagedBean
@ViewScoped
public class GestionMenuView {

	private ProfileService profileService;
	private ModuleService moduleService;
	private MenuService menuService;
	private List<Profile> profiles;
	private List<Module> modules;
	private List<Module> parents;
	private List<Menu> menus;
	private Menu selectedMenu;
	private Profile selectedProfile;

	@PostConstruct
	public void init() {
		System.out.println("---- instantiating Gestion Menu controller ----");
		profileService = new ProfileService();
		moduleService = new ModuleService();
		menuService = new MenuService();
		setMenus(new ArrayList<Menu>());
		setProfiles(profileService.getExploitable());
		setModules(moduleService.getExploitable());
		setParents(moduleService.getParents(menus));
		setSelectedMenu(new Menu());
	}

	public void loadMenus() {
		menus = menuService.getByProfile(selectedProfile);
		parents = moduleService.getParents(menus);
	}
	
	public void updateParents(){
		parents = moduleService.getParents(menus);
	}

	public void ajouter() {
		if (testProfile()) {
			menus.add(new Menu());
		}
	}

	public void save() {
		if (testProfile()) {
			menuService.save(menus, selectedProfile, parents);
		}
	}

	private boolean testProfile() {
		if (selectedProfile == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !", "Veuiller choisir un profil"));
			return false;
		}
		return true;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Module> getParents() {
		return parents;
	}

	public void setParents(List<Module> parents) {
		this.parents = parents;
	}

	public Menu getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(Menu selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Profile getSelectedProfile() {
		return selectedProfile;
	}

	public void setSelectedProfile(Profile selectedProfile) {
		this.selectedProfile = selectedProfile;
	}
}
