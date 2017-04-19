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
@Table(name = "czatgrupowy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Czatgrupowy.findAll", query = "SELECT c FROM Czatgrupowy c")
    , @NamedQuery(name = "Czatgrupowy.findByIdczatgrupowy", query = "SELECT c FROM Czatgrupowy c WHERE c.idczatgrupowy = :idczatgrupowy")
    , @NamedQuery(name = "Czatgrupowy.findByTresc", query = "SELECT c FROM Czatgrupowy c WHERE c.tresc = :tresc")
    , @NamedQuery(name = "Czatgrupowy.findByDatawyslania", query = "SELECT c FROM Czatgrupowy c WHERE c.datawyslania = :datawyslania")})
public class Czatgrupowy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idczatgrupowy")
    private Integer idczatgrupowy;
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
    @JoinColumn(name = "idgrupy", referencedColumnName = "idgrupy")
    @ManyToOne(optional = false)
    private Grupy idgrupy;
    @JoinColumn(name = "idnadawcy", referencedColumnName = "iduzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy idnadawcy;

    public Czatgrupowy() {
    }

    public Czatgrupowy(Integer idczatgrupowy) {
        this.idczatgrupowy = idczatgrupowy;
    }

    public Czatgrupowy(Integer idczatgrupowy, String tresc, Date datawyslania) {
        this.idczatgrupowy = idczatgrupowy;
        this.tresc = tresc;
        this.datawyslania = datawyslania;
    }

    public Integer getIdczatgrupowy() {
        return idczatgrupowy;
    }

    public void setIdczatgrupowy(Integer idczatgrupowy) {
        this.idczatgrupowy = idczatgrupowy;
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

    public Grupy getIdgrupy() {
        return idgrupy;
    }

    public void setIdgrupy(Grupy idgrupy) {
        this.idgrupy = idgrupy;
    }

    public Uzytkownicy getIdnadawcy() {
        return idnadawcy;
    }

    public void setIdnadawcy(Uzytkownicy idnadawcy) {
        this.idnadawcy = idnadawcy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idczatgrupowy != null ? idczatgrupowy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Czatgrupowy)) {
            return false;
        }
        Czatgrupowy other = (Czatgrupowy) object;
        if ((this.idczatgrupowy == null && other.idczatgrupowy != null) || (this.idczatgrupowy != null && !this.idczatgrupowy.equals(other.idczatgrupowy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lib.Czatgrupowy[ idczatgrupowy=" + idczatgrupowy + " ]";
    }
    
}
