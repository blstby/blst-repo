package com.sofac.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sofac.dao.ModuleDao;
import com.sofac.model.Menu;
import com.sofac.model.Module;

public class ModuleService {

	private ModuleDao dao = new ModuleDao();

	public boolean save(Module module) {
		return dao.save(module);
	}

	public boolean update(Module module) {
		return dao.update(module);
	}

	public List<Module> getAll() {
		return dao.getAll();
	}

	public List<Module> getExploitable() {
		List<Module> modules = dao.getAll();
		List<Module> ret = new ArrayList<Module>();
		for (int i = 0; i < modules.size(); i++) {
			if (modules.get(i).isExploitable()) {
				ret.add(modules.get(i));
			}
		}
		return ret;
	}

	public List<Module> getParentExploitable() {
		List<Module> modules = dao.getParentExploitable();
		List<Module> ret = new ArrayList<Module>();
		for (int i = 0; i < modules.size(); i++) {
			if (modules.get(i).isExploitable()) {
				ret.add(modules.get(i));
			}
		}
		return ret;
	}

	public List<Module> getParents(List<Menu> menus) {
		List<Module> ret = new ArrayList<>();
		if (!menus.isEmpty()) {
			for (int i = 0; i < menus.size(); i++) {
				if (menus.get(i).getModule().getContenu() == null) {
					ret.add(menus.get(i).getModule());
				}
			}
		}
		return ret;
	}

	public void update(List<Module> modules) {
		boolean test = true;
		for (int i = 0; i < modules.size(); i++) {
			if (!update(modules.get(i))) {
				test = false;
			}
		}
		if (test) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès !", "Modules mis à jour avec succès"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !",
					"Une erreur s'est produite lors de la mis à jour"));
		}
	}
}
