package ru.pfr.sev.cvp.rest.fpfr.db.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import ru.pfr.sev.cvp.rest.fpfr.db.entity.onetomany.Intelligence;
import ru.pfr.sev.cvp.rest.fpfr.db.entity.onetoone.Apendix;
import ru.pfr.sev.cvp.rest.fpfr.db.entity.onetoone.Notices;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class testCrudDateToEntity {
    @Test
    public void testCrud(){
        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employer.class)
                .buildSessionFactory();
       try {
           Session session = factory.getCurrentSession();
           Employer employer = new Employer();
           session.beginTransaction();
           session.save(employer);
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
                addAnnotatedClass(Employer.class)
                .buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            Employer employer = new Employer();
            int id = 4;

            session.beginTransaction();
                employer = session.get(Employer.class,id);
                session.getTransaction().commit();
            System.out.println(employer);
        }
        finally {
            factory.close();
        }
    }

    @Test
    public void testOneToOne(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employer.class)
                .addAnnotatedClass(Notices.class)
                .addAnnotatedClass(Apendix.class)
                 .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employer employer = new Employer("00000000000","xxxx");

            try {
                Notices notices = new Notices(new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),"2021-04-16",
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"));
                employer.setEmpNotices(notices);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                Apendix apendix = new Apendix(employer.getRegNum(),
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        "-",
                        "-");
                employer.setEmpApendix(apendix);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            session.beginTransaction();
            session.save(employer);
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
                .addAnnotatedClass(Employer.class)
                .addAnnotatedClass(Notices.class)
                .addAnnotatedClass(Apendix.class)
                .addAnnotatedClass(Intelligence.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employer employer = new Employer("00000000001","rrrrr");

            try {
                Notices notices = new Notices(new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),"2021-04-16",
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"));
                employer.setEmpNotices(notices);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                Apendix apendix = new Apendix(employer.getRegNum(),
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-16"),
                        "-",
                        "-");
                employer.setEmpApendix(apendix);
            } catch (ParseException e) {
                e.printStackTrace();
            }


//                Intelligence intelligence = new Intelligence("1","2","3",10);
//                Intelligence intelligence1 = new Intelligence("4","5","6",12);

                employer.addIntaligence(new Intelligence("1","2","3",10));
                employer.addIntaligence(new Intelligence("4","5","6",12));



            session.beginTransaction();
            session.save(employer);
            session.getTransaction().commit();


            System.out.println("Done!!!");
        }
        finally {
            session.close();
            factory.close();
        }
    }



}
