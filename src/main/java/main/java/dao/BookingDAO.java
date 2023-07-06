package main.java.dao;

import main.java.entity.Booking;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void addBooking(Booking booking) {
        entityManager.persist(booking);
    }

    public Booking getBooking(String bookingId) {
        return entityManager.find(Booking.class, bookingId);
    }

    public void updateBooking(Booking booking) {
        entityManager.merge(booking);
    }

    public void deleteBooking(Booking booking) {
        entityManager.remove(booking);
    }
}
