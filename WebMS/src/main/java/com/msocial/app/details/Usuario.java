package com.msocial.app.details;

import java.util.Collection;
import java.util.Date;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Julio Carballo
 */
public class Usuario implements org.springframework.security.core.userdetails.UserDetails {
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
    private Collection<GrantedAuthority> list;

    public Usuario() {
    }

    public Usuario(String username) {
        this.username = username;
    }

    @Override
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msocial.app.entities.Login[ usuario=" + username + " ]";
    }

    /**
     * Returns the authorities granted to the user. Cannot return
     * <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return list;
    }

    /**
     * Set the authorities granted to the user.
     *
     * @param roles
     */
    public void setAuthorities(Collection<GrantedAuthority> roles) {
        this.list = roles;
    }

    /**
     * Regresa el identificador único de un usuario.
     * @return 
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Establece el identificador único de un usuario.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Método que establece el status de autenticación de un usuario.
     *
     * @param status
     */
    public void setAuthentication(boolean status) {
        this.status = status;
    }

    /**
     * Indicates whether the user's account has expired. An expired account
     * cannot be authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie
     * non-expired), <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code>
     * otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie
     * non-expired), <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot
     * be authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code>
     * otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
