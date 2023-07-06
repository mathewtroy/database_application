package main.java.select;

import java.sql.*;
public class SelectSomeOperations {
    private static final String MYSQL_URL = "jdbc:postgresql://slon.felk.cvut.cz:5432/krossale";
    private static final String USER = "krossale";
    private static final String PASSWORD = "qwerty12a";

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException
    {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection(MYSQL_URL, USER, PASSWORD);


        System.out.println("\n");

            Statement s2 = c.createStatement();
            ResultSet rs2 = s2.executeQuery(
                    "SELECT * from hotel"
            );

            while (rs2.next()) {
                System.out.println(
                        "ICO:" + rs2.getString(1) + ", " +
                        "web:" + rs2.getString(2) + ", " +
                        "star:" + rs2.getString(3) + ". "
                );
            }
        System.out.println("\n");

        Statement s3 = c.createStatement();
        ResultSet rs3 = s3.executeQuery(
                "SELECT * from booking"
        );

        while (rs3.next()) {
            System.out.println(
                    "Person pass:" + rs3.getString(1) + ", " +
                            "Pocet dny:" + rs3.getString(5) + ", " +
                            "Potvrzeno:" + rs3.getString(6) + ". "
            );
        }
        System.out.println("\n");


        Statement s4 = c.createStatement();

        // Execute a query to count the number of people in the Person table

        ResultSet rs4 = s4.executeQuery("SELECT COUNT(*) AS count FROM Person");

        if (rs4.next()) {
            int count = rs4.getInt("count");
            System.out.println("Pocet lidi v tabulce Person: " + count);
        } else {
            System.out.println("Tabulka Person je prazdna.");
        }

        rs4.close();
        s4.close();


        System.out.println("\n");

        // Preparing an SQL query to count the number of bookings in April 2023

        String sql = "SELECT COUNT(*) FROM Booking " +
                "WHERE bookingFrom >= '2023-04-01' AND bookingTo <= '2023-04-30'";

        Statement statement = c.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            System.out.println("Pocet objednavek v roce 2023 v dubnu: " + count);
        }

        System.out.println("\n");


//5
        Statement s5 = c.createStatement();

        // Execute a query to get a booking with the maximum number of days
        // and the person's first and last name

        ResultSet rs5 = s5.executeQuery(
                "SELECT b.numberOfDays, p.firstname, p.surname " +
                        "FROM Booking b " +
                        "JOIN Person p ON b.person_pass = p.pass " +
                        "ORDER BY b.numberOfDays DESC " +
                        "LIMIT 1"
        );

        if (rs5.next()) {
            int numberOfDays = rs5.getInt("numberOfDays");
            String firstName = rs5.getString("firstname");
            String lastName = rs5.getString("surname");

            System.out.println("Maximalni rezervace");
            System.out.println("Pocet dnu: " + numberOfDays);
            System.out.println("Jmeno: " + firstName);
            System.out.println("Prijmeni: " + lastName);
        } else {
            System.out.println("Neni informace o rezervaci.");
        }

        rs5.close();
        s5.close();
        System.out.println("\n");

// 6
        Statement s6 = c.createStatement();

        // Executing a query to count the number of employees with the job title "Banker" in the Person table
        ResultSet rs6 = s6.executeQuery("SELECT COUNT(*) AS count FROM Person WHERE occupation = 'Banker'");

        if (rs6.next()) {
            int count = rs6.getInt("count");
            System.out.println("Pocet lidi s povolani Banker: " + count);
        } else {
            System.out.println("Neni informace o lidech s povolani Banker.");
        }

        rs6.close();
        s6.close();

        System.out.println("\n");

// 7
        Statement s7 = c.createStatement();

        // Execute a query to count the number of professions and display a table with two columns
        // (professional name and quantity), where the quantity is less than 750
        ResultSet rs7 = s7.executeQuery(
                "SELECT occupation, COUNT(*) AS count " +
                        "FROM Person " +
                        "GROUP BY occupation " +
                        "HAVING COUNT(*) = 750"
        );

        System.out.println("Tabulka s povolani, ktera ukazuje pocet pouze s 750 osoby:");

        System.out.println("------------------------------");
        System.out.println("|   Povolani   |   Pocet   |");
        System.out.println("------------------------------");

        while (rs7.next()) {
            String occupation = rs7.getString("occupation");
            int count = rs7.getInt("count");

            System.out.printf("| %-13s | %-14d |\n", occupation, count);
        }

        System.out.println("------------------------------");

        rs7.close();
        s7.close();


        System.out.println("\n");

        c.close();
    }
}