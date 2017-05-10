package com.sofac.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
@SuppressWarnings("deprecation")
public class HibernateUtil {
     
    private static final SessionFactory mySQLSessionFactory;
    private static final SessionFactory oracleSessionFactory;
     
    static{
        try{
            mySQLSessionFactory = new Configuration().configure("mysql.cfg.xml").buildSessionFactory();
            oracleSessionFactory = new Configuration().configure("oracle.cfg.xml").buildSessionFactory();
 
        }catch (Throwable ex) {
            System.err.println("Session Factory could not be created." + ex);
            throw new ExceptionInInitializerError(ex);
        }   
    }
     
    public static SessionFactory getMySQLSessionFactory() {
        return mySQLSessionFactory;
    }
    
    public static SessionFactory getOracleSessionFactory() {
    	return oracleSessionFactory;
    }
    
    public static void shutdown() {
        // Close caches and connection pools
        getMySQLSessionFactory().close();
        getOracleSessionFactory().close();
    }
     
}