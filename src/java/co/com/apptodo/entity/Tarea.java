/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.entity;

import co.com.apptodo.utils.EstadoTarea;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
@Entity
@Table(name = "tareas")

@NamedQuery(name = "Tarea.buscarActivo", query = "SELECT o FROM Tarea o WHERE o.estado <> 0 AND o.usuario = :usuario")
public class Tarea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String actividad;

    @NotNull
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;

    @NotNull
    private Integer estado;

    public Tarea() {
    }

    public Tarea(String actividad, Usuario usuario, Integer estado) {
        this.actividad = actividad;
        this.usuario = usuario;
        this.estado = estado;
    }

     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

       @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.actividad != null ? this.actividad.hashCode() : 0);
        hash = 97 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        hash = 97 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarea other = (Tarea) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.actividad == null) ? (other.actividad != null) : !this.actividad.equals(other.actividad)) {
            return false;
        }
        if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", actividad=" + actividad + ", usuario=" + usuario + ", estado=" + estado + '}';
    }
 
}
