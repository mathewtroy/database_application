package main.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import main.java.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee read(String pass) {
        return entityManager.find(Employee.class, pass);
    }

    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    public void delete(Employee employee) {
        entityManager.remove(employee);
    }
}
