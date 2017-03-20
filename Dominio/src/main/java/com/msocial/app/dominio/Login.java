package com.msocial.app.dominio;

import java.util.Date;
/**
 *
 * @author Julio Carballo Alomar
 * 
 */
public class Login extends Generic {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String nombre;
    private String roluser;
    private Date fechaalta;
    private String swactivo;
    private String swmodpass;
    private String swmodificar;
    private String url;
    boolean status = false;

    public Login() {
    }

    public Login(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRoluser() {
        return roluser;
    }

    public void setRoluser(String roluser) {
        this.roluser = roluser;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public String getSwactivo() {
        return swactivo;
    }

    public void setSwactivo(String swactivo) {
        this.swactivo = swactivo;
    }

    public String getSwmodpass() {
        return swmodpass;
    }

    public void setSwmodpass(String swmodpass) {
        this.swmodpass = swmodpass;
    }

    public String getSwmodificar() {
        return swmodificar;
    }

    public void setSwmodificar(String swmodificar) {
        this.swmodificar = swmodificar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
