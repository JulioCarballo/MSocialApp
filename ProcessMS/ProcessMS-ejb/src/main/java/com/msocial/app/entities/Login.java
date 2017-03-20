package com.msocial.app.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julio Carballo Alomar
 */
@Entity
@Table(name = "LOGIN", catalog = "", schema = "SISTEMASDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findByUsuarioAndPassword", query = "SELECT l FROM Login l WHERE l.usuario = :usuario and l.password = :password"),
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByUsuario", query = "SELECT l FROM Login l WHERE l.usuario = :usuario"),
    @NamedQuery(name = "Login.findByPassword", query = "SELECT l FROM Login l WHERE l.password = :password"),
    @NamedQuery(name = "Login.findByNombre", query = "SELECT l FROM Login l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Login.findByRolUser", query = "SELECT l FROM Login l WHERE l.roluser = :roluser"),
    @NamedQuery(name = "Login.findByFechaAlta", query = "SELECT l FROM Login l WHERE l.fechaalta = :fechaalta"),
    @NamedQuery(name = "Login.findBySwActivo", query="SELECT l FROM Login l WHERE l.swactivo = :swactivo"),
    @NamedQuery(name = "Login.findBySwModPass", query="SELECT l FROM Login l WHERE l.swmodpass = :swmodpass"),
    @NamedQuery(name = "Login.findBySwModificar", query="SELECT l FROM Login l WHERE l.swmodificar = :swmodificar"),
    @NamedQuery(name = "Login.findByUrl", query = "SELECT l FROM Login l WHERE l.url = :url")})
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 200)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 10)
    @Column(name = "ROLUSER")
    private String roluser;
    @Column(name = "FECHAALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaalta;
    @Size(max = 1)
    @Column(name = "SWACTIVO")
    private String swactivo;
    @Size(max = 1)
    @Column(name = "SWMODPASS")
    private String swmodpass;
    @Size(max = 1)
    @Column(name = "SWMODIFICAR")
    private String swmodificar;
    @Size(max = 100)
    @Column(name = "URL")
    private String url;

    public Login() {
    }

    public Login(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msocial.app.entities.Login[ usuario=" + usuario + " ]";
    }
}
