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
  
  public List precio(int id_producto) throws ClassNotFoundException{
      DBHandler handler = new DBHandler();
      handler.getConnection();
        List l=handler.PrecioProd("SELECT precio FROM productos WHERE id_producto ='"+id_producto+"'");
        
        double precio= (double) l.get(0);
        System.out.println(precio);
        return l;
  }
     
      public void InsertCompras(String fecha_compra,String fecha_entrega,int id_producto,int id_prov,int cantidad) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        String status="0";
        List l=handler.PrecioProd("SELECT precio FROM productos WHERE id_producto ='"+id_producto+"'");
        double precio= (double) l.get(0);
        double total=precio*cantidad;
        
        handler.executeInsert("INSERT INTO compras(fecha_compra,fecha_entrega,id_producto,id_prov,cantidad,total,status) "+ 
        "VALUES('"+fecha_compra+"','"+fecha_entrega+"','"+id_producto+"','"+id_prov+"','"+cantidad+"','"+total+"','"+status+"')");
    }
      
      public List listaCompras() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.ComprasList("SELECT * FROM \"compras\"");
        System.out.println("Compraslist: "+lst);
        return lst;
    } 
     
     public static void main(String[] args) throws ClassNotFoundException {
        /*ComprasValidations obj = new ComprasValidations();
        obj.InsertCompras(5,"2020/11/22", "2020/11/22", 3, 2, 12);*/
       
    }  
}
