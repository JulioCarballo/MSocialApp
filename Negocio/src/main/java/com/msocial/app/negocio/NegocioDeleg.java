package com.msocial.app.negocio;

import com.msocial.app.dominio.Delegacion;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Julio Carballo Alomar
 */
@Remote
public interface NegocioDeleg {
    void altaDelegacion(Delegacion obj) throws Exception;
    void modificaDelegacion(Delegacion obj) throws Exception;
    void borrarDelegacion (Delegacion obj) throws Exception;
    
    List<Delegacion> obtListaDelegaciones() throws Exception;

}
