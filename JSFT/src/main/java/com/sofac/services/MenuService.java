package com.sofac.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.sofac.dao.MenuDao;
import com.sofac.model.Menu;
import com.sofac.model.Module;
import com.sofac.model.Profile;
import com.sofac.util.Tab;

public class MenuService {

	private MenuDao dao = new MenuDao();

	public boolean save(Menu menu) {
		return dao.save(menu);
	}

	public MenuModel loadMenu(Profile profile) {
		MenuModel ret = new DefaultMenuModel();
		if (profile.isExploitable()) {
			DefaultSubMenu subMenu;
			DefaultMenuItem menuItem;
			List<Menu> parents = dao.getProfileParents(profile);
			for (int i = 0; i < parents.size(); i++) {
				if (parents.get(i).isExploitable()) {
					if (parents.get(i).getModule().getContenu() == null) {
						subMenu = new DefaultSubMenu(parents.get(i).getModule().getNomMenu());
						subMenu.setStyle("font-size: 15px");
						List<Menu> modules = dao.getByProfileByParent(profile, parents.get(i).getModule());
						for (int j = 0; j < modules.size(); j++) {
							if (modules.get(j).isExploitable()) {
								menuItem = new DefaultMenuItem(modules.get(j).getModule().getNomMenu());
								menuItem.setCommand(
										"#{homeView.addTab('" + modules.get(j).getModule().getNomTab() + "')}");
								menuItem.setUpdate("tabss");
								menuItem.setStyle("font-size: 15px");
								subMenu.addElement(menuItem);
							}
						}
						ret.addElement(subMenu);
					} else {
						menuItem = new DefaultMenuItem(parents.get(i).getModule().getNomMenu());
						menuItem.setCommand("#{homeView.addTab('" + parents.get(i).getModule().getNomTab() + "'");
						menuItem.setUpdate("tabss");
						menuItem.setStyle("font-size: 15px");
						ret.addElement(menuItem);
					}
				}
			}
		}
		return ret;
	}

	public MenuModel test() {
		MenuModel ret = new DefaultMenuModel();
		DefaultMenuItem menuItem = new DefaultMenuItem("Chi 7aja");
		menuItem.setCommand("#{homeView.save()}");
		DefaultSubMenu subMenu = new DefaultSubMenu();
		subMenu.addElement(menuItem);
		ret.addElement(subMenu);
		return ret;
	}

	public List<Tab> loadTabs(Profile profile) {
		List<Tab> ret = new ArrayList<Tab>();
		if (profile.isExploitable()) {
			List<Menu> parents = dao.getByProfile(profile);
			for (int i = 0; i < parents.size(); i++) {
				if (parents.get(i).isExploitable()) {
					if (parents.get(i).getModule().getContenu() != null && parents.get(i).getModule().isExploitable()) {
						String controller = Character.toLowerCase(parents.get(i).getModule().getContenu().charAt(0))
								+ parents.get(i).getModule().getContenu().substring(1);
						Tab t = new Tab(parents.get(i).getModule().getNomTab(),
								"/WEB-INF/secure/" + parents.get(i).getModule().getContenu() + ".xhtml",
								controller + "View");
						t.setOpen(false);
						ret.add(t);
					}
				}
			}
		}
		return ret;
	}

	public List<Menu> getByProfile(Profile profile) {
		return dao.getByProfile(profile);
	}

	public void save(List<Menu> menus, Profile profile, List<Module> parents) {
		String titre = "";
		String message = "";
		FacesMessage.Severity severity = null;
		if (menus.isEmpty()) {
			titre = "Erreur !";
			message = "Veuiller ajouter un menu";
			severity = FacesMessage.SEVERITY_ERROR;
		} else {
			for (int i = 0; i < menus.size(); i++) {
				message = message + isParent(menus.get(i), parents);
			}
			if (message.equals("")) {
				message = check(menus);
				if (message.equals("")) {
					for (int i = 0; i < menus.size(); i++) {
						menus.get(i).setProfile(profile);
						if (update(menus.get(i))) {
							titre = "Succès !";
							message = "Menus mis à jour avec succès";
							severity = FacesMessage.SEVERITY_INFO;
						} else {
							titre = "Erreur !";
							message = "Une erreur s'est produite lors de la mis à jour";
							severity = FacesMessage.SEVERITY_ERROR;
							break;
						}
					}
				}else{
					titre = "Erreur !";
					severity = FacesMessage.SEVERITY_ERROR;
				}
			} else {
				titre = "Erreur !";
				severity = FacesMessage.SEVERITY_ERROR;
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, titre, message));
	}

	private String check(List<Menu> menus) {
		boolean test = false;
		String ret = "";
		for (int i = 0; i < menus.size() - 1; i++) {
			for (int j = i + 1; j < menus.size(); j++) {
				if ((menus.get(i).getModule().getContenu() == null && menus.get(j).getModule().getContenu() == null)
						&& (menus.get(i).getModule().equals(menus.get(j).getModule()))) {
					test = true;
				}
			}
		}
		if (test) {
			ret = "Enlever les sous-Menus doubles";
		}
		return ret;
	}

	private String isParent(Menu menu, List<Module> parents) {
		boolean test = true;
		for (int i = 0; i < parents.size(); i++) {
			if (menu.getModule().equals(parents.get(i)) || menu.getParent() != null) {
				test = false;
			}
		}
		if (test) {
			return "Le menu '" + menu.getModule().getNomMenu() + "' n'est pas un sous-Menu ---";
		} else {
			return "";
		}
	}

	private boolean update(Menu menu) {
		return dao.update(menu);
	}

}
