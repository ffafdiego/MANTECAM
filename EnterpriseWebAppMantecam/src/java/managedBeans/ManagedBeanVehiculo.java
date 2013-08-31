/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Entities.Item;
import Entities.Tipoitem;
import Entities.Usuario;
import Entities.Vehiculo;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import sessionbeans.ItemFacadeLocal;
import sessionbeans.VehiculoFacadeLocal;

/**
 *
 * @author Pablitolog
 */
@Named(value = "managedBeanVehiculo")
@RequestScoped
public class ManagedBeanVehiculo {
    @EJB
    private ItemFacadeLocal itemFacade;
    @EJB
    private VehiculoFacadeLocal vehiculoFacade;
    private Usuario idUsario;
    private Integer idVehiculo;
    private Integer kilometraje_vehiculo, ano, hola;
    private String chofer, estado_vehiculo, modelo, marca, patente;
    private final static String[] estado_vehiculos;
    private Item item,aceite,afinamiento,freno,neumatico,amortiguacion,circuito;
    private List<Vehiculo> vehiculos;
    private Vehiculo auxiliar, camion;
    private Tipoitem tipoItem;   
    static{
        estado_vehiculos = new String[3];
        estado_vehiculos[0] = "No Disponible";
        estado_vehiculos[1] = "Disponible";
        estado_vehiculos[2] = "De Baja";   
    }
    
    public ManagedBeanVehiculo() {
    }
            
    
    @PostConstruct
    public void init(){
        vehiculos = vehiculoFacade.findAll();
    }
    
    public String[] getEstado_vehiculos(){
        return estado_vehiculos;    
    }
    
    public Integer getHola() {
        return hola;
    }

    public void setHola(Integer hola) {
        this.hola = hola;
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

    public Vehiculo getCamion() {
        return camion;
    }

    public void setCamion(Vehiculo camion) {
        this.camion = camion;
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

    public Vehiculo getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(Vehiculo auxiliar) {
        this.auxiliar = auxiliar;
    }

    public Integer getKilometraje_vehiculo() {
        return kilometraje_vehiculo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setKilometraje_vehiculo(Integer kilometraje_vehiculo) {
        this.kilometraje_vehiculo = kilometraje_vehiculo;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public String getEstado_vehiculo() {
        return estado_vehiculo;
    }

    public void setEstado_vehiculo(String estado_vehiculo) {
        this.estado_vehiculo = estado_vehiculo;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    
      public void nuevoVehiculo(){
       //Creando Vehículo
       Vehiculo vehiculo;
       vehiculo = new Vehiculo(patente, marca, modelo, ano, kilometraje_vehiculo, chofer, estado_vehiculo);
       idUsario = new Usuario(1);
       vehiculo.setIdUsario(idUsario);
       vehiculoFacade.create(vehiculo);
       Integer km = vehiculo.getKilometrajeVehiculo();
       auxiliar = new Vehiculo(vehiculo.getIdVehiculo());
       tipoItem = new Tipoitem(1);
       nuevoItem(auxiliar, km,tipoItem);
       tipoItem = new Tipoitem(2);
       nuevoItem(auxiliar, km,tipoItem);
       tipoItem = new Tipoitem(3);
       nuevoItem(auxiliar, km,tipoItem);
       tipoItem = new Tipoitem(4);
       nuevoItem(auxiliar, km,tipoItem);
       tipoItem = new Tipoitem(5);
       nuevoItem(auxiliar, km,tipoItem);
       tipoItem = new Tipoitem(6);
       nuevoItem(auxiliar, km,tipoItem);
       
          
       //id para crear items de vehículo cread 
       
      }
    
      public void nuevoItem(Vehiculo idV,Integer km,Tipoitem tipo){
      
      item = new Item("Nuevo", 0 , "Nuevito", null , km);
    
      java.util.Date fecha = new Date();
      item.setFecha(fecha);     
      item.setIdVehiculo(idV);
      item.setIdTipoitem(tipo);
      itemFacade.create(item);
      }
      
      public void editarChoferVehiculo(Integer idVehiculo){ 
      }
     
      
      public void mostrarMensaje(String men){
        FacesMessage msg = new FacesMessage(men);        
        FacesContext.getCurrentInstance().addMessage(null, msg);  
      
      }
      public void editarChofer(RowEditEvent event) {  
        Vehiculo vehiculo = (Vehiculo) event.getObject();
        vehiculoFacade.edit(vehiculo);                
        FacesMessage msg = new FacesMessage("Chofer Editado");        
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
      
        public void editarCamion(RowEditEvent event) {  
        Vehiculo vehiculo = (Vehiculo) event.getObject();
        vehiculoFacade.edit(vehiculo);        
        
        FacesMessage msg = new FacesMessage("Vehículo Editado");        
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("No se ha producido ningún cambio", ((Vehiculo) event.getObject()).getChofer());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  

   
}