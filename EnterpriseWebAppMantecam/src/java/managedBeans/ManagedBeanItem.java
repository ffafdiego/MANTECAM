/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Entities.Item;
import Entities.Tipoitem;
import Entities.Vehiculo;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sessionbeans.ItemFacadeLocal;

/**
 *
 * @author Diego
 */
@Named(value = "managedBeanItem")
@RequestScoped
public class ManagedBeanItem {
    @EJB
    private ItemFacadeLocal itemFacade;
    
    private String descripcionItem;
    private Date fecha;
    private Integer kilometrajeLimite;
    private Vehiculo idVehiculo;
    private Tipoitem idTipoitem;
    private List<Item> items;
    
    
    
    public ManagedBeanItem( ) {
    }
    @PostConstruct
    public void init(){
        items = itemFacade.findAll();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
            
   
    
    public void nuevoItem(Vehiculo idCamion){
        Item item;
                 
    }
    
    public void detalleCamion(Vehiculo idVehiculo){
        
        
        
        
    }
    
    
}
