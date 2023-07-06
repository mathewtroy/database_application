package main.java.entity;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "public", catalog = "krossale")
public class Book {
    @Id
    @ManyToOne
    @JoinColumn(name = "person_pass")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "employee_pass")
    private Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return Objects.equals(person, that.person) && Objects.equals(employee, that.employee) && Objects.equals(timeAdded, that.timeAdded) && Objects.equals(bookingFrom, that.bookingFrom) && Objects.equals(bookingTo, that.bookingTo) && Objects.equals(numberOfDays, that.numberOfDays) && Objects.equals(accepted, that.accepted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, employee, timeAdded, bookingFrom, bookingTo, numberOfDays, accepted);
    }
}


