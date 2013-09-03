/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.Item;
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
public class ItemFacade extends AbstractFacade<Item> implements ItemFacadeLocal {
    @PersistenceContext(unitName = "EnterpriseAppMantecam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemFacade() {
        super(Item.class);
    }

   
    @Override
    public List<Item> buscarPorChofer(Integer chofer) {
        Query query;
        query = em.createNamedQuery("Item.findByChofer")
                .setParameter("chofer", chofer);
        return query.getResultList();
    }
    
    @Override
    public void revisarKmPiezas(Vehiculo camion){  
        Query query;
        query = em.createNamedQuery("Item.findByChofer")
                .setParameter("chofer", camion.getIdVehiculo());
       
        
        System.out.println(query.getResultList().listIterator());
        
        
    
    
    }

  
   
    
}
