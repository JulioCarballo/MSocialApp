package com.msocial.app.negocio;

import com.msocial.app.dominio.Login;
import javax.ejb.Remote;

/**
 *
 * @author Julio Carballo Alomar
 */
@Remote
public interface NegocioLogin {
    Login validarLogin(Login obj) throws Exception;
        
}
