package com.msocial.app.bean;

import com.msocial.app.details.Usuario;
import com.msocial.app.dominio.Login;
import com.msocial.app.servicio.IfaceLogin;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 *
 * @author Julio Carballo Alomar
 */
public class BeanLogin implements AuthenticationProvider {
    private IfaceLogin serviceLogin;
    Login userWrk = new Login();

    /**
     * @return the serviceLogin
     */
    public IfaceLogin getServiceLogin() {
        return serviceLogin;
    }

    /**
     * @param serviceLogin the serviceLogin to set
     */
    public void setServiceLogin(IfaceLogin serviceLogin) {
        this.serviceLogin = serviceLogin;
    }

    public boolean userExist(Login user) {
        try {
            user = getServiceLogin().validarLogin(user);
            if(user.getStatus()) {
                userWrk.setUsername(user.getUsername());
                userWrk.setPassword(user.getPassword());
                userWrk.setNombre(user.getNombre());
                userWrk.setMensaje(user.getMensaje());
                userWrk.setRoluser(user.getRoluser());
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userLogin = authentication.getPrincipal().toString();
        String passwordLogin = authentication.getCredentials().toString();
        System.out.println("User: " + userLogin);
        System.out.println("Password: " + passwordLogin);
        Login user = new Login();
        user.setUsername(userLogin);
        user.setPassword(passwordLogin);
        if(userExist(user)) {
            System.out.println("El rol obtenido es: " + userWrk.getRoluser());
            List<GrantedAuthority> autoridades = new ArrayList<GrantedAuthority>();
            //autoridades.add(new SimpleGrantedAuthority("ROLE_USER"));
            //autoridades.add(new SimpleGrantedAuthority("ROLE_VIP"));
            //autoridades.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            //autoridades.add(new SimpleGrantedAuthority("ROLE_VENDEDOR"));
            //autoridades.add(new SimpleGrantedAuthority("ROLE_ALUMNO"));
            autoridades.add(new SimpleGrantedAuthority(userWrk.getRoluser()));
            Usuario userDetails = new Usuario();
            userDetails.setUsername(userLogin);
            userDetails.setPassword(passwordLogin);
            userDetails.setFechaalta(new Date());
            userDetails.setNombre(userWrk.getNombre());
            userDetails.setRoluser(userWrk.getRoluser());
            Authentication customAuthentication = new UsernamePasswordAuthenticationToken(userDetails, 
                    passwordLogin, autoridades);
            BeanMenu menu = new BeanMenu();
            menu.setUser(userWrk);
            menu.setVisibleMenu(true);
            menu.setDisInicio(true);
            menu.setFechaActual(new Date());
            ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("beanMenu", menu);
            return customAuthentication;
        } else {
            System.out.println("Usuario o Contraseña Inválidos.");
            throw new BadCredentialsException("Usuario o Contraseña Inválidos.");
        }
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
}
