package com.example.partsShop.partsDAO;
import com.example.partsShop.entities.Part;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class PartsIMPL implements PartsDAO{
    private final EntityManager entityManager;
    @Autowired
    public PartsIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Object> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Object> query = session.createQuery("from Part");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Object findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Part.class, id);
    }

    @Override
    @Transactional
    public void save(Object part) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(part);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Part myPart = currentSession.get(Part.class, id);
        currentSession.delete(myPart);
    }
}
