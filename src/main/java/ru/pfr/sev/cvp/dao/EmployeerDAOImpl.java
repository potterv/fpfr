package ru.pfr.sev.cvp.dao;

//import org.hibernate.Session;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;


import javax.persistence.EntityManager;
//import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeerDAOImpl implements EmployeerDAO {
    @Autowired
//    private SessionFactory sessionFactory;
    private EntityManager entityManager;

    @Override
    public List<Employeer> getAllEmployeer() {
        Session session = entityManager.unwrap(Session.class);

        Query<Employeer> query = session.createQuery("from Employeer", Employeer.class);

        List<Employeer> allEmployeer = query.getResultList();
//        Query qury = entityManager.createQuery("frome Employeer");
//        List<Employeer> allEmployeer = qury.getResultList();
        return allEmployeer;
    }

    @Override
    public void saveEmployeer(Employeer employeer){
        Session session = entityManager.unwrap(Session.class);
        Transaction txn = session.beginTransaction();

        session.saveOrUpdate(employeer);
        txn.commit();
//        Employeer newEmployeer = entityManager.merge(employeer);
//        employeer.setId(newEmployeer.getId());
    }

    @Override
    public Employeer getEmployer(int id) {
//        Session session = entityManager.unwrap(Session.class);
//
//        Employeer employeer = session.get(Employeer.class,id);
        Employeer employeer = entityManager.find(Employeer.class,id);
        return employeer;
    }

    @Override
    public void deleteEmployeer(int id) {

        Session session = entityManager.unwrap(Session.class);
        Transaction txn = session.beginTransaction();
        Query<Employeer> query = session.createQuery("delete from Employeer "+"where id = :employeerId");
        query.setParameter("employeerId",id);
        query.executeUpdate();
        txn.commit();

//        Query query = entityManager.createQuery("delete from Employeer "+
//                "where id =:employeerId");
//        query.setParameter("employeerId", id);
//
//        query.executeUpdate();
    }
}
