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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

            Notices notices = new Notices(LocalDate.parse("2021-04-16"),
                    LocalDate.parse("2021-04-16"),"2021-04-16",
                    LocalDate.parse("2021-04-16"));
            employeer.setEmpNotices(notices);

            Apendix apendix = new Apendix(
                    LocalDate.parse("2021-04-16"),
                    LocalDate.parse("2021-04-16"),
                    "-",
                    "-");
            employeer.setEmpApendix(apendix);

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
            Employeer employeer = new Employeer("00000000009","ooo pppp");

            Notices notices = new Notices(LocalDate.parse("2021-04-16"),
                    LocalDate.parse("2021-04-16"),"2021-04-16",
                    LocalDate.parse("2021-04-16"));
            employeer.setEmpNotices(notices);

            Apendix apendix = new Apendix(LocalDate.parse("2021-04-16"),
                    LocalDate.parse("2021-04-16"),
                    "-",
                    "-");
            employeer.setEmpApendix(apendix);


//                Intelligence intelligence = new Intelligence("1","2","3",10);
//                Intelligence intelligence1 = new Intelligence("4","5","6",12);

                employeer.addIntaligence(new Intelligence("5","1","7",18));
                employeer.addIntaligence(new Intelligence("7","8","7",14));



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
