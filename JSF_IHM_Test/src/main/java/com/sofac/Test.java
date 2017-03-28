package com.sofac;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

@ManagedBean
@ViewScoped
public class Test {

	private List<Tab> tabs;
	private List<Tab> openTabs;
	private int activeIndex;
	private TabView TabWindow = new TabView();
	private String t = null;
	private String t2 = null;
	private String text;
	private TabService tabService = new TabService();

	 @PostConstruct
	 public void init(){
		 tabs = new ArrayList<Tab>();
		 openTabs = new ArrayList<Tab>();
		 tabs.add(new Tab(0,"Title 1","/include1.xhtml"));
		 tabs.add(new Tab(1,"Title 2","/include2.xhtml"));
	 }

	public void a(String a) {
		setText(a);
	}

	public void logout() {
		addMessage("Bye !", "Logged out");
	}

	public void addTab(int i) {
		if(!tabService.getByIndex(i, tabs).isOpen()){
			tabs.get(i).setOpen(true);
			openTabs.add(new Tab(i,"Title "+(i+1),"/include"+(i+1)+".xhtml"));
		}
		TabWindow.setActiveIndex(tabService.returnIndex(i,openTabs)); 
	}

	public void test() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary", "Message");
		FacesContext.getCurrentInstance().addMessage(null, message);
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
		int i = Integer.parseInt(event.getTab().getTitle().substring(event.getTab().getTitle().length() - 1));
		tabs.get(i-1).setOpen(false);
		openTabs.remove(i-1);
	}

	public void onTabChange(TabChangeEvent event) {
		TabView tabView = (TabView) event.getComponent();
		setActiveIndex(tabView.getChildren().indexOf(event.getTab()));
	}
	
	public Tab getByIndex(int i){
		return tabService.getByIndex(i, tabs);
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public int getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
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

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public List<Tab> getTabs() {
		return tabs;
	}

	public void setTabs(List<Tab> tabs) {
		this.tabs = tabs;
	}
}
