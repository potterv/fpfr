package ru.pfr.sev.cvp.fpfr.db.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import ru.pfr.modules.xls_parser_fin_monitor.Organization;
import ru.pfr.modules.xls_parser_fin_monitor.XLSParser;
import ru.pfr.sev.cvp.fpfr.db.entity.onetomany.Intelligence;
import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Notices;
import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Apendix;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Deprecated
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
                .addAnnotatedClass(ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Apendix.class)
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
                    "2021-04-16",
                    "2021-04-16",
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
                .addAnnotatedClass(ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Apendix.class)
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

            Apendix apendix = new Apendix("2021-04-16",
                    "2021-04-16",
                    "-",
                    "-");
            employeer.setEmpApendix(apendix);


//                Intelligence intelligence = new Intelligence("1","2","3",10);
//                Intelligence intelligence1 = new Intelligence("4","5","6",12);

                employeer.addIntaligence(new Intelligence("5","1","7","18"));
                employeer.addIntaligence(new Intelligence("7","8","7","14"));



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

    @Test
    public void setDateDB(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employeer.class)
                .addAnnotatedClass(Notices.class)
                .addAnnotatedClass(ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Apendix.class)
                .addAnnotatedClass(Intelligence.class)
                .buildSessionFactory();
        Session session = null;
        XLSParser xlsParser =new XLSParser();
        List<Organization>listOrg = new ArrayList();
        listOrg = xlsParser.parsingFileToOrgList("D:\\!!!DOCUMENTS\\ФИН. САНКЦИИ ПО СВЕРКЕ (УВЕДОМЛЕНИЯ)\\Таблица рег-новая1____для разработки.xls");



        try {
            for (Organization organization: listOrg
            ) {
            session = factory.getCurrentSession();
            Employeer employeer = new Employeer(organization.getRegNumber(),organization.getOrgName());

             organization.getArrayOfNotification().forEach(System.out::println);


            Notices notices = new Notices(checkDate(organization.getArrayOfNotification().get(0).get(0)),
                                          checkDate(organization.getArrayOfNotification().get(0).get(1)) ,
                                           organization.getArrayOfNotification().get(0).get(2),
                                          checkDate(organization.getArrayOfNotification().get(0).get(3)));
            employeer.setEmpNotices(notices);
            organization.getArrayOfAppendix().forEach(System.out::println);

//            LocalDate localDate = LocalDate.parse(checkDate(organization.getArrayOfAppendix().get(0).get(0)));
            Apendix apendix = new Apendix(organization.getArrayOfAppendix().get(0).get(0),
                    organization.getArrayOfAppendix().get(0).get(1),
                    organization.getArrayOfAppendix().get(0).get(2),
                    organization.getArrayOfAppendix().get(0).get(3));
            employeer.setEmpApendix(apendix);


//                Intelligence intelligence = new Intelligence("1","2","3",10);
//                Intelligence intelligence1 = new Intelligence("4","5","6",12);

            for (List<String> listIntrl:organization.getArrayOfIntelligence()
                 ) {
                organization.getArrayOfIntelligence().forEach(System.out::println);

                employeer.addIntaligence(new Intelligence(organization.getArrayOfIntelligence().get(0).get(0),
                        organization.getArrayOfIntelligence().get(0).get(1),
                        organization.getArrayOfIntelligence().get(0).get(2),
                        organization.getArrayOfIntelligence().get(0).get(3)));
            }

//            employeer.addIntaligence(new Intelligence("5","1","7",18));
//            employeer.addIntaligence(new Intelligence("7","8","7",14));



            session.beginTransaction();
            session.save(employeer);
            session.getTransaction().commit();


            System.out.println("Done!!!");
        }
        }
        finally {
            session.close();
            factory.close();
        }

        Integer i[]= new Integer[4];

        List<Integer[]> list = new ArrayList();

        list.add(i);
    }


    private LocalDate checkDate(String s){
    if (s.equals("null")) return null;
    else return  LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private Integer checkInt(String s){
        if (s.equals("null")) return null;
        else return  Integer.getInteger(s);
    }

    @Test
    public void testNull(){
        checkDate("null");
    }

}
