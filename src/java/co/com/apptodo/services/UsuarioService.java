/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.services;

import co.com.apptodo.entity.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
@Local
public interface UsuarioService extends GenericService<Usuario, Long> {

    public Usuario consultarPorCorreo(String correo);

    public Usuario login(Usuario usuario);
}
