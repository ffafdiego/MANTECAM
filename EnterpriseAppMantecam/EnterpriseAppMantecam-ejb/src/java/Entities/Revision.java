/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "revision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revision.findAll", query = "SELECT r FROM Revision r"),
    @NamedQuery(name = "Revision.findByIdRevision", query = "SELECT r FROM Revision r WHERE r.idRevision = :idRevision"),
    @NamedQuery(name = "Revision.findByFechaRevision", query = "SELECT r FROM Revision r WHERE r.fechaRevision = :fechaRevision"),
    @NamedQuery(name = "Revision.findByTecnico",query ="SELECT r FROM Revision r JOIN r.idUsario t WHERE t.idUsario = :id"),
    @NamedQuery(name = "Revision.findByEstadoRevision", query = "SELECT r FROM Revision r WHERE r.estadoRevision = :estadoRevision")})
public class Revision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_REVISION")
    private Integer idRevision;
    @Column(name = "FECHA_REVISION")
    @Temporal(TemporalType.DATE)
    private Date fechaRevision;
    @Size(max = 1024)
    @Column(name = "ESTADO_REVISION")
    private String estadoRevision;
    @JoinColumn(name = "ID_USARIO", referencedColumnName = "ID_USARIO")
    @ManyToOne
    private TecnicoMecanico idUsario;
    @JoinColumn(name = "ID_VEHICULO", referencedColumnName = "ID_VEHICULO")
    @ManyToOne
    private Vehiculo idVehiculo;

    public Revision() {
    }

    public Revision(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Revision(Integer idRevision) {
        this.idRevision = idRevision;
    }

    public Integer getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(Integer idRevision) {
        this.idRevision = idRevision;
    }

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getEstadoRevision() {
        return estadoRevision;
    }

    public void setEstadoRevision(String estadoRevision) {
        this.estadoRevision = estadoRevision;
    }

    public TecnicoMecanico getIdUsario() {
        return idUsario;
    }

    public void setIdUsario(TecnicoMecanico idUsario) {
        this.idUsario = idUsario;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRevision != null ? idRevision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revision)) {
            return false;
        }
        Revision other = (Revision) object;
        if ((this.idRevision == null && other.idRevision != null) || (this.idRevision != null && !this.idRevision.equals(other.idRevision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Revision[ idRevision=" + idRevision + " ]";
    }
    
}
