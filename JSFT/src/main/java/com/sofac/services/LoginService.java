package com.sofac.services;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class LoginService {

	public String connect(String login, String pwd) {
		FacesContext context = FacesContext.getCurrentInstance();
		if ((login.equals("admin") && pwd.equals("admin"))
				|| (login.equals("sofac") && pwd.equals("sofac"))) {
			context.getExternalContext().getSessionMap().put("user", login);
			return "/secure/home?faces-redirect=true";
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Unknown login", "try again"));
			return null;
		}
	}
	
	public String logOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

}
