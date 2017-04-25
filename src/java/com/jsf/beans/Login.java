package com.jsf.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.jsf.dao.LoginDAO;
import com.jsf.util.DataConnect;
import com.jsf.util.SessionUtils;
import db.Uzytkownicy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String msg;
    private String user;

    private String imie;
    private String nazwisko;
    
    private Integer iduzytkownika;
    private String email;
    private Date dataurodzenia;
    private String kodpocztowy;
    private String miasto;
    private String ulica;
    private boolean zgloszony;
    private boolean plec;
    
    private String imienazwisko;

    /////////////
    public Integer getIduzytkownika() {
        return iduzytkownika;
    }

    public void setIduzytkownika(Integer iduzytkownika) {
        this.iduzytkownika = iduzytkownika;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataurodzenia() {
        return dataurodzenia;
    }

    public void setDataurodzenia(Date dataurodzenia) {
        this.dataurodzenia = dataurodzenia;
    }

    public String getKodpocztowy() {
        return kodpocztowy;
    }

    public void setKodpocztowy(String kodpocztowy) {
        this.kodpocztowy = kodpocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public boolean getZgloszony() {
        return zgloszony;
    }

    public void setZgloszony(boolean zgloszony) {
        this.zgloszony = zgloszony;
    }

    public boolean getPlec() {
        return plec;
    }

    public void setPlec(boolean plec) {
        this.plec = plec;
    }
    
    
    
    
    
    
    //////////////
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    
    public String getImieNazwisko() {
        return imienazwisko;
    }

    public void setImieNazwisko(String imienazwisko) {
        this.imienazwisko = imienazwisko;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //validate login
    public String validateUsernamePassword() {
        boolean valid = LoginDAO.validate(user, pwd);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            //return "admin";  
            ///////
            System.out.println("D");

            {

                Connection con = null;
                PreparedStatement ps = null;

                try {
                    con = DataConnect.getConnection();
                    ps = con.prepareStatement("Select imie, nazwisko, email, plec, dataurodzenia, kodpocztowy, miasto, ulica, zgłoszony from uzytkownicy where login = ?");
                    ps.setString(1, user);

                    ResultSet rs = ps.executeQuery();
                    boolean found = false;
                    while (rs.next()) {
                        setImie(rs.getString("imie"));
                        setNazwisko(rs.getString("nazwisko"));
                        setEmail(rs.getString("email"));
                        setPlec(rs.getBoolean("plec"));
                        setDataurodzenia(rs.getDate("dataurodzenia"));
                        setKodpocztowy(rs.getString("kodpocztowy"));
                        setMiasto(rs.getString("miasto"));
                        setUlica(rs.getString("ulica"));
                        setZgloszony(rs.getBoolean("zgłoszony"));
                        
                        
                       // setImieNazwisko(rs.getString("imie")+" "+rs.getString("nazwisko"));
                        
                        found = true;
                    }
                    rs.close();
                 } catch (Exception e) {
            System.out.println("Error ->" + e.getMessage());
            return (null);
                 }

            }

            ///////
            return "index";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Bledny login lub haslo",
                            "Wpisz poprawne dane"));
            return "login";
        }

    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "logowanie_rejestracja";
    }
}
