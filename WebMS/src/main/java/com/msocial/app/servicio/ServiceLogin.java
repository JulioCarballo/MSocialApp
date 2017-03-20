package com.msocial.app.servicio;

import com.msocial.app.dominio.Login;
import com.msocial.app.negocio.NegocioLogin;
import com.msocial.app.util.Utilidades;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julio Carballo Alomar
 */
@Service
public class ServiceLogin implements IfaceLogin {
    NegocioLogin ejb;

    @Override
    public Login validarLogin(Login obj) throws Exception {
        ejb = (NegocioLogin)Utilidades.getEJBRemote("ejbLogin", NegocioLogin.class.getName());
        return ejb.validarLogin(obj);
    }    
    

}
