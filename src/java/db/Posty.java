/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "posty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posty.findAll", query = "SELECT p FROM Posty p")
    , @NamedQuery(name = "Posty.findByIdposta", query = "SELECT p FROM Posty p WHERE p.idposta = :idposta")
    , @NamedQuery(name = "Posty.findByTresc", query = "SELECT p FROM Posty p WHERE p.tresc = :tresc")
    , @NamedQuery(name = "Posty.findByDataposta", query = "SELECT p FROM Posty p WHERE p.dataposta = :dataposta")
    , @NamedQuery(name = "Posty.findByIdkommentarzposta", query = "SELECT p FROM Posty p WHERE p.idkommentarzposta = :idkommentarzposta")
    , @NamedQuery(name = "Posty.findByZgloszony", query = "SELECT p FROM Posty p WHERE p.zgloszony = :zgloszony")})
public class Posty implements Serializable, Comparable<Posty> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idposta")
    private Integer idposta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tresc")
    private String tresc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataposta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataposta;
    @Column(name = "idkommentarzposta")
    private Integer idkommentarzposta;
    @Column(name = "zgloszony")
    private Boolean zgloszony;
    @JoinColumn(name = "idgrupy", referencedColumnName = "idgrupy")
    @ManyToOne
    private Grupy idgrupy;
    @JoinColumn(name = "iduzytkownika", referencedColumnName = "iduzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy iduzytkownika;
    @OneToMany(mappedBy = "idposta")
    private Collection<Interakcje> interakcjeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idposta")
    private Collection<Powiadomieniaopostach> powiadomieniaopostachCollection;

    public Posty() {
    }

    public Posty(Integer idposta) {
        this.idposta = idposta;
    }

    public Posty(Integer idposta, String tresc, Date dataposta) {
        this.idposta = idposta;
        this.tresc = tresc;
        this.dataposta = dataposta;
    }

//    public Posty(String tresc, Date dataposta, Uzytkownicy iduzytkownika) {
//        this.tresc = tresc;
//        this.dataposta = dataposta;
//        this.iduzytkownika = iduzytkownika;
//    }
    public Integer getIdposta() {
        return idposta;
    }

    public void setIdposta(Integer idposta) {
        this.idposta = idposta;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Date getDataposta() {
        return dataposta;
    }

    public void setDataposta(Date dataposta) {
        this.dataposta = dataposta;
    }

    public Integer getIdkommentarzposta() {
        return idkommentarzposta;
    }

    public void setIdkommentarzposta(Integer idkommentarzposta) {
        this.idkommentarzposta = idkommentarzposta;
    }

    public Boolean getZgloszony() {
        return zgloszony;
    }

    public void setZgloszony(Boolean zgloszony) {
        this.zgloszony = zgloszony;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idposta != null ? idposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posty)) {
            return false;
        }
        Posty other = (Posty) object;
        if ((this.idposta == null && other.idposta != null) || (this.idposta != null && !this.idposta.equals(other.idposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Posty[ idposta=" + idposta + " ]";
    }

    @Override
    public int compareTo(Posty o) {
        if (this.dataposta.before(o.dataposta)) {
            return 1;
        } else {
            return -1;
        }
    }

}
