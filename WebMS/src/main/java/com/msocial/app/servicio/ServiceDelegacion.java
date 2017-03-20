package com.msocial.app.servicio;

import com.msocial.app.dominio.Delegacion;
import com.msocial.app.negocio.NegocioDeleg;
import com.msocial.app.util.Utilidades;
import java.util.List;

/**
 *
 * @author Julio Carballo Alomar
 */
public class ServiceDelegacion implements IfaceDelegacion{
    NegocioDeleg ejb;

    @Override
    public void altaDelegacion(Delegacion obj) throws Exception {
        try {
            ejb = (NegocioDeleg)Utilidades.getEJBRemote("ejbDeleg", NegocioDeleg.class.getName());
            ejb.altaDelegacion(obj);
        } catch(Exception ex) {
            throw new Exception("ejbDeleg - Error en altaDelegacion: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void modificaDelegacion(Delegacion obj) throws Exception {
        try {
            ejb = (NegocioDeleg)Utilidades.getEJBRemote("ejbDeleg", NegocioDeleg.class.getName());
            ejb.modificaDelegacion(obj);
        } catch(Exception ex) {
            throw new Exception("ejbDeleg - Error en modificaDelegacion: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void borrarDelegacion(Delegacion obj) throws Exception {
        try {
            ejb = (NegocioDeleg)Utilidades.getEJBRemote("ejbDeleg", NegocioDeleg.class.getName());
            ejb.borrarDelegacion(obj);
        } catch(Exception ex) {
            throw new Exception("ejbDeleg - Error en borrarDelegacion: " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<Delegacion> obtListaDelegaciones() throws Exception {
        try {
            ejb = (NegocioDeleg)Utilidades.getEJBRemote("ejbDeleg", NegocioDeleg.class.getName());
            return ejb.obtListaDelegaciones();
        } catch(Exception ex) {
            throw new Exception("ejbDeleg - Error en altaDelegacion: " + ex.getMessage(), ex);
        }
    }
    
}
