package main.java.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;



@Entity
@Table(name = "person", schema = "public", catalog = "krossale")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "EMP_TYPE", discriminatorType = DiscriminatorType.INTEGER)
public class Person {
    @Id
    @Column(name = "pass")
    private String pass;

    @Basic
    @Column(name = "firstname")
    private String firstname;

    @Basic
    @Column(name = "surname")
    private String surname;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "birthday")
    private Date birthday;

    @Basic
    @Column(name = "occupation")
    private String occupation;

    // Constructors, getters, and setters

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return Objects.equals(pass, that.pass) && Objects.equals(firstname, that.firstname) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email) && Objects.equals(birthday, that.birthday) && Objects.equals(occupation, that.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pass, firstname, surname, email, birthday, occupation);
    }

}



