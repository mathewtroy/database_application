package main.java.entity;

import javax.persistence.*;

@Entity
@Table(name = "lease", schema = "public", catalog = "krossale")
public class Lease {
    @Id
    @ManyToOne
    @JoinColumn(name = "pass")
    private Accommodated accommodated;

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "room_number", referencedColumnName = "room_number"),
            @JoinColumn(name = "number", referencedColumnName = "number"),
            @JoinColumn(name = "city", referencedColumnName = "city"),
            @JoinColumn(name = "street", referencedColumnName = "street"),
            @JoinColumn(name = "postal", referencedColumnName = "postal")
    })
    private Room room;

    // Constructors, getters, and setters

    public Accommodated getAccommodated() {
        return accommodated;
    }

    public void setAccommodated(Accommodated accommodated) {
        this.accommodated = accommodated;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}


