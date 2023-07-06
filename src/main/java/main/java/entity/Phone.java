package main.java.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "phone", schema = "public", catalog = "krossale")
public class Phone {
    @Id
    @ManyToOne
    @JoinColumn(name = "pass")
    private Employee employee;

    @Column(name = "phone")
    private String phone;

    // Constructors, getters, and setters

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone that = (Phone) o;
        return Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }
}


