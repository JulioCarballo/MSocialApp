package com.msocial.app.servicio;

import com.msocial.app.dominio.Login;
import com.msocial.app.negocio.NegocioUser;
import com.msocial.app.util.Utilidades;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julio Carballo Alomar
 */
@Service
public class ServiceUser implements IfaceUser {
    NegocioUser ejb;
    
    @Override
    public void altaUsuario(Login obj) throws Exception {
        try {
            ejb = (NegocioUser)Utilidades.getEJBRemote("ejbUser", NegocioUser.class.getName());
            ejb.altaUsuario(obj);
        } catch(Exception ex) {
            throw new Exception("ejbUser - Error en altaUsuario: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void modificaUsuario(Login obj) throws Exception {
        try {
        ejb = (NegocioUser)Utilidades.getEJBRemote("ejbUser", NegocioUser.class.getName());
        ejb.modificaUsuario(obj);
        } catch(Exception ex) {
            throw new Exception("ejbUser - Error en modificaUsuario: " + ex.getMessage(), ex);
        }
    }
    
    @Override
    public void borrarUsuario(Login obj) throws Exception {
        try {
            ejb = (NegocioUser)Utilidades.getEJBRemote("ejbUser", NegocioUser.class.getName());
            ejb.borrarUsuario(obj);
        } catch(Exception ex) {
            throw new Exception("ejbUser - Error en borrarUsuario: " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<Login> obtListaUsuarios() throws Exception {
        try {
            ejb = (NegocioUser)Utilidades.getEJBRemote("ejbUser", NegocioUser.class.getName());
            return ejb.obtListaUsuarios();
        } catch(Exception ex) {
            throw new Exception("ejbUser - Error en obtListaUsuario: " + ex.getMessage(), ex);
        }
    }    
    
    
}
