/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Pablitolog
 */
@Named(value = "managedBeanCliente")
@RequestScoped
public class ManagedBeanCliente {
    
    private String username;
    private String pass;

   


    public ManagedBeanCliente() {
    }
}
