/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msocial.app.filter;

import com.msocial.app.bean.BeanMenu;
import com.msocial.app.dominio.Login;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author SergioRios
 */
public class AuthenticationFilterMS extends UsernamePasswordAuthenticationFilter {
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, 
            FilterChain fc, Authentication auth) throws IOException, ServletException {
        super.successfulAuthentication(request, response, fc, auth);
        Login user = (Login)auth.getPrincipal();
        HttpSession session = request.getSession(true);
        BeanMenu menu = new BeanMenu();
        menu.setVisibleMenu(true);
        menu.setUser(user);
        session.setAttribute("beanMenu", user);
        System.out.println("Success: "+user.getUsername());
    }

    /**
     * Default behaviour for unsuccessful authentication.
     * <ol>
     * <li>Clears the {@link SecurityContextHolder}</li>
     * <li>Stores the exception in the session (if it exists or
     * <tt>allowSesssionCreation</tt> is set to <tt>true</tt>)</li>
     * <li>Informs the configured <tt>RememberMeServices</tt> of the failed
     * login</li>
     * <li>Delegates additional behaviour to the
     * {@link AuthenticationFailureHandler}.</li>
     * </ol>
     * @param request
     * @param response
     * @param failed
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
