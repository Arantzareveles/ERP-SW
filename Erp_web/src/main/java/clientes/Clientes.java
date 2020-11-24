/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Arantza Reveles 1
 */
@Named("appCliente")
@SessionScoped
public class Clientes implements Serializable {

    private String id_cliente;
    private String nombre;
    private String apellido_pat;
    private String apellido_mat;
    private String direccion;
    private String status;
    private List<Clientes> listClientes;

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_pat() {
        return apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Clientes> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Clientes> listClientes) {
        this.listClientes = listClientes;
    }

    //validacion
    public void agrCliente() throws ClassNotFoundException {

        Pattern c = Pattern.compile("[a-z A-Z ñ 0-9 á é í ó ú #]*$");
        Matcher nom = c.matcher(nombre);
        Matcher ap = c.matcher(apellido_pat);
        Matcher am = c.matcher(apellido_mat);
        Matcher dir = c.matcher(direccion);

        Pattern p = Pattern.compile("[0-1]{1}");
        Matcher stat = p.matcher(status);

        Pattern i = Pattern.compile("[0-9]");
        Matcher id = i.matcher(id_cliente);

        if (id_cliente.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!id.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID solo puede contener números", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (nombre.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo NOMBRE esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!nom.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo NOMBRE no puede contener caracteres especiales", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (apellido_pat.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo APELLIDO PATERNO esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!ap.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo APELLIDO PATERNO no puede contener caracteres especiales", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (apellido_mat.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo APELLIDO MATERNO esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!am.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo APELLIDO MATERNO no puede contener caracteres especiales", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (direccion.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo DIRECCION esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (status.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo STATUS esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!stat.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo STATUS solo puede contener 1 o 0 ", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente AGREGADO correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            int idcli = Integer.parseInt(id_cliente);
            new ClientesValidations().InsertClient(idcli, nombre, apellido_pat, apellido_mat, direccion, status);
        }

    }

    public List<Clientes> ConsultClientes() throws ClassNotFoundException {

        listClientes = new ClientesValidations().listaClientes();
        return listClientes;
    }

    public String process() throws ClassNotFoundException {
        ConsultClientes();
        return "clienteslist.xhtml";

    }

}
