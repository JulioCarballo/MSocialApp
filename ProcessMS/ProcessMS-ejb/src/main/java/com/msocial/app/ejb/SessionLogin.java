package com.msocial.app.ejb;

import com.msocial.app.dominio.Login;
import com.msocial.app.negocio.NegocioLogin;
import com.msocial.app.utilEjb.UtilidadesEjb;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author Julio Carballo Alomar
 */
@Stateless(mappedName = "ejbLogin")
public class SessionLogin implements NegocioLogin {
    @PersistenceContext(unitName = "persistenceMS")
    EntityManager entMan;
    String userWrk;
    String passWrk;
    String claveEncript;

    @Override
    public Login validarLogin(Login obj) throws Exception {
        try {
            Query query = entMan.createNamedQuery("Login.findByUsuarioAndPassword");
            userWrk = obj.getUsername().toUpperCase();
            passWrk = obj.getPassword().toLowerCase();
            claveEncript = UtilidadesEjb.encriptar(passWrk);
            query.setParameter("usuario", userWrk);
            query.setParameter("password", claveEncript);
            List lista = query.getResultList();
            if(lista.size() > 0) {
                //--------------------------------------------------------------------------------------
                // Al estar el script dentro del Login (Entity), lo devuelve como tal, de manera que
                // no podemos 'convertirlo' a Login (Dominio). Tenemos que buscar la manera de hacerlo
                //          LoginEntity regLista = (LoginEntity)lista.get(0);
                // Hemos encontrado en Internet que en el caso de que dos clases tengan el mismo nombre
                // se puede definir la llamada de la siguiente manera para especificar a cual de ellas
                // pertenece. De momento lo dejamos así, hasta encontrar como podemos 'reducir' la
                // definición.
                com.msocial.app.entities.Login regLista = (com.msocial.app.entities.Login)lista.get(0);
                obj.setNombre(regLista.getNombre());
                obj.setRoluser(regLista.getRoluser());
                //--------------------------------------------------------------------------------------
                obj.setStatus(true);
                obj.setMensaje("Usuario encontrado. . .");
            } else {
                obj.setStatus(false);
                obj.setMensaje("El Usuario no fue encontrado. . .");
            }
            return obj;
        } catch(Exception ex) {
            throw new Exception("Error en validarUsuario: "+ex.getMessage(), ex);
        }
    }

}
