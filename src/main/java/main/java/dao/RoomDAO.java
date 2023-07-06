package main.java.dao;

import main.java.entity.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoomDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void addRoom(Room room) {
        entityManager.persist(room);
    }

    public Room getRoom(String roomNumber, String buildingNumber, String buildingCity, String buildingStreet, String buildingPostal) {
        return entityManager.find(Room.class, new Object[]{roomNumber, buildingNumber, buildingCity, buildingStreet, buildingPostal});
    }

    public void updateRoom(Room room) {
        entityManager.merge(room);
    }

    public void deleteRoom(Room room) {
        entityManager.remove(room);
    }
}

