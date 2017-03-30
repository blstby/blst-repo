package com.sofac.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
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
	private TabView TabWindow;
	private String text;
	private TabService tabService;
	private MenuService menuService;
	private MenuModel menu;

	@PostConstruct
	public void init() {
		TabWindow = new TabView();
		tabService = new TabService();
		menuService = new MenuService();
		tabs = tabService.createDummyTabs();
		openTabs = tabService.initializeTabs(2);
		menu = menuService.createDummyMenu();
	}

	public void a(String a) {
		setText(a);
	}

	public void addTab(String title) {
		if (tabService.check(openTabs, title)) {
			openTabs = tabService.addTab(tabs, openTabs, title);
		}
		if (tabService.getIndex(openTabs, title) > -1) {
			TabWindow.setActiveIndex(tabService.getIndex(openTabs, title));
		}
	}

	public void showMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hello",
				"I am a message in a dialog");
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
		openTabs = tabService.closeTab(openTabs, event.getTab().getTitle());
	}

	public TabView getTabWindow() {
		return TabWindow;
	}

	public void setTabWindow(TabView tabWindow) {
		TabWindow = tabWindow;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
}
