package com.jsf.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public class DataConnect {

    public static Connection getConnection() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection(
            //		"jdbc:mysql://localhost:3306/cardb", "pankaj", "pankaj123");

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://beta.ur.edu.pl:5432/facebook", "postgres", "!Q2w3e4r");

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