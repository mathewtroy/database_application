package main.java.dao;

import main.java.entity.Hotel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class HotelDAO {
    private EntityManager em;
    private EntityTransaction et;

    public HotelDAO(EntityManager em) {
        this.em = em;
        this.et = em.getTransaction();
    }

    public void insert(Hotel hotel) {
        et.begin();
        em.persist(hotel);
        et.commit();
    }

    public Hotel update(Hotel hotel) {
        et.begin();
        Hotel updatedHotel = em.merge(hotel);
        et.commit();
        return updatedHotel;
    }

    public void delete(Hotel hotel) {
        et.begin();
        em.remove(hotel);
        et.commit();
    }

    public Hotel get(String ico) {
        et.begin();
        Hotel hotel = em.find(Hotel.class, ico);
        et.commit();
        return hotel;
    }

    public List<Hotel> getItems() {
        TypedQuery<Hotel> query = em.createQuery("SELECT h FROM Hotel AS h", Hotel.class);
        List<Hotel> hotels = query.getResultList();
        return hotels;
    }

    public List<Hotel> getItemsByValue(String columnName, String value) {
        TypedQuery<Hotel> query = em.createQuery("SELECT h FROM Hotel AS h "
                + "WHERE (h." + columnName + "=:val)", Hotel.class);
        query.setParameter("val", value);
        List<Hotel> hotels = query.getResultList();
        return hotels;
    }

    public List<Hotel> getAll() {
        return getItems();
    }
}
