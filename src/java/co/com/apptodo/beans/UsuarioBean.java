/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.beans;

import co.com.apptodo.entity.Usuario;
import co.com.apptodo.services.UsuarioService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

    private static final Logger logger = Logger.getLogger("UsusarioBean");
    @EJB
    private UsuarioService usuarioService;
    private List<Usuario> usuarios;
    private Usuario usuario;

    public UsuarioBean() {
        usuario = new Usuario();
    }

    @PostConstruct
    private void init() {
        //inicio
    }

    public void guardar() {

        try {
            if (usuario.getId() == null || usuario.getId() == 0) {
                usuarioService.insertar(usuario);
                logger.log(Level.INFO, "Usuario [{0}] registrado", usuario);
            } else {
                usuarioService.modificar(usuario);
                logger.log(Level.INFO, "Usuario [{0}] modificado", usuario);
            }
            usuario = new Usuario();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al registrar el usuario", e);
        }
    }

    private void listar() {
        logger.log(Level.INFO, "Listando usuarios [{0}]", usuarios);
        usuarios = usuarioService.listarTodo(Usuario.class);
    }

    public void seleccionar(Usuario usuario) {
        logger.log(Level.INFO, "Seleccionando usuario [{0}]", usuario);
        this.usuario = usuario;
    }

    public void eliminar(Usuario usuario) {
        try {
            usuarioService.eliminar(usuario.getId(), Usuario.class);
            logger.log(Level.INFO, "Usuario [{0}] eliminado", usuario);
            listar();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error inesperado al intentar eliminar el usuario");            
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   
}
