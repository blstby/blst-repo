package com.sofac.services;

import java.util.ArrayList;

import com.sofac.dao.AffaireDao;
import com.sofac.model.AffaireInfo;
import com.sofac.models.Affaire;

public class AffaireService {

	AffaireDao dao = new AffaireDao();
	
	public ArrayList<AffaireInfo> getByTiers(String tiers){
		ArrayList<Affaire> lst = dao.getByTiers(tiers);
		ArrayList<AffaireInfo> ret = new ArrayList<>();
		for(int i = 0; i < lst.size(); i++){
			long id = lst.get(i).getIdAffaire();
			ret.add(new AffaireInfo(lst.get(i), dao.dureeAff(id), dao.montantEch(id), dao.crRealise(id), dao.datePremEch(id),
					dao.dateDernEch(id)));
		}
		return ret;
	}
	
	public Long nbAffaire(String tiers){
		return dao.nbAffaire(tiers);
	}
	
	public ArrayList<String> getTypeTiers(String tiers, Long idAff){
		return dao.getTypeTiers(tiers, idAff);
	}
	
	public String[] situationTier(String tier){
		return dao.situationTier(tier);
	}
	
	public Double encoursAff(long id){
		return dao.encoursAff(id);
	}
	
	public Double soldeAffTiers(long id, String tier){
		return dao.soldeAffTiers(id, tier);
	}
}
