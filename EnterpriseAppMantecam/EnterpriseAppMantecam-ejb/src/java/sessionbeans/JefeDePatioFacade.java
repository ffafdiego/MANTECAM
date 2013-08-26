/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.JefeDePatio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pablitolog
 */
@Stateless
public class JefeDePatioFacade extends AbstractFacade<JefeDePatio> implements JefeDePatioFacadeLocal {
    @PersistenceContext(unitName = "EnterpriseAppMantecam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JefeDePatioFacade() {
        super(JefeDePatio.class);
    }
    
}
