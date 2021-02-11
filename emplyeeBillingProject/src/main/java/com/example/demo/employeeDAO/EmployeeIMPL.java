package com.example.demo.employeeDAO;

import com.example.demo.entities.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeIMPL implements EmployeeDAO {
    private final EntityManager entityManager;
    @Autowired
    public EmployeeIMPL(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public List<Object> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Object> query  = session.createQuery("from Employee ");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Object findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Employee.class,id);
    }

    @Override
    @Transactional
    public void save(Object employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee e = session.get(Employee.class,id);
        session.delete(e);
    }
}
