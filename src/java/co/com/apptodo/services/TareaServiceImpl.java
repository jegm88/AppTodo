/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.services;

import co.com.apptodo.entity.Tarea;
import co.com.apptodo.entity.Usuario;
import co.com.apptodo.utils.EstadoTarea;
import java.util.List;
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
public class TareaServiceImpl extends GenericServiceImpl<Tarea, Long> implements TareaService {

    private static final Logger LOGGER = Logger.getLogger("UsuarioServiceImpl");

    @Override
    public List<Tarea> listarActivos(Usuario u) {
        LOGGER.log(Level.INFO, "Ejecutando metodo consultar por correo({0})", u.getCorreo());
        TypedQuery<Tarea> query = entityManager.createNamedQuery("Tarea.buscarActivo", Tarea.class);
        query.setParameter("usuario", u);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            LOGGER.log(Level.WARNING, "No hay tareas disponibles");
            return null;
        }
    }
}
