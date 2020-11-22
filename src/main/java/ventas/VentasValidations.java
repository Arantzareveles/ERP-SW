/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;


import com.ittol.beans.DBHandler;
import java.util.List;

/**
 *
 * @author Arantza Reveles 1
 */
public class VentasValidations {
    
  public List ClientesVGetId() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.IDCliente("SELECT id_cliente FROM \"pedidos\"");
        System.out.println("Cliente list: "+lst);
        return lst;
    } 
  
  public List PedidoGetId() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.IDPedido("SELECT id_pedido FROM \"pedidos\"");
        System.out.println("Pedido list: "+lst);
        return lst;
    } 
     
      public void InsertVenta(int id_pedido,String fecha_entrega,int id_clien,Double total,String status) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("INSERT INTO ventas(id_pedido,fecha_entrega,id_cliente,total,status) "+ 
        "VALUES('"+id_pedido+"','"+fecha_entrega+"','"+id_clien+"','"+total+"','"+status+"')");
    }
      
      public List listaVentas() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.VentasList("SELECT * FROM \"ventas\"");
        System.out.println("Ventaslist: "+lst);
        return lst;
    } 
     
     //public static void main(String[] args) throws ClassNotFoundException {
        //VentasValidations obj = new VentasValidations();
        ///obj.ClientesGetId();
    //}  
}
