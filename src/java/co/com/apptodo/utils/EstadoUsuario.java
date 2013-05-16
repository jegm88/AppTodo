/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.utils;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
public enum EstadoUsuario {
    
    INACTIVO(0), ACTIVO(1), SUSPENDIDO(2);
    
    private int estado;
    private String descripcion;
    
    private EstadoUsuario(int estado) {
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
