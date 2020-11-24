/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proveedores;

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
@Named("appProveedor")
@SessionScoped
public class Proveedores implements Serializable {

    private String id_prov;
    private String nombre;
    private String descripcion;
    private String tipo_pago;
    private String banco;
    private String no_cuenta;
    private String no_tarjeta;
    private String status;
    private List<Proveedores> listProveedores;

    public String getId_prov() {
        return id_prov;
    }

    public void setId_prov(String id_prov) {
        this.id_prov = id_prov;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNo_cuenta() {
        return no_cuenta;
    }

    public void setNo_cuenta(String no_cuenta) {
        this.no_cuenta = no_cuenta;
    }

    public String getNo_tarjeta() {
        return no_tarjeta;
    }

    public void setNo_tarjeta(String no_tarjeta) {
        this.no_tarjeta = no_tarjeta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Proveedores> getListProveedores() {
        return listProveedores;
    }

    public void setListProveedores(List<Proveedores> listProveedores) {
        this.listProveedores = listProveedores;
    }

    //VALIDACIONES   
    public void agrProveedor() throws ClassNotFoundException {

        Pattern i = Pattern.compile("[0-9]");
        Matcher id = i.matcher(id_prov);

        Pattern p = Pattern.compile("[0-1]{1}");
        Matcher stat = p.matcher(status);

        if (id_prov.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!id.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID solo puede contener números", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (nombre.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo NOMBRE DE PROVEEDOR esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (descripcion.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo DESCRIPCION DE PRODUCTO esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        } else if (status.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo STATUS esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!stat.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo STATUS solo puede contener 1 o 0 ", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proveedor AGREGADO correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

            int idprov = Integer.parseInt(id_prov);
            new ProveedoresValidations().InsertProve(idprov, nombre, descripcion, tipo_pago, banco, no_cuenta, no_tarjeta, status);

        }
     
    }      

    public List<Proveedores> ConsultProveedores() throws ClassNotFoundException {

        listProveedores = new ProveedoresValidations().listaProveedores();
        return listProveedores;
    }

    public String process() throws ClassNotFoundException {
        ConsultProveedores();
        return "provlist.xhtml";

    }

}
