package main.java.select;

import java.sql.*;

public class SelectHotel {

    private static final String MYSQL_URL = "jdbc:postgresql://slon.felk.cvut.cz:5432/krossale";
    private static final String USER = "krossale";
    private static final String PASSWORD = "qwerty12a";
    private static final String SQL_SELECT_HOTEL = "SELECT * from hotel";


    public static void main(String[] args)
            throws ClassNotFoundException, SQLException
    {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection(MYSQL_URL, USER, PASSWORD);

        Statement s2 = c.createStatement();
        ResultSet rs2 = s2.executeQuery(SQL_SELECT_HOTEL);

        while (rs2.next()) {
            System.out.println(
                    "ICO:" + rs2.getString(1) + ", " +
                    "web:" + rs2.getString(2) + ", " +
                    "star:" + rs2.getString(3) + ". "
            );
        }

        c.close();
    }
}