/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Entities.TecnicoMecanico;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import sessionbeans.TecnicoMecanicoFacadeLocal;

/**
 *
 * @author Diego
 */
@Named(value = "managedBeanTecnico")
@Dependent
public class ManagedBeanTecnico {
    @EJB
    private TecnicoMecanicoFacadeLocal tecnicoMecanicoFacade;
    List<TecnicoMecanico> tecnicos;

    /**
     * Creates a new instance of ManagedBeanTecnico
     */
    public ManagedBeanTecnico() {
       
    }

    public List<TecnicoMecanico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<TecnicoMecanico> tecnicos) {
        this.tecnicos = tecnicos;
    }
    @PostConstruct
    public void init() {
        tecnicos = tecnicoMecanicoFacade.findAll();
    }
}
