/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Entities.Trabajo;
import Entities.Vehiculo;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sessionbeans.TrabajoFacadeLocal;
import sessionbeans.VehiculoFacadeLocal;

/**
 *
 * @author Diego
 */
@Named(value = "managedBeanTrabajo")
@RequestScoped
public class ManagedBeanTrabajo {
    @EJB
    private VehiculoFacadeLocal vehiculoFacade;
    @EJB
    private TrabajoFacadeLocal trabajoFacade;    
    private String descripcion;
    private Date fechaTrabajo;
    private Date horaIngreso;
    private Date horaSalida;
    private String lugar;
    private String estadoTrabajo;
    private Vehiculo idVehiculo;
    private List<Vehiculo> vehiculos;
    private List<Trabajo> trabajos;
    private List<Trabajo> filtrado;
    private Integer auxiliar;
    private Vehiculo carro;

    
    @PostConstruct
    public void init(){
        trabajos =  trabajoFacade.findAll();
        vehiculos = trabajoFacade.obtenerVehiculos();
    }
    

    public Integer getAuxiliar() {
        return auxiliar;
    }

    public Vehiculo getCarro() {
        return carro;
    }

    public void setCarro(Vehiculo carro) {
        this.carro = carro;
    }

    public void setAuxiliar(Integer auxiliar) {
        this.auxiliar = auxiliar;
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public TrabajoFacadeLocal getTrabajoFacade() {
        return trabajoFacade;
    }

    public void setTrabajoFacade(TrabajoFacadeLocal trabajoFacade) {
        this.trabajoFacade = trabajoFacade;
    }

    public List<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(List<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }
    

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public void crearTrabajo(){
        Trabajo trabajo;
        trabajo = new Trabajo(descripcion, fechaTrabajo, horaIngreso, horaSalida, lugar, estadoTrabajo);
        Vehiculo car = new Vehiculo(auxiliar);
        trabajo.setIdVehiculo(car);
        trabajoFacade.create(trabajo);
                
    }    

    public ManagedBeanTrabajo() {
    }
}
