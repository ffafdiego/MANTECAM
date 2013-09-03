/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.Trabajo;
import Entities.Vehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pablitolog
 */
@Local
public interface TrabajoFacadeLocal {

    void create(Trabajo trabajo);

    void edit(Trabajo trabajo);

    void remove(Trabajo trabajo);

    Trabajo find(Object id);

    List<Trabajo> findAll();

    List<Trabajo> findRange(int[] range);

    int count();
    
}
