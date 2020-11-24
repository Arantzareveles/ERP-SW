/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import productos.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import proveedores.Proveedores;

/**
 *
 * @author Arantza Reveles 1
 */
@Named("appProductos")
@SessionScoped

public class Productos implements Serializable {

    private String id_producto;
    private String nom_prod;
    private String precio;
    private String id_prove;
    private String tiempo;
    private String status;

    private List<Productos> listProductos;
    private List<SelectItem> listidProveedor;

    public void Productos() throws ClassNotFoundException {
        getListProveedor();

    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getId_prove() {
        return id_prove;
    }

    public void setId_prove(String id_prove) {
        this.id_prove = id_prove;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Productos> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Productos> listProductos) {
        this.listProductos = listProductos;
    }

    public List<SelectItem> getListidProveedor() {
        return listidProveedor;
    }

    public void setListidProveedor(List<SelectItem> listidProveedor) {
        this.listidProveedor = listidProveedor;
    }

    public void onLoad() throws ClassNotFoundException {
        getListProveedor();
    }

    public List<SelectItem> getListProveedor() throws ClassNotFoundException {
        this.listidProveedor = new ArrayList<SelectItem>();

        List<Proveedores> p = new ProductosValidations().ProveedoresGetId();

        for (int i = 0; i < p.size(); i++) {
            SelectItem providItem = new SelectItem(p.get(i));
            this.listidProveedor.add(providItem);
            System.out.println();
        }
        System.out.println("lista proveedor: ----------------------" + listidProveedor);
        return listidProveedor;
    }

    //VALIDACIONES
    public void agrProd() throws ClassNotFoundException {

        Pattern i = Pattern.compile("[0-9]");
        Matcher id = i.matcher(id_producto);
        Matcher idp = i.matcher(id_prove);

        Pattern pre = Pattern.compile("([0-9].){1,4}$");
        Matcher prec = pre.matcher(precio);

        Pattern p = Pattern.compile("[0-1]{1}");
        Matcher stat = p.matcher(status);

        if (id_producto.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!id.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID solo puede contener números", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (nom_prod.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo NOMBRE DE PRODUCTO esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (precio.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo TOTAL esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!prec.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo TOTAL no puede contener caracteres especiales", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (id_prove.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID PROVEEDOR esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!idp.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID PROVEEDOR solo puede contener números", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (tiempo.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo TIEMPO esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (status.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo STATUS esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!stat.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo STATUS solo puede contener 1 o 0 ", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto AGREGADO correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

            int idprod = Integer.parseInt(id_producto);
            double preciop = Double.parseDouble(precio);
            int idprov = Integer.parseInt(id_prove);

            new ProductosValidations().InsertProducto(idprod, nom_prod, preciop, idprov, tiempo, status);

        }
    }

    public void mostarProv() {
        System.out.println(id_prove);
    }

    public List<Productos> ConsultProducto() throws ClassNotFoundException {
        //System.out.println("hola estamos en listProducto");
        listProductos = new ProductosValidations().listaProductos();
        return listProductos;
    }

    public String process() throws ClassNotFoundException {
        ConsultProducto();
        return "productoslist.xhtml";

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Productos obj = new Productos();
        obj.getListProductos();
    }

}
