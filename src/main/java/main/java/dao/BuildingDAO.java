package main.java.dao;

import main.java.entity.Building;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BuildingDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void addBuilding(Building building) {
        entityManager.persist(building);
    }

    public Building getBuilding(String number, String city, String street, String postal) {
        return entityManager.find(Building.class, new Object[]{number, city, street, postal});
    }

    public void updateBuilding(Building building) {
        entityManager.merge(building);
    }

    public void deleteBuilding(Building building) {
        entityManager.remove(building);
    }
}


