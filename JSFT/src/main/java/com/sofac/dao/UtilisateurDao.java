package com.sofac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sofac.dao.HibernateUtil;
import com.sofac.model.Utilisateur;

public class UtilisateurDao {

	// public boolean connect(Utilisateur utilisateur) throws HibernateException
	// {
	// try {
	// Session session = HibernateUtil.getSessionFactory().openSession();
	// session.beginTransaction();
	// Query query = session.createQuery("select count(*) from Utilisateur where
	// login ='" + utilisateur.getLogin()
	// + "' and mdp = '" + utilisateur.getMdp() + "'");
	// if (((Long) query.uniqueResult()).intValue() == 1) {
	// session.close();
	// return true;
	// } else {
	// return false;
	// }
	// } catch (HibernateException e) {
	// return false;
	// }
	// }

	public Utilisateur find(Utilisateur utilisateur) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			Utilisateur ret = (Utilisateur) session
					.createQuery("from Utilisateur where login ='" + utilisateur.getLogin() + "'").uniqueResult();
			if (ret != null) {
				if (ret.getType().equals("Spec")) {
					if (!ret.getMdp().equals(utilisateur.getMdp())) {
						ret.setLogin("");
						ret.setMdp("");
					}
				} else {
					if(!connect(utilisateur)){
						ret.setLogin("");
						ret.setMdp("");
					}
				}
			}else{
				ret = new Utilisateur();
				ret.setLogin("");
				ret.setMdp("");
			}
			session.close();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}

	public boolean connect(Utilisateur utilisateur) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery("select count(*) from utilex where login ='" + utilisateur.getLogin()
					+ "' and mdp = '" + utilisateur.getMdp() + "'");
			if (query.uniqueResult().toString().equals("1")) {
				session.close();
				return true;
			}else{
				session.close();
				return false;
			}
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean update(Utilisateur utilisateur) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(utilisateur);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAll() throws HibernateException {
		try { 
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			List<Utilisateur> ret = (List<Utilisateur>) session.createQuery("from Utilisateur").list();
			session.close();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}
}
