package com.sofac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sofac.model.Module;

public class ModuleDao {

	public boolean save(Module module) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			session.save(module);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean update(Module module) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(module);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Module> getAll() throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			List<Module> ret = (List<Module>) session.createQuery("from Module").list();
			session.close();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Module> getParentExploitable() throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			List<Module> ret = (List<Module>) session.createQuery("from Module where contenu is null").list();
			session.close();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}
}
