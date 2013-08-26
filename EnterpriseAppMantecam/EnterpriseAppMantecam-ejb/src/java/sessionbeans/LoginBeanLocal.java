/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import javax.ejb.Local;

/**
 *
 * @author Pablitolog
 */
@Local
public interface LoginBeanLocal {

    public void setUserName(String username);
    
}
