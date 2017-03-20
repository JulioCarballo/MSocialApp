package com.msocial.app.bean;

import com.msocial.app.dominio.Delegacion;
import com.msocial.app.servicio.ServiceDelegacion;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Julio Carballo Alomar
 */
@ViewScoped
public class BeanDelegacion implements Serializable{
    
    private Delegacion delegacion;
    private Delegacion delegSelec;
    private List<Delegacion> listaDelegaciones;
    
    private ServiceDelegacion serviceDeleg;
    // Con esto controlamos que tanto el InputText del código como el botón 'Crear', no están 'disponibles'
    // en el caso de que hayamos seleccionado un registro de la tabla.
    private boolean ctrCodDeleg;

    @PostConstruct
    public void init(){
        try {
            setCtrCodDeleg(false);
            listaDelegaciones = getServiceDeleg().obtListaDelegaciones();
        } catch (Exception ex) {
            Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Delegacion getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(Delegacion delegacion) {
        this.delegacion = delegacion;
    }

    public Delegacion getDelegSelec() {
        return delegSelec;
    }

    public void setDelegSelec(Delegacion delegSelec) {
        this.delegSelec = delegSelec;
    }

    public List<Delegacion> getListaDelegaciones() {
        return listaDelegaciones;
    }

    public void setListaDelegaciones(List<Delegacion> listaDelegaciones) {
        this.listaDelegaciones = listaDelegaciones;
    }

    public ServiceDelegacion getServiceDeleg() {
        return serviceDeleg;
    }

    public void setServiceDeleg(ServiceDelegacion serviceDeleg) {
        this.serviceDeleg = serviceDeleg;
    }

    public boolean isCtrCodDeleg() {
        return ctrCodDeleg;
    }

    public void setCtrCodDeleg(boolean ctrCodDeleg) {
        this.ctrCodDeleg = ctrCodDeleg;
    }
    
    public void onRowSelect(SelectEvent event) {
        setCtrCodDeleg(true);
        this.delegacion = (Delegacion) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Delegacion Seleccionada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void altaDelegacion() throws Exception {
        try {
            setCtrCodDeleg(false);
            getServiceDeleg().altaDelegacion(delegacion);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Alta correcta");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.delegacion = new Delegacion();
            listaDelegaciones.clear();
            listaDelegaciones = getServiceDeleg().obtListaDelegaciones();
        } catch (Exception ex){
            throw new Exception("Error en altaDelegacion: " + ex.getMessage(), ex);
        }
    }

    public void modDelegacion() throws Exception {
        try {
            setCtrCodDeleg(false);
            getServiceDeleg().modificaDelegacion(delegacion);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Modificación correcta");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.delegacion = new Delegacion();
            listaDelegaciones.clear();
            listaDelegaciones = getServiceDeleg().obtListaDelegaciones();
        } catch (Exception ex){
            throw new Exception("Error en modDelegacion: " + ex.getMessage(), ex);
        }
    }

    public void borrarDelegacion() throws Exception {
        try {
            setCtrCodDeleg(false);
            getServiceDeleg().borrarDelegacion(delegacion);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Eliminación correcta");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.delegacion = new Delegacion();
            listaDelegaciones.clear();
            listaDelegaciones = getServiceDeleg().obtListaDelegaciones();
        } catch (Exception ex){
            throw new Exception("Error en borrarDelegacion: " + ex.getMessage(), ex);
        }
    }
    
}
