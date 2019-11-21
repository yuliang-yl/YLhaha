package com.yl.utils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Administrator
 * @create 2019-11-21-11:04
 */
public class Hibernateutils {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;
    static{
        sessionFactory=new Configuration().configure().buildSessionFactory();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
    }
    public static Session getSession(){
        return session;
    }
    public static Query getquery(String hql){
        return session.createQuery(hql);
    }

}
