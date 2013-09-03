/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Diego
 */
@Named(value = "managedBeanAutentificador")
@Dependent
public class ManagedBeanAutentificador {

    /**
     * Creates a new instance of ManagedBeanAutentificador
     */
    public ManagedBeanAutentificador() {
    }
}
