/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZimnY
 */
@Entity
@Table(name = "uzytkownicygrup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uzytkownicygrup.findAll", query = "SELECT u FROM Uzytkownicygrup u")
    , @NamedQuery(name = "Uzytkownicygrup.findByIduzytkownikagrupy", query = "SELECT u FROM Uzytkownicygrup u WHERE u.iduzytkownikagrupy = :iduzytkownikagrupy")
    , @NamedQuery(name = "Uzytkownicygrup.findByZaproszenie", query = "SELECT u FROM Uzytkownicygrup u WHERE u.zaproszenie = :zaproszenie")})
public class Uzytkownicygrup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduzytkownikagrupy")
    private Integer iduzytkownikagrupy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zaproszenie")
    private boolean zaproszenie;
    @JoinColumn(name = "idgrupy", referencedColumnName = "idgrupy")
    @ManyToOne(optional = false)
    private Grupy idgrupy;
    @JoinColumn(name = "iduzytkownika", referencedColumnName = "iduzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy iduzytkownika;

    public Uzytkownicygrup() {
    }

    public Uzytkownicygrup(Integer iduzytkownikagrupy) {
        this.iduzytkownikagrupy = iduzytkownikagrupy;
    }

    public Uzytkownicygrup(Integer iduzytkownikagrupy, boolean zaproszenie) {
        this.iduzytkownikagrupy = iduzytkownikagrupy;
        this.zaproszenie = zaproszenie;
    }

    public Integer getIduzytkownikagrupy() {
        return iduzytkownikagrupy;
    }

    public void setIduzytkownikagrupy(Integer iduzytkownikagrupy) {
        this.iduzytkownikagrupy = iduzytkownikagrupy;
    }

    public boolean getZaproszenie() {
        return zaproszenie;
    }

    public void setZaproszenie(boolean zaproszenie) {
        this.zaproszenie = zaproszenie;
    }

    public Grupy getIdgrupy() {
        return idgrupy;
    }

    public void setIdgrupy(Grupy idgrupy) {
        this.idgrupy = idgrupy;
    }

    public Uzytkownicy getIduzytkownika() {
        return iduzytkownika;
    }

    public void setIduzytkownika(Uzytkownicy iduzytkownika) {
        this.iduzytkownika = iduzytkownika;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduzytkownikagrupy != null ? iduzytkownikagrupy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzytkownicygrup)) {
            return false;
        }
        Uzytkownicygrup other = (Uzytkownicygrup) object;
        if ((this.iduzytkownikagrupy == null && other.iduzytkownikagrupy != null) || (this.iduzytkownikagrupy != null && !this.iduzytkownikagrupy.equals(other.iduzytkownikagrupy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lib.Uzytkownicygrup[ iduzytkownikagrupy=" + iduzytkownikagrupy + " ]";
    }
    
}
