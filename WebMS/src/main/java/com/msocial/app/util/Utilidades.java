package com.msocial.app.util;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author Julio Carballo Alomar
 */
public class Utilidades {
    public static Object getEJBRemote(String nameEJB, String iface) throws Exception {
        Context context;
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        props.put(Context.PROVIDER_URL, "http://localhost:7001");
        try {
            context = new InitialContext(props);
            String lookup = nameEJB+"#"+iface;
            System.out.println("Lookup: "+lookup);
            return context.lookup(lookup);
        } catch(Exception ex) {
            throw new Exception("No se encontro el EJB: '"+nameEJB+"'.");
        }
    }
    
}
