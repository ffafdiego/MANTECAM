/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Diego
 */
@Named(value = "managedBeanLogin")
@SessionScoped
public class ManagedBeanLogin implements Serializable {

    /**
     * Creates a new instance of ManagedBeanLogin
     */
    public ManagedBeanLogin() {
    }
}
