package com.sofac.controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sofac.model.Affaire;

@ManagedBean
@ViewScoped 
public class AffaireView {

	private ArrayList<Affaire> affaires;
	
	@PostConstruct
	public void init(){
		System.out.println("---------- Instantiating AffaireController --------");
		affaires = new ArrayList<Affaire>();
	}

	public ArrayList<Affaire> getAffaires() {
		return affaires;
	}

	public void setAffaires(ArrayList<Affaire> affaires) {
		this.affaires = affaires;
	}
}
