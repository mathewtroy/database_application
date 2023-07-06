package main.java.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "employee", schema = "public", catalog = "krossale")
@DiscriminatorValue("1")
/**
 * The @DiscriminatorValue("1") annotation indicates
 * that the discriminator value for instances of the Employee class is "1".
 * This value is used when storing or retrieving instances of the Employee class in the database,
 * to distinguish it from other subclasses in the inheritance hierarchy.
 *
 */


/**
 * Employee inherits properties and behavior from the Person class,
 * indicating a relationship where an Employee entity is a specialized type of Person.
 *
 */
public class Employee extends Person {

    @Basic
    @Column(name = "pass")
    private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee that = (Employee) o;
        return Objects.equals(pass, that.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pass);
    }

}


