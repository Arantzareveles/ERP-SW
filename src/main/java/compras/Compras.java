/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras;

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
import pedidos.Pedidos;
import productos.Productos;
import ventas.Ventas;
import ventas.VentasValidations;

/**
 *
 * @author Arantza Reveles 1
 */
@Named("appCompras")
@SessionScoped
public class Compras implements Serializable {

    private String id_compras;
    private String fecha_compra;
    private String fecha_entrega;
    private String id_producto;
    private String id_prov;
    private String cantidad;
    private String total;
    private String status;

    private List<Compras> listCompras;
    private List<SelectItem> listidProducto;
    private List<SelectItem> listidProv;

    public void Compras() throws ClassNotFoundException {
        //getListClienteV();
        //getListPedidos();

    }

    public String getId_compras() {
        return id_compras;
    }

    public void setId_compras(String id_compras) {
        this.id_compras = id_compras;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getId_prov() {
        return id_prov;
    }

    public void setId_prov(String id_prov) {
        this.id_prov = id_prov;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Compras> getListCompras() {
        return listCompras;
    }

    public void setListCompras(List<Compras> listCompras) {
        this.listCompras = listCompras;
    }

    public List<SelectItem> getListidProducto() {
        return listidProducto;
    }

    public void setListidProducto(List<SelectItem> listidProducto) {
        this.listidProducto = listidProducto;
    }

    public List<SelectItem> getListidProv() {
        return listidProv;
    }

    public void setListidProv(List<SelectItem> listidProv) {
        this.listidProv = listidProv;
    }

    public List<SelectItem> getListProducto() throws ClassNotFoundException {
        this.listidProducto = new ArrayList<SelectItem>();

        List<Productos> p = new ComprasValidations().ProductoGetId();

        for (int i = 0; i < p.size(); i++) {
            SelectItem cliidItem = new SelectItem(p.get(i));
            this.listidProducto.add(cliidItem);
        }
        System.out.println("lista productos" + listidProducto);
        return listidProducto;
    }

    public List<SelectItem> getListProveedor() throws ClassNotFoundException {
        this.listidProv = new ArrayList<SelectItem>();

        List<Pedidos> p = new ComprasValidations().ProvGetId();

        for (int i = 0; i < p.size(); i++) {
            SelectItem pedidItem = new SelectItem(p.get(i));
            this.listidProv.add(pedidItem);
        }
        System.out.println("lista proveedor" + listidProv);
        return listidProv;
    }

    //validaciones
    public void agrCompras() throws ClassNotFoundException {

        Pattern p = Pattern.compile("[0-1]{1}");
        Matcher stat = p.matcher(status);

        Pattern i = Pattern.compile("[0-9]");
        Matcher id = i.matcher(id_compras);
        Matcher idpd = i.matcher(id_producto);
        Matcher idpv = i.matcher(id_prov);
        Matcher can = i.matcher(cantidad);

        Pattern tot = Pattern.compile("([0-9].){1,4}$");
        Matcher tota = tot.matcher(total);

        if (id_compras.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!id.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID solo puede contener números", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (fecha_compra.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo FECHA COMPRA esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (fecha_entrega.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo FECHA ENTREGA esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (id_producto.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID PRODUCTO esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!idpd.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID PRODUCTO solo puede contener números", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (id_prov.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID PROVEEDOR esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!idpv.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID PROVEEDOR solo puede contener números", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (cantidad.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo CANTIDAD esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!can.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo CANTIDAD no puede contener caracteres especiales", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (total.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo TOTAL esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!tota.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo TOTAL no puede contener caracteres especiales", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (status.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo STATUS esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!stat.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo STATUS solo puede contener 1 o 0 ", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Compra AGREGADA correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

            int idcom = Integer.parseInt(id_compras);
            int cant = Integer.parseInt(cantidad);
            double totalc = Double.parseDouble(total);
            int idprove = Integer.parseInt(id_prov);
            int idprod = Integer.parseInt(id_producto);

            new ComprasValidations().InsertCompras(idcom, fecha_compra, fecha_entrega, idprod, idprove, cant, totalc, status);

        }
    }

    public void mostar() {
        System.out.println(id_producto);
    }

    public void mostarId() {
        System.out.println(id_prov);
    }

    public List<Compras> ConsultCompras() throws ClassNotFoundException {

        listCompras = new ComprasValidations().listaCompras();
        return listCompras;
    }

    public String process() throws ClassNotFoundException {
        ConsultCompras();
        return "compraslist.xhtml";

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Compras obj = new Compras();
        obj.getListCompras();
    }

}
