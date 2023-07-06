package main.java.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotel", schema = "public", catalog = "krossale")
public class Hotel {

    @Id
    @Column(name = "ico")
    private String ico;

    @Basic
    @Column(name = "website")
    private String website;

    @Basic
    @Column(name = "stars")
    private int stars;

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel that = (Hotel) o;
        return Objects.equals(ico, that.ico) && Objects.equals(website, that.website) && Objects.equals(stars, that.stars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ico, website, stars);
    }
}
