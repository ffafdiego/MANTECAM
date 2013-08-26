/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablitolog
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsario", query = "SELECT u FROM Usuario u WHERE u.idUsario = :idUsario"),
    @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username"),
    @NamedQuery(name = "Usuario.findByPass", query = "SELECT u FROM Usuario u WHERE u.pass = :pass")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USARIO")
    private Integer idUsario;
    @Size(max = 1024)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 1024)
    @Column(name = "PASS")
    private String pass;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private JefeDePlanta jefeDePlanta;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private SupervisorTecnico supervisorTecnico;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private TecnicoMecanico tecnicoMecanico;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private JefeDePatio jefeDePatio;
    @OneToMany(mappedBy = "idUsario")
    private Collection<Vehiculo> vehiculoCollection;

    public Usuario( String username, String pass) { 
        
        this.idUsario = null;
        this.username = username;
        this.pass = pass;
        this.jefeDePatio =getJefeDePatio();
        
    }

    public Usuario(){
    }
        
    public Usuario(Integer idUsario) {
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

    public JefeDePlanta getJefeDePlanta() {
        return jefeDePlanta;
    }

    public void setJefeDePlanta(JefeDePlanta jefeDePlanta) {
        this.jefeDePlanta = jefeDePlanta;
    }

    public SupervisorTecnico getSupervisorTecnico() {
        return supervisorTecnico;
    }

    public void setSupervisorTecnico(SupervisorTecnico supervisorTecnico) {
        this.supervisorTecnico = supervisorTecnico;
    }

    public TecnicoMecanico getTecnicoMecanico() {
        return tecnicoMecanico;
    }

    public void setTecnicoMecanico(TecnicoMecanico tecnicoMecanico) {
        this.tecnicoMecanico = tecnicoMecanico;
    }

    public JefeDePatio getJefeDePatio() {
        return jefeDePatio;
    }

    public void setJefeDePatio(JefeDePatio jefeDePatio) {
        this.jefeDePatio = jefeDePatio;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsario == null && other.idUsario != null) || (this.idUsario != null && !this.idUsario.equals(other.idUsario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Usuario[ idUsario=" + idUsario + " ]";
    }
    
}
