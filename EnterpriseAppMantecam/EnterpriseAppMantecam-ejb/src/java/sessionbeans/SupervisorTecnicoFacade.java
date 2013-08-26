/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.SupervisorTecnico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pablitolog
 */
@Stateless
public class SupervisorTecnicoFacade extends AbstractFacade<SupervisorTecnico> implements SupervisorTecnicoFacadeLocal {
    @PersistenceContext(unitName = "EnterpriseAppMantecam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupervisorTecnicoFacade() {
        super(SupervisorTecnico.class);
    }
    
}
