package com.jsf.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {

    public static Connection getConnection() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection(
            //		"jdbc:mysql://localhost:3306/cardb", "pankaj", "pankaj123");

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/facebook", "postgres", "postgres");

            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->"
                    + ex.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}
