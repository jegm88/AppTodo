/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.services;

import co.com.apptodo.entity.Tarea;
import co.com.apptodo.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
@Local
public interface TareaService extends GenericService<Tarea, Long> {
        List<Tarea> listarActivos(Usuario u);
}
