/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZimnY
 */
@Entity
@Table(name = "znajomi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Znajomi.findAll", query = "SELECT z FROM Znajomi z")
    , @NamedQuery(name = "Znajomi.findByIdznajomosci", query = "SELECT z FROM Znajomi z WHERE z.idznajomosci = :idznajomosci")
    , @NamedQuery(name = "Znajomi.findByDataznajomosci", query = "SELECT z FROM Znajomi z WHERE z.dataznajomosci = :dataznajomosci")
    , @NamedQuery(name = "Znajomi.findByZaproszenie", query = "SELECT z FROM Znajomi z WHERE z.zaproszenie = :zaproszenie")})
public class Znajomi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idznajomosci")
    private Integer idznajomosci;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataznajomosci")
    @Temporal(TemporalType.DATE)
    private Date dataznajomosci;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zaproszenie")
    private boolean zaproszenie;
    @JoinColumn(name = "iduzytkownika", referencedColumnName = "iduzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy iduzytkownika;
    @JoinColumn(name = "idznajomego", referencedColumnName = "iduzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy idznajomego;

    public Znajomi() {
    }

    public Znajomi(Integer idznajomosci) {
        this.idznajomosci = idznajomosci;
    }

    public Znajomi(Integer idznajomosci, Date dataznajomosci, boolean zaproszenie) {
        this.idznajomosci = idznajomosci;
        this.dataznajomosci = dataznajomosci;
        this.zaproszenie = zaproszenie;
    }

    public Integer getIdznajomosci() {
        return idznajomosci;
    }

    public void setIdznajomosci(Integer idznajomosci) {
        this.idznajomosci = idznajomosci;
    }

    public Date getDataznajomosci() {
        return dataznajomosci;
    }

    public void setDataznajomosci(Date dataznajomosci) {
        this.dataznajomosci = dataznajomosci;
    }

    public boolean getZaproszenie() {
        return zaproszenie;
    }

    public void setZaproszenie(boolean zaproszenie) {
        this.zaproszenie = zaproszenie;
    }

    public Uzytkownicy getIduzytkownika() {
        return iduzytkownika;
    }

    public void setIduzytkownika(Uzytkownicy iduzytkownika) {
        this.iduzytkownika = iduzytkownika;
    }

    public Uzytkownicy getIdznajomego() {
        return idznajomego;
    }

    public void setIdznajomego(Uzytkownicy idznajomego) {
        this.idznajomego = idznajomego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idznajomosci != null ? idznajomosci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Znajomi)) {
            return false;
        }
        Znajomi other = (Znajomi) object;
        if ((this.idznajomosci == null && other.idznajomosci != null) || (this.idznajomosci != null && !this.idznajomosci.equals(other.idznajomosci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Znajomi[ idznajomosci=" + idznajomosci + " ]";
    }
    
}
