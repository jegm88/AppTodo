/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.beans;

import co.com.apptodo.entity.Usuario;
import co.com.apptodo.services.UsuarioService;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jhonny <jegm@hotmail.com>
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final Logger logger = Logger.getLogger("LoginBean");
    @EJB
    private UsuarioService usuarioService;
    private Usuario usuario;
    
    private String pagInicio = "index";
    private String pagPpal = "principal";

    public LoginBean() {
        usuario = new Usuario();
    }

    public String login() {
        Usuario usuarioLogin = usuarioService.login(usuario);
        if (usuarioLogin != null) {
            logger.log(Level.INFO, "Usuario logeado exitosamente");
            usuario = usuarioLogin;
            return pagPpal;
        } else {
            return null;
        }
    }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().
                getExternalContext().getSession(false);

        session.invalidate();

        return pagInicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
