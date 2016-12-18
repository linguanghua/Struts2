package com.test;

import com.junxu.po.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;

/**
 * Created by LinXu on 2016/12/18.
 */
public class Test {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init(){
        Configuration configuration = new Configuration().configure();

        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void Destory(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @org.junit.Test
    public void testUser(){
        User u = new User();
        u.setUsername("linxu");
        u.setPassword("123");
        u.setId("1");

        session.save(u);

    }
    @org.junit.Test
    public void testUpdate(){
        User user = session.get(User.class,"1");
        user.setPassword("1234");
        session.update( user);
    }
    @org.junit.Test
    public void testDelete(){
        User user = session.get(User.class,"1");

        session.delete( user);
    }

    @org.junit.Test
    public void testGet(){
        User user = session.get(User.class,"1");

       // System.out.println(user.getClass().getName());
    }

    @org.junit.Test
    public void testLoad(){
        User user = session.load(User.class,"1");

    //    System.out.println(user);
    }

}
