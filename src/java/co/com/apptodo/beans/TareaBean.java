/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.beans;

import co.com.apptodo.entity.Tarea;
import co.com.apptodo.entity.Usuario;
import co.com.apptodo.services.TareaService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
@ManagedBean
@ViewScoped
public class TareaBean implements Serializable {

    private static final Logger logger = Logger.getLogger("UsusarioBean");
    @EJB
    private TareaService tareaService;
    private List<Tarea> tareas;
    private Tarea tarea;
    private Boolean estado;
    
    private String pagRetorno = "principal";

    public TareaBean() {
        tarea = new Tarea();
        FacesContext fc = FacesContext.getCurrentInstance();
        Usuario user = fc.getApplication().evaluateExpressionGet(fc, "#{loginBean.usuario}", Usuario.class);
        tarea.setUsuario(user);
    }

    @PostConstruct
    private void init() {
        listar();
    }

    public String guardar() {
        parseEstado();
        try {
            if (tarea.getId() == null || tarea.getId() == 0) {
                tareaService.insertar(tarea);
                logger.log(Level.INFO, "Tarea [{0}] registrado", tarea);
            } else {
                tareaService.modificar(tarea);
                logger.log(Level.INFO, "Tarea [{0}] modificado", tarea);
            }
            tarea = new Tarea();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al registrar la tarea", e);
        }
        
        return pagRetorno;
    }

    private void listar() {
        logger.log(Level.INFO, "Listando tareas");
        tareas = tareaService.listarActivos(tarea.getUsuario());
    }
    
    public String mostrar() {
        System.out.println(tarea);
        parseEstadoTarea(tarea);
        return null;
    }

    public void seleccionar(Tarea tarea) {
        logger.log(Level.INFO, "Seleccionando tarea [{0}]", tarea);
        this.tarea = tarea;
    }

    public String eliminar() {
        try {
            tarea.setEstado(0);
            tareaService.modificar(tarea);
            logger.log(Level.INFO, "Tarea [{0}] eliminado", tarea);
            listar();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error inesperado al intentar eliminar la tarea");
        }
        return pagRetorno;
    }

    public Boolean parseEstadoTarea(Tarea tarea) {
        if (tarea.getEstado()==2) {
            estado = true;
        } else if (tarea.getEstado()==1){
            estado = false;
        }
        return estado;
    }

    public void parseEstado() {
        if (estado) {
            tarea.setEstado(2);
        } else {
            tarea.setEstado(1);
        }
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}