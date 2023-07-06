package main.java.dao;

import main.java.entity.Lease;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LeaseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // Методы доступа к данным (создание, чтение, обновление, удаление) с использованием EntityManager

    public void addLease(Lease lease) {
        entityManager.persist(lease);
    }

    public Lease getLease(String leaseId) {
        return entityManager.find(Lease.class, leaseId);
    }

    public void updateLease(Lease lease) {
        entityManager.merge(lease);
    }

    public void deleteLease(Lease lease) {
        entityManager.remove(lease);
    }
}
