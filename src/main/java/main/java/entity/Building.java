package main.java.entity;

import javax.persistence.*;

@Entity
@Table(name = "building", schema = "public", catalog = "krossale")
public class Building {
    @Id
    @Column(name = "number")
    private String number;

    @Id
    @Column(name = "city")
    private String city;

    @Id
    @Column(name = "street")
    private String street;

    @Id
    @Column(name = "postal")
    private String postal;

    /**
     * The @ManyToOne annotation indicates that there is a many-to-one relationship
     * between Building and Hotel entities.
     * This means that multiple buildings can be associated with a single hotel.
     *
     */
    @ManyToOne
    @JoinColumn(name = "hotel", referencedColumnName = "ico")
    private Hotel hotel;

    // Constructors, getters, and setters

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}


