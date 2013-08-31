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
@Table(name = "tipoitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoitem.findAll", query = "SELECT t FROM Tipoitem t"),
    @NamedQuery(name = "Tipoitem.findByIdTipoitem", query = "SELECT t FROM Tipoitem t WHERE t.idTipoitem = :idTipoitem"),
    @NamedQuery(name = "Tipoitem.findByNombreItem", query = "SELECT t FROM Tipoitem t WHERE t.nombreItem = :nombreItem"),
    @NamedQuery(name = "Tipoitem.findByVidaUtil", query = "SELECT t FROM Tipoitem t WHERE t.vidaUtil = :vidaUtil")})
public class Tipoitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPOITEM")
    private Integer idTipoitem;
    @Size(max = 1024)
    @Column(name = "NOMBRE_ITEM")
    private String nombreItem;
    @Column(name = "VIDA_UTIL")
    private Integer vidaUtil;
    @OneToMany(mappedBy = "idTipoitem")
    private Collection<Item> itemCollection;

    public Tipoitem() {
    }

    public Tipoitem(Integer idTipoitem) {
        this.idTipoitem = idTipoitem;
    }

    public Integer getIdTipoitem() {
        return idTipoitem;
    }

    public void setIdTipoitem(Integer idTipoitem) {
        this.idTipoitem = idTipoitem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public Integer getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(Integer vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoitem != null ? idTipoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoitem)) {
            return false;
        }
        Tipoitem other = (Tipoitem) object;
        if ((this.idTipoitem == null && other.idTipoitem != null) || (this.idTipoitem != null && !this.idTipoitem.equals(other.idTipoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tipoitem[ idTipoitem=" + idTipoitem + " ]";
    }
    
}
