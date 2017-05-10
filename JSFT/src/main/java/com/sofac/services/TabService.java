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

	public List<Tab> addTab(List<Tab> from, List<Tab> to, String title) {
		boolean test = false;
		for (int i = 0; i < from.size(); i++) {
			if (from.get(i).getTitle().equals(title)) {
				Tab t = new Tab(from.get(i).getTitle(), from.get(i).getContent(), from.get(i).getController(),
						from.get(i).getParam());
				t.setOpen(true);
				to.add(t);
				return to;
			}
		}
		test = true;
		if (test) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention !",
					"Ce n'est pas un module");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
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
			if (trim(list.get(i).getTitle()).equals(title)) {
				ret = i;
			}
		}
		return ret;
	}

	public List<Tab> closeTab(List<Tab> list, String title) {
		String cont = "";
		for (int i = 0; i < list.size(); i++) {
			if (trim(list.get(i).getTitle()).equals(title)) {
				cont = list.get(i).getController();
				list.remove(i);
			}
		}
		if (testTab(list, title, "Antécédents", "-")) {
			FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove("tierSynthView");
		}else if(testTab(list, title, "-", "+")){
			FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove("affSynthView");
		}else if(testTab(list, title, "+", "_")){
			FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove("affaireView");
		}
		FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(cont);
		return list;
	}

	private boolean testTab(List<Tab> list, String title, String aTester, String mark) {
		boolean test = true;
		boolean t = true;
		if (title.startsWith(mark)) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getTitle().startsWith(mark)) {
					test = false;
				}
				if (list.get(i).getTitle().startsWith(aTester)) {
					t = false;
				}
			}
			if (test && t) {
				return true;
			}
		}
		return false;
	}

	public Tab getTab(List<Tab> list, String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				return list.get(i);
			}
		}
		return null;
	}

	public int setIndex(int index) {
		if (index > 0) {
			int i = index - 1;
			return i;
		} else {
			return 0;
		}
	}

	public int setIndex(List<Tab> list, String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				return i;
			}
		}
		return -1;
	}

	public String trim(String str) {
		if (str.length() > 19) {
			str = str.substring(0, 16);
			str += "...";
		}
		return str;
	}
}