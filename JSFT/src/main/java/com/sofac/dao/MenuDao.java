package com.sofac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sofac.model.Menu;
import com.sofac.model.Module;
import com.sofac.model.Profile;

public class MenuDao {

	public boolean save(Menu menu) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			session.save(menu);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

//	@SuppressWarnings("unchecked")
//	public List<Menu> getByModule(Module module) throws HibernateException {
//		try {
//			Session session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
//			Query query = session
//					.createQuery("from Menu where parent.id = " + module.getId() + "or module.id = " + module.getId());
//			List<Menu> ret = (List<Menu>) query.list();
//			session.close();
//			return ret;
//		} catch (HibernateException e) {
//			return null;
//		}
//	}

	@SuppressWarnings("unchecked")
	public List<Menu> getProfileParents(Profile profile) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery(
					"from Menu where profile.id = " + profile.getId() + " and parent is null order by nOrdre");
			List<Menu> ret = (List<Menu>) query.list();
			session.close();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Menu> getByProfileByParent(Profile profile, Module module) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("from Menu where profile.id = " + profile.getId() + " and parent.id = "
					+ module.getId() + " order by nOrdre");
			List<Menu> ret = (List<Menu>) query.list();
			session.close();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Menu> getByProfile(Profile profile) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			List<Menu> ret = (List<Menu>) session.createQuery("from Menu where profile.id =" + profile.getId() + " order by nOrdre").list();
			session.close();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}

	public boolean update(Menu menu) throws HibernateException {
		try {
			Session session = HibernateUtil.getMySQLSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(menu);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
}
