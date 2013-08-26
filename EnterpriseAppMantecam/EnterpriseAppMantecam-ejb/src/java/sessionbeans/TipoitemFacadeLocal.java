/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.Tipoitem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pablitolog
 */
@Local
public interface TipoitemFacadeLocal {

    void create(Tipoitem tipoitem);

    void edit(Tipoitem tipoitem);

    void remove(Tipoitem tipoitem);

    Tipoitem find(Object id);

    List<Tipoitem> findAll();

    List<Tipoitem> findRange(int[] range);

    int count();
    
}
