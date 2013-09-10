/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Entities.Revision;
import Entities.TecnicoMecanico;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import sessionbeans.RevisionFacadeLocal;
import sessionbeans.TecnicoMecanicoFacadeLocal;

/**
 *
 * @author Diego
 */
@Named(value = "managedBeanTecnico")
@Dependent
public class ManagedBeanTecnico {
    @EJB
    private RevisionFacadeLocal revisionFacade;
    @EJB
    private TecnicoMecanicoFacadeLocal tecnicoMecanicoFacade;
    List<TecnicoMecanico> tecnicos;
    List<Revision> misRevisiones;
    /**
     * Creates a new instance of ManagedBeanTecnico
     */
    public ManagedBeanTecnico() {
       
    }
    @PostConstruct
    public void init() {
        tecnicos = tecnicoMecanicoFacade.findAll();
        
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
   
}
