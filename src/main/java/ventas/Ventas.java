/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

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

/**
 *
 * @author Arantza Reveles 1
 */
@Named("appVentas")
@SessionScoped

public class Ventas implements Serializable {

    private String id_venta;
    private String id_pedido;
    private String fecha_entrega;
    private String id_clien;
    private String total;
    private String status;

    private List<Ventas> listVentas;
    private List<SelectItem> listidClientesVen;
    private List<SelectItem> listidPedidos;

    public void Pedidos() throws ClassNotFoundException {
        getListClienteV();
        getListPedidos();

    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getId_clien() {
        return id_clien;
    }

    public void setId_clien(String id_clien) {
        this.id_clien = id_clien;
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

    public List<Ventas> getListVentas() {
        return listVentas;
    }

    public void setListVentas(List<Ventas> listVentas) {
        this.listVentas = listVentas;
    }

    public List<SelectItem> getListidClientesVen() {
        return listidClientesVen;
    }

    public void setListidClientesVen(List<SelectItem> listidClientesVen) {
        this.listidClientesVen = listidClientesVen;
    }

    public List<SelectItem> getListidPedidos() {
        return listidPedidos;
    }

    public void setListidPedidos(List<SelectItem> listidPedidos) {
        this.listidPedidos = listidPedidos;
    }

    public List<SelectItem> getListClienteV() throws ClassNotFoundException {
        this.listidClientesVen = new ArrayList<SelectItem>();

        List<Pedidos> c = new VentasValidations().ClientesVGetId();

        for (int i = 0; i < c.size(); i++) {
            SelectItem cliidItem = new SelectItem(c.get(i));
            this.listidClientesVen.add(cliidItem);
        }
        System.out.println("lista clientes" + listidClientesVen);
        return listidClientesVen;
    }

    public List<SelectItem> getListPedidos() throws ClassNotFoundException {
        this.listidPedidos = new ArrayList<SelectItem>();

        List<Pedidos> p = new VentasValidations().PedidoGetId();

        for (int i = 0; i < p.size(); i++) {
            SelectItem pedidItem = new SelectItem(p.get(i));
            this.listidPedidos.add(pedidItem);
        }
        System.out.println("lista pedidos" + listidPedidos);
        return listidPedidos;
    }

    public void agrVenta() throws ClassNotFoundException {

        Pattern i = Pattern.compile("[0-9]");
        Matcher id = i.matcher(id_venta);
        Matcher idp = i.matcher(id_pedido);
        Matcher idc = i.matcher(id_clien);

        Pattern p = Pattern.compile("[0-1]{1}");
        Matcher stat = p.matcher(status);

        Pattern tot = Pattern.compile("([0-9].){1,4}$");
        Matcher tota = tot.matcher(total);

        if (id_venta.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!id.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID solo puede contener números", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (id_pedido.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID PEDIDO esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!idp.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID PEDIDO solo puede contener números", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (fecha_entrega.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo FECHA ENTREGA esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (id_clien.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID CLIENTE esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!idc.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID CLIENTE solo puede contener números", null);
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
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Venta AGREGADA correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

            int idven = Integer.parseInt(id_venta);
            double totalv = Double.parseDouble(total);
            int idcli = Integer.parseInt(id_clien);
            int idped = Integer.parseInt(id_pedido);

            new VentasValidations().InsertVenta(idven, idped, fecha_entrega, idcli, totalv, status);

        }
         
    }    

    public void mostar() {
        System.out.println(id_pedido);
    }

    public void mostarId() {
        System.out.println(id_clien);
    }

    public List<Ventas> ConsultVentas() throws ClassNotFoundException {

        listVentas = new VentasValidations().listaVentas();
        return listVentas;
    }

    public String process() throws ClassNotFoundException {
        ConsultVentas();
        return "ventaslist.xhtml";

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Ventas obj = new Ventas();
        obj.getListVentas();
    }

}
