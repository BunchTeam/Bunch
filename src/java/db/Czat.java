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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZimnY
 */
@Entity
@Table(name = "czat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Czat.findAll", query = "SELECT c FROM Czat c")
    , @NamedQuery(name = "Czat.findByIdczat", query = "SELECT c FROM Czat c WHERE c.idczat = :idczat")
    , @NamedQuery(name = "Czat.findByTresc", query = "SELECT c FROM Czat c WHERE c.tresc = :tresc")
    , @NamedQuery(name = "Czat.findByDatawyslania", query = "SELECT c FROM Czat c WHERE c.datawyslania = :datawyslania")})
public class Czat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idczat")
    private Integer idczat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tresc")
    private String tresc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datawyslania")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datawyslania;
    @JoinColumn(name = "idnadawcy", referencedColumnName = "iduzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy idnadawcy;
    @JoinColumn(name = "idodbiorcy", referencedColumnName = "iduzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy idodbiorcy;

    public Czat() {
    }

    public Czat(Integer idczat) {
        this.idczat = idczat;
    }

    public Czat(Integer idczat, String tresc, Date datawyslania) {
        this.idczat = idczat;
        this.tresc = tresc;
        this.datawyslania = datawyslania;
    }

    public Integer getIdczat() {
        return idczat;
    }

    public void setIdczat(Integer idczat) {
        this.idczat = idczat;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Date getDatawyslania() {
        return datawyslania;
    }

    public void setDatawyslania(Date datawyslania) {
        this.datawyslania = datawyslania;
    }

    public Uzytkownicy getIdnadawcy() {
        return idnadawcy;
    }

    public void setIdnadawcy(Uzytkownicy idnadawcy) {
        this.idnadawcy = idnadawcy;
    }

    public Uzytkownicy getIdodbiorcy() {
        return idodbiorcy;
    }

    public void setIdodbiorcy(Uzytkownicy idodbiorcy) {
        this.idodbiorcy = idodbiorcy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idczat != null ? idczat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Czat)) {
            return false;
        }
        Czat other = (Czat) object;
        if ((this.idczat == null && other.idczat != null) || (this.idczat != null && !this.idczat.equals(other.idczat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lib.Czat[ idczat=" + idczat + " ]";
    }
    
}
