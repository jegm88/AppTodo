/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.utils;

import co.com.apptodo.entity.Usuario;
import co.com.apptodo.services.UsuarioService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
@Singleton
@Startup
public class Inicial {

    private static final Logger LOGGER = Logger.getLogger("RegistroInicial");
    @EJB
    private UsuarioService servicioUsuario;
    private Usuario usr = new Usuario("usuario", "prueba", "test@test.com","", EstadoUsuario.ACTIVO.getEstado());

    @PostConstruct
    private void init() {
        try {
            if(servicioUsuario.listarTodo(Usuario.class).isEmpty() || servicioUsuario.consultarPorCorreo(usr.getCorreo())==null){
                servicioUsuario.insertar(usr);
                LOGGER.log(Level.INFO, "({0}) inicial creado satisfactoriamente", this.getClass().getSimpleName());
            }
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, "Error al realizar el registro inicial ({0})", this.getClass().getSimpleName());
        }
    }
}
