package com.sofac.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.hibernate.transform.Transformers;

import com.sofac.dao.HibernateUtil;
import com.sofac.models.Affaire;
import com.sofac.models.Afftiers;
import com.sofac.models.Refcomm;
import com.sofac.models.Tiers;

import oracle.jdbc.internal.OracleTypes;

public class Test {

	private String libelle;
	private String code;
	private String type;


	public Test() {
		super();
	}

	public Test(String libelle, String code) {
		super();
		this.libelle = libelle;
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("*************start*************");
		Session session = HibernateUtil.getOracleSessionFactory().openSession();
		session.beginTransaction();
//		String sql = "select code, libelle, typ_code as type from LIB_ACODIFS la where la.typ_code = 'PAYS' and la.code_langue = '1' and la.code_statut = '2'";
//		SQLQuery query = session.createSQLQuery(sql);
//		query.addScalar("code");
//		query.addScalar("libelle");
//		query.addScalar("type");
//		query.setResultTransformer(Transformers.aliasToBean(Test.class));
//		List<Test> results = (List<Test>) query.list();
//		System.out.println(results.get(0).code + "  " + results.get(0).libelle + "  " + results.get(0).type);
//		Query query =  session.createQuery("select a.idAffaire from Affaire a where a.tiersClient = 'CL00138727'");
//		List<Long> lst = (List<Long>) query.list();
//		System.out.println(lst.get(0) + " " + lst.get(9));
//		List<Tiers> lst =  query.list();
//		List<Tiers> lst =  session.createQuery("select t from Tiers t, Tieiden i where t.tiers = i.tiers and i.codePieceIden = 'BI' and i.noPieceIden = 'B -105999'").list();
//		List<Refcomm> lst =  session.createQuery("from Empltiers where tiers = 'CL00000793'").list();
//		for(int i = 0; i < lst.size(); i++){
//			System.out.println(lst.get(i).getNom() + lst.get(i).getPrenom());
//		}
		session.doWork(new Work() {
			  public void execute(Connection connection) throws SQLException {
			    CallableStatement call = connection.prepareCall("{ ? = call PKG_UTIL_MONT_1SFC.CALC_MNT_PRET_AFF (?) }");
			    call.registerOutParameter( 1, OracleTypes.NUMBER );
			    call.setNString(2, "78349230");
//			    call.setNString(3, "CL00213672");
//			    call.setNString(3, new SimpleDateFormat("Myydd").format(new Date()));
			    call.execute();
			    double res =  call.getDouble(1);
//			    Date result = call.getDate(1);
//			    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//			    System.out.println("--- " + format.format(result) + " ---");
			    System.out.println("---" + res + "---");
//			    if(Double.parseDouble(result) <= 0){
//			    	System.out.println("wa3");
//			    }
			  }
			});
		session.close();
//		System.out.println(new SimpleDateFormat("Myydd").format(new Date()));
//		System.out.println(Double.parseDouble("26183,08".replace(",",".")));
		System.out.println("*************finish*************");
	}
}
