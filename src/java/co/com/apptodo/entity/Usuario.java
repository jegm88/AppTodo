/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
@NamedQuery(name = "Usuario.buscarPorCorreo",query = "SELECT o FROM Usuario o WHERE o.correo = :correo"),
@NamedQuery(name = "Usuario.login", query = "SELECT o FROM Usuario o WHERE o.correo = :correo AND o.password = :password")
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombres;
    @NotNull
    private String apellidos;
    @NotNull
    @Column(unique=true)
    private String correo;
    @NotNull
    private String password;
    @NotNull
    private Integer estado;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, String correo, String password, Integer estado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordword) {
        this.password = passwordword;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", password=" + password + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 53 * hash + (this.nombres != null ? this.nombres.hashCode() : 0);
        hash = 53 * hash + (this.apellidos != null ? this.apellidos.hashCode() : 0);
        hash = 53 * hash + (this.correo != null ? this.correo.hashCode() : 0);
        hash = 53 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 53 * hash + (this.estado != null ? this.estado.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nombres == null) ? (other.nombres != null) : !this.nombres.equals(other.nombres)) {
            return false;
        }
        if ((this.apellidos == null) ? (other.apellidos != null) : !this.apellidos.equals(other.apellidos)) {
            return false;
        }
        if ((this.correo == null) ? (other.correo != null) : !this.correo.equals(other.correo)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        return true;
    }
}
