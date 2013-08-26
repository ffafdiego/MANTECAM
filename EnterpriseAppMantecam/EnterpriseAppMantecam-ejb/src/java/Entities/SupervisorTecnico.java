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
@Table(name = "supervisor_tecnico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupervisorTecnico.findAll", query = "SELECT s FROM SupervisorTecnico s"),
    @NamedQuery(name = "SupervisorTecnico.findByIdUsario", query = "SELECT s FROM SupervisorTecnico s WHERE s.idUsario = :idUsario"),
    @NamedQuery(name = "SupervisorTecnico.findByUsername", query = "SELECT s FROM SupervisorTecnico s WHERE s.username = :username"),
    @NamedQuery(name = "SupervisorTecnico.findByPass", query = "SELECT s FROM SupervisorTecnico s WHERE s.pass = :pass"),
    @NamedQuery(name = "SupervisorTecnico.findByNombreSupervisor", query = "SELECT s FROM SupervisorTecnico s WHERE s.nombreSupervisor = :nombreSupervisor"),
    @NamedQuery(name = "SupervisorTecnico.findByApellidoSupervisor", query = "SELECT s FROM SupervisorTecnico s WHERE s.apellidoSupervisor = :apellidoSupervisor"),
    @NamedQuery(name = "SupervisorTecnico.findByTelefonoSupervisor", query = "SELECT s FROM SupervisorTecnico s WHERE s.telefonoSupervisor = :telefonoSupervisor")})
public class SupervisorTecnico implements Serializable {
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
    @Column(name = "NOMBRE_SUPERVISOR")
    private String nombreSupervisor;
    @Size(max = 1024)
    @Column(name = "APELLIDO_SUPERVISOR")
    private String apellidoSupervisor;
    @Size(max = 1024)
    @Column(name = "TELEFONO_SUPERVISOR")
    private String telefonoSupervisor;
    @JoinColumn(name = "ID_USARIO", referencedColumnName = "ID_USARIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public SupervisorTecnico() {
    }

    public SupervisorTecnico(Integer idUsario) {
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

    public String getNombreSupervisor() {
        return nombreSupervisor;
    }

    public void setNombreSupervisor(String nombreSupervisor) {
        this.nombreSupervisor = nombreSupervisor;
    }

    public String getApellidoSupervisor() {
        return apellidoSupervisor;
    }

    public void setApellidoSupervisor(String apellidoSupervisor) {
        this.apellidoSupervisor = apellidoSupervisor;
    }

    public String getTelefonoSupervisor() {
        return telefonoSupervisor;
    }

    public void setTelefonoSupervisor(String telefonoSupervisor) {
        this.telefonoSupervisor = telefonoSupervisor;
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
        if (!(object instanceof SupervisorTecnico)) {
            return false;
        }
        SupervisorTecnico other = (SupervisorTecnico) object;
        if ((this.idUsario == null && other.idUsario != null) || (this.idUsario != null && !this.idUsario.equals(other.idUsario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SupervisorTecnico[ idUsario=" + idUsario + " ]";
    }
    
}
