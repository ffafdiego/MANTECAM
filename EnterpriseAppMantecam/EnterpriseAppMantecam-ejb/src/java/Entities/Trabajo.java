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
@Table(name = "trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajo.findAll", query = "SELECT t FROM Trabajo t"),
    @NamedQuery(name = "Trabajo.findByIdTrabajo", query = "SELECT t FROM Trabajo t WHERE t.idTrabajo = :idTrabajo"),
    @NamedQuery(name = "Trabajo.findByDescripcion", query = "SELECT t FROM Trabajo t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Trabajo.findByFechaTrabajo", query = "SELECT t FROM Trabajo t WHERE t.fechaTrabajo = :fechaTrabajo"),
    @NamedQuery(name = "Trabajo.findByHoraIngreso", query = "SELECT t FROM Trabajo t WHERE t.horaIngreso = :horaIngreso"),
    @NamedQuery(name = "Trabajo.findByHoraSalida", query = "SELECT t FROM Trabajo t WHERE t.horaSalida = :horaSalida"),
    @NamedQuery(name = "Trabajo.findByLugar", query = "SELECT t FROM Trabajo t WHERE t.lugar = :lugar"),
    @NamedQuery(name = "Trabajo.findByEstadoTrabajo", query = "SELECT t FROM Trabajo t WHERE t.estadoTrabajo = :estadoTrabajo")})
public class Trabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TRABAJO")
    private Integer idTrabajo;
    @Size(max = 1024)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA_TRABAJO")
    @Temporal(TemporalType.DATE)
    private Date fechaTrabajo;
    @Column(name = "HORA_INGRESO")
    @Temporal(TemporalType.TIME)
    private Date horaIngreso;
    @Column(name = "HORA_SALIDA")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @Size(max = 1024)
    @Column(name = "LUGAR")
    private String lugar;
    @Size(max = 1024)
    @Column(name = "ESTADO_TRABAJO")
    private String estadoTrabajo;
    @JoinColumn(name = "ID_VEHICULO", referencedColumnName = "ID_VEHICULO")
    @ManyToOne
    private Vehiculo idVehiculo;

    public Trabajo() {
    }

    public Trabajo(Integer idTrabajo) {
        this.idTrabajo = idTrabajo;
    }
    public Trabajo(String descripcion, Date fechaTrabajo, Date horaIngreso, Date horaSalida, String lugar, String estadoTrabajo) {
        this.descripcion = descripcion;
        this.fechaTrabajo = fechaTrabajo;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.lugar = lugar;
        this.estadoTrabajo = estadoTrabajo;
       
    }

    public Integer getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(Integer idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaTrabajo() {
        return fechaTrabajo;
    }

    public void setFechaTrabajo(Date fechaTrabajo) {
        this.fechaTrabajo = fechaTrabajo;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getEstadoTrabajo() {
        return estadoTrabajo;
    }

    public void setEstadoTrabajo(String estadoTrabajo) {
        this.estadoTrabajo = estadoTrabajo;
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
        hash += (idTrabajo != null ? idTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajo)) {
            return false;
        }
        Trabajo other = (Trabajo) object;
        if ((this.idTrabajo == null && other.idTrabajo != null) || (this.idTrabajo != null && !this.idTrabajo.equals(other.idTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Trabajo[ idTrabajo=" + idTrabajo + " ]";
    }
    
}
