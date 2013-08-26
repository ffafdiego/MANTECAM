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
 * @author Pablitolog
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByIdItem", query = "SELECT i FROM Item i WHERE i.idItem = :idItem"),
    @NamedQuery(name = "Item.findByDescripcionItem", query = "SELECT i FROM Item i WHERE i.descripcionItem = :descripcionItem"),
    @NamedQuery(name = "Item.findByFecha", query = "SELECT i FROM Item i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "Item.findByKilometrajeLimite", query = "SELECT i FROM Item i WHERE i.kilometrajeLimite = :kilometrajeLimite")})
public class Item implements Serializable {
    @Size(max = 1024)
    @Column(name = "ESTADO_ITEM")
    private String estadoItem;
    @Column(name = "CANTIDAD_REVISIONES")
    private Integer cantidadRevisiones;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ITEM")
    private Integer idItem;
    @Size(max = 1024)
    @Column(name = "DESCRIPCION_ITEM")
    private String descripcionItem;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "KILOMETRAJE_LIMITE")
    private Integer kilometrajeLimite;
    @JoinColumn(name = "ID_VEHICULO", referencedColumnName = "ID_VEHICULO")
    @ManyToOne
    private Vehiculo idVehiculo;
    @JoinColumn(name = "ID_TIPOITEM", referencedColumnName = "ID_TIPOITEM")
    @ManyToOne
    private Tipoitem idTipoitem;

    public Item(String estadoItem, Integer cantidadRevisiones, String descripcionItem, Date fecha, Integer kilometrajeLimite) {
        this.estadoItem = estadoItem;
        this.cantidadRevisiones = cantidadRevisiones;
        this.descripcionItem = descripcionItem;
        this.fecha = fecha;
        this.kilometrajeLimite = kilometrajeLimite;
    }

  
    public Item() {
    }

    public Item(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getDescripcionItem() {
        return descripcionItem;
    }

    public void setDescripcionItem(String descripcionItem) {
        this.descripcionItem = descripcionItem;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getKilometrajeLimite() {
        return kilometrajeLimite;
    }

    public void setKilometrajeLimite(Integer kilometrajeLimite) {
        this.kilometrajeLimite = kilometrajeLimite;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Tipoitem getIdTipoitem() {
        return idTipoitem;
    }

    public void setIdTipoitem(Tipoitem idTipoitem) {
        this.idTipoitem = idTipoitem;
    }
     public String getEstadoItem() {
        return estadoItem;
    }

    public void setEstadoItem(String estadoItem) {
        this.estadoItem = estadoItem;
    }

    public Integer getCantidadRevisiones() {
        return cantidadRevisiones;
    }

    public void setCantidadRevisiones(Integer cantidadRevisiones) {
        this.cantidadRevisiones = cantidadRevisiones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Item[ idItem=" + idItem + " ]";
    }

   
    
}
