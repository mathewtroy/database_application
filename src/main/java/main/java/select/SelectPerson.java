package main.java.select;

import java.sql.*;

public class SelectPerson {

    private static final String MYSQL_URL = "jdbc:postgresql://slon.felk.cvut.cz:5432/krossale";
    private static final String USER = "krossale";
    private static final String PASSWORD = "qwerty12a";
    private static final String SQL_SELECT_HOTEL = "SELECT * from person";


    public static void main(String[] args)
            throws ClassNotFoundException, SQLException
    {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection(MYSQL_URL, USER, PASSWORD);

        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(SQL_SELECT_HOTEL);

        while (rs.next()) {
            System.out.println(
                    "ID:" + rs.getString(1) + ", " +
                            "Jmeno:" + rs.getString(2) + ", " +
                            "Prijmeni:" + rs.getString(3) + ", " +
                            "Email:" + rs.getString(4) + ", " +
                            "Narozeni" + rs.getString(5) + ", " +
                            "Povolani:" + rs.getString(6) + ". "
            );
        }

        c.close();
    }
}