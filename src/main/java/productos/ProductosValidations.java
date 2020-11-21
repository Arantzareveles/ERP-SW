/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;


import productos.*;
import com.ittol.beans.DBHandler;
import java.util.List;

/**
 *
 * @author Arantza Reveles 1
 */
public class ProductosValidations {
    
  public List ProveedoresGetId() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.IDProveedor("SELECT id_prov FROM \"proveedores\"");
       
        System.out.println("Proveedor list: "+lst);
        return lst;
    } 
     
      public void InsertProducto(int id_producto,String nom_prod,Double precio,int id_prove,String tiempo,String status) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("INSERT INTO productos(id_producto,nom_prod,precio,id_prove,tiempo,status) "+ 
        "VALUES('"+id_producto+"','"+nom_prod+"','"+precio+"','"+id_prove+"','"+tiempo+"','"+status+"')");
    }
      
      public List listaProductos() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.ProductosList("SELECT * FROM \"productos\"");
        System.out.println("Productoslist: "+lst);
        return lst;
    } 
     
     //public static void main(String[] args) throws ClassNotFoundException {
        //VentasValidations obj = new VentasValidations();
        ///obj.ClientesGetId();
    //}  
}
