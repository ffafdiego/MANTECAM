/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Entities.Item;
import Entities.Tipoitem;
import Entities.Vehiculo;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Diego
 */
@Named(value = "managedBeanItem")
@RequestScoped
public class ManagedBeanItem {
    
    private String descripcionItem;
    private Date fecha;
    private Integer kilometrajeLimite;
    private Vehiculo idVehiculo;
    private Tipoitem idTipoitem;

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
            
    public ManagedBeanItem( ) {
    }
    
    
    public void nuevoItem(Vehiculo idCamion){
        Item item;
        item = new Item(descripcionItem, fecha, kilometrajeLimite);
        
          
    }
    
    
}
