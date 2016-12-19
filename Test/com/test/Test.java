package com.test;

import com.junxu.po.Grade;
import com.junxu.po.Student;
import com.junxu.po.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

import java.util.Set;

/**
 * Created by LinXu on 2016/12/18.
 */
public class Test {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
//        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//        configuration.addResource("com/junxu/UserEntity.hbm.xml");
//        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//
//         ServiceRegistry ssr = ssrb.build();
//        sessionFactory = configuration.buildSessionFactory(ssr);
        Configuration configuration = new Configuration().configure();
      //  configuration.addResource("com/junxu/UserEntity.hbm.xml");
      //  configuration.addResource("com/junxu/po/User.hbm.xml");
        configuration.addResource("com/junxu/po/Student.hbm.xml");
        configuration.addResource("com/junxu/po/Grade.hbm.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        StandardServiceRegistry ssr = ssrb.build();
        sessionFactory = configuration.buildSessionFactory(ssr);


        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void Destory() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @org.junit.Test
    public void testUser() {
//        User u = new User();
//        u.setUsername("林广华");
//        u.setPassword("123");
//        u.setId("2");

        Grade grade = new Grade("物联网5班","物联网专业");

        Student student1 = new Student("林序","男");
        Student student2 = new Student("君序","女");
        grade.getStudents().add(student1);
        grade.getStudents().add(student2);

        session.save(grade);
        session.save(student1);
        session.save(student2);

    }

    @org.junit.Test
    public void testGetGrade(){
        Grade g = session.get(Grade.class,1);
        System.out.println(g.getGname()+","+g.getGinfo());

        Set<Student> students = g.getStudents();
        for (Student s:
             students) {
            System.out.println(s.getName()+","+s.getSex());
        }
    }

    @org.junit.Test
    public void testUpdate() {
        User user = session.get(User.class, "1");
        user.setPassword("1234");
        session.update(user);
    }

    @org.junit.Test
    public void testDelete() {
        User user = session.get(User.class, "1");

        session.delete(user);
    }

    @org.junit.Test
    public void testGet() {
        User user = session.get(User.class, "2");

        System.out.println(user.getUsername());
    }

    @org.junit.Test
    public void testLoad() {
        User user = session.load(User.class, "1");

        //    System.out.println(user);
    }

}
