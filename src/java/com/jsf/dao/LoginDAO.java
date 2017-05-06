package com.jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsf.util.DataConnect;
import db.Uzytkownicy;
import java.util.ArrayList;

public class LoginDAO {
    
 
    public static boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        
      
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select login, haslo from uzytkownicy where login = ? and haslo = ?");
            ps.setString(1, user);
            ps.setString(2, password);
                    
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {

                return true;
            }
            System.out.println("Bledne dane");
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return false;
    }
    
   
   
}
