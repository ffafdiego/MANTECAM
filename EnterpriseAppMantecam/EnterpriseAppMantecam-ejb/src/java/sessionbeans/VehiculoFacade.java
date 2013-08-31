/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

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
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "EnterpriseAppMantecam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }

    @Override
    public List<Vehiculo> buscarPorPatente(String patente) {

        Query query;

        query = em.createNamedQuery("Vehiculo.findByPatente")
                .setParameter("patente", patente);
        return query.getResultList();
    }

    @Override
    public List<Vehiculo> buscarPorMarca(String marca) {
        Query query;
        query = em.createNamedQuery("Vehiculo.findByMarca")
                .setParameter("marca", marca);
        return query.getResultList();
    }
    
    @Override
    public List<Vehiculo> buscarVehiculo(Integer idVehiculo){
        Query query;
        query = em.createNamedQuery("Vehiculo.findByIdVehiculo")
                .setParameter("idVehiculo",idVehiculo );    
        return query.getResultList();  
    }
}
    

