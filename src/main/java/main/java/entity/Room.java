package main.java.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room", schema = "public", catalog = "krossale")
public class Room {
    @Id
    @Column(name = "room_number")
    private String roomNumber;

    /**
     * The @ManyToOne annotation indicates that there is a many-to-one relationship
     * between Room and Building entities.
     * This means that multiple rooms can be associated with a single building.
     *
     */
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "number", referencedColumnName = "number"),
            @JoinColumn(name = "city", referencedColumnName = "city"),
            @JoinColumn(name = "street", referencedColumnName = "street"),
            @JoinColumn(name = "postal", referencedColumnName = "postal")
    })
    private Building building;

    @Column(name = "size")
    private int size;

    @Column(name = "type")
    private String type;

    // Constructors, getters, and setters

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room that = (Room) o;
        return size == that.size && Objects.equals(roomNumber, that.roomNumber) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, size, type);
    }
}


