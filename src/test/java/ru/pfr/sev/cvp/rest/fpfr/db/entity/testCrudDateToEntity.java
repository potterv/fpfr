package ru.pfr.sev.cvp.rest.fpfr.db.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;


public class testCrudDateToEntity {
    @Test
    public void testCrud(){
        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employer.class)
                .buildSessionFactory();
       try {
           Session session = factory.getCurrentSession();
           Employer employer = new Employer("092-001-040992", "ООО ОЛИМП", 1);
           session.beginTransaction();
           session.save(employer);
           session.getTransaction().commit();
//           session.close();
       }
       finally {
           factory.close();
       }

    }



}
