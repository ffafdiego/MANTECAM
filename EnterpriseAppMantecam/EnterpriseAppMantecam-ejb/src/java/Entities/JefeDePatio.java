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
@Table(name = "jefe_de_patio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JefeDePatio.findAll", query = "SELECT j FROM JefeDePatio j"),
    @NamedQuery(name = "JefeDePatio.findByIdUsario", query = "SELECT j FROM JefeDePatio j WHERE j.idUsario = :idUsario"),
    @NamedQuery(name = "JefeDePatio.findByUsername", query = "SELECT j FROM JefeDePatio j WHERE j.username = :username"),
    @NamedQuery(name = "JefeDePatio.findByPass", query = "SELECT j FROM JefeDePatio j WHERE j.pass = :pass"),
    @NamedQuery(name = "JefeDePatio.findByNombreJpatio", query = "SELECT j FROM JefeDePatio j WHERE j.nombreJpatio = :nombreJpatio"),
    @NamedQuery(name = "JefeDePatio.findByApellidoJpatio", query = "SELECT j FROM JefeDePatio j WHERE j.apellidoJpatio = :apellidoJpatio"),
    @NamedQuery(name = "JefeDePatio.findByTelefonoJpatio", query = "SELECT j FROM JefeDePatio j WHERE j.telefonoJpatio = :telefonoJpatio")})
public class JefeDePatio implements Serializable {
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
    @Column(name = "NOMBRE_JPATIO")
    private String nombreJpatio;
    @Size(max = 1024)
    @Column(name = "APELLIDO_JPATIO")
    private String apellidoJpatio;
    @Size(max = 1024)
    @Column(name = "TELEFONO_JPATIO")
    private String telefonoJpatio;
    @JoinColumn(name = "ID_USARIO", referencedColumnName = "ID_USARIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public JefeDePatio() {
    }

    public JefeDePatio(Integer idUsario) {
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

    public String getNombreJpatio() {
        return nombreJpatio;
    }

    public void setNombreJpatio(String nombreJpatio) {
        this.nombreJpatio = nombreJpatio;
    }

    public String getApellidoJpatio() {
        return apellidoJpatio;
    }

    public void setApellidoJpatio(String apellidoJpatio) {
        this.apellidoJpatio = apellidoJpatio;
    }

    public String getTelefonoJpatio() {
        return telefonoJpatio;
    }

    public void setTelefonoJpatio(String telefonoJpatio) {
        this.telefonoJpatio = telefonoJpatio;
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
        if (!(object instanceof JefeDePatio)) {
            return false;
        }
        JefeDePatio other = (JefeDePatio) object;
        if ((this.idUsario == null && other.idUsario != null) || (this.idUsario != null && !this.idUsario.equals(other.idUsario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.JefeDePatio[ idUsario=" + idUsario + " ]";
    }
    
}
