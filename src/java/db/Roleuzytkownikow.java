/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ZimnY
 */
@Entity
@Table(name = "roleuzytkownikow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roleuzytkownikow.findAll", query = "SELECT r FROM Roleuzytkownikow r")
    , @NamedQuery(name = "Roleuzytkownikow.findByIdroli", query = "SELECT r FROM Roleuzytkownikow r WHERE r.idroli = :idroli")
    , @NamedQuery(name = "Roleuzytkownikow.findByNazwa", query = "SELECT r FROM Roleuzytkownikow r WHERE r.nazwa = :nazwa")
    , @NamedQuery(name = "Roleuzytkownikow.findByPrzegladaniewszystkichpostow", query = "SELECT r FROM Roleuzytkownikow r WHERE r.przegladaniewszystkichpostow = :przegladaniewszystkichpostow")
    , @NamedQuery(name = "Roleuzytkownikow.findByEdytowaniewszystkichpostow", query = "SELECT r FROM Roleuzytkownikow r WHERE r.edytowaniewszystkichpostow = :edytowaniewszystkichpostow")
    , @NamedQuery(name = "Roleuzytkownikow.findByUsuwaniewszystkichpostow", query = "SELECT r FROM Roleuzytkownikow r WHERE r.usuwaniewszystkichpostow = :usuwaniewszystkichpostow")
    , @NamedQuery(name = "Roleuzytkownikow.findByPrzegladaniewszystkichgrup", query = "SELECT r FROM Roleuzytkownikow r WHERE r.przegladaniewszystkichgrup = :przegladaniewszystkichgrup")
    , @NamedQuery(name = "Roleuzytkownikow.findByUsuwaniewszystkichgrup", query = "SELECT r FROM Roleuzytkownikow r WHERE r.usuwaniewszystkichgrup = :usuwaniewszystkichgrup")
    , @NamedQuery(name = "Roleuzytkownikow.findByPrzegladaniewszystkichkont", query = "SELECT r FROM Roleuzytkownikow r WHERE r.przegladaniewszystkichkont = :przegladaniewszystkichkont")
    , @NamedQuery(name = "Roleuzytkownikow.findByUsuwaniewszystkichkont", query = "SELECT r FROM Roleuzytkownikow r WHERE r.usuwaniewszystkichkont = :usuwaniewszystkichkont")})
public class Roleuzytkownikow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idroli")
    private Integer idroli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nazwa")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "przegladaniewszystkichpostow")
    private boolean przegladaniewszystkichpostow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edytowaniewszystkichpostow")
    private boolean edytowaniewszystkichpostow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuwaniewszystkichpostow")
    private boolean usuwaniewszystkichpostow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "przegladaniewszystkichgrup")
    private boolean przegladaniewszystkichgrup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuwaniewszystkichgrup")
    private boolean usuwaniewszystkichgrup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "przegladaniewszystkichkont")
    private boolean przegladaniewszystkichkont;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuwaniewszystkichkont")
    private boolean usuwaniewszystkichkont;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idroli")
    private Collection<Uzytkownicy> uzytkownicyCollection;

    public Roleuzytkownikow() {
    }

    public Roleuzytkownikow(Integer idroli) {
        this.idroli = idroli;
    }

    public Roleuzytkownikow(Integer idroli, String nazwa, boolean przegladaniewszystkichpostow, boolean edytowaniewszystkichpostow, boolean usuwaniewszystkichpostow, boolean przegladaniewszystkichgrup, boolean usuwaniewszystkichgrup, boolean przegladaniewszystkichkont, boolean usuwaniewszystkichkont) {
        this.idroli = idroli;
        this.nazwa = nazwa;
        this.przegladaniewszystkichpostow = przegladaniewszystkichpostow;
        this.edytowaniewszystkichpostow = edytowaniewszystkichpostow;
        this.usuwaniewszystkichpostow = usuwaniewszystkichpostow;
        this.przegladaniewszystkichgrup = przegladaniewszystkichgrup;
        this.usuwaniewszystkichgrup = usuwaniewszystkichgrup;
        this.przegladaniewszystkichkont = przegladaniewszystkichkont;
        this.usuwaniewszystkichkont = usuwaniewszystkichkont;
    }

    public Integer getIdroli() {
        return idroli;
    }

    public void setIdroli(Integer idroli) {
        this.idroli = idroli;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public boolean getPrzegladaniewszystkichpostow() {
        return przegladaniewszystkichpostow;
    }

    public void setPrzegladaniewszystkichpostow(boolean przegladaniewszystkichpostow) {
        this.przegladaniewszystkichpostow = przegladaniewszystkichpostow;
    }

    public boolean getEdytowaniewszystkichpostow() {
        return edytowaniewszystkichpostow;
    }

    public void setEdytowaniewszystkichpostow(boolean edytowaniewszystkichpostow) {
        this.edytowaniewszystkichpostow = edytowaniewszystkichpostow;
    }

    public boolean getUsuwaniewszystkichpostow() {
        return usuwaniewszystkichpostow;
    }

    public void setUsuwaniewszystkichpostow(boolean usuwaniewszystkichpostow) {
        this.usuwaniewszystkichpostow = usuwaniewszystkichpostow;
    }

    public boolean getPrzegladaniewszystkichgrup() {
        return przegladaniewszystkichgrup;
    }

    public void setPrzegladaniewszystkichgrup(boolean przegladaniewszystkichgrup) {
        this.przegladaniewszystkichgrup = przegladaniewszystkichgrup;
    }

    public boolean getUsuwaniewszystkichgrup() {
        return usuwaniewszystkichgrup;
    }

    public void setUsuwaniewszystkichgrup(boolean usuwaniewszystkichgrup) {
        this.usuwaniewszystkichgrup = usuwaniewszystkichgrup;
    }

    public boolean getPrzegladaniewszystkichkont() {
        return przegladaniewszystkichkont;
    }

    public void setPrzegladaniewszystkichkont(boolean przegladaniewszystkichkont) {
        this.przegladaniewszystkichkont = przegladaniewszystkichkont;
    }

    public boolean getUsuwaniewszystkichkont() {
        return usuwaniewszystkichkont;
    }

    public void setUsuwaniewszystkichkont(boolean usuwaniewszystkichkont) {
        this.usuwaniewszystkichkont = usuwaniewszystkichkont;
    }

    @XmlTransient
    public Collection<Uzytkownicy> getUzytkownicyCollection() {
        return uzytkownicyCollection;
    }

    public void setUzytkownicyCollection(Collection<Uzytkownicy> uzytkownicyCollection) {
        this.uzytkownicyCollection = uzytkownicyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idroli != null ? idroli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roleuzytkownikow)) {
            return false;
        }
        Roleuzytkownikow other = (Roleuzytkownikow) object;
        if ((this.idroli == null && other.idroli != null) || (this.idroli != null && !this.idroli.equals(other.idroli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lib.Roleuzytkownikow[ idroli=" + idroli + " ]";
    }
    
}
