package com.sofac.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sofac.services.LoginService;

@ManagedBean
@SessionScoped
public class LoginView {

	private String text;
	private String login = new String();
	private String pwd = new String();
	private LoginService loginService = new LoginService();

	public String connect() {
		String ret = loginService.connect(login, pwd);
		if (ret == null) {
			login = "";
			pwd = "";
		}
		return ret;
	}

	public String logOut() {
		return loginService.logOut();
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
