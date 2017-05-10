package com.sofac.services;

import java.util.ArrayList;

import com.sofac.dao.AffaireDao;
import com.sofac.models.Affaire;

public class AffaireService {

	AffaireDao dao = new AffaireDao();
	
	public ArrayList<Affaire> getByTiers(String tiers){
		return dao.getByTiers(tiers);
	}
	
	public Long nbAffaire(String tiers){
		return dao.nbAffaire(tiers);
	}
	
	public ArrayList<String> getTypeTiers(String tiers, Long idAff){
		return dao.getTypeTiers(tiers, idAff);
	}
	
	public String[] SituationTier(String tier){
		return dao.SituationTier(tier);
	}
}
