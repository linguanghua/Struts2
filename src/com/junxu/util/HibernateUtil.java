package com.junxu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by LinXu on 2016/12/19.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;

    static {
        Configuration configuration = new Configuration().configure();
        configuration.addResource("com/junxu/UserEntity.hbm.xml");
        configuration.addResource("com/junxu/po/Student.hbm.xml");
        configuration.addResource("com/junxu/po/Grade.hbm.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        StandardServiceRegistry ssr = ssrb.build();
        sessionFactory = configuration.buildSessionFactory(ssr);
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session getSession(){
        session = sessionFactory.openSession();
        return session;
    }

    public static void closeSesson(Session session){
        if(session!=null){
            session.close();
        }
    }

}
