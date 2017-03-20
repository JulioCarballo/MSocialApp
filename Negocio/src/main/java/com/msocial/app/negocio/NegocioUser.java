package com.msocial.app.negocio;

import com.msocial.app.dominio.Login;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Julio Carballo Alomar
 */
@Remote
public interface NegocioUser {
    void altaUsuario(Login obj) throws Exception;
    void modificaUsuario(Login obj) throws Exception;
    void borrarUsuario (Login obj) throws Exception;
    
    List<Login> obtListaUsuarios() throws Exception;
    
}
