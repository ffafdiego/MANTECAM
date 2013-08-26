/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.TecnicoMecanico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pablitolog
 */
@Stateless
public class TecnicoMecanicoFacade extends AbstractFacade<TecnicoMecanico> implements TecnicoMecanicoFacadeLocal {
    @PersistenceContext(unitName = "EnterpriseAppMantecam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TecnicoMecanicoFacade() {
        super(TecnicoMecanico.class);
    }
    
}
