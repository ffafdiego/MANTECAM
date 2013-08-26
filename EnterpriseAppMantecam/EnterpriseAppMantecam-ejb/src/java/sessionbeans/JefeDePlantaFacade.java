/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.JefeDePlanta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pablitolog
 */
@Stateless
public class JefeDePlantaFacade extends AbstractFacade<JefeDePlanta> implements JefeDePlantaFacadeLocal {
    @PersistenceContext(unitName = "EnterpriseAppMantecam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JefeDePlantaFacade() {
        super(JefeDePlanta.class);
    }
    
}
