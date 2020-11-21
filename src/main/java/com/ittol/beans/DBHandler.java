/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

import clientes.Clientes;
import compras.Compras;
import pedidos.Pedidos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import productos.Productos;


import proveedores.Proveedores;
import ventas.Ventas;


/**
 *
 * @author Arantza Reveles 1
 */
public class DBHandler {
     public Connection conn;

    public DBHandler() {

    }
    public void getConnection() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Erp", "postgres", "seguridadweb");
            if (conn == null) {
                System.out.println("No connection obtained... Please check");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public List executeQuery(String sqlStatement) {
        List list = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                list = new ArrayList();
                while (rs.next()) {
                    list.add(rs.getString("usuario"));
                    list.add(rs.getString("password"));
                    list.add(rs.getString("rol"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    } 
    
    //este metodo se utiliza para insertar en una tabla 
     public boolean executeInsert(String sqlStatement) {
       
        if (conn != null) {
            try {
                 Statement statement = conn.createStatement(); 
                 statement.executeUpdate(sqlStatement);
                 return true;
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
     
     //este metodo se utiliza para listar datos
     
      public  List ClientesList(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    
                     Clientes cli = new Clientes();
                     cli.setId_cliente(rs.getString("id_cliente"));
                     cli.setNombre(rs.getString("nombre"));
                     cli.setApellido_pat(rs.getString("ap_pat"));
                     cli.setApellido_mat(rs.getString("ap_mat"));
                     cli.setDireccion(rs.getString("direccion"));
                     cli.setStatus(rs.getString("status"));
                     l.add(cli);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }
      
      
      public  List PedidosList(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    
                     Pedidos pedi = new Pedidos();
                     pedi.setId_pedido(rs.getString("id_pedido"));
                     pedi.setId_cliente(rs.getString("id_cliente"));
                     pedi.setDir_entrega(rs.getString("dir_entrega"));
                     pedi.setFecha_compra(rs.getString("fecha_compra"));
                     pedi.setModel_compu(rs.getString("modelo_compu"));
                     pedi.setModel_motherbo(rs.getString("modelo_motherbo"));
                     pedi.setModel_discoduro(rs.getString("modelo_discoduro"));
                     pedi.setModel_procesador(rs.getString("modelo_procesador"));
                     pedi.setCantidad(rs.getString("cantidad"));
                     pedi.setTotal_compra(rs.getString("total_compra"));
                     pedi.setStatus(rs.getString("status"));
                     l.add(pedi);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }
      
    //para mandar a llamar en un campo los ID agregados(lista)
     public List IDCliente(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getInt("id_cliente"));
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
       
     //para mandar a llamar en un campo los ID agregados(lista)
     public List IDProveedor(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getInt("id_prov"));
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
     
//para mandar a llamar en un campo los ID agregados(lista)
     public List IDClienteV(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getInt("id_cliente"));
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }     
     
     //para mandar a llamar en un campo los ID agregados(lista)
     public List IDPedido(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getInt("id_pedido"));
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }

     
     public List IDProv(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getInt("id_prov"));
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
     
     public List IDProducto(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                     l.add(rs.getInt("id_producto"));
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
     
      public  List ProveedoresList(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    
                     Proveedores prove = new Proveedores();
                     prove.setId_prov(rs.getString("id_prov"));
                     prove.setNombre(rs.getString("nombre"));
                     prove.setDescripcion(rs.getString("descripcion"));
                     prove.setTipo_pago(rs.getString("tipo_pago"));
                     prove.setBanco(rs.getString("banco"));
                     prove.setNo_cuenta(rs.getString("no_cuenta"));
                     prove.setNo_tarjeta(rs.getString("no_tarjeta"));
                     prove.setStatus(rs.getString("status"));
                     l.add(prove);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }
      
      
       public  List VentasList(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    
                     Ventas ven = new Ventas();
                     ven.setId_venta(rs.getString("id_venta"));
                     ven.setId_pedido(rs.getString("id_pedido"));
                     ven.setFecha_entrega(rs.getString("fecha_entrega"));
                     ven.setId_clien(rs.getString("id_cliente"));
                     ven.setTotal(rs.getString("total"));
                     ven.setStatus(rs.getString("status"));
                     l.add(ven);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }
       
     
       public  List ComprasList(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    
                     Compras com = new Compras();
                     com.setId_compras(rs.getString("id_compras"));
                     com.setFecha_compra(rs.getString("fecha_compra"));
                     com.setFecha_entrega(rs.getString("fecha_entrega"));
                     com.setId_producto(rs.getString("id_producto"));
                     com.setId_prov(rs.getString("id_prov"));
                     com.setCantidad(rs.getString("cantidad"));
                     com.setTotal(rs.getString("total"));
                     com.setStatus(rs.getString("status"));
                     l.add(com);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }
     public  List ProductosList(String sqlStatement) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    
                     Productos prod = new Productos();
                     prod.setId_producto(rs.getString("id_producto"));
                     prod.setNom_prod(rs.getString("nom_prod"));
                     prod.setPrecio(rs.getString("precio"));
                     prod.setId_prove(rs.getString("id_prove"));
                     prod.setTiempo(rs.getString("tiempo"));
                     prod.setStatus(rs.getString("status"));
                     l.add(prod);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
     }  
       
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            }catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
    
 
}
