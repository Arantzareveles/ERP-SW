/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
/*import ventas.Ventas;
import ventas.VentasValidations;*/

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
         
         Calendar fech = new GregorianCalendar();
         String año = String.valueOf(fech.get(Calendar.YEAR));
         String mes = String.valueOf(fech.get(Calendar.MONTH) + 1);
         String dia = String.valueOf(fech.get(Calendar.DAY_OF_MONTH));
         String fechaS = año + "/" + mes + "/" + dia;
         
         
          String anio=fecha_entrega.substring(0,4);
          String mesU=fecha_entrega.substring(5,7);
          String diaU=fecha_entrega.substring(8,10);
          int añoEnt= Integer.parseInt(anio) -Integer.parseInt(año);

        

        Pattern i = Pattern.compile("[0-9]+");
        Matcher can = i.matcher(cantidad);

        

        if (fecha_entrega.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo FECHA ENTREGA esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if (Integer.parseInt(anio) < Integer.parseInt(año)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El año no pude ser menor al año actual", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (Integer.parseInt(anio) == Integer.parseInt(año) && Integer.parseInt(mesU) < Integer.parseInt(mes)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El mes no pude ser menor al mes actual", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (Integer.parseInt(anio) == Integer.parseInt(año) && Integer.parseInt(mesU) == Integer.parseInt(mes)) {
            if (Integer.parseInt(diaU) <= Integer.parseInt(dia)) {
                //System.out.println("El dia no pude der menor al actual");
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El dia no pude der menor o igual al actual", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);

            } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido registrado correctamente", null);
                FacesContext.getCurrentInstance().addMessage(null, fm);
                int cant = Integer.parseInt(cantidad);
                int idprove = Integer.parseInt(id_prov);
                int idprod = Integer.parseInt(id_producto);

                new ComprasValidations().InsertCompras(fechaS, fecha_entrega, idprod, idprove, cant);

            }
        } else if (añoEnt > 1) {
            //System.out.println("Los pedidos solo pueden ralizarse a un maximo de un año");
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Los pedidos solo pueden ralizarse a un maximo de un año", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (cantidad.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo CANTIDAD esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else if(cantidad.length()>3){
             FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo CANTIDAD no puede contener mas de 3 digitos", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!can.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo CANTIDAD no puede contener caracteres especiales", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Compra AGREGADA correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

            //int idcom = Integer.parseInt(id_compras);
            int cant = Integer.parseInt(cantidad);
            int idprove = Integer.parseInt(id_prov);
            int idprod = Integer.parseInt(id_producto);

            new ComprasValidations().InsertCompras(fechaS, fecha_entrega, idprod, idprove, cant);

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
