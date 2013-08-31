/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Entities.JefeDePatio;
import Entities.JefeDePlanta;
import Entities.SupervisorTecnico;
import Entities.TecnicoMecanico;
import Entities.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import sessionbeans.UsuarioFacadeLocal;

/**
 *
 * @author Pablitolog
 */
@Named(value = "managedBeanUsuario")
@Dependent
public class ManagedBeanUsuario {
    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    private String username;
    private String pass;
    private JefeDePlanta jefeDePlanta;
    private JefeDePatio jefeDePatio;
    private SupervisorTecnico supervisorTecnico ;
    private TecnicoMecanico tecnicoMecanico;
    private List<Usuario> usuarios;
    
    public ManagedBeanUsuario() {
    }
    
    @PostConstruct
    public void init(){
        usuarios = usuarioFacade.findAll();
    
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public JefeDePlanta getJefeDePlanta() {
        return jefeDePlanta;
    }

    public void setJefeDePlanta(JefeDePlanta jefeDePlanta) {
        this.jefeDePlanta = jefeDePlanta;
    }

    public JefeDePatio getJefeDePatio() {
        return jefeDePatio;
    }

    public void setJefeDePatio(JefeDePatio jefeDePatio) {
        this.jefeDePatio = jefeDePatio;
    }

    public SupervisorTecnico getSupervisorTecnico() {
        return supervisorTecnico;
    }

    public void setSupervisorTecnico(SupervisorTecnico supervisorTecnico) {
        this.supervisorTecnico = supervisorTecnico;
    }

    public TecnicoMecanico getTecnicoMecanico() {
        return tecnicoMecanico;
    }

    public void setTecnicoMecanico(TecnicoMecanico tecnicoMecanico) {
        this.tecnicoMecanico = tecnicoMecanico;
    }
   
    
    
}
