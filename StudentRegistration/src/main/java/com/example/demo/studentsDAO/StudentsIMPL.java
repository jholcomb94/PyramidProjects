package com.example.demo.studentsDAO;

import com.example.demo.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentsIMPL implements StudentsDAO{
    private final EntityManager entityManager;
    @Autowired

    public StudentsIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Object> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Object> query = session.createQuery("from Student");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Object findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Student.class, id);
    }

    @Override
    @Transactional
    public void save(Object student) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(student);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Student myStudent = currentSession.get(Student.class, id);
        currentSession.delete(myStudent);
    }
}
