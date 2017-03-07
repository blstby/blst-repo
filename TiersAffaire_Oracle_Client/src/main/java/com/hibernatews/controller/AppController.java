package com.hibernatews.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hibernatews.service.Affaire;
import com.hibernatews.service.AffaireService;
import com.hibernatews.service.Affaires;
import com.hibernatews.service.Exception_Exception;
import com.hibernatews.service.ResultMsg;
import com.hibernatews.service.ServicesImplService;
import com.hibernatews.service.Tiers;
import com.hibernatews.service.TiersService;

@Controller
@RequestMapping("/")
public class AppController {

	ServicesImplService service = new ServicesImplService();
	Affaires stub = service.getServicesImplPort();
	TiersService serviceTiers = new TiersService();
	AffaireService serviceAffaire = new AffaireService();

	@RequestMapping(value = { "/", "index" })
	public String index() {
		return "index";
	}

	@RequestMapping(value = { "/listT" })
	public String listTiers(ModelMap model) {
		List<Tiers> tiers = new ArrayList<Tiers>();
		try {
			tiers = stub.allTiers();
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tiers", tiers);
		return "listT";
	}

	@RequestMapping(value = {"/listA"}, method = RequestMethod.GET)
	public String listAffaire(ModelMap model){
		List<Affaire> affaires = new ArrayList<Affaire>();
		try {
			affaires = stub.allAffaire();
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("affaires", affaires);
		model.addAttribute("tier", new Tiers());
		return "listA";
	}
	
	@RequestMapping(value = {"/listA"}, method = RequestMethod.POST)
	public String affaireByTier(@ModelAttribute("tier") Tiers tier, ModelMap model){
		List<Affaire> affaires = new ArrayList<Affaire>();
		try {
			affaires = stub.affaireByTiers(tier.getId());
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("affaires", affaires);
		return "listA";
	}
	
	@RequestMapping(value = {"/newT"}, method = RequestMethod.GET)
	public String createTier(ModelMap model){
		model.addAttribute("tier", new Tiers());
		return "newT";
	}
	
	@RequestMapping(value = {"/newT"}, method = RequestMethod.POST)
	public String createTier(@ModelAttribute("tier") Tiers tier, ModelMap model){
		ResultMsg msg = new ResultMsg(); 
		try {
			msg = stub.newTiers(tier.getTier(), tier.getNom());
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("msg", msg);
		return "resultat";
	}
	
	@RequestMapping(value = {"/newA"}, method = RequestMethod.GET)
	public String createAffaire(ModelMap model){
		model.addAttribute("affaire", new Affaire());
		return "newA";
	}
	
	@RequestMapping(value = {"/newA"}, method = RequestMethod.POST)
	public String createAffaire(@ModelAttribute("affaire") Affaire affaire, ModelMap model){
		ResultMsg msg = new ResultMsg(); 
		try {
			msg = stub.newAffaire(affaire.getIdTier(), affaire.getCodeProduit(), affaire.getMontantFin());
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("msg", msg);
		return "resultat";
	}
	
	@RequestMapping(value = {"/save-{id}-tier"})
	public String saveTier(@PathVariable int id, ModelMap model){
		try {
			serviceTiers.saveTiers(id);
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping(value = {"/save-{id}-affaire"})
	public String saveAffaire(@PathVariable int id, ModelMap model){
		try {
			serviceAffaire.saveAffaire(id);
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
