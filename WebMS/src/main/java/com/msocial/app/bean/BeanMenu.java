package com.msocial.app.bean;

import com.msocial.app.dominio.Login;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Julio Carballo Alomar
 */
public class BeanMenu implements Serializable {
    private Login user;
    private boolean visibleMenu = false;
    private boolean disInicio;
    private boolean disUsuarios;
    private boolean disAlumnos;
    private boolean disArticulos;
    private boolean disDelegaciones;
    private Date fechaActual;
    
    private void resetMenu() {
        setDisAlumnos(false);
        setDisArticulos(false);
        setDisInicio(false);
        setDisUsuarios(false);
        setDisDelegaciones(false);
    }
    
    public Login getUser() {
        return user;
    }

    public void setUser(Login user) {
        this.user = user;
    }

    public boolean isVisibleMenu() {
        return visibleMenu;
    }

    public void setVisibleMenu(boolean visibleMenu) {
        this.visibleMenu = visibleMenu;
    }

    public boolean isDisInicio() {
        return disInicio;
    }

    public void setDisInicio(boolean disInicio) {
        this.disInicio = disInicio;
    }

    public boolean isDisUsuarios() {
        return disUsuarios;
    }

    public void setDisUsuarios(boolean disUsuarios) {
        this.disUsuarios = disUsuarios;
    }

    public boolean isDisAlumnos() {
        return disAlumnos;
    }

    public void setDisAlumnos(boolean disAlumnos) {
        this.disAlumnos = disAlumnos;
    }

    public boolean isDisArticulos() {
        return disArticulos;
    }

    public void setDisArticulos(boolean disArticulos) {
        this.disArticulos = disArticulos;
    }

    public boolean isDisDelegaciones() {
        return disDelegaciones;
    }

    public void setDisDelegaciones(boolean disDelegaciones) {
        this.disDelegaciones = disDelegaciones;
    }

    public String disabledInicio() {
        resetMenu();
        setDisInicio(true);
        return "/content/welcome?faces-redirect=true";
    }
    
    public String disabledUsuarios() {
        resetMenu();
        setDisUsuarios(true);
        return "/content/maestros/users?faces-redirect=true";
    }
    
    public String disabledAlumnos() {
        resetMenu();
        setDisAlumnos(true);
        return "/content/alumnos/students?faces-redirect=true";
    }
    
    public String disabledArticulos() {
        resetMenu();
        setDisArticulos(true);
        return "/content/articulos/products?faces-redirect=true";
    }

    public String disabledDelegaciones() {
        resetMenu();
        setDisDelegaciones(true);
        return "/content/maestros/delegs?faces-redirect=true";
    }
    
    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }


}
