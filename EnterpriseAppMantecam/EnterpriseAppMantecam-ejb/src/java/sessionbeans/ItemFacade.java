/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.Item;
import Entities.Vehiculo;
import java.util.Iterator;
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
    public List<Item> buscarPorVehiculo(Integer vehiculo) {
        Query query;
        query = em.createNamedQuery("Item.findByVehiculo")
                .setParameter("vehiculo", vehiculo);
        return query.getResultList();
    }

    // RevisarkmPiezas devuelve 1 si existe al menos una pieza que exceda su kilometraje limite, 0 en caso contrario
    @Override
    public Integer revisarKmPiezas(Vehiculo camion) {
        Integer flag = 0;
        Query query;
        query = em.createNamedQuery("Item.findByChofer")
                .setParameter("chofer", camion.getIdVehiculo());
        List<Item> piezas = query.getResultList();
        System.out.println(piezas);
        System.out.println(piezas.toArray()[0]);
        for (int i = 0; i < piezas.size(); i++) {
            Object iterador = piezas.toArray()[i];
            Item itemsCamion = (Item) iterador;
            if (camion.getKilometrajeVehiculo() >= itemsCamion.getKilometrajeLimite()) {
                itemsCamion.setEstadoItem("Revisar");
                flag = 1;
            }
        }
        return flag;
    }
    
    //revisartodaslasPiezas: 1 en caso de todas las piezas bien y 0 en caso contrario 
    @Override
    public Integer revisartodaslasPiezas(Vehiculo camion) {
        Integer flag = 1;
        Query query;
        query = em.createNamedQuery("Item.findByChofer")
                .setParameter("chofer", camion.getIdVehiculo());
        List<Item> piezas = query.getResultList();
        System.out.println(piezas);
        System.out.println(piezas.toArray()[0]);
        for (int i = 0; i < piezas.size(); i++) {
            Object iterador = piezas.toArray()[i];
            Item itemsCamion = (Item) iterador;
            if (itemsCamion.getEstadoItem().compareTo("Revisar")== 0) {
                flag = 0;
            }
        }
        System.out.println(flag);
        return flag;
         
    }
    
  
   
    
}
