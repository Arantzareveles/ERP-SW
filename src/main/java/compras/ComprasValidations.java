/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras;



import com.ittol.beans.DBHandler;
import java.util.List;

/**
 *
 * @author Arantza Reveles 1
 */
public class ComprasValidations {
    
  public List ProductoGetId() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.IDProducto("SELECT id_producto FROM \"productos\"");
        System.out.println("Cliente list: "+lst);
        return lst;
    } 
  
  public List ProvGetId() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.IDProv("SELECT id_prov FROM \"proveedores\"");
        System.out.println("Pedido list: "+lst);
        return lst;
    } 
     
      public void InsertCompras(int id_compras,String fecha_compra,String fecha_entrega,int id_producto,int id_prov,int cantidad,Double total,String status) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("INSERT INTO compras(id_compras,fecha_compra,fecha_entrega,id_producto,id_prov,cantidad,total,status) "+ 
        "VALUES('"+id_compras+"','"+fecha_compra+"','"+fecha_entrega+"','"+id_producto+"','"+id_prov+"','"+cantidad+"','"+total+"','"+status+"')");
    }
      
      public List listaCompras() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.ComprasList("SELECT * FROM \"compras\"");
        System.out.println("Compraslist: "+lst);
        return lst;
    } 
     
     //public static void main(String[] args) throws ClassNotFoundException {
        //VentasValidations obj = new VentasValidations();
        ///obj.ClientesGetId();
    //}  
}
