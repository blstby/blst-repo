package com.sofac.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;
import org.primefaces.model.menu.MenuModel;

import com.sofac.util.Tab;
import com.sofac.services.MenuService;
import com.sofac.services.TabService;

@ManagedBean
@ViewScoped
public class HomeView {

	private List<Tab> tabs;
	private List<Tab> openTabs;
	private int index;
	private TabService tabService;
	private MenuService menuService;
	private MenuModel menu;
	@ManagedProperty("#{loginView}")
	private LoginView loginView;
	private String t = "ma3";

	@PostConstruct
	public void init() {
		tabService = new TabService();
		menuService = new MenuService();
		tabs = menuService.loadTabs(loginView.getUtilisateur().getProfile());
		openTabs = new ArrayList<Tab>();
		menu = menuService.loadMenu(loginView.getUtilisateur().getProfile());
	}

	public void addTab(String title) {
		if (tabService.check(openTabs, title)) {
			openTabs = tabService.addTab(tabs, openTabs, title);
		}
		if (tabService.getIndex(openTabs, tabService.trim(title)) != -1) {
			index = tabService.getIndex(openTabs, tabService.trim(title));
		}
	}

	public void showMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hello", "include " + (FacesContext.getCurrentInstance().getViewRoot().getViewMap().containsKey("includeView")));
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public void save() {
		addMessage("Success", "Data saved");
	}

	public void update() {
		addMessage("Success", "Data updated");
	}

	public void delete() {
		addMessage("Success", "Data deleted");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onTabClose(TabCloseEvent event) {
		String title = event.getTab().getTitle();
		String ti = openTabs.get(index).getTitle();
		openTabs = tabService.closeTab(openTabs, title);
		if (trim(ti).equals(title)) {
			index = tabService.setIndex(index);
		} else {
			index = tabService.setIndex(openTabs, ti);
		}
	}

	public void onTabChange(TabChangeEvent event) {
		index = tabService.getIndex(openTabs, event.getTab().getTitle());
	}
	
	public String trim(String str){
		return tabService.trim(str);
	}

	public List<Tab> getTabs() {
		return tabs;
	}

	public void setTabs(List<Tab> tabs) {
		this.tabs = tabs;
	}

	public MenuModel getMenu() {
		return menu;
	}

	public void setMenu(MenuModel menu) {
		this.menu = menu;
	}

	public List<Tab> getOpenTabs() {
		return openTabs;
	}

	public void setOpenTabs(List<Tab> openTabs) {
		this.openTabs = openTabs;
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}
}
