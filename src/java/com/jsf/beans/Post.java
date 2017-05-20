package com.jsf.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.jsf.util.DataConnect;
import com.jsf.util.SessionUtils;
import db.Posty;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class Post implements Serializable{
  
    private static final long serialVersionUID = 1094801825228386363L; 

    private String dodaj;

    public String getDodaj() {
        return dodaj;
    }

    public void setDodaj(String dodaj) {
        this.dodaj = dodaj;
    }
    
    
    
    public void dodajPost(Integer idposta, Integer iduzytkownika) {
        
 
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String tresc_dodaj = request.getParameter("dodaj_post"+idposta+":tresc_dodaj"+idposta);
        System.out.println("tresc_dodaj = " + tresc_dodaj);
        System.out.println(iduzytkownika);

        //Date date2 = new GregorianCalendar().getTime();
        // System.out.println("data = " + date2);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        //String date3 = formatter.format(date2);
             //System.out.println("data = " + date3);
             
        //java.sql.Date sqlDate2 = java.sql.Date.valueOf( date3 ); 
     //   System.out.println("data = " + sqlDate2);

        int i = 0;

            Connection con = null;
            PreparedStatement ps = null;
            
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "INSERT INTO posty(iduzytkownika, tresc, dataposta, idkommentarzposta) VALUES(?,?,?,?)";
                    ps = con.prepareStatement(sql);   
                    ps.setInt(1, iduzytkownika);
                    ps.setString(2, getDodaj());
                    ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                    ps.setInt(4, idposta);
                    i = ps.executeUpdate();
                    System.out.println("Dodano posta");
                    setDodaj("");
                }

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            } finally {
                try {
                    con.close();
                    ps.close();
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                   // e.printStackTrace();
                }
            }
        
      
    
        // return null;
    }
    
    
    
    
    
    
    public void dodajPost2(Integer idposta, Integer iduzytkownika) {
        
 
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String tresc_dodaj = request.getParameter("dodaj_post"+idposta+":tresc_dodaj"+idposta);
        System.out.println("tresc_dodaj = " + tresc_dodaj);
        System.out.println(iduzytkownika);

        //Date date2 = new GregorianCalendar().getTime();
        // System.out.println("data = " + date2);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        //String date3 = formatter.format(date2);
             //System.out.println("data = " + date3);
             
        //java.sql.Date sqlDate2 = java.sql.Date.valueOf( date3 ); 
     //   System.out.println("data = " + sqlDate2);

        int i = 0;
     

            Connection con = null;
            PreparedStatement ps = null;

            try {

                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "INSERT INTO posty(iduzytkownika, tresc, dataposta, idkommentarzposta) VALUES(?,?,?,?)";
                    ps = con.prepareStatement(sql);
                       
                    ps.setInt(1, iduzytkownika);
                    ps.setString(2, getDodaj());
                    ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                    ps.setInt(4, 0);

                    i = ps.executeUpdate();
                    System.out.println("Dodano posta");
                    setDodaj("");
                }

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            } finally {
                try {
                    con.close();
                    ps.close();
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                   // e.printStackTrace();
                }
            }
        
      
        
        // return null;
    }
   
}
