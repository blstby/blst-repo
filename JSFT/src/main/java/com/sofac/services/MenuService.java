package com.sofac.services;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

public class MenuService {

	public MenuModel createDummyMenu(){
		MenuModel ret = new DefaultMenuModel();
		DefaultSubMenu subMenu = new DefaultSubMenu("Ajax Menu-Items");
		 DefaultMenuItem menuItem = new DefaultMenuItem("Save");
		 menuItem.setCommand("#{homeView.save()}");
		 subMenu.addElement(menuItem);
		 menuItem = new DefaultMenuItem("Update");
		 menuItem.setCommand("#{homeView.update()}");
		 subMenu.addElement(menuItem);
		 ret.addElement(subMenu);
		 subMenu = new DefaultSubMenu("Non-Ajax Menu-Items");
		 menuItem = new DefaultMenuItem("Delete");
		 menuItem.setCommand("#{homeView.delete()}");
		 subMenu.addElement(menuItem);
		 ret.addElement(subMenu);
		 subMenu = new DefaultSubMenu("Tabs");
		 menuItem = new DefaultMenuItem("Tab 1");
		 menuItem.setCommand("#{homeView.addTab('Title 1')}");
		 menuItem.setUpdate("tabss");
		 subMenu.addElement(menuItem);
		 menuItem = new DefaultMenuItem("Tab 2");
		 menuItem.setCommand("#{homeView.addTab('Title 2')}");
		 menuItem.setUpdate("tabss");
		 subMenu.addElement(menuItem);
		 menuItem = new DefaultMenuItem("Tab 3");
		 menuItem.setCommand("#{homeView.addTab('Title 3')}");
		 menuItem.setUpdate("tabss");
		 subMenu.addElement(menuItem);
		 ret.addElement(subMenu);
		 return ret;
	}
	
}
