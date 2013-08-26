/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablitolog
 */
@Entity
@Table(name = "jefe_de_planta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JefeDePlanta.findAll", query = "SELECT j FROM JefeDePlanta j"),
    @NamedQuery(name = "JefeDePlanta.findByIdUsario", query = "SELECT j FROM JefeDePlanta j WHERE j.idUsario = :idUsario"),
    @NamedQuery(name = "JefeDePlanta.findByUsername", query = "SELECT j FROM JefeDePlanta j WHERE j.username = :username"),
    @NamedQuery(name = "JefeDePlanta.findByPass", query = "SELECT j FROM JefeDePlanta j WHERE j.pass = :pass"),
    @NamedQuery(name = "JefeDePlanta.findByNombreJplanta", query = "SELECT j FROM JefeDePlanta j WHERE j.nombreJplanta = :nombreJplanta"),
    @NamedQuery(name = "JefeDePlanta.findByApellidoJplanta", query = "SELECT j FROM JefeDePlanta j WHERE j.apellidoJplanta = :apellidoJplanta"),
    @NamedQuery(name = "JefeDePlanta.findByTelefonoJplanta", query = "SELECT j FROM JefeDePlanta j WHERE j.telefonoJplanta = :telefonoJplanta")})
public class JefeDePlanta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USARIO")
    private Integer idUsario;
    @Size(max = 1024)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 1024)
    @Column(name = "PASS")
    private String pass;
    @Size(max = 1024)
    @Column(name = "NOMBRE_JPLANTA")
    private String nombreJplanta;
    @Size(max = 1024)
    @Column(name = "APELLIDO_JPLANTA")
    private String apellidoJplanta;
    @Size(max = 1024)
    @Column(name = "TELEFONO_JPLANTA")
    private String telefonoJplanta;
    @JoinColumn(name = "ID_USARIO", referencedColumnName = "ID_USARIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public JefeDePlanta() {
    }

    public JefeDePlanta(Integer idUsario) {
        this.idUsario = idUsario;
    }

    public Integer getIdUsario() {
        return idUsario;
    }

    public void setIdUsario(Integer idUsario) {
        this.idUsario = idUsario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombreJplanta() {
        return nombreJplanta;
    }

    public void setNombreJplanta(String nombreJplanta) {
        this.nombreJplanta = nombreJplanta;
    }

    public String getApellidoJplanta() {
        return apellidoJplanta;
    }

    public void setApellidoJplanta(String apellidoJplanta) {
        this.apellidoJplanta = apellidoJplanta;
    }

    public String getTelefonoJplanta() {
        return telefonoJplanta;
    }

    public void setTelefonoJplanta(String telefonoJplanta) {
        this.telefonoJplanta = telefonoJplanta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsario != null ? idUsario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JefeDePlanta)) {
            return false;
        }
        JefeDePlanta other = (JefeDePlanta) object;
        if ((this.idUsario == null && other.idUsario != null) || (this.idUsario != null && !this.idUsario.equals(other.idUsario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.JefeDePlanta[ idUsario=" + idUsario + " ]";
    }
    
}
