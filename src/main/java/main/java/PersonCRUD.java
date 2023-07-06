package main.java;

import main.java.dao.PersonDAO;
import main.java.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.List;

public class PersonCRUD {

    private static final String MYSQL_URL = "jdbc:postgresql://slon.felk.cvut.cz:5432/krossale";
    private static final String USER = "krossale";
    private static final String PASSWORD = "qwerty12a";
    private static final String UNIT_NAME = "JA_PU";

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection(MYSQL_URL, USER, PASSWORD);
        System.out.println("\n");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        PersonDAO personDAO = new PersonDAO(em);

        List<Person> persons = personDAO.getAll();
        System.out.println("------------------------------------\n");
        System.out.println("Seznam vsech osob, co mame na zacatku:\n");

        for (Person person : persons) {
            System.out.println(
                "ID:" + person.getPass() + ", " +
                ", Jmeno:" + person.getFirstname() + ", " +
                ", Prijmeni:" + person.getSurname() + ", " +
                ", Email:" + person.getEmail() + ", " +
                ", Narozeni" + person.getBirthday() + ", " +
                ", Povolani:" + person.getOccupation() + ". ");
        }


        // Insert new persons
        System.out.println("------------------------------------");
        System.out.println("Pridam novou osobu:");
        Person person1 = new Person();
        person1.setPass("699988868");
        person1.setFirstname("Komarek");
        person1.setSurname("Martin");
        person1.setEmail("komar@cz.cz");
        person1.setBirthday(new Date(92, 8, 5));
        person1.setOccupation("Cashier");
        personDAO.insert(person1);

//        Person person2 = new Person();
//        person2.setPass("699988867");
//        person2.setFirstname("Mudra");
//        person2.setSurname("Klima");
//        person2.setEmail("mudra@cz.cz");
//        person2.setBirthday(new Date(75, 1, 9));
//        person2.setOccupation("Paramedic");
//        personDAO.insert(person2);

        System.out.println("Seznam vsech osob, co mame po pridani:\n");
        for (Person person : personDAO.getAll()) {
            System.out.println(
                    "ID:" + person.getPass() + ", " +
                    "Jmeno:" + person.getFirstname() + ", " +
                    "Prijmeni:" + person.getSurname() + ", " +
                    "Email:" + person.getEmail() + ", " +
                    "Narozeni:" + person.getBirthday() + ", " +
                    "Povolani:" + person.getOccupation() + ". ");
        }


        // Change name from 'Mudra' to 'Martin'
        System.out.println("Zmenim jmeno osoby:");
        Person personToUpdate = personDAO.get("699988867");
        if (personToUpdate != null) {
            personToUpdate.setFirstname("Martin");
            personDAO.update(personToUpdate);
        }

        System.out.println("Seznam vsech osob, co mame po zmene jmenu:\n");
        for (Person person : personDAO.getAll()) {
            System.out.println(
                    "ID:" + person.getPass() + ", " +
                            "Jmeno:" + person.getFirstname() + ", " +
                            "Prijmeni:" + person.getSurname() + ", " +
                            "Email:" + person.getEmail() + ", " +
                            "Narozeni:" + person.getBirthday() + ", " +
                            "Povolani:" + person.getOccupation() + ". ");
        }


        // Delete person
        System.out.println("------------------------------------");
        System.out.println("Odstraneni osoby:");
        Person personToDelete = personDAO.get("699988867");
        if (personToDelete != null) {
            personDAO.delete(personToDelete);
        }

        System.out.println("Seznam vsech osob, co mame po odstraneni:\n");
        for (Person person : personDAO.getAll()) {
            System.out.println(
                    "ID:" + person.getPass() + ", " +
                            "Jmeno:" + person.getFirstname() + ", " +
                            "Prijmeni:" + person.getSurname() + ", " +
                            "Email:" + person.getEmail() + ", " +
                            "Narozeni:" + person.getBirthday() + ", " +
                            "Povolani:" + person.getOccupation() + ". ");
        }


        em.close();
        emf.close();
        c.close();

/**
 *----------------------------------------------------------
 *  Dědičnost
 *
 *  Pouzil jsem dedicnost ve slozce "entity" soubory:
 *
 *  1.  Accommodated
 *  2.  Employee
 *  3.  Mobile
 *
 *----------------------------------------------------------
 *  ManyToMany ve slozce "entity" soubory:
 *  1.  Accommodated
 *
 *----------------------------------------------------------
 *  ManyToOne ve slozce "entity" soubory:
 *  1.  Building
 *  2.  Booking
 *  3.  Room
 *
 **/

    }

}