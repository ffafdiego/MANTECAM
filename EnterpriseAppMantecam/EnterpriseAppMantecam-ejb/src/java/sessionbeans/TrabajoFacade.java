/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.Trabajo;
import Entities.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pablitolog
 */
@Stateless
public class TrabajoFacade extends AbstractFacade<Trabajo> implements TrabajoFacadeLocal {
    @PersistenceContext(unitName = "EnterpriseAppMantecam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajoFacade() {
        super(Trabajo.class);
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        Query query;
        
        query = em.createNamedQuery("Trabajo.obtenerVehiculos");                
        return query.getResultList();       
    }    
}
