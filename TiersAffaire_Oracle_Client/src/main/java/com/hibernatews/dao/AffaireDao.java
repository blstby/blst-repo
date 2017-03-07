package com.hibernatews.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernatews.model.Tiers;

public class AffaireDao {
	
	public boolean saveAffaire(com.hibernatews.service.Affaire affaire) throws HibernateException{
		com.hibernatews.model.Affaire a = new com.hibernatews.model.Affaire();
		a.setId(affaire.getId());
		a.setCode_produit(affaire.getCodeProduit());
		a.setMontant_fin(affaire.getMontantFin());
		Tiers tier = new Tiers();
		tier.setId(affaire.getIdTier());
		a.setTier(tier);
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(a);
			session.getTransaction().commit();
			session.close();
			return true;
			} catch (HibernateException e) {
				return false;
			}
	}
}
