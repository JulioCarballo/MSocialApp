package com.msocial.app.servicio;

import com.msocial.app.dominio.Login;

/**
 *
 * @author Julio Carballo Alomar
 */
public interface IfaceLogin {
    Login validarLogin(Login obj) throws Exception;
    

}
