package main.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import main.java.entity.Accommodated;
import main.java.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public class AccommodatedDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Accommodated accommodated) {
        entityManager.persist(accommodated);
    }

    public Accommodated read(Person person) {
        return entityManager.find(Accommodated.class, person);
    }

    public void update(Accommodated accommodated) {
        entityManager.merge(accommodated);
    }

    public void delete(Accommodated accommodated) {
        entityManager.remove(accommodated);
    }
}
