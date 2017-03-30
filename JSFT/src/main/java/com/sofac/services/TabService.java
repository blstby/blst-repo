package com.sofac.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sofac.util.Tab;

public class TabService {

	public List<Tab> initializeTabs(int size) {
		List<Tab> ret = new ArrayList<Tab>();
		for (int i = 0; i < size; i++) {
			ret.add(new Tab(i, false));
		}
		return ret;
	}

	public List<Tab> createDummyTabs() {
		List<Tab> ret = new ArrayList<Tab>();
		ret.add(new Tab("Title 1", "/secure/include1.xhtml"));
		ret.add(new Tab("Title 2", "/secure/include2.xhtml"));
		ret.add(new Tab("Title 3", "/secure/include3.xhtml"));
		return ret;
	}

	public List<Tab> addTab(List<Tab> from, List<Tab> to, String title) {
		for (int i = 0; i < to.size(); i++) {
			if (!to.get(i).isOpen()) {
				for (int j = 0; j < from.size(); j++) {
					if (from.get(j).getTitle().equals(title)) {
						to.get(i).setTitle(from.get(j).getTitle());
						to.get(i).setContent(from.get(j).getContent());
						to.get(i).setOpen(true);
						return to;
					}
				}
			}
		}
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Open Tabs capcity exceeded",
				"Close a tab before opening a new one");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return to;
	}

	public boolean check(List<Tab> list, String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				return false;
			}
		}
		return true;
	}

	public int getIndex(List<Tab> list, String title) {
		int ret = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				ret = i;
			}
		}
		return ret;
	}

	public List<Tab> closeTab(List<Tab> list, String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				list.get(i).setContent("");
				list.get(i).setTitle("");
				list.get(i).setOpen(false);
			}
		}
		return list;
	}
}