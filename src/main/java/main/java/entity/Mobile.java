package main.java.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mobile", schema = "public", catalog = "krossale")
@DiscriminatorValue("2")
/**
 *  The @DiscriminatorValue("2") annotation indicates
 *  that the discriminator value for instances of the Mobile class is "2".
 *  This value is used when storing or retrieving instances of the Mobile class in the database,
 *  to distinguish it from other subclasses in the inheritance hierarchy.
 *
 */


/**
 *  Mobile inherits properties and behavior from the Person class,
 *  indicating a relationship where an Mobile entity is a specialized type of Person.
 *
 */
public class Mobile extends Person {

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
        Mobile that = (Mobile) o;
        return Objects.equals(pass, that.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pass);
    }
}


