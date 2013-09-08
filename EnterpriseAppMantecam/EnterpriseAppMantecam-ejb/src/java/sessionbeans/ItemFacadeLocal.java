/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.Item;
import Entities.Vehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pablitolog
 */
@Local
public interface ItemFacadeLocal {

    void create(Item item);

    void edit(Item item);

    void remove(Item item);

    Item find(Object id);

    List<Item> findAll();

    List<Item> findRange(int[] range);

    int count();   

    public Integer revisarKmPiezas(Vehiculo camion);

    public Integer revisartodaslasPiezas(Vehiculo camion);

    public List<Item> buscarPorVehiculo(Integer vehiculo);

}
