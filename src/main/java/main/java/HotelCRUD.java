package main.java;

import main.java.dao.HotelDAO;
import main.java.entity.Hotel;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class HotelCRUD {

    private static final String MYSQL_URL = "jdbc:postgresql://slon.felk.cvut.cz:5432/krossale";
    private static final String USER = "krossale";
    private static final String PASSWORD = "qwerty12a";
    private static final String UNIT_NAME = "JA_PU";

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException
    {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection(MYSQL_URL, USER, PASSWORD);
        System.out.println("\n");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        HotelDAO hotelDAO = new HotelDAO(em);

        // Get all hotels
        List<Hotel> hotels = hotelDAO.getAll();
        System.out.println("------------------------------------\n");
        System.out.println("Seznam vsech hotelu, co mame na zacatku:\n");
        for (Hotel hotel : hotels) {
            System.out.println(
                    "ICO: " + hotel.getIco() +
                    ", Web:" + hotel.getWebsite()+
                    ", Star:" + hotel.getStars());
        }


//        // Inserting
        System.out.println("------------------------------------");
        System.out.println("Vytvorime novy hotel:\n");
        Hotel hotel23 = new Hotel();
        hotel23.setIco("HOTEL0100");
        hotel23.setWebsite("www.website100.cz");
        hotel23.setStars(4);
        hotelDAO.insert(hotel23);
        System.out.println("Inserted Hotel: " + hotel23.getIco());


//        Tranzakce z prikladu CP-4
//        Zmenim nazev website v hotelu

        // Updating
        System.out.println("------------------------------------");
        System.out.println("Udelame Update hotelu:\n");
        Hotel hotelToUpdate = hotelDAO.get("HOTEL001");
        //hotelToUpdate.setStars(5);
        hotelToUpdate.setWebsite("www.newwebtttttt.cz");
        hotelDAO.update(hotelToUpdate);
        System.out.println(
                "ICO of the Updated Hotel: " + hotelToUpdate.getIco() +
                ", Updated website: " + hotelToUpdate.getWebsite() );


//        // Deleting
        System.out.println("------------------------------------");
        System.out.println("Odstranime hotel:\n");
        String icoToDelete = "HOTEL022";
        Hotel hotelToDelete = hotelDAO.get(icoToDelete);
        if (hotelToDelete != null) {
            hotelDAO.delete(hotelToDelete);
            System.out.println("Hotel with ICO (" + icoToDelete + ") has been deleted.");
        } else {
            System.out.println("Hotel with ICO (" + icoToDelete + ") not found.");
        }


        // Get all hotels
        List<Hotel> hotels_new = hotelDAO.getAll();
        System.out.println("------------------------------------");
        System.out.println("Seznam vsech hotelu, co mame po zmene:\n");
        for (Hotel hotel : hotels_new) {
            System.out.println(
                    "ICO: " + hotel.getIco() +
                    ", Web:" + hotel.getWebsite()+
                    ", Star:" + hotel.getStars());
        }


        em.close();
        emf.close();
        c.close();

    }

}

