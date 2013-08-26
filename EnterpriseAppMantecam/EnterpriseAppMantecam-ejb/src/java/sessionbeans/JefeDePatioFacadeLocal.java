/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.JefeDePatio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pablitolog
 */
@Local
public interface JefeDePatioFacadeLocal {

    void create(JefeDePatio jefeDePatio);

    void edit(JefeDePatio jefeDePatio);

    void remove(JefeDePatio jefeDePatio);

    JefeDePatio find(Object id);

    List<JefeDePatio> findAll();

    List<JefeDePatio> findRange(int[] range);

    int count();
    
}
