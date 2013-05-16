/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.utils;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
public enum EstadoTarea {
    
    ELIMINADO(0), ACTIVO(1), CHECKED(2);
    
    private int estado;
    private String descripcion;
    
    private EstadoTarea(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }  
    
    @Override
    public String toString() {
        return descripcion;
    }   
}
