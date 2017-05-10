package com.sofac.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.sofac.model.Tiers;

@ManagedBean
@ViewScoped
public class IncludeView {
	
	private List<Tiers> openedTiers;
	
	@PostConstruct
	public void init(){
		System.out.println("---------- Instantiating controller --------");
		openedTiers = new ArrayList<Tiers>();
	}
	
	public void initialize(){
//		AntecedentView antecedentView = (AntecedentView) FacesContext.getCurrentInstance().getViewRoot().getViewMap().get("antecedentView");
//		text = antecedentView.getSelectedTiers().getNom();
	}
	
	public void test() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Titre du message", "Contenu du message"));
	}
	
	private String text;
	private String t;
	private int cmp = 0;

	public void write(){
		cmp++;
		text = ""+ cmp;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}

	public List<Tiers> getOpenedTiers() {
		return openedTiers;
	}

	public void setOpenedTiers(List<Tiers> openedTiers) {
		this.openedTiers = openedTiers;
	}
}
