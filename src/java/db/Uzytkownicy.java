/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.jsf.dao.LoginDAO;
import com.jsf.util.DataConnect;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ZimnY
 */
@Entity
@Table(name = "uzytkownicy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uzytkownicy.findAll", query = "SELECT u FROM Uzytkownicy u")
    , @NamedQuery(name = "Uzytkownicy.findByIduzytkownika", query = "SELECT u FROM Uzytkownicy u WHERE u.iduzytkownika = :iduzytkownika")
    , @NamedQuery(name = "Uzytkownicy.findByLogin", query = "SELECT u FROM Uzytkownicy u WHERE u.login = :login")
    , @NamedQuery(name = "Uzytkownicy.findByHaslo", query = "SELECT u FROM Uzytkownicy u WHERE u.haslo = :haslo")
    , @NamedQuery(name = "Uzytkownicy.findByEmail", query = "SELECT u FROM Uzytkownicy u WHERE u.email = :email")
    , @NamedQuery(name = "Uzytkownicy.findByImie", query = "SELECT u FROM Uzytkownicy u WHERE u.imie = :imie")
    , @NamedQuery(name = "Uzytkownicy.findByNazwisko", query = "SELECT u FROM Uzytkownicy u WHERE u.nazwisko = :nazwisko")
    , @NamedQuery(name = "Uzytkownicy.findByDataurodzenia", query = "SELECT u FROM Uzytkownicy u WHERE u.dataurodzenia = :dataurodzenia")
    , @NamedQuery(name = "Uzytkownicy.findByKodpocztowy", query = "SELECT u FROM Uzytkownicy u WHERE u.kodpocztowy = :kodpocztowy")
    , @NamedQuery(name = "Uzytkownicy.findByMiasto", query = "SELECT u FROM Uzytkownicy u WHERE u.miasto = :miasto")
    , @NamedQuery(name = "Uzytkownicy.findByUlica", query = "SELECT u FROM Uzytkownicy u WHERE u.ulica = :ulica")
    , @NamedQuery(name = "Uzytkownicy.findByZgloszony", query = "SELECT u FROM Uzytkownicy u WHERE u.zgloszony = :zgloszony")
    , @NamedQuery(name = "Uzytkownicy.findByPlec", query = "SELECT u FROM Uzytkownicy u WHERE u.plec = :plec")})
public class Uzytkownicy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduzytkownika")
    private Integer iduzytkownika;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "haslo")
    private String haslo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "dataurodzenia")
    @Temporal(TemporalType.DATE)
    private Date dataurodzenia;
    @Size(max = 2147483647)
    @Column(name = "kodpocztowy")
    private String kodpocztowy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "miasto")
    private String miasto;
    @Size(max = 2147483647)
    @Column(name = "ulica")
    private String ulica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zgloszony")
    private boolean zgloszony;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plec")
    private boolean plec;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnadawcy")
    private Collection<Czat> czatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idodbiorcy")
    private Collection<Czat> czatCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduzytkownika")
    private Collection<Uzytkownicygrup> uzytkownicygrupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnadawcy")
    private Collection<Czatgrupowy> czatgrupowyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduzytkownika")
    private Collection<Posty> postyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduzytkownika")
    private Collection<Znajomi> znajomiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idznajomego")
    private Collection<Znajomi> znajomiCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduzytkownika")
    private Collection<Interakcje> interakcjeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduzytkownika")
    private Collection<Powiadomieniaopostach> powiadomieniaopostachCollection;
    @JoinColumn(name = "idroli", referencedColumnName = "idroli")
    @ManyToOne(optional = false)
    private Roleuzytkownikow idroli;
    


    
    

    public Uzytkownicy() {
    }

    public Uzytkownicy(Integer iduzytkownika) {
        this.iduzytkownika = iduzytkownika;
    }

    public Uzytkownicy(Integer iduzytkownika, String login, String haslo, String email, String imie, String nazwisko, String miasto, boolean zgloszony, boolean plec) {
        this.iduzytkownika = iduzytkownika;
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miasto = miasto;
        this.zgloszony = zgloszony;
        this.plec = plec;
    }

    public Integer getIduzytkownika() {
        return iduzytkownika;
    }

    public void setIduzytkownika(Integer iduzytkownika) {
        this.iduzytkownika = iduzytkownika;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    @XmlTransient
    public Collection<Czat> getCzatCollection() {
        return czatCollection;
    }

    public void setCzatCollection(Collection<Czat> czatCollection) {
        this.czatCollection = czatCollection;
    }

    @XmlTransient
    public Collection<Czat> getCzatCollection1() {
        return czatCollection1;
    }

    public void setCzatCollection1(Collection<Czat> czatCollection1) {
        this.czatCollection1 = czatCollection1;
    }

    @XmlTransient
    public Collection<Uzytkownicygrup> getUzytkownicygrupCollection() {
        return uzytkownicygrupCollection;
    }

    public void setUzytkownicygrupCollection(Collection<Uzytkownicygrup> uzytkownicygrupCollection) {
        this.uzytkownicygrupCollection = uzytkownicygrupCollection;
    }

    @XmlTransient
    public Collection<Czatgrupowy> getCzatgrupowyCollection() {
        return czatgrupowyCollection;
    }

    public void setCzatgrupowyCollection(Collection<Czatgrupowy> czatgrupowyCollection) {
        this.czatgrupowyCollection = czatgrupowyCollection;
    }

    @XmlTransient
    public Collection<Posty> getPostyCollection() {
        return postyCollection;
    }

    public void setPostyCollection(Collection<Posty> postyCollection) {
        this.postyCollection = postyCollection;
    }

    @XmlTransient
    public Collection<Znajomi> getZnajomiCollection() {
        return znajomiCollection;
    }

    public void setZnajomiCollection(Collection<Znajomi> znajomiCollection) {
        this.znajomiCollection = znajomiCollection;
    }

    @XmlTransient
    public Collection<Znajomi> getZnajomiCollection1() {
        return znajomiCollection1;
    }

    public void setZnajomiCollection1(Collection<Znajomi> znajomiCollection1) {
        this.znajomiCollection1 = znajomiCollection1;
    }

    @XmlTransient
    public Collection<Interakcje> getInterakcjeCollection() {
        return interakcjeCollection;
    }

    public void setInterakcjeCollection(Collection<Interakcje> interakcjeCollection) {
        this.interakcjeCollection = interakcjeCollection;
    }

    @XmlTransient
    public Collection<Powiadomieniaopostach> getPowiadomieniaopostachCollection() {
        return powiadomieniaopostachCollection;
    }

    public void setPowiadomieniaopostachCollection(Collection<Powiadomieniaopostach> powiadomieniaopostachCollection) {
        this.powiadomieniaopostachCollection = powiadomieniaopostachCollection;
    }

    public Roleuzytkownikow getIdroli() {
        return idroli;
    }

    public void setIdroli(Roleuzytkownikow idroli) {
        this.idroli = idroli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduzytkownika != null ? iduzytkownika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzytkownicy)) {
            return false;
        }
        Uzytkownicy other = (Uzytkownicy) object;
        if ((this.iduzytkownika == null && other.iduzytkownika != null) || (this.iduzytkownika != null && !this.iduzytkownika.equals(other.iduzytkownika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lib.Uzytkownicy[ iduzytkownika=" + iduzytkownika + " ]";
    }

   
    
}
