/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.SupervisorTecnico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pablitolog
 */
@Local
public interface SupervisorTecnicoFacadeLocal {

    void create(SupervisorTecnico supervisorTecnico);

    void edit(SupervisorTecnico supervisorTecnico);

    void remove(SupervisorTecnico supervisorTecnico);

    SupervisorTecnico find(Object id);

    List<SupervisorTecnico> findAll();

    List<SupervisorTecnico> findRange(int[] range);

    int count();
    
}
