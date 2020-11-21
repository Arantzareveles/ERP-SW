/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedidos;

import clientes.Clientes;
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

/**
 *
 * @author Arantza Reveles 1
 */
@Named("appPedidos")
@SessionScoped

public class Pedidos implements Serializable {

    private String id_pedido;
    private String id_cliente;
    private String dir_entrega;
    private String fecha_compra;
    private String model_compu;
    private String model_motherbo;
    private String model_discoduro;
    private String model_procesador;
    private String cantidad;
    private String total_compra;
    private String status;

    private List<Pedidos> listPedidos;
    private List<SelectItem> listidClientes;

    public void Pedidos() throws ClassNotFoundException {
        getListCliente();

    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDir_entrega() {
        return dir_entrega;
    }

    public void setDir_entrega(String dir_entrega) {
        this.dir_entrega = dir_entrega;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getModel_compu() {
        return model_compu;
    }

    public void setModel_compu(String model_compu) {
        this.model_compu = model_compu;
    }

    public String getModel_motherbo() {
        return model_motherbo;
    }

    public void setModel_motherbo(String model_motherbo) {
        this.model_motherbo = model_motherbo;
    }

    public String getModel_discoduro() {
        return model_discoduro;
    }

    public void setModel_discoduro(String model_discoduro) {
        this.model_discoduro = model_discoduro;
    }

    public String getModel_procesador() {
        return model_procesador;
    }

    public void setModel_procesador(String model_procesador) {
        this.model_procesador = model_procesador;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(String total_compra) {
        this.total_compra = total_compra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Pedidos> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Pedidos> listPedidos) {
        this.listPedidos = listPedidos;
    }

    public List<SelectItem> getListidClientes() {
        return listidClientes;
    }

    public void setListidClientes(List<SelectItem> listidClientes) {
        this.listidClientes = listidClientes;
    }

    public List<SelectItem> getListCliente() throws ClassNotFoundException {
        this.listidClientes = new ArrayList<SelectItem>();

        List<Clientes> c = new PedidosValidations().ClientesGetId();

        for (int i = 0; i < c.size(); i++) {
            SelectItem cliidItem = new SelectItem(c.get(i));
            this.listidClientes.add(cliidItem);
        }
        System.out.println("lista clientes" + listidClientes);
        return listidClientes;
    }

    public void agrPedido() throws ClassNotFoundException {
       
        Pattern p = Pattern.compile("[0-1]{1}");
        Matcher stat = p.matcher(status);
        
        Pattern i = Pattern.compile("[0-9]");
        Matcher id = i.matcher(id_pedido);
        Matcher idc = i.matcher(id_cliente);
        Matcher can = i.matcher(cantidad);

        Pattern c = Pattern.compile("[a-z A-Z ñ 0-9 á é í ó ú #]*$");
        Matcher dir = c.matcher(dir_entrega);
        
        Pattern tot = Pattern.compile("([0-9].){1,4}$");
        Matcher tota= tot.matcher(total_compra);

        if (id_pedido.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!id.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID solo puede contener números", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (id_cliente.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID CLIENTE esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!idc.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ID CLIENTE solo puede contener números", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (dir_entrega.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo DIRECCION ENTREGA esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!dir.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo DIRECCION ENTREGA solo puede contener letras y caracteres especificos", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (fecha_compra.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo FECHA COMPRA esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (model_compu.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo MODELO DE COMPUTADORA esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (model_motherbo.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo MODELO DE MOTHERBOARD esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);    
        } else if (model_discoduro.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo MODELO DISCO DURO esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (model_procesador.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo MODELO PROCESADOR esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (cantidad.equals("")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo CANTIDAD esta vacio", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else if (!can.matches()) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo CANTIDAD no puede contener caracteres especiales", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);  
        } else if (total_compra.equals("")) {
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
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido AGREGADO correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

            int idped = Integer.parseInt(id_pedido);
            int idcli = Integer.parseInt(id_cliente);
            double total = Double.parseDouble(total_compra);
            int cant = Integer.parseInt(cantidad);

            new PedidosValidations().InsertPedido(idped, idcli, dir_entrega, fecha_compra, model_compu, model_motherbo, model_discoduro, model_procesador, cant, total, status);

        }
    }

    public List<Pedidos> ConsultPedidos() throws ClassNotFoundException {

        listPedidos = new PedidosValidations().listaPedidos();
        return listPedidos;
    }

    public String process() throws ClassNotFoundException {
        ConsultPedidos();
        return "pedidoslist.xhtml";

    }

    public void mostrarIdCli() {
        System.out.println(id_cliente);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Pedidos obj = new Pedidos();
        obj.getListPedidos();
    }

}
