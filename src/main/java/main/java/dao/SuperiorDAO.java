package main.java.dao;

import main.java.entity.Employee;
import main.java.entity.Superior;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SuperiorDAO {
    @PersistenceContext
    private EntityManager entityManager;


    public void addSuperior(Superior superior) {
        entityManager.persist(superior);
    }

    public Superior getSuperior(Employee boss, Employee assistant) {
        return entityManager.find(Superior.class, new Object[]{boss, assistant});
    }

    public void updateSuperior(Superior superior) {
        entityManager.merge(superior);
    }

    public void deleteSuperior(Superior superior) {
        entityManager.remove(superior);
    }
}
