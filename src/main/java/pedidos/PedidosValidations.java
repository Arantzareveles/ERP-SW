/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedidos;

import com.ittol.beans.DBHandler;
import java.util.List;

/**
 *
 * @author Arantza Reveles 1
 */
public class PedidosValidations {
    
  public List ClientesGetId() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.IDCliente("SELECT id_cliente FROM \"clientes\"");
        System.out.println("Clientelist: "+lst);
        return lst;
    } 
     
      public void InsertPedido(int id_pedido,int id_cliente,String dir_entrega,String fecha_compra,String modelo_compu,String modelo_motherbo,String modelo_discoduro,String modelo_procesador,int cantidad, Double total_compra,String status) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("INSERT INTO pedidos(id_pedido,id_cliente,dir_entrega,fecha_compra,modelo_compu,modelo_motherbo,modelo_discoduro,modelo_procesador,cantidad,total_compra,status) "+ 
        "VALUES('"+id_pedido+"','"+id_cliente+"','"+dir_entrega+"','"+fecha_compra+"','"+modelo_compu+"','"+modelo_motherbo+"','"+modelo_discoduro+"','"+modelo_procesador+"','"+cantidad+"','"+total_compra+"','"+status+"')");
    }
      
      public List listaPedidos() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.PedidosList("SELECT * FROM \"pedidos\"");
        System.out.println("Pedidoslist: "+lst);
        return lst;
    } 
     
     public static void main(String[] args) throws ClassNotFoundException {
        /*PedidosValidations obj = new PedidosValidations();
        obj.InsertPedido(5, 2, "h", "2020/11/10","h","h","h","h", 2, 200.50, "true");*/
    }  
}
