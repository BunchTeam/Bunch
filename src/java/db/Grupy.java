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
@Table(name = "grupy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupy.findAll", query = "SELECT g FROM Grupy g")
    , @NamedQuery(name = "Grupy.findByIdgrupy", query = "SELECT g FROM Grupy g WHERE g.idgrupy = :idgrupy")
    , @NamedQuery(name = "Grupy.findByNazwa", query = "SELECT g FROM Grupy g WHERE g.nazwa = :nazwa")})
public class Grupy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupy")
    private Integer idgrupy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nazwa")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrupy")
    private Collection<Uzytkownicygrup> uzytkownicygrupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrupy")
    private Collection<Czatgrupowy> czatgrupowyCollection;
    @OneToMany(mappedBy = "idgrupy")
    private Collection<Posty> postyCollection;

    public Grupy() {
    }

    public Grupy(Integer idgrupy) {
        this.idgrupy = idgrupy;
    }

    public Grupy(Integer idgrupy, String nazwa) {
        this.idgrupy = idgrupy;
        this.nazwa = nazwa;
    }

    public Integer getIdgrupy() {
        return idgrupy;
    }

    public void setIdgrupy(Integer idgrupy) {
        this.idgrupy = idgrupy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupy != null ? idgrupy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupy)) {
            return false;
        }
        Grupy other = (Grupy) object;
        if ((this.idgrupy == null && other.idgrupy != null) || (this.idgrupy != null && !this.idgrupy.equals(other.idgrupy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Grupy[ idgrupy=" + idgrupy + " ]";
    }
    
}
