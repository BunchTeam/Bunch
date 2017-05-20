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
@Table(name = "emocje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emocje.findAll", query = "SELECT e FROM Emocje e")
    , @NamedQuery(name = "Emocje.findByIdemocji", query = "SELECT e FROM Emocje e WHERE e.idemocji = :idemocji")
    , @NamedQuery(name = "Emocje.findByNazwa", query = "SELECT e FROM Emocje e WHERE e.nazwa = :nazwa")
    , @NamedQuery(name = "Emocje.findByIndeksemocji", query = "SELECT e FROM Emocje e WHERE e.indeksemocji = :indeksemocji")
    , @NamedQuery(name = "Emocje.findByEmoji", query = "SELECT e FROM Emocje e WHERE e.emoji = :emoji")})
public class Emocje implements Serializable, Comparable<Emocje> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idemocji")
    private Integer idemocji;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nazwa")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indeksemocji")
    private int indeksemocji;
    @Size(max = 2147483647)
    @Column(name = "emoji")
    private String emoji;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idemocji")
    private Collection<Interakcje> interakcjeCollection;

    public Emocje() {
    }

    public Emocje(Integer idemocji) {
        this.idemocji = idemocji;
    }

    public Emocje(Integer idemocji, String nazwa, int indeksemocji) {
        this.idemocji = idemocji;
        this.nazwa = nazwa;
        this.indeksemocji = indeksemocji;
    }

    public Integer getIdemocji() {
        return idemocji;
    }

    public void setIdemocji(Integer idemocji) {
        this.idemocji = idemocji;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getIndeksemocji() {
        return indeksemocji;
    }

    public void setIndeksemocji(int indeksemocji) {
        this.indeksemocji = indeksemocji;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    @XmlTransient
    public Collection<Interakcje> getInterakcjeCollection() {
        return interakcjeCollection;
    }

    public void setInterakcjeCollection(Collection<Interakcje> interakcjeCollection) {
        this.interakcjeCollection = interakcjeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idemocji != null ? idemocji.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emocje)) {
            return false;
        }
        Emocje other = (Emocje) object;
        if ((this.idemocji == null && other.idemocji != null) || (this.idemocji != null && !this.idemocji.equals(other.idemocji))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Emocje[ idemocji=" + idemocji + " ]";
    }

    @Override
    public int compareTo(Emocje o) {
            return this.idemocji.compareTo(o.idemocji);
    }
    
}
