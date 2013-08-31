/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.Vehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pablitolog
 */
@Local
public interface VehiculoFacadeLocal {

    void create(Vehiculo vehiculo);

    void edit(Vehiculo vehiculo);

    void remove(Vehiculo vehiculo);

    Vehiculo find(Object id);

    List<Vehiculo> findAll();

    List<Vehiculo> findRange(int[] range);

    int count();

    List<Vehiculo> buscarPorPatente(String Patente);

    List<Vehiculo> buscarPorMarca(String marca);

    List<Vehiculo> buscarVehiculo(Integer idVehiculo);
    
}
