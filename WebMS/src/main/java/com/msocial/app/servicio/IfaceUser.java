package com.msocial.app.servicio;

import com.msocial.app.dominio.Login;
import java.util.List;

/**
 *
 * @author Julio Carballo Alomar
 */
public interface IfaceUser {
    void altaUsuario(Login obj) throws Exception;
    void modificaUsuario (Login obj) throws Exception;
    void borrarUsuario (Login obj) throws Exception;
    
    List<Login> obtListaUsuarios() throws Exception;
    
}
