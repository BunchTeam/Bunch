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
@Table(name = "powiadomieniaopostach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Powiadomieniaopostach.findAll", query = "SELECT p FROM Powiadomieniaopostach p")
    , @NamedQuery(name = "Powiadomieniaopostach.findByIdpowiadomienia", query = "SELECT p FROM Powiadomieniaopostach p WHERE p.idpowiadomienia = :idpowiadomienia")
    , @NamedQuery(name = "Powiadomieniaopostach.findByDatapowiadomienia", query = "SELECT p FROM Powiadomieniaopostach p WHERE p.datapowiadomienia = :datapowiadomienia")})
public class Powiadomieniaopostach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpowiadomienia")
    private Integer idpowiadomienia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datapowiadomienia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datapowiadomienia;
    @JoinColumn(name = "idinterakcji", referencedColumnName = "idinterakcji")
    @ManyToOne
    private Interakcje idinterakcji;
    @JoinColumn(name = "idposta", referencedColumnName = "idposta")
    @ManyToOne(optional = false)
    private Posty idposta;
    @JoinColumn(name = "iduzytkownika", referencedColumnName = "iduzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy iduzytkownika;

    public Powiadomieniaopostach() {
    }

    public Powiadomieniaopostach(Integer idpowiadomienia) {
        this.idpowiadomienia = idpowiadomienia;
    }

    public Powiadomieniaopostach(Integer idpowiadomienia, Date datapowiadomienia) {
        this.idpowiadomienia = idpowiadomienia;
        this.datapowiadomienia = datapowiadomienia;
    }

    public Integer getIdpowiadomienia() {
        return idpowiadomienia;
    }

    public void setIdpowiadomienia(Integer idpowiadomienia) {
        this.idpowiadomienia = idpowiadomienia;
    }

    public Date getDatapowiadomienia() {
        return datapowiadomienia;
    }

    public void setDatapowiadomienia(Date datapowiadomienia) {
        this.datapowiadomienia = datapowiadomienia;
    }

    public Interakcje getIdinterakcji() {
        return idinterakcji;
    }

    public void setIdinterakcji(Interakcje idinterakcji) {
        this.idinterakcji = idinterakcji;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpowiadomienia != null ? idpowiadomienia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Powiadomieniaopostach)) {
            return false;
        }
        Powiadomieniaopostach other = (Powiadomieniaopostach) object;
        if ((this.idpowiadomienia == null && other.idpowiadomienia != null) || (this.idpowiadomienia != null && !this.idpowiadomienia.equals(other.idpowiadomienia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lib.Powiadomieniaopostach[ idpowiadomienia=" + idpowiadomienia + " ]";
    }
    
}
