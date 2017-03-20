package com.msocial.app.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julio Carballo Alomar
 */
@Entity
@Table(name = "DELEGACION", catalog = "", schema = "SISTEMASDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delegacion.findAll", query = "SELECT d FROM Delegacion d"),
    @NamedQuery(name = "Delegacion.findByDelCodigo", query = "SELECT d FROM Delegacion d WHERE d.delCodigo = :delCodigo"),
    @NamedQuery(name = "Delegacion.findByDelNombre", query = "SELECT d FROM Delegacion d WHERE d.delNombre = :delNombre")})
public class Delegacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "DEL_CODIGO")
    private String delCodigo;
    @Size(max = 60)
    @Column(name = "DEL_NOMBRE")
    private String delNombre;

    public Delegacion() {
    }

    public Delegacion(String delCodigo) {
        this.delCodigo = delCodigo;
    }

    public String getDelCodigo() {
        return delCodigo;
    }

    public void setDelCodigo(String delCodigo) {
        this.delCodigo = delCodigo;
    }

    public String getDelNombre() {
        return delNombre;
    }

    public void setDelNombre(String delNombre) {
        this.delNombre = delNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (delCodigo != null ? delCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delegacion)) {
            return false;
        }
        Delegacion other = (Delegacion) object;
        if ((this.delCodigo == null && other.delCodigo != null) || (this.delCodigo != null && !this.delCodigo.equals(other.delCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.msocial.app.entities.Delegacion[ delCodigo=" + delCodigo + " ]";
    }
    
}
