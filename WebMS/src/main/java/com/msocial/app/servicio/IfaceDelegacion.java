package com.msocial.app.servicio;

import com.msocial.app.dominio.Delegacion;
import java.util.List;

/**
 *
 * @author Julio Carballo Alomar
 */
public interface IfaceDelegacion {
    void altaDelegacion(Delegacion obj) throws Exception;
    void modificaDelegacion (Delegacion obj) throws Exception;
    void borrarDelegacion (Delegacion obj) throws Exception;
    
    List<Delegacion> obtListaDelegaciones() throws Exception;
    
}
