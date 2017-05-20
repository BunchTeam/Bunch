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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ZimnY
 */
@Entity
@Table(name = "interakcje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interakcje.findAll", query = "SELECT i FROM Interakcje i")
    , @NamedQuery(name = "Interakcje.findByIdinterakcji", query = "SELECT i FROM Interakcje i WHERE i.idinterakcji = :idinterakcji")
    , @NamedQuery(name = "Interakcje.findByDatainterakcji", query = "SELECT i FROM Interakcje i WHERE i.datainterakcji = :datainterakcji")})
public class Interakcje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinterakcji")
    private Integer idinterakcji;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datainterakcji")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainterakcji;
    @JoinColumn(name = "idemocji", referencedColumnName = "idemocji")
    @ManyToOne(optional = false)
    private Emocje idemocji;
    @JoinColumn(name = "idposta", referencedColumnName = "idposta")
    @ManyToOne
    private Posty idposta;
    @JoinColumn(name = "iduzytkownika", referencedColumnName = "iduzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy iduzytkownika;
    @OneToMany(mappedBy = "idinterakcji")
    private Collection<Powiadomieniaopostach> powiadomieniaopostachCollection;

    public Interakcje() {
    }

    public Interakcje(Integer idinterakcji) {
        this.idinterakcji = idinterakcji;
    }

    public Interakcje(Integer idinterakcji, Date datainterakcji) {
        this.idinterakcji = idinterakcji;
        this.datainterakcji = datainterakcji;
    }

    public Integer getIdinterakcji() {
        return idinterakcji;
    }

    public void setIdinterakcji(Integer idinterakcji) {
        this.idinterakcji = idinterakcji;
    }

    public Date getDatainterakcji() {
        return datainterakcji;
    }

    public void setDatainterakcji(Date datainterakcji) {
        this.datainterakcji = datainterakcji;
    }

    public Emocje getIdemocji() {
        return idemocji;
    }

    public void setIdemocji(Emocje idemocji) {
        this.idemocji = idemocji;
    }

    public Posty getIdposta() {
        return idposta;
    }

    public void setIdposta(Posty idposta) {
        this.idposta = idposta;
    }

    public Uzytkownicy getIduzytkownika() {
        return iduzytkownika;
    }

    public void setIduzytkownika(Uzytkownicy iduzytkownika) {
        this.iduzytkownika = iduzytkownika;
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
        hash += (idinterakcji != null ? idinterakcji.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interakcje)) {
            return false;
        }
        Interakcje other = (Interakcje) object;
        if ((this.idinterakcji == null && other.idinterakcji != null) || (this.idinterakcji != null && !this.idinterakcji.equals(other.idinterakcji))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Interakcje[ idinterakcji=" + idinterakcji + " ]";
    }
    
}
