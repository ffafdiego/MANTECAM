/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Entities.Revision;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import sessionbeans.RevisionFacadeLocal;

/**
 *
 * @author Diego
 */
@Named(value = "managedBeanRevision")
@Dependent
public class ManagedBeanRevision {
    @EJB
    private RevisionFacadeLocal revisionFacade1;
    private List<Revision> revisiones;
    private Revision seleccionado;
    
    

    /**
     * Creates a new instance of ManagedBeanRevision
     */
    public ManagedBeanRevision() {
    }
    @PostConstruct
    public void init() {
        revisiones = revisionFacade1.findAll();
    
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
    
    
    
    
    
   
    
    
    
        
}
