package com.msocial.app.ejb;

import com.msocial.app.dominio.Delegacion;
import com.msocial.app.negocio.NegocioDeleg;
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
@Stateless(mappedName = "ejbDeleg")
public class SessionDeleg implements NegocioDeleg{
    @PersistenceContext(unitName = "persistenceMS")
    EntityManager entMan;
    // Debido a que tenemos que operar tanto con Delegacion (Entity) como con Delegacion (Dominio), realizamos
    // la siguiente definición para poder usarla en el momento oportuno.
    com.msocial.app.entities.Delegacion delegEnt;
    String codDelTmp;

    @Override
    public void altaDelegacion(Delegacion obj) throws Exception {
        // Recibimos un Login (Dominio) y habrá que convertirlo a Login (Entity).
        delegEnt = new com.msocial.app.entities.Delegacion();
        codDelTmp = obj.getDelCodigo().toUpperCase();
        delegEnt = entMan.find(com.msocial.app.entities.Delegacion.class, codDelTmp);
        if (delegEnt != null) {
            System.out.println("La delegación ya existe, de manera que no hacemos nada");
        } else {
            delegEnt = new com.msocial.app.entities.Delegacion();
            delegEnt.setDelCodigo(codDelTmp);
            delegEnt.setDelNombre(obj.getDelNombre());
            try{
                entMan.persist(delegEnt);
                //entMan.flush();
            } catch (Exception ex) {
                throw new Exception("Error en altaDelegacion: " + ex.getMessage(), ex);
            }
        }
    }

    @Override
    public void modificaDelegacion(Delegacion obj) throws Exception {
        // Recibimos un Login (Dominio) y habrá que convertirlo a Login (Entity).
        delegEnt = new com.msocial.app.entities.Delegacion();
        codDelTmp = obj.getDelCodigo().toUpperCase();
        delegEnt.setDelCodigo(codDelTmp);
        delegEnt = entMan.find(com.msocial.app.entities.Delegacion.class, codDelTmp);
        if (delegEnt != null) {
            delegEnt.setDelNombre(obj.getDelNombre());
        }
    }

    @Override
    public void borrarDelegacion(Delegacion obj) throws Exception {
        // Recibimos un Login (Dominio) y habrá que convertirlo a Login (Entity).
        delegEnt = new com.msocial.app.entities.Delegacion();
        codDelTmp = obj.getDelCodigo().toUpperCase();
        delegEnt.setDelCodigo(codDelTmp);
        delegEnt = entMan.find(com.msocial.app.entities.Delegacion.class, codDelTmp);
        if (delegEnt != null) {
            entMan.remove(delegEnt);
        }
    }

    @Override
    public List<Delegacion> obtListaDelegaciones() throws Exception {
        try {
            Query query = entMan.createNamedQuery("Delegacion.findAll");
            List listaEnt = query.getResultList();
            List<Delegacion> listaDom = new ArrayList<Delegacion>();
            if(listaEnt.size() > 0) {
                // Debemos pasar la Lista (Entity) a Lista (Dominio) para que se pueda utilizar
                // correctamente en el resto de la aplicación.
                for (int indice=0; indice<listaEnt.size(); indice++) {
                    delegEnt = new com.msocial.app.entities.Delegacion();
                    Delegacion delegDom = new Delegacion();
                    delegEnt = (com.msocial.app.entities.Delegacion)listaEnt.get(indice);
                    delegDom.setDelCodigo(delegEnt.getDelCodigo());
                    delegDom.setDelNombre(delegEnt.getDelNombre());
                    listaDom.add(delegDom);
                }
            }
            return listaDom;
        } catch(Exception ex) {
            throw new Exception("Error en obtListaUsuarios: " + ex.getMessage(), ex);
        }
    }
    
}
