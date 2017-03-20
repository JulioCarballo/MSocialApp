package com.msocial.app.dominio;


/**
 *
 * @author Julio Carballo Alomar
 */
public class Delegacion extends Generic{
    private static final long serialVersionUID = 1L;
    private String delCodigo;
    private String delNombre;
    private boolean status = false;

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

}
