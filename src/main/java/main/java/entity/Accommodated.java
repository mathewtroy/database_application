package main.java.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "accommodated", schema = "public", catalog = "krossale")
@DiscriminatorValue("3")

/**
 * The @DiscriminatorValue("3") annotation indicates
 * that the discriminator value for instances of the Accommodated class is "3".
 * This value is used when storing or retrieving instances of the Accommodated class in the database,
 * to distinguish it from other subclasses in the inheritance hierarchy.
 *
 */


/**
 * Accommodated inherits properties and behavior from the Person class,
 * indicating a relationship where an Accommodated entity is a specialized type of Person.
 *
 */
public class Accommodated extends Person {

    @Basic
    @Column(name = "pass")
    private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * The @ManyToMany annotation indicates a many-to-many relationship
     * between Accommodated and Room entities.
     * It is configured using a join table named "lease",
     * which establishes the association between the two entities.
     *
     */
    @ManyToMany
    @JoinTable(
            name = "lease"
    )
    private Set<Room> leasedRooms;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accommodated that = (Accommodated) o;
        return Objects.equals(pass, that.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pass);
    }

}



