package main.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import main.java.entity.Mobile;
import org.springframework.stereotype.Repository;

@Repository
public class MobileDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Mobile mobile) {
        entityManager.persist(mobile);
    }

    public Mobile read(String pass) {
        return entityManager.find(Mobile.class, pass);
    }

    public void update(Mobile mobile) {
        entityManager.merge(mobile);
    }

    public void delete(Mobile mobile) {
        entityManager.remove(mobile);
    }
}
