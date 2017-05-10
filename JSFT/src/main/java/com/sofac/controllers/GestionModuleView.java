package com.sofac.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sofac.model.Module;
import com.sofac.services.ModuleService;

@ManagedBean
@ViewScoped
public class GestionModuleView {

	private List<Module> modules;
	private ModuleService moduleService;

	@PostConstruct
	public void init() {
		moduleService = new ModuleService();
		setModules(moduleService.getAll());
	}

	public void ajouter() {
		modules.add(new Module());
	}

	public void save() {
		moduleService.update(modules);
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
}
