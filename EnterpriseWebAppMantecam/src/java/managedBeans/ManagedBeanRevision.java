/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Entities.Revision;
import Entities.TecnicoMecanico;
import Entities.Vehiculo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import sessionbeans.RevisionFacadeLocal;
import sessionbeans.TecnicoMecanicoFacadeLocal;
import sessionbeans.VehiculoFacadeLocal;

/**
 *
 * @author Diego
 */
@Named(value = "managedBeanRevision")
@RequestScoped
public class ManagedBeanRevision {

   @EJB
    private TecnicoMecanicoFacadeLocal tecnicoMecanicoFacade1;
    @EJB
    private VehiculoFacadeLocal vehiculoFacade;
    @EJB
    private TecnicoMecanicoFacadeLocal tecnicoMecanicoFacade;
    @EJB
    private RevisionFacadeLocal revisionFacade;
    private List<Revision> revisiones,historial,misRevisiones;
    private Revision seleccionado;
    private List<TecnicoMecanico> tecnicos;
    private Vehiculo camion;
    private Integer revi;

    public List<Revision> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Revision> historial) {
        this.historial = historial;
    }
    
    

    /**
     * Creates a new instance of ManagedBeanRevision
     */
    public ManagedBeanRevision() {
    }

   
    @PostConstruct
    public void init() {
        revisiones = revisionFacade.findByEstadoRevision("Revisar");
        revisiones.addAll(revisionFacade.findByEstadoRevision("En Revisión"));
        misRevisiones = revisionFacade.findByTecnico(2);//CAMBIAR POR ID DE USUARIO TECNICO CONECTADO
        tecnicos = tecnicoMecanicoFacade.findAll();
        historial = revisionFacade.findByEstadoRevision("Ok");
        
    
    }

    public Revision getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Revision seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }
     public List<Revision> getMisRevisiones() {
        return misRevisiones;
    }

    public void setMisRevisiones(List<Revision> misRevisiones) {
        this.misRevisiones = misRevisiones;
    }
    public List<TecnicoMecanico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<TecnicoMecanico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Vehiculo getCamion() {
        return camion;
    }

    public void setCamion(Vehiculo camion) {
        this.camion = camion;
    }   

    public Integer getRevi() {
        return revi;
    }

    public void setRevi(Integer revi) {
        this.revi = revi;
    }
    
    public String revisionCamion(Integer rev){
        seleccionado = revisionFacade.find(rev);
        
    
    
    
        return null;
    }
    
    
    public String asignarMecanico(Integer rev,Integer tecnico) {
        seleccionado = revisionFacade.find(rev);
        TecnicoMecanico selected = tecnicoMecanicoFacade.find(tecnico);
        seleccionado.setIdUsario(selected);
        revisionFacade.edit(seleccionado);        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha asignado Mecánico "+ seleccionado.getIdUsario().getNombreTecnico()+" "+seleccionado.getIdUsario().getApellidoTecnico() +" a Revisión de vehículo " + seleccionado.getIdVehiculo().getPatente(),"");
        FacesContext.getCurrentInstance().addMessage(null, message);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        return "asignarTecnico?faces-redirect=true";
    }
    
    public String liberarMecanico(Integer rev){
         seleccionado = revisionFacade.find(rev);
         
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha liberado a Mecánico "+seleccionado.getIdUsario().getNombreTecnico()+" "+seleccionado.getIdUsario().getApellidoTecnico() +"de Revisión de Vehículo " + seleccionado.getIdVehiculo().getPatente(),"");
         FacesContext.getCurrentInstance().addMessage(null, message);
         FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
         seleccionado.setIdUsario(null);
         revisionFacade.edit(seleccionado);
         return "asignarTecnico?faces-redirect=true";
        
       

    }
 
}
