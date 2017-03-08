package com.hibernate.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import com.hibernate.model.Affaire;
import com.hibernate.model.ResultMsg;
import com.hibernate.model.Tiers;

@WebService(name= "Affaires")
public interface Services {

	@WebResult(name = "Message")
	@WebMethod(operationName = "NewTiers")
	ResultMsg createTiers(@WebParam(name = "Tier") @XmlElement( required = true )String tier, 
			@WebParam(name = "Nom") @XmlElement( required = true )String nom) throws Exception;
	
	@WebResult(name = "Message")
	@WebMethod(operationName = "NewAffaire")
	ResultMsg createAffaire(@WebParam(name = "id_Tier")int idTier, 
			@WebParam(name = "codeProduit") @XmlElement( required = true )String codeProd, 
			@WebParam(name = "Montant") @XmlElement( required = true )float montant) throws Exception;
	
	@WebResult(name = "Affaire")
	@WebMethod(operationName = "AffaireByTiers")
	List<Affaire> findByTiers(@WebParam(name = "id_Tier") @XmlElement( required = true )int id) throws Exception;
	
	@WebResult(name = "Affaire")
	@WebMethod(operationName = "AllAffaire")
	List<Affaire> findAllAffaire() throws Exception;
	
	@WebResult(name = "Tier")
	@WebMethod(operationName = "AllTiers")
	List<Tiers> findAllTiers() throws Exception;
}
