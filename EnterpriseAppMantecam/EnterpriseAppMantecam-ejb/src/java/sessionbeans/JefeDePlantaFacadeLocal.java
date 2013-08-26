/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.JefeDePlanta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pablitolog
 */
@Local
public interface JefeDePlantaFacadeLocal {

    void create(JefeDePlanta jefeDePlanta);

    void edit(JefeDePlanta jefeDePlanta);

    void remove(JefeDePlanta jefeDePlanta);

    JefeDePlanta find(Object id);

    List<JefeDePlanta> findAll();

    List<JefeDePlanta> findRange(int[] range);

    int count();
    
}
