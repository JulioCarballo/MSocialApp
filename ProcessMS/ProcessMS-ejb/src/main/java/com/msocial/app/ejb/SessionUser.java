package com.msocial.app.ejb;

import com.msocial.app.dominio.Login;
import com.msocial.app.negocio.NegocioUser;
import com.msocial.app.utilEjb.UtilidadesEjb;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Julio Carballo Alomar
 */
@Stateless(mappedName = "ejbUser")
public class SessionUser implements NegocioUser {
    @PersistenceContext(unitName = "persistenceMS")
    EntityManager entMan;
    // Debido a que tenemos que operar tanto con Login (Entity) como con Login (Dominio), realizamos
    // la siguiente definición para poder usarla en el momento oportuno.
    com.msocial.app.entities.Login userEnt;
    String userTmp;
    String passTmp;
    String claveEncript;

    @Override
    public void altaUsuario(Login obj) throws Exception {
        userTmp = obj.getUsername().toUpperCase();
        passTmp = obj.getPassword().toLowerCase();
        // Recibimos un Login (Dominio) y habrá que convertirlo a Login (Entity).
        userEnt = new com.msocial.app.entities.Login();
        userEnt.setUsuario(userTmp);
        userEnt = entMan.find(com.msocial.app.entities.Login.class, userTmp);
        if (userEnt != null){ // No exite el usuario, de manera que lo damos de alta
            System.out.println("El usuario exite. No hacemos nada pero no damos error!!!!");
        } else {    
            userEnt = new com.msocial.app.entities.Login();
            userEnt.setUsuario(userTmp);
            claveEncript = UtilidadesEjb.encriptar(passTmp);
            userEnt.setPassword(claveEncript);
            userEnt.setNombre(obj.getNombre());
            userEnt.setFechaalta(obj.getFechaalta());
            userEnt.setRoluser(obj.getRoluser());
            userEnt.setSwactivo(obj.getSwactivo());
            userEnt.setSwmodpass(obj.getSwmodpass());
            userEnt.setSwmodificar(obj.getSwmodificar());
            try{
                entMan.persist(userEnt);
                entMan.flush();
            } catch (Exception ex) {
                throw new Exception("Error en altaUsuario: " + ex.getMessage(), ex);
            }
        }
    }

    @Override
    public void modificaUsuario(Login obj) throws Exception {
        // Recibimos un Login (Dominio) y habrá que convertirlo a Login (Entity).
        userEnt = new com.msocial.app.entities.Login();
        userTmp = obj.getUsername().toUpperCase();
        passTmp = obj.getPassword().toLowerCase();
        userEnt.setUsuario(userTmp);
        userEnt = entMan.find(com.msocial.app.entities.Login.class, userTmp);
        if (userEnt != null) {
            claveEncript = UtilidadesEjb.encriptar(passTmp);
            userEnt.setPassword(claveEncript);
            userEnt.setNombre(obj.getNombre());
            userEnt.setFechaalta(obj.getFechaalta());
            userEnt.setRoluser(obj.getRoluser());
            userEnt.setSwactivo(obj.getSwactivo());
            userEnt.setSwmodpass(obj.getSwmodpass());
            userEnt.setSwmodificar(obj.getSwmodificar());
        }
    }
    
    @Override
    public void borrarUsuario(Login obj) throws Exception {
        userEnt = new com.msocial.app.entities.Login();
        // En este caso, sólo necesitamos el usuario para poder dar de baja el registro
        userTmp = obj.getUsername().toUpperCase();
        userEnt.setUsuario(userTmp);
        userEnt = entMan.find(com.msocial.app.entities.Login.class, userTmp);
        if (userEnt != null) {
            entMan.remove(userEnt);
        }
    }

    @Override
    public List<Login> obtListaUsuarios() throws Exception {
        try {
            Query query = entMan.createNamedQuery("Login.findAll");
            List listaEnt = query.getResultList();
            List<Login> listaDom = new ArrayList<Login>();
            if(listaEnt.size() > 0) {
                // Debemos pasar la Lista (Entity) a Lista (Dominio) para que se pueda utilizar
                // correctamente en el resto de la aplicación.
                for (int indice=0; indice<listaEnt.size(); indice++) {
                    userEnt = new com.msocial.app.entities.Login();
                    Login userDom = new Login();
                    userEnt = (com.msocial.app.entities.Login)listaEnt.get(indice);
                    userDom.setUsername(userEnt.getUsuario());
                    userDom.setPassword(userEnt.getPassword());
                    userDom.setNombre(userEnt.getNombre());
                    userDom.setRoluser(userEnt.getRoluser());
                    userDom.setFechaalta(userEnt.getFechaalta());
                    userDom.setSwactivo(userEnt.getSwactivo());
                    userDom.setSwmodpass(userEnt.getSwmodpass());
                    userDom.setSwmodificar(userEnt.getSwmodificar());
                    listaDom.add(userDom);
                }
            }
            return listaDom;
        } catch(Exception ex) {
            throw new Exception("Error en obtListaUsuarios: " + ex.getMessage(), ex);
        }
    }    
    
}
