/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.services;

import co.com.apptodo.entity.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
@Stateless
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long> implements UsuarioService {

    private static final Logger LOGGER = Logger.getLogger("UsuarioServiceImpl");

    @Override
    public Usuario consultarPorCorreo(String correo) {
        LOGGER.log(Level.INFO, "Ejecutando metodo consultar por correo({0})", this.getClass().getSimpleName());
        TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.buscarPorCorreo", Usuario.class);
        query.setParameter("correo", correo);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOGGER.log(Level.WARNING, "Usuario no existe");
            return null;
        }
    }

    @Override
    public Usuario login(Usuario usuario) {
        LOGGER.log(Level.INFO, "Ejecutando login({0})", this.getClass().getSimpleName());
        TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.login", Usuario.class);
        query.setParameter("correo", usuario.getCorreo());
        query.setParameter("password", usuario.getPassword());

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOGGER.log(Level.WARNING, "Usuario no existe");
            return null;
        }
    }
}
