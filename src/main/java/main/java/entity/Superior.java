package main.java.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "superior", schema = "public", catalog = "krossale")
public class Superior {
    @Id
    @ManyToOne
    @JoinColumn(name = "boss_pass")
    private Employee boss;

    @Id
    @ManyToOne
    @JoinColumn(name = "assistant_pass")
    private Employee assistant;

    // Constructors, getters, and setters

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public Employee getAssistant() {
        return assistant;
    }

    public void setAssistant(Employee assistant) {
        this.assistant = assistant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Superior that = (Superior) o;
        return Objects.equals(boss, that.boss) && Objects.equals(assistant, that.assistant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boss, assistant);
    }
}


