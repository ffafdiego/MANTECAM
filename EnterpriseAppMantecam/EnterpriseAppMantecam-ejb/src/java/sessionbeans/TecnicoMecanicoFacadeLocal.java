/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.TecnicoMecanico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pablitolog
 */
@Local
public interface TecnicoMecanicoFacadeLocal {

    void create(TecnicoMecanico tecnicoMecanico);

    void edit(TecnicoMecanico tecnicoMecanico);

    void remove(TecnicoMecanico tecnicoMecanico);

    TecnicoMecanico find(Object id);

    List<TecnicoMecanico> findAll();

    List<TecnicoMecanico> findRange(int[] range);

    int count();
    
}
