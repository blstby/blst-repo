package com.sofac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.sofac.util.Codiff;

public class TieidenDao {

	@SuppressWarnings("unchecked")
	public List<Codiff> getPiece() throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select code, libelle, typ_code as type from LIB_ACODIFS la where la.typ_code = 'PIDN' and la.code_langue = '1' and la.code_statut = '2'");
			query.addScalar("code");
			query.addScalar("libelle");
			query.addScalar("type");
			query.setResultTransformer(Transformers.aliasToBean(Codiff.class));
			List<Codiff> ret = (List<Codiff>) query.list();
			session.close();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}
}
