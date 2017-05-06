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
import java.sql.Statement;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String msg;
    private String user;

    private String imie1;
    private String nazwisko1;

    private String imie;
    private String nazwisko;

    private Integer iduzytkownika;
    private String email;
    private Date dataurodzenia;
    private String kodpocztowy;
    private String miasto;
    private String ulica;
    private boolean zgloszony;
    private String plec;

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

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
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

    public String getImie1() {
        return imie1;
    }

    public void setImie1(String imie1) {
        this.imie1 = imie1;
    }

    public String getNazwisko1() {
        return nazwisko1;
    }

    public void setNazwisko1(String nazwisko1) {
        this.nazwisko1 = nazwisko1;
    }
    
    

    public String aktualizujProfil() {

        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String imie1 = request.getParameter("formaImie:imie1");
        System.out.println("imie1 = " + imie1);
        String nazwisko1 = request.getParameter("formaImie:nazwisko1");
        System.out.println("nazwisko1 = " + nazwisko1);
        String e_mail1 = request.getParameter("formaImie:e_mail1");
        System.out.println("e_mail1 = " + e_mail1);
        String kod_pocztowy1 = request.getParameter("formaImie:kod_pocztowy1");
        System.out.println("kod_pocztowy1 = " + kod_pocztowy1);
        String ulica1 = request.getParameter("formaImie:ulica1");
        System.out.println("ulica1 = " + ulica1);
        
       // String txtAnotherProperty= request.getParameter("txtAnotherProperty");
    //    System.out.println("txtAnotherProperty = " + txtAnotherProperty);
        
    //    imie = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("imie");
        
    //    System.out.println("Imie = " + imie);
    //    System.out.println("Nazwisko = " + nazwisko);
    //    System.out.println("User = " + user);
        
        
        
        /*
        
        //   Map<String, String> map = FacesContext.getCurrentInstance().getRequestParameterMap();
        //   String imie1 = map.get("imienazwisko:First_name");
        // String nazwisko1 = map.get("imienazwisko:Last_name");
        // String noweimie = (FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderValuesMap().get("noweimie")).toString();
        //  System.out.println( "Nowe imie to "+ noweimie);
        HttpSession session = SessionUtils.getSession();
        session.setAttribute("username", user);
        //return "admin";
        ///////
        // System.out.println("D");
        {
            Connection con = null;
            PreparedStatement ps = null;
            try {
                con = DataConnect.getConnection();
                ps = con.prepareStatement("UPDATE uzytkownicy SET imie = ?, nazwisko = ? WHERE login = ?");
                //  ps.setString(1, "Bartłomiej");
                // ps.setString(2, "Zimny");
                System.out.println("Imie = " + imie);
                ps.setString(1, imie);
                System.out.println("Nazwisko = " + nazwisko);
                ps.setString(2, nazwisko);
                System.out.println("User = " + user);
                ps.setString(3, user);
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.out.println("Error ->" + e.getMessage());
                return (null);
            }
        }
        ///////
         */
        return "index";

    }

    //validate login
    public String validateUsernamePassword() {
        boolean valid = LoginDAO.validate(user, pwd);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            //return "admin";  
            ///////
            //  System.out.println("D");

            {

                Connection con = null;
                PreparedStatement ps = null;

                try {
                    con = DataConnect.getConnection();
                    ps = con.prepareStatement("Select imie, nazwisko, email, plec, dataurodzenia, kodpocztowy, miasto, ulica, zgloszony from uzytkownicy where login = ?");
                    ps.setString(1, user);

                    ResultSet rs = ps.executeQuery();
                    boolean found = false;
                    while (rs.next()) {
                        setImie(rs.getString("imie"));
                        setNazwisko(rs.getString("nazwisko"));
                        setEmail(rs.getString("email"));

                        // setPlec(rs.getBoolean("plec"));
                        if (rs.getBoolean("plec") == false) {
                            setPlec("Mężczyzna");
                        } else {
                            setPlec("Kobieta");
                        }
                        setDataurodzenia(rs.getDate("dataurodzenia"));
                        setKodpocztowy(rs.getString("kodpocztowy"));
                        setMiasto(rs.getString("miasto"));
                        setUlica(rs.getString("ulica"));
                        setZgloszony(rs.getBoolean("zgloszony"));

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
