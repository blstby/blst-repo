package aaa.views;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class loginView {

	private String text;
	private String login = new String();
	private String pwd = new String();

	public String check() {
		System.out.println("+++" + login);
		if (login.equals("admin")) {
			return null;
		} else {
			return "/login";
		}
	}

	public String connect() {
		FacesContext context = FacesContext.getCurrentInstance();
		if ((this.login.equals("admin") && this.pwd.equals("admin"))
				|| (this.login.equals("Reda") && this.pwd.equals("mdp"))) {
			context.getExternalContext().getSessionMap().put("user", login);
			return "/home/NewFile?faces-redirect=true";
		} else {
			context.addMessage(null, new FacesMessage("Unknown login, try again"));
			login = "";
			pwd = "";
			return null;
		}
	}

	public String logOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
