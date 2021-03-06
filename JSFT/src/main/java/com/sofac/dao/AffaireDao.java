package com.sofac.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.sofac.models.Affaire;

import oracle.jdbc.internal.OracleTypes;

public class AffaireDao {

	private String str;
	private double dbl;

	@SuppressWarnings("unchecked")
	public ArrayList<Affaire> getByTiers(String tiers) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			ArrayList<Affaire> ret = new ArrayList<>();
			Query query = session.createQuery("select distinct a from Afftiers af, Affaire a where af.id.tiers1 = '"
					+ tiers + "' and af.id.idAffaire = a.idAffaire and af.id.codeNatTiers in ('PCLI', 'CLIE')");
			// List<Object[]> results = (List<Object[]>) query.list();
			// for (Object[] result : results) {
			// ret.add(new AffaireInfo((Affaire) result[1], (Afftiers)
			// result[0]));
			// }
			ret = (ArrayList<Affaire>) query.list();
			session.close();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}

	public Long nbAffaire(String tiers) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			Query query = session
					.createQuery("select count(distinct af.id.idAffaire) from Afftiers af where af.id.tiers1 = '"
							+ tiers + "' and af.id.codeNatTiers in ('PCLI', 'CLIE')");
			Long ret = (Long) query.uniqueResult();
			session.close();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> getTypeTiers(String tiers, Long idAff) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			ArrayList<String> ret = (ArrayList<String>) session
					.createQuery("select a.id.codeNatTiers from Afftiers a where a.id.tiers1 = '" + tiers + "' and "
							+ "a.id.codeNatTiers in ('PCLI', 'CLIE') and a.id.idAffaire = " + idAff)
					.list();
			return ret;
		} catch (HibernateException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public String[] situationTier(String tier) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			double enC = 0;
			double solde = 0;
			int cEnC = 0;
			int cEch = 0;
			ArrayList<Long> lstT = (ArrayList<Long>) session
					.createQuery("select a.idAffaire from Affaire a where a.tiersClient = '" + tier + "'").list();
			for (int i = 0; i < lstT.size(); i++) {
				double temp = encoursAff(lstT.get(i));
				if (temp > 0) {
					cEnC++;
					enC += temp;
				} else {
					cEch++;
				}
				temp = soldeAffTiers(lstT.get(i), tier);
				solde += temp;
			}
			return new String[] { Double.toString(enC), Integer.toString(cEnC), Double.toString(solde),
					Integer.toString(cEch) };
		} catch (HibernateException e) {
			return null;
		}
	}

	public Double encoursAff(long id) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			session.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ ? = call ops$ingenetudes.db_cal_crd_affaire_arrete(?,?) }");
					call.registerOutParameter(1, OracleTypes.VARCHAR);
					call.setNString(2, id + "");
					call.setNString(3, new SimpleDateFormat("Myydd").format(new Date()));
					call.execute();
					str = call.getString(1);
				}
			});
			session.close();
			return Double.parseDouble(str.replace(",", "."));
		} catch (HibernateException e) {
			return null;
		}
	}

	public Double soldeAffTiers(long id, String tier) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			session.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ ? = call ops$ingenetudes.db_cal_solde_affaire(?,?,?) }");
					call.registerOutParameter(1, OracleTypes.VARCHAR);
					call.setNString(2, id + "");
					call.setNString(3, tier);
					call.setNString(4, new SimpleDateFormat("Myydd").format(new Date()));
					call.execute();
					str = call.getString(1);
				}
			});
			session.close();
			return Double.parseDouble(str.replace(",", "."));
		} catch (HibernateException e) {
			return null;
		}
	}

	public String dureeAff(long id) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			session.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection.prepareCall("{ ? = call DB_EKC_DUREE_AFF_0FIN (?) }");
					call.registerOutParameter(1, OracleTypes.NUMBER);
					call.setNString(2, "" + id);
					call.execute();
					str = call.getInt(1) + "";
				}
			});
			session.close();
			return str;
		} catch (HibernateException e) {
			return null;
		}
	}

	public double montantEch(long id) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			session.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ ? = call PKG_UTIL_MONT_1SFC.CALC_MNT_ECHEANCE_AFF  (?) }");
					call.registerOutParameter(1, OracleTypes.NUMBER);
					call.setNString(2, "" + id);
					call.execute();
					dbl = call.getDouble(1);
				}
			});
			session.close();
			return dbl;
		} catch (HibernateException e) {
			return -9001;
		}
	}

	public String datePremEch(long id) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			session.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection.prepareCall("{ ? = call DB_EKC_DATE_DEB_AFF_0FIN (?) }");
					call.registerOutParameter(1, OracleTypes.DATE);
					call.setNString(2, "" + id);
					call.execute();
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date d = call.getDate(1);
					if (d != null)
						str = format.format(d);
					else
						str = "N/A";
				}
			});
			session.close();
			return str;
		} catch (HibernateException e) {
			return null;
		}
	}

	public String dateDernEch(long id) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			session.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection.prepareCall("{ ? = call DB_EKC_DATE_FIN_AFF_0FIN (?) }");
					call.registerOutParameter(1, OracleTypes.DATE);
					call.setNString(2, "" + id);
					call.execute();
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date d = call.getDate(1);
					if (d != null)
						str = format.format(d);
					else
						str = "N/A";
				}
			});
			session.close();
			return str;
		} catch (HibernateException e) {
			return null;
		}
	}
	
	public double crRealise(long id) throws HibernateException {
		try {
			Session session = HibernateUtil.getOracleSessionFactory().openSession();
			session.beginTransaction();
			session.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ ? = call PKG_UTIL_MONT_1SFC.CALC_MNT_PRET_AFF (?) }");
					call.registerOutParameter(1, OracleTypes.NUMBER);
					call.setNString(2, "" + id);
					call.execute();
					dbl = call.getDouble(1);
				}
			});
			session.close();
			return dbl;
		} catch (HibernateException e) {
			return -9001;
		}
	}
}
