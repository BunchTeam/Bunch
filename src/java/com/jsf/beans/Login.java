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
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;

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
    private boolean plec;
    private boolean plec1;

    private String imienazwisko;

    private Uzytkownicy uzytkownik;

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

    public boolean isPlec() {
        return plec;
    }

    public void setPlec(boolean plec) {
        this.plec = plec;
    }

    public String plectoString() {
        if (this.plec) {
            return "Kobieta";
        } else {
            return "Mężczyzna";
        }
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

    public boolean getPlec1() {
        return plec1;
    }

    public void setPlec1(boolean plec1) {
        this.plec1 = plec1;
    }

    public String plectoString(Boolean plec) {
        if (plec) {
            return "Kobieta";
        } else {
            return "Mężczyzna";
        }
    }

    public Uzytkownicy getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownicy uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public String zarejestruj() {

        boolean plecbool;

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String imie_rej = request.getParameter("rejestracja:imie_rej");
        //    System.out.println("imie_rej = " + imie_rej);
        String nazwisko_rej = request.getParameter("rejestracja:nazwisko_rej");
        //    System.out.println("nazwisko_rej = " + nazwisko_rej);
        String login_rej = request.getParameter("rejestracja:login_rej");
        //      System.out.println("login_rej = " + login_rej);
        String haslo_rej = request.getParameter("rejestracja:haslo_rej");
        //    System.out.println("haslo_rej = " + haslo_rej);
        String powtorzhaslo_rej = request.getParameter("rejestracja:powtorzhaslo_rej");
        //    System.out.println("powtorzhaslo_rej = " + powtorzhaslo_rej);
        String miasto_rej = request.getParameter("rejestracja:miasto_rej");
        //     System.out.println("miasto_rej = " + miasto_rej);
        String email_rej = request.getParameter("rejestracja:email_rej");
        //     System.out.println("email_rej = " + email_rej);

        String kod_rej = request.getParameter("rejestracja:kod_rej");
        //    System.out.println("kod_rej = " + kod_rej);
        String ulica_rej = request.getParameter("rejestracja:ulica_rej");
        //    System.out.println("ulica_rej = " + ulica_rej);

        String profile_date_year = request.getParameter("rejestracja:profile_date_year");
        //  System.out.println("profile_date_year = " + profile_date_year);
        int rok = Integer.parseInt(profile_date_year);
        String profile_date_month = request.getParameter("rejestracja:profile_date_month");
        //   System.out.println("profile_date_month = " + profile_date_month);
        int miesiac = Integer.parseInt(profile_date_month);
        String profile_date_day = request.getParameter("rejestracja:profile_date_day");
        //   System.out.println("profile_date_day = " + profile_date_day);
        int dzien = Integer.parseInt(profile_date_day);

        Date date2 = new GregorianCalendar(rok, miesiac - 1, dzien).getTime();
        // System.out.println("data = " + date2);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date3 = formatter.format(date2);
        //System.out.println("data = " + date3);
        String plec_rej = request.getParameter("rejestracja:plec_rej");
        //     System.out.println("plec_rej = " + plec_rej)

        if (plec_rej.equalsIgnoreCase("true") || plec_rej.equalsIgnoreCase("false")) {
            plecbool = Boolean.valueOf(plec_rej);
        } else {
            plecbool = false;
            System.out.println("error ");
        }

        java.sql.Date sqlDate2 = java.sql.Date.valueOf(date3);
        //   System.out.println("data = " + sqlDate2);

        int i = 0;
        if ((haslo_rej).equals(powtorzhaslo_rej)) {

            Connection con = null;
            PreparedStatement ps = null;

            try {

                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "INSERT INTO uzytkownicy(login, haslo, email, imie, nazwisko, dataurodzenia, kodpocztowy, miasto, ulica, idroli, zgloszony, plec ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, login_rej);
                    ps.setString(2, haslo_rej);
                    ps.setString(3, email_rej);
                    ps.setString(4, imie_rej);
                    ps.setString(5, nazwisko_rej);
                    ps.setDate(6, sqlDate2);
                    ps.setString(7, kod_rej);
                    ps.setString(8, miasto_rej);
                    ps.setString(9, ulica_rej);
                    ps.setInt(10, 2);
                    ps.setBoolean(11, false);
                    ps.setBoolean(12, plecbool);

                    i = ps.executeUpdate();
                    System.out.println("Dodano uzytkownika");
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    con.close();
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (i > 0) {
            return "sukces";
        } else {
            return "blad";
        }

        // return null;
    }

    public String zarejestruj2() {

        boolean plecbool;

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String imie_rej = request.getParameter("rejestracja:imie_rej");
        //    System.out.println("imie_rej = " + imie_rej);
        String nazwisko_rej = request.getParameter("rejestracja:nazwisko_rej");
        //    System.out.println("nazwisko_rej = " + nazwisko_rej);
        String login_rej = request.getParameter("rejestracja:login_rej");
        //      System.out.println("login_rej = " + login_rej);
        String haslo_rej = request.getParameter("rejestracja:haslo_rej");
        //    System.out.println("haslo_rej = " + haslo_rej);
        String powtorzhaslo_rej = request.getParameter("rejestracja:powtorzhaslo_rej");
        //    System.out.println("powtorzhaslo_rej = " + powtorzhaslo_rej);
        String miasto_rej = request.getParameter("rejestracja:miasto_rej");
        //     System.out.println("miasto_rej = " + miasto_rej);
        String email_rej = request.getParameter("rejestracja:email_rej");
        //     System.out.println("email_rej = " + email_rej);

        String kod_rej = request.getParameter("rejestracja:kod_rej");
        //    System.out.println("kod_rej = " + kod_rej);
        String ulica_rej = request.getParameter("rejestracja:ulica_rej");
        //    System.out.println("ulica_rej = " + ulica_rej);

//        String profile_date_year = request.getParameter("rejestracja:profile_date_year");
//        //  System.out.println("profile_date_year = " + profile_date_year);
//        int rok = Integer.parseInt(profile_date_year);
//        String profile_date_month = request.getParameter("rejestracja:profile_date_month");
//        //   System.out.println("profile_date_month = " + profile_date_month);
//        int miesiac = Integer.parseInt(profile_date_month);
//        String profile_date_day = request.getParameter("rejestracja:profile_date_day");
//        //   System.out.println("profile_date_day = " + profile_date_day);
//        int dzien = Integer.parseInt(profile_date_day);
//
//        Date date2 = new GregorianCalendar(rok, miesiac - 1, dzien).getTime();
//        // System.out.println("data = " + date2);
//
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date3 = formatter.format(getDataurodzenia());
        //System.out.println("data = " + date3);
        //String plec_rej = request.getParameter("rejestracja:plec_rej");
        //     System.out.println("plec_rej = " + plec_rej)

//        if (plec_rej.equalsIgnoreCase("true") || plec_rej.equalsIgnoreCase("false")) {
//            plecbool = Boolean.valueOf(plec_rej);
//        } else {
//            plecbool = false;
//            System.out.println("error ");
//        }
        java.sql.Date sqlDate2 = java.sql.Date.valueOf(date3);
        //   System.out.println("data = " + sqlDate2);

        int i = 0;
        if ((haslo_rej).equals(powtorzhaslo_rej)) {

            Connection con = null;
            PreparedStatement ps = null;

            try {

                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "INSERT INTO uzytkownicy(login, haslo, email, imie, nazwisko, dataurodzenia, kodpocztowy, miasto, ulica, idroli, zgloszony, plec ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, login_rej);
                    ps.setString(2, haslo_rej);
                    ps.setString(3, email_rej);
                    ps.setString(4, imie_rej);
                    ps.setString(5, nazwisko_rej);
                    ps.setDate(6, sqlDate2);
                    ps.setString(7, kod_rej);
                    ps.setString(8, miasto_rej);
                    ps.setString(9, ulica_rej);
                    ps.setInt(10, 2);
                    ps.setBoolean(11, false);
                    ps.setBoolean(12, isPlec());
                    login_rej="";
                    
                    i = ps.executeUpdate();
                    System.out.println("Dodano uzytkownika");
                    FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Dodany użytkownika",
                            "Rejestracja utworzona pomyślnie"
                           ));
                }

            } catch (Exception e) {
                  FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Podaj poprawne dane",
                            "Wpisz poprawne dane"));
            } finally {
                try {
                    con.close();
                    ps.close();
                } catch (Exception e) {
                     FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Podaj poprawne dane",
                            "Wpisz poprawne dane"));
                }
            }
        }
        if (i > 0) {
            return "sukces";
        } else {
            return "blad";
        }

        // return null;
    }

    public String aktualizujProfil() {

        boolean plecbool1;

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
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
        String miasto1 = request.getParameter("formaImie:miasto1");
        System.out.println("miasto1 = " + miasto1);

        String plec1 = request.getParameter("formaImie:plec1");
        //     System.out.println("plec_rej = " + plec_rej)

        if (plec1.equalsIgnoreCase("true") || plec1.equalsIgnoreCase("false")) {
            plecbool1 = Boolean.valueOf(plec1);
        } else {
            plecbool1 = false;
            System.out.println("error ");
        }

        String profile_date_year = request.getParameter("formaImie:profile_date_year");
        //  System.out.println("profile_date_year = " + profile_date_year);
        int rok = Integer.parseInt(profile_date_year);
        String profile_date_month = request.getParameter("formaImie:profile_date_month");
        //   System.out.println("profile_date_month = " + profile_date_month);
        int miesiac = Integer.parseInt(profile_date_month);
        String profile_date_day = request.getParameter("formaImie:profile_date_day");
        //   System.out.println("profile_date_day = " + profile_date_day);
        int dzien = Integer.parseInt(profile_date_day);

        Date date2 = new GregorianCalendar(rok, miesiac - 1, dzien).getTime();
        // System.out.println("data = " + date2);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date3 = formatter.format(date2);
        //System.out.println("data = " + date3);

        java.sql.Date sqlDate3 = java.sql.Date.valueOf(date3);

        String starehaslo = request.getParameter("formaImie:starehaslo");
        System.out.println("starehaslo = " + starehaslo);

        String nowehaslo = request.getParameter("formaImie:nowehaslo");
        System.out.println("miasnowehasloto1 = " + nowehaslo);

        String nowehaslo1 = request.getParameter("formaImie:nowehaslo1");
        System.out.println("nowehaslo1 = " + nowehaslo1);

        // String txtAnotherProperty= request.getParameter("txtAnotherProperty");
        //    System.out.println("txtAnotherProperty = " + txtAnotherProperty);
        // String noweimie = (FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderValuesMap().get("noweimie")).toString();
        //  System.out.println( "Nowe imie to "+ noweimie);
        //    imie = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("imie");
        //    System.out.println("Imie = " + imie);
        //    System.out.println("Nazwisko = " + nazwisko);
        //    System.out.println("User = " + user);
        //   Map<String, String> map = FacesContext.getCurrentInstance().getRequestParameterMap();
        //   String imie1 = map.get("imienazwisko:First_name");
        // String nazwisko1 = map.get("imienazwisko:Last_name");
        // String noweimie = (FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderValuesMap().get("noweimie")).toString();
        //  System.out.println( "Nowe imie to "+ noweimie);
        Connection con = null;
        PreparedStatement ps = null;

        if (nowehaslo.equals("")) {

            try {
                con = DataConnect.getConnection();
                ps = con.prepareStatement("UPDATE uzytkownicy SET imie = ?, nazwisko = ?, email = ?, kodpocztowy = ?, ulica = ?, miasto = ?, plec = ?, dataurodzenia = ? WHERE login = ?");
                ps.setString(1, imie1);
                ps.setString(2, nazwisko1);
                ps.setString(3, e_mail1);
                ps.setString(4, kod_pocztowy1);
                ps.setString(5, ulica1);
                ps.setString(6, miasto1);
                ps.setBoolean(7, plecbool1);
                ps.setDate(8, sqlDate3);
                ps.setString(9, user);
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.out.println("Error ->" + e.getMessage());
                return (null);
            }
        } else {
            try {
                con = DataConnect.getConnection();
                ps = con.prepareStatement("UPDATE uzytkownicy SET imie = ?, nazwisko = ?, email = ?, kodpocztowy = ?, ulica = ?, miasto = ?, plec = ?, dataurodzenia = ?, haslo = ? WHERE login = ?");
                ps.setString(1, imie1);
                ps.setString(2, nazwisko1);
                ps.setString(3, e_mail1);
                ps.setString(4, kod_pocztowy1);
                ps.setString(5, ulica1);
                ps.setString(6, miasto1);
                ps.setBoolean(7, plecbool1);
                ps.setDate(8, sqlDate3);
                ps.setString(9, nowehaslo);
                ps.setString(10, user);
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.out.println("Error ->" + e.getMessage());
                return (null);
            }
        }
        return null;
    }

    public String aktualizujProfil2() {

        boolean plecbool1;

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
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
        String miasto1 = request.getParameter("formaImie:miasto1");
        System.out.println("miasto1 = " + miasto1);

//        String plec1 = request.getParameter("formaImie:plec1");
//        //     System.out.println("plec_rej = " + plec_rej)
//
//        if (plec1.equalsIgnoreCase("true") || plec1.equalsIgnoreCase("false")) {
//            plecbool1 = Boolean.valueOf(plec1);
//        } else {
//            plecbool1 = false;
//            System.out.println("error ");
//        }
//        String profile_date_year = request.getParameter("formaImie:profile_date_year");
//        //  System.out.println("profile_date_year = " + profile_date_year);
//        int rok = Integer.parseInt(profile_date_year);
//        String profile_date_month = request.getParameter("formaImie:profile_date_month");
//        //   System.out.println("profile_date_month = " + profile_date_month);
//        int miesiac = Integer.parseInt(profile_date_month);
//        String profile_date_day = request.getParameter("formaImie:profile_date_day");
//        //   System.out.println("profile_date_day = " + profile_date_day);
//        int dzien = Integer.parseInt(profile_date_day);
//
        // System.out.println("data = " + date2);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(getDataurodzenia());
        Date date2 = new GregorianCalendar(gc.get(GregorianCalendar.YEAR), GregorianCalendar.MONTH - 1, GregorianCalendar.DAY_OF_MONTH).getTime();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date3 = formatter.format(date2);
        setDataurodzenia(date2);
        //System.out.println("data = " + date3);

        java.sql.Date sqlDate3 = java.sql.Date.valueOf(date3);

        String starehaslo = request.getParameter("formaImie:starehaslo");
        System.out.println("starehaslo = " + starehaslo);

        String nowehaslo = request.getParameter("formaImie:nowehaslo");
        System.out.println("miasnowehasloto1 = " + nowehaslo);

        String nowehaslo1 = request.getParameter("formaImie:nowehaslo1");
        System.out.println("nowehaslo1 = " + nowehaslo1);

        // String txtAnotherProperty= request.getParameter("txtAnotherProperty");
        //    System.out.println("txtAnotherProperty = " + txtAnotherProperty);
        // String noweimie = (FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderValuesMap().get("noweimie")).toString();
        //  System.out.println( "Nowe imie to "+ noweimie);
        //    imie = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("imie");
        //    System.out.println("Imie = " + imie);
        //    System.out.println("Nazwisko = " + nazwisko);
        //    System.out.println("User = " + user);
        //   Map<String, String> map = FacesContext.getCurrentInstance().getRequestParameterMap();
        //   String imie1 = map.get("imienazwisko:First_name");
        // String nazwisko1 = map.get("imienazwisko:Last_name");
        // String noweimie = (FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderValuesMap().get("noweimie")).toString();
        //  System.out.println( "Nowe imie to "+ noweimie);
        Connection con = null;
        PreparedStatement ps = null;

        if (nowehaslo.equals("")) {

            try {
                con = DataConnect.getConnection();
                ps = con.prepareStatement("UPDATE uzytkownicy SET imie = ?, nazwisko = ?, email = ?, kodpocztowy = ?, ulica = ?, miasto = ?, plec = ?, dataurodzenia = ? WHERE login = ?");
                ps.setString(1, imie1);
                ps.setString(2, nazwisko1);
                ps.setString(3, e_mail1);
                ps.setString(4, kod_pocztowy1);
                ps.setString(5, ulica1);
                ps.setString(6, miasto1);
                ps.setBoolean(7, isPlec());
                ps.setDate(8, sqlDate3);
                ps.setString(9, user);
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.out.println("Error ->" + e.getMessage());
                 FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "wpisz popraw dane",
                            "Wpisz poprawne dane"));
                return (null);
            }
        } else {
            try {
                con = DataConnect.getConnection();
                ps = con.prepareStatement("UPDATE uzytkownicy SET imie = ?, nazwisko = ?, email = ?, kodpocztowy = ?, ulica = ?, miasto = ?, plec = ?, dataurodzenia = ?, haslo = ? WHERE login = ?");
                ps.setString(1, imie1);
                ps.setString(2, nazwisko1);
                ps.setString(3, e_mail1);
                ps.setString(4, kod_pocztowy1);
                ps.setString(5, ulica1);
                ps.setString(6, miasto1);
                ps.setBoolean(7, isPlec());
                ps.setDate(8, sqlDate3);
                ps.setString(9, nowehaslo);
                ps.setString(10, user);
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.out.println("Error ->" + e.getMessage());
                 FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Popraw dane",
                            "Wpisz poprawne dane"));
                return (null);
            }
        }
        return null;
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
                    ps = con.prepareStatement("Select iduzytkownika, imie, nazwisko, email, plec, dataurodzenia, kodpocztowy, miasto, ulica, zgloszony from uzytkownicy where login = ?");
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
                        setZgloszony(rs.getBoolean("zgloszony"));
                        setIduzytkownika(rs.getInt("iduzytkownika"));
                        setUzytkownik(new Uzytkownicy(iduzytkownika, msg, miasto, email, imie, nazwisko, miasto, zgloszony, plec));
                        // setImieNazwisko(rs.getString("imie")+" "+rs.getString("nazwisko"));
                        found = true;
                    }
                    rs.close();
                } catch (Exception e) {

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
            setPwd("");

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
