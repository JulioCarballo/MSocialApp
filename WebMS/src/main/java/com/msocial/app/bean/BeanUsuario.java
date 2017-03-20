package com.msocial.app.bean;

import com.msocial.app.dominio.Login;
import com.msocial.app.servicio.ServiceUser;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import javax.faces.context.ExternalContext;

/**
 *
 * @author Julio Carballo Alomar
 */
@ViewScoped
public class BeanUsuario implements Serializable{
    
    private Login usuario;
    private Login userSelec;
    private List<Login> listaUsuarios;

    private ServiceUser servicioUser;
    // Con esto controlamos que tanto el InputText del codigo como el boton 'Crear', no estan 'disponibles'
    // en el caso de que hayamos seleccionado un registro de la tabla.
    private boolean ctrCodUser;

    @PostConstruct
    public void init(){
        try {
            setCtrCodUser(false);
            Date fechaActual = new Date();
            usuario.setFechaalta(fechaActual);
            listaUsuarios = getServicioUser().obtListaUsuarios();
        } catch (Exception ex) {
            Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Login getUsuario() {
        return usuario;
    }

    public void setUsuario(Login usuario) {
        this.usuario = usuario;
    }

    public Login getUserSelec() {
        return userSelec;
    }

    public void setUserSelec(Login userSelec) {
        this.userSelec = userSelec;
    }


    public List<Login> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Login> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ServiceUser getServicioUser() {
        return servicioUser;
    }

    public void setServicioUser(ServiceUser servicioUser) {
        this.servicioUser = servicioUser;
    }

    public boolean isCtrCodUser() {
        return ctrCodUser;
    }

    public void setCtrCodUser(boolean ctrCodUser) {
        this.ctrCodUser = ctrCodUser;
    }

    
    public void onRowSelect(SelectEvent event) {
        //FacesMessage msg = new FacesMessage("Usuario Seleccionado", ((Login) event.getObject()).getUsername());
        if (userSelec.getSwmodificar().equals("N")) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Atencion", "Usuario NO modificable");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            this.usuario = (Login) event.getObject();
            setCtrCodUser(true);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Usuario Seleccionado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void altaUsuario() throws Exception {
        try {
            setCtrCodUser(false);
            getServicioUser().altaUsuario(usuario);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Alta correcta");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.usuario = new Login();
            // Volvemos a cargar la lista de usuarios
            listaUsuarios.clear();
            listaUsuarios = getServicioUser().obtListaUsuarios();
        } catch (Exception ex){
            throw new Exception("Error en altaUsuario: " + ex.getMessage(), ex);
        }
    }

    public void modUsuario() throws Exception {
        try {
            setCtrCodUser(false);
            getServicioUser().modificaUsuario(usuario);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Modificacion correcta");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.usuario = new Login();
            // Volvemos a cargar la lista de usuarios
            listaUsuarios.clear();
            listaUsuarios = getServicioUser().obtListaUsuarios();
        } catch (Exception ex){
            throw new Exception("Error en modUsuario: " + ex.getMessage(), ex);
        }
    }

    public void borrarUsuario() throws Exception {
        try {
            setCtrCodUser(false);
            getServicioUser().borrarUsuario(usuario);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Eliminacion correcta");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.usuario = new Login();
            // Volvemos a cargar la lista de usuarios
            listaUsuarios.clear();
            listaUsuarios = getServicioUser().obtListaUsuarios();
        } catch (Exception ex){
            throw new Exception("Error en borrarUsuario: " + ex.getMessage(), ex);
        }
    }

    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
         
        HSSFCellStyle cellStyle = wb.createCellStyle();  
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
         
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            HSSFCell cell = header.getCell(i);
             
            cell.setCellStyle(cellStyle);
        }
    }
     
    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
         
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "LogoPetit.png";
         
        pdf.add(Image.getInstance(logo));
    }

}
