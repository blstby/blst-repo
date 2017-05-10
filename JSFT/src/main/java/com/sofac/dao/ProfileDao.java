package com.sofac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sofac.model.Profile;

public class ProfileDao {

	public boolean save(Profile profile) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			session.save(profile);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean update(Profile profile) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(profile);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Profile> getAll() throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			List<Profile> ret = (List<Profile>) session.createQuery("from Profile").list();
			session.close();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}
}
