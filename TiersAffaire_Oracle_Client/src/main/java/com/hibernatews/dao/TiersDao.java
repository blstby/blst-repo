package com.hibernatews.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernatews.dao.HibernateUtil;

public class TiersDao {
	
	public boolean saveTier(com.hibernatews.service.Tiers tier) throws HibernateException {
		com.hibernatews.model.Tiers t = new com.hibernatews.model.Tiers();
		t.setId(tier.getId());
		t.setNom(tier.getNom());
		t.setTier(tier.getTier());
		try{
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("hoolaaaa");
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		return true;
		} catch (HibernateException e) {
			return false;
		}
	}

}
