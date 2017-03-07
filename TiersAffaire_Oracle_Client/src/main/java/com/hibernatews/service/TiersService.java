package com.hibernatews.service;

import java.util.List;

import com.hibernatews.dao.TiersDao;

public class TiersService {

	TiersDao dao = new TiersDao();
	ServicesImplService service = new ServicesImplService();
	Affaires stub = service.getServicesImplPort();

	public boolean saveTiers(int id) throws Exception_Exception {
		List<Tiers> tiers = stub.allTiers();
		for (Tiers tier : tiers) {
			if (tier.getId() == id) {
				return dao.saveTier(tier);
			}
		}
		return false;
	}

}
