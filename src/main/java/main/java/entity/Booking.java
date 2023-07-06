package main.java.entity;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;

@Entity
    @Table(name = "booking", schema = "public", catalog = "krossale")
    public class Booking {

    /**
     * The @ManyToOne annotation indicates that there is a many-to-one relationship
     * between the Book entity and the associated entity (Person or Employee).
     *
     * The Book entity has two many-to-one relationships
     * with the Person and Employee entities, respectively.
     * The person field represents the associated person who booked the booking,
     * and the employee field represents the associated employee who handled the booking.
     *
     */
    @Id
        @ManyToOne
        @JoinColumn(name = "person_pass")
        private Person person;

        @Column(name = "time_added")
        private Timestamp timeAdded;

        @Column(name = "bookingFrom")
        private Date bookingFrom;

        @Column(name = "bookingTo")
        private Date bookingTo;

        @Column(name = "numberOfDays")
        private int numberOfDays;

        @Column(name = "accepted")
        private boolean accepted;

        // Constructors, getters, and setters

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Timestamp getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Timestamp timeAdded) {
        this.timeAdded = timeAdded;
    }

    public Date getBookingFrom() {
        return bookingFrom;
    }

    public void setBookingFrom(Date bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    public Date getBookingTo() {
        return bookingTo;
    }

    public void setBookingTo(Date bookingTo) {
        this.bookingTo = bookingTo;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

}


