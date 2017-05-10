package com.sofac.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.hibernate.transform.Transformers;

import com.sofac.model.TiersInfo;
import com.sofac.models.Empltiers;
import com.sofac.models.Refcomm;
import com.sofac.models.Tieiden;
import com.sofac.models.Tiers;
import com.sofac.util.Codiff;

import oracle.jdbc.internal.OracleTypes;

public class TiersDao {

	private String str;

	@SuppressWarnings("unchecked")
	public List<TiersInfo> recherche(String code, String cin, String rc, String nom) throws HibernateException {
		try {
			List<TiersInfo> ret = new ArrayList<>();
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			String query = "select t from Tiers t where 1=1";
			if (cin != null) {
				query = " select distinct t from Tiers t, Tieiden i where i.codePieceIden = 'BI' and i.noPieceIden = '"
						+ cin + "'";
			}
			if (code != null) {
				query += " and t.tiers = '" + code + "'";
			}
			if (rc != null) {
				query += " and t.no_rc = '" + rc + "'";
			}
			if (nom != null) {
				query += " and concat(t.nom, t.prenom) like '%" + nom + "%'";
			}
			List<Tiers> tiers = new ArrayList<>();
			tiers = (List<Tiers>) session.createQuery(query).list();
			if (tiers.size() < 100) {
				for (int i = 0; i < tiers.size(); i++) {
					List<Tieiden> tieidens = (List<Tieiden>) session
							.createQuery("from Tieiden where tiers = '" + tiers.get(i).getTiers() + "'").list();
					String adresse = executeFunction("OPS$EKIPMA.DB_EKC_ADRESSE_TIERS_0FIN(?,?)",
							tiers.get(i).getTiers());
					ret.add(new TiersInfo(tiers.get(i), tieidens, adresse));
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						"Le résultat de la recherche est supérieur à 100, veuillez donnner plus de détails"));
				return null;
			}
			session.close();
			return ret;

		} catch (HibernateException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public TiersInfo explorer(TiersInfo tiersInfo) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			tiersInfo.setRib(executeFunction("OPS$EKIPMA.DB_EKC_RIB_TIERS_0FIN(?)", tiersInfo.getTiers().getTiers()));
			tiersInfo.setEmpltiers((Empltiers) session
					.createQuery("from Empltiers where tiers = '" + tiersInfo.getTiers().getTiers() + "'")
					.uniqueResult());
			tiersInfo.setRefcomms((List<Refcomm>) session
					.createQuery("from Refcomm where tiers = '" + tiersInfo.getTiers().getTiers() + "'").list());
			session.close();
			return tiersInfo;
		} catch (HibernateException e) {
			return null;
		}
	}

	private String executeFunction(String fun, String arg) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			session.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection.prepareCall("{ ? = call " + fun + " }");
					call.registerOutParameter(1, OracleTypes.VARCHAR);
					call.setNString(2, arg);
					if (fun.equals("OPS$EKIPMA.DB_EKC_ADRESSE_TIERS_0FIN(?,?)")) {
						call.setNString(3, "LIGNE");
					}
					call.execute();
					str = call.getString(1);
				}
			});
			session.close();
			return str;
		} catch (HibernateException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Codiff> getCodiff(String type) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("select code, texte_aide as libelle, typ_code as type from LIB_ACODIFS la where la.typ_code = '"
							+ type + "' and la.code_langue = '1' and la.code_statut = '2'");
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
