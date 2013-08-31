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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByIdVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "Vehiculo.findByPatente", query = "SELECT v FROM Vehiculo v WHERE v.patente = :patente"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculo.findByAno", query = "SELECT v FROM Vehiculo v WHERE v.ano = :ano"),
    @NamedQuery(name = "Vehiculo.findByKilometrajeVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.kilometrajeVehiculo = :kilometrajeVehiculo"),
    @NamedQuery(name = "Vehiculo.findByChofer", query = "SELECT v FROM Vehiculo v WHERE v.chofer = :chofer"),
    @NamedQuery(name = "Vehiculo.findByEstadoVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.estadoVehiculo = :estadoVehiculo")})
public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VEHICULO")
    private Integer idVehiculo;
    @Size(max = 1024)
    @Column(name = "PATENTE")
    private String patente;
    @Size(max = 1024)
    @Column(name = "MARCA")
    private String marca;
    @Size(max = 1024)
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "ANO")
    private Integer ano;
    @Column(name = "KILOMETRAJE_VEHICULO")
    private Integer kilometrajeVehiculo;
    @Size(max = 1024)
    @Column(name = "CHOFER")
    private String chofer;
    @Size(max = 1024)
    @Column(name = "ESTADO_VEHICULO")
    private String estadoVehiculo;
    @OneToMany(mappedBy = "idVehiculo")
    private Collection<Revision> revisionCollection;
    @OneToMany(mappedBy = "idVehiculo")
    private Collection<Trabajo> trabajoCollection;
    @OneToMany(mappedBy = "idVehiculo")
    private Collection<Item> itemCollection;
    @JoinColumn(name = "ID_USARIO", referencedColumnName = "ID_USARIO")
    @ManyToOne
    private Usuario idUsario;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
 public Vehiculo(String patente, String marca, String modelo, Integer ano, Integer kilometrajeVehiculo, String chofer, String estadoVehiculo) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.kilometrajeVehiculo = kilometrajeVehiculo;
        this.chofer = chofer;
        this.estadoVehiculo = estadoVehiculo;
       
    }
    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getKilometrajeVehiculo() {
        return kilometrajeVehiculo;
    }

    public void setKilometrajeVehiculo(Integer kilometrajeVehiculo) {
        this.kilometrajeVehiculo = kilometrajeVehiculo;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    @XmlTransient
    public Collection<Revision> getRevisionCollection() {
        return revisionCollection;
    }

    public void setRevisionCollection(Collection<Revision> revisionCollection) {
        this.revisionCollection = revisionCollection;
    }

    @XmlTransient
    public Collection<Trabajo> getTrabajoCollection() {
        return trabajoCollection;
    }

    public void setTrabajoCollection(Collection<Trabajo> trabajoCollection) {
        this.trabajoCollection = trabajoCollection;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public Usuario getIdUsario() {
        return idUsario;
    }

    public void setIdUsario(Usuario idUsario) {
        this.idUsario = idUsario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Vehiculo[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
