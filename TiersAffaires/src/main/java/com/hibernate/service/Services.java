package com.hibernate.service;

import java.util.List;

import javax.jws.WebService;

import com.hibernate.model.Affaire;
import com.hibernate.model.ResultMsg;
import com.hibernate.model.Tiers;

@WebService(name= "Affaires")
public interface Services {

	ResultMsg createTiers(Tiers tier) throws Exception;
	
	ResultMsg createAffaire(Affaire affaire) throws Exception;
	
	List<Affaire> findByTiers(Tiers tier) throws Exception;
	
	List<Affaire> findAllAffaire() throws Exception;
	
	List<Tiers> findAllTiers() throws Exception;
}
