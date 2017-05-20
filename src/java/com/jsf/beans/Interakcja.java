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
//import db.Emocje;
import db.Interakcje;
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
import java.util.GregorianCalendar;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class Interakcja implements Serializable{
  private static final long serialVersionUID = 1094801825228386363L; 

    private String dodaj;

    public String getDodaj() {
        return dodaj;
    }

    public void setDodaj(String dodaj) {
        this.dodaj = dodaj;
    }
    
    
public void dodajInterakcja(Integer idemocja, Integer idposta, Integer iduzytkownika) {
        
 
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //String tresc_dodaj = request.getParameter("dodaj_post"+idposta+":tresc_dodaj"+idposta);
        //System.out.println("tresc_dodaj = " + tresc_dodaj);
        System.out.println(idposta);
        System.out.println(iduzytkownika);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        int i = 0;

            Connection con = null;
            PreparedStatement ps2 = null;
            PreparedStatement ps = null;  
            
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql2 = "DELETE FROM interakcje WHERE idemocji IN (1,2,3,4) AND iduzytkownika = " + iduzytkownika + " AND idposta = " + idposta;
                    String sql = "INSERT INTO interakcje(datainterakcji, idemocji, iduzytkownika, idposta) VALUES(?,?,?,?)";
                    ps2 = con.prepareStatement(sql2);
                    ps = con.prepareStatement(sql);
                    ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                    ps.setInt(2, idemocja);
                    ps.setInt(3, iduzytkownika);
                    ps.setInt(4, idposta);
                    i = ps2.executeUpdate();
                    i = ps.executeUpdate();
                    System.out.println("Dodano interakcje");
                }

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            } finally {
                try {
                    con.close();
                    ps2.close();
                    ps.close();
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                   // e.printStackTrace();
                }
            }
    }    
    public void dodajEmocja1(Integer idposta, Integer iduzytkownika) {
        
 
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //String tresc_dodaj = request.getParameter("dodaj_post"+idposta+":tresc_dodaj"+idposta);
        //System.out.println("tresc_dodaj = " + tresc_dodaj);
        System.out.println(idposta);
        System.out.println(iduzytkownika);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        int i = 0;

            Connection con = null;
            PreparedStatement ps2 = null;
            PreparedStatement ps = null;  
            
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql2 = "DELETE FROM interakcje WHERE idemocji IN (1,2,3,4) AND iduzytkownika = " + iduzytkownika + " AND idposta = " + idposta;
                    String sql = "INSERT INTO interakcje(datainterakcji, idemocji, iduzytkownika, idposta) VALUES(?,?,?,?)";
                    ps2 = con.prepareStatement(sql2);
                    ps = con.prepareStatement(sql);
                    ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                    ps.setInt(2, 1);
                    ps.setInt(3, iduzytkownika);
                    ps.setInt(4, idposta);
                    i = ps2.executeUpdate();
                    i = ps.executeUpdate();
                    System.out.println("Dodano interakcje");
                }

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            } finally {
                try {
                    con.close();
                    ps2.close();
                    ps.close();
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                   // e.printStackTrace();
                }
            }
    }    
    
    
    public void dodajEmocja2(Integer idposta, Integer iduzytkownika) {
        
 
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //String tresc_dodaj = request.getParameter("dodaj_post"+idposta+":tresc_dodaj"+idposta);
        //System.out.println("tresc_dodaj = " + tresc_dodaj);
        System.out.println(idposta);
        System.out.println(iduzytkownika);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        int i = 0;

            Connection con = null;
            PreparedStatement ps2 = null;
            PreparedStatement ps = null;
            
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql2 = "DELETE FROM interakcje WHERE idemocji IN (1,2,3,4) AND iduzytkownika = " + iduzytkownika + " AND idposta = " + idposta;
                    String sql = "INSERT INTO interakcje(datainterakcji, idemocji, iduzytkownika, idposta) VALUES(?,?,?,?)";
                    ps2 = con.prepareStatement(sql2);
                    ps = con.prepareStatement(sql);
                    ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                    ps.setInt(2, 2);
                    ps.setInt(3, iduzytkownika);
                    ps.setInt(4, idposta);
                    i = ps2.executeUpdate();
                    i = ps.executeUpdate();   
                    System.out.println("Dodano interakcje");
                }

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            } finally {
                try {
                    con.close();
                    ps2.close();
                    ps.close();
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                   // e.printStackTrace();
                }
            }
    } 
    
    
    
    
    public void dodajEmocja3(Integer idposta, Integer iduzytkownika) {
        
 
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //String tresc_dodaj = request.getParameter("dodaj_post"+idposta+":tresc_dodaj"+idposta);
        //System.out.println("tresc_dodaj = " + tresc_dodaj);
        System.out.println(idposta);
        System.out.println(iduzytkownika);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        int i = 0;

            Connection con = null;
            PreparedStatement ps2 = null;
            PreparedStatement ps = null;
            
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql2 = "DELETE FROM interakcje WHERE idemocji IN (1,2,3,4) AND iduzytkownika = " + iduzytkownika + " AND idposta = " + idposta;
                    String sql = "INSERT INTO interakcje(datainterakcji, idemocji, iduzytkownika, idposta) VALUES(?,?,?,?)";
                    ps2 = con.prepareStatement(sql2);
                    ps = con.prepareStatement(sql);
                    ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                    ps.setInt(2, 3);
                    ps.setInt(3, iduzytkownika);
                    ps.setInt(4, idposta);
                    i = ps2.executeUpdate();
                    i = ps.executeUpdate();
                    System.out.println("Dodano interakcje");
                }

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            } finally {
                try {
                    con.close();
                    ps2.close();
                    ps.close();                   
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                   // e.printStackTrace();
                }
            }
    } 
    
    
    
    
    
    public void dodajEmocja4(Integer idposta, Integer iduzytkownika) {
        
 
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //String tresc_dodaj = request.getParameter("dodaj_post"+idposta+":tresc_dodaj"+idposta);
        //System.out.println("tresc_dodaj = " + tresc_dodaj);
        System.out.println(idposta);
        System.out.println(iduzytkownika);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        int i = 0;

            Connection con = null;
            PreparedStatement ps2 = null;
            PreparedStatement ps = null;
            
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql2 = "DELETE FROM interakcje WHERE idemocji IN (1,2,3,4) AND iduzytkownika = " + iduzytkownika + " AND idposta = " + idposta;
                    String sql = "INSERT INTO interakcje(datainterakcji, idemocji, iduzytkownika, idposta) VALUES(?,?,?,?)";
                    ps2 = con.prepareStatement(sql2);
                    ps = con.prepareStatement(sql);
                    ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                    ps.setInt(2, 4);
                    ps.setInt(3, iduzytkownika);
                    ps.setInt(4, idposta);
                    i = ps2.executeUpdate();
                    i = ps.executeUpdate();
                    System.out.println("Dodano interakcje");
                }

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            } finally {
                try {
                    con.close();
                    ps2.close();
                    ps.close();                    
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                   // e.printStackTrace();
                }
            }
    } 
    
    
    
    
}