package ru.pfr.sev.cvp.fpfr.db.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import ru.pfr.sev.cvp.fpfr.db.entity.onetomany.Intelligence;
import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Apendix;
import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Notices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class testCrudDateToEntity {
    @Test
    public void testCrud(){
        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employeer.class)
                .buildSessionFactory();
       try {
           Session session = factory.getCurrentSession();
           Employeer employeer = new Employeer();
           session.beginTransaction();
           session.save(employeer);
           session.getTransaction().commit();
//           session.close();
       }
       finally {

                      factory.close();
       }

    }

    @Test
    public void testReadData(){
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employeer.class)
                .buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            Employeer employeer = new Employeer();
            int id = 4;

            session.beginTransaction();
                employeer = session.get(Employeer.class,id);
                session.getTransaction().commit();
            System.out.println(employeer);
        }
        finally {
            factory.close();
        }
    }

    @Test
    public void testOneToOne(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employeer.class)
                .addAnnotatedClass(Notices.class)
                .addAnnotatedClass(Apendix.class)
                 .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employeer employeer = new Employeer("00000000000","xxxx");

            try {
                Notices notices = new Notices(new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),"2021-04-16",
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"));
                employeer.setEmpNotices(notices);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                Apendix apendix = new Apendix(
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        "-",
                        "-");
                employeer.setEmpApendix(apendix);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            session.beginTransaction();
            session.save(employeer);
            session.getTransaction().commit();


            System.out.println("Done!!!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
    @Test
    public void testOneToMany(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employeer.class)
                .addAnnotatedClass(Notices.class)
                .addAnnotatedClass(Apendix.class)
                .addAnnotatedClass(Intelligence.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employeer employeer = new Employeer("00000000005","rrrrr");

            try {
                Notices notices = new Notices(new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),"2021-04-16",
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"));
                employeer.setEmpNotices(notices);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                Apendix apendix = new Apendix(new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        "-",
                        "-");
                employeer.setEmpApendix(apendix);
            } catch (ParseException e) {
                e.printStackTrace();
            }


//                Intelligence intelligence = new Intelligence("1","2","3",10);
//                Intelligence intelligence1 = new Intelligence("4","5","6",12);

//                employeer.addIntaligence(new Intelligence("1","2","3",10));
//                employeer.addIntaligence(new Intelligence("4","5","6",12));



            session.beginTransaction();
            session.save(employeer);
            session.getTransaction().commit();


            System.out.println("Done!!!");
        }
        finally {
            session.close();
            factory.close();
        }

        Integer i[]= new Integer[4];

        List<Integer[]> list = new ArrayList();

        list.add(i);
    }



}
