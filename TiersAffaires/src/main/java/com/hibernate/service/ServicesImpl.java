package com.hibernate.service;

import java.util.List;

import javax.jws.WebService;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.conf.HibernateUtil;
import com.hibernate.model.Affaire;
import com.hibernate.model.ResultMsg;
import com.hibernate.model.Tiers;

@WebService(endpointInterface = "com.hibernate.service.Services")
public class ServicesImpl implements Services {

	public ResultMsg createTiers(Tiers tier) throws HibernateException {
		ResultMsg ret = new ResultMsg();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(tier);
			session.getTransaction().commit();
			session.close();
			ret.setId(tier.getId());
			ret.setResult("Tier insere avec succes");
			ret.setMessage("Description goes here !");
		} catch (HibernateException e) {
			e.printStackTrace();
			ret.setResult("Tier non insere");
			ret.setMessage(e.getStackTrace().toString());
			return ret;
		}
		return ret;
	}

	public ResultMsg createAffaire(Affaire affaire) throws HibernateException {
		ResultMsg ret = new ResultMsg();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(affaire);
			session.getTransaction().commit();
			session.close();
			ret.setId(affaire.getId());
			ret.setResult("Affaire inseree avec succes");
			ret.setMessage("Description goes here !");
		} catch (HibernateException e) {
			e.printStackTrace();
			ret.setResult("Erreur !! Affaire non inseree");
			ret.setMessage(e.getStackTrace().toString());
			return ret;
		}
		return ret;
	}

	
	@SuppressWarnings("unchecked")
	public List<Affaire> findByTiers(Tiers tier) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Affaire where tier.id =" + tier.getId());
			List<Affaire> res = (List<Affaire>) query.list();
			return res;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Affaire> findAllAffaire() throws HibernateException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Affaire> res = session.createQuery("from Affaire").list();
			session.close();
			return res;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Tiers> findAllTiers() throws HibernateException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();		
			List<Tiers> res = session.createQuery("from Tiers").list();
			session.close();
			return res;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
}
