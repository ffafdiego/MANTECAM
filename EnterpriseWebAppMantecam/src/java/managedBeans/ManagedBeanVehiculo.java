/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Entities.Item;
import Entities.Revision;
import Entities.Tipoitem;
import Entities.Usuario;
import Entities.Vehiculo;
import java.awt.event.ActionEvent;
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
import sessionbeans.RevisionFacadeLocal;
import sessionbeans.TipoitemFacadeLocal;
import sessionbeans.VehiculoFacadeLocal;

/**
 *
 * @author Pablitolog
 */
@Named(value = "managedBeanVehiculo")
@RequestScoped
public class ManagedBeanVehiculo {

    @EJB
    private RevisionFacadeLocal revisionFacade;
    @EJB
    private TipoitemFacadeLocal tipoitemFacade;
    @EJB
    private ItemFacadeLocal itemFacade;
    @EJB
    private VehiculoFacadeLocal vehiculoFacade;
    private Usuario idUsario;
    private Integer kilometraje_vehiculo, ano, hola, idVehiculo;
    private String chofer, estado_vehiculo, modelo, marca, patente;
    private final static String[] estado_vehiculos;
    private Item item;
    private List<Vehiculo> vehiculos;
    private Vehiculo auxiliar, camion, seleccionado;
    private Tipoitem tipoItem;

    static {
        estado_vehiculos = new String[2];
        estado_vehiculos[0] = "Disponible";
        estado_vehiculos[1] = "No Disponible";
    }

    public ManagedBeanVehiculo() {
    }

    @PostConstruct
    public void init() {
        vehiculos = vehiculoFacade.findAll();
        kilometraje_vehiculo = 0;
    }

    public String[] getEstado_vehiculos() {
        return estado_vehiculos;
    }

    public Vehiculo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Vehiculo seleccionado) {
        this.seleccionado = seleccionado;
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

    public void agregarKm(Integer id, Integer km) {
        System.out.println(id);
        camion = vehiculoFacade.find(id);
        camion.setKilometrajeVehiculo(camion.getKilometrajeVehiculo() + km);
        if (itemFacade.revisarKmPiezas(camion) == 1) {
            camion.setEstadoVehiculo("No Disponible");
            Revision revision;
            revision = new Revision(camion);
            java.util.Date fecha = new Date();
            revision.setFechaRevision(fecha);
            revision.setEstadoRevision("Revisar");
            revisionFacade.create(revision);

        }
        vehiculoFacade.edit(camion);
    }

    public void nuevoVehiculo() {
        //Creando Vehículo
        Vehiculo vehiculo;
        vehiculo = new Vehiculo(patente, marca, modelo, ano, kilometraje_vehiculo, chofer, estado_vehiculo);
        if (kilometraje_vehiculo < 0 ) {



            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se ha podido ingresar el vehículo", "Kilometraje debe ser mayor a 0");
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);



        } else {
            idUsario = new Usuario(1);
            vehiculo.setIdUsario(idUsario);
            vehiculoFacade.create(vehiculo);
            Integer km = vehiculo.getKilometrajeVehiculo();
            auxiliar = new Vehiculo(vehiculo.getIdVehiculo());
            tipoItem = new Tipoitem(1);
            Tipoitem tipo = tipoitemFacade.find(1);
            Integer km_pieza = tipo.getVidaUtil();
            nuevoItem(auxiliar, km_pieza + km, tipoItem);
            tipoItem = new Tipoitem(2);
            tipo = tipoitemFacade.find(2);
            km_pieza = tipo.getVidaUtil();
            nuevoItem(auxiliar, km_pieza + km, tipoItem);

            tipoItem = new Tipoitem(3);
            tipo = tipoitemFacade.find(3);
            km_pieza = tipo.getVidaUtil();
            nuevoItem(auxiliar, km_pieza + km, tipoItem);

            tipoItem = new Tipoitem(4);
            tipo = tipoitemFacade.find(4);
            km_pieza = tipo.getVidaUtil();
            nuevoItem(auxiliar, km_pieza + km, tipoItem);

            tipoItem = new Tipoitem(5);
            tipo = tipoitemFacade.find(5);
            km_pieza = tipo.getVidaUtil();
            nuevoItem(auxiliar, km_pieza + km, tipoItem);

            tipoItem = new Tipoitem(6);
            tipo = tipoitemFacade.find(6);
            km_pieza = tipo.getVidaUtil();
            nuevoItem(auxiliar, km_pieza + km, tipoItem);
            //id para crear items de vehículo cread 

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Vehículo " + patente + " Agregado Exitosamente", marca + " " + modelo);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            patente = "";
            marca = "";
            modelo = "";
            ano = null;
            kilometraje_vehiculo = null;
            chofer = "";
            estado_vehiculo = "";

        }

    }

    public String cambiarPagina() {
       return "listarVehiculos?faces-redirect=true";        
    }
    
    
      public String volverTecnico() {
       return "asignarTecnico?faces-redirect=true";        
    }
    

    public void nuevoItem(Vehiculo idV, Integer km, Tipoitem tipo) {

        item = new Item("Pieza Nueva", 0, "Ok", null, km);
        java.util.Date fecha = new Date();
        item.setFecha(fecha);
        item.setIdVehiculo(idV);
        item.setIdTipoitem(tipo);
        itemFacade.create(item);
    }

    public void editarChoferVehiculo(Integer idVehiculo) {
    }

    public void mostrarMensaje(String men) {
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