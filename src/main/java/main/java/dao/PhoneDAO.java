package main.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import main.java.entity.Phone;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Phone phone) {
        entityManager.persist(phone);
    }

    public Phone read(String pass) {
        return entityManager.find(Phone.class, pass);
    }

    public void update(Phone phone) {
        entityManager.merge(phone);
    }

    public void delete(Phone phone) {
        entityManager.remove(phone);
    }
}
