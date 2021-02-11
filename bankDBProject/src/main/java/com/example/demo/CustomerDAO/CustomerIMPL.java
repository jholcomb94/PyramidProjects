package com.example.demo.CustomerDAO;

import com.example.demo.entities.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class CustomerIMPL implements CustomerDAO{
    private final EntityManager entityManager;
    @Autowired
    public CustomerIMPL(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Object> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Object> query  = session.createQuery("from Customer ");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Object findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Customer.class,id);
    }

    @Override
    @Transactional
    public void save(Object customer) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(customer);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Customer c = session.get(Customer.class,id);
        session.delete(c);
    }

}
