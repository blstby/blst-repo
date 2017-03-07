package com.hibernatews.service;

import java.util.List;

import com.hibernatews.dao.AffaireDao;

public class AffaireService {

	AffaireDao dao = new AffaireDao();
	ServicesImplService service = new ServicesImplService();
	Affaires stub = service.getServicesImplPort();

	public boolean saveAffaire(int id) throws Exception_Exception {
		List<Affaire> affaires = stub.allAffaire();
		for (Affaire affaire : affaires) {
			if (affaire.getId() == id) {
				return dao.saveAffaire(affaire);
			}
		}
		return false;
	}
}
