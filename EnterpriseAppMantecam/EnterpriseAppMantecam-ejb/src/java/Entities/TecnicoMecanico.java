/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "tecnico_mecanico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecnicoMecanico.findAll", query = "SELECT t FROM TecnicoMecanico t"),
    @NamedQuery(name = "TecnicoMecanico.findByIdUsario", query = "SELECT t FROM TecnicoMecanico t WHERE t.idUsario = :idUsario"),
    @NamedQuery(name = "TecnicoMecanico.findByIdTipoUsuario", query = "SELECT t FROM TecnicoMecanico t WHERE t.idTipoUsuario = :idTipoUsuario"),
    @NamedQuery(name = "TecnicoMecanico.findByUsername", query = "SELECT t FROM TecnicoMecanico t WHERE t.username = :username"),
    @NamedQuery(name = "TecnicoMecanico.findByPass", query = "SELECT t FROM TecnicoMecanico t WHERE t.pass = :pass"),
    @NamedQuery(name = "TecnicoMecanico.findByNombreTecnico", query = "SELECT t FROM TecnicoMecanico t WHERE t.nombreTecnico = :nombreTecnico"),
    @NamedQuery(name = "TecnicoMecanico.findByApellidoTecnico", query = "SELECT t FROM TecnicoMecanico t WHERE t.apellidoTecnico = :apellidoTecnico"),
    @NamedQuery(name = "TecnicoMecanico.findByTelefonoTecnico", query = "SELECT t FROM TecnicoMecanico t WHERE t.telefonoTecnico = :telefonoTecnico"),
    @NamedQuery(name = "TecnicoMecanico.findByEstadoTecnico", query = "SELECT t FROM TecnicoMecanico t WHERE t.estadoTecnico = :estadoTecnico")})
public class TecnicoMecanico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USARIO")
    private Integer idUsario;
    @Column(name = "ID_TIPO_USUARIO")
    private Integer idTipoUsuario;
    @Size(max = 1024)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 1024)
    @Column(name = "PASS")
    private String pass;
    @Size(max = 1024)
    @Column(name = "NOMBRE_TECNICO")
    private String nombreTecnico;
    @Size(max = 1024)
    @Column(name = "APELLIDO_TECNICO")
    private String apellidoTecnico;
    @Size(max = 1024)
    @Column(name = "TELEFONO_TECNICO")
    private String telefonoTecnico;
    @Size(max = 1024)
    @Column(name = "ESTADO_TECNICO")
    private String estadoTecnico;
    @OneToMany(mappedBy = "idUsario")
    private Collection<Revision> revisionCollection;
    @JoinColumn(name = "ID_USARIO", referencedColumnName = "ID_USARIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public TecnicoMecanico() {
    }

    public TecnicoMecanico(Integer idUsario) {
        this.idUsario = idUsario;
    }

    public Integer getIdUsario() {
        return idUsario;
    }

    public void setIdUsario(Integer idUsario) {
        this.idUsario = idUsario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
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

    public String getNombreTecnico() {
        return nombreTecnico;
    }

    public void setNombreTecnico(String nombreTecnico) {
        this.nombreTecnico = nombreTecnico;
    }

    public String getApellidoTecnico() {
        return apellidoTecnico;
    }

    public void setApellidoTecnico(String apellidoTecnico) {
        this.apellidoTecnico = apellidoTecnico;
    }

    public String getTelefonoTecnico() {
        return telefonoTecnico;
    }

    public void setTelefonoTecnico(String telefonoTecnico) {
        this.telefonoTecnico = telefonoTecnico;
    }

    public String getEstadoTecnico() {
        return estadoTecnico;
    }

    public void setEstadoTecnico(String estadoTecnico) {
        this.estadoTecnico = estadoTecnico;
    }

    @XmlTransient
    public Collection<Revision> getRevisionCollection() {
        return revisionCollection;
    }

    public void setRevisionCollection(Collection<Revision> revisionCollection) {
        this.revisionCollection = revisionCollection;
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
        if (!(object instanceof TecnicoMecanico)) {
            return false;
        }
        TecnicoMecanico other = (TecnicoMecanico) object;
        if ((this.idUsario == null && other.idUsario != null) || (this.idUsario != null && !this.idUsario.equals(other.idUsario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TecnicoMecanico[ idUsario=" + idUsario + " ]";
    }
    
}
