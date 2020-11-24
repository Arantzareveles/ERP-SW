/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proveedores;


import com.ittol.beans.DBHandler;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arantza Reveles 1
 */
public class ProveedoresValidations {
     public void InsertProve(int id_prov,String nombre,String descripcion,String tipo_pago,String banco,String no_cuenta,String no_tarjeta,String status) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("INSERT INTO public.\"proveedores\"(id_prov,nombre,descripcion,tipo_pago,banco,no_cuenta,no_tarjeta,status) "+ "VALUES('"+id_prov+"','"+nombre+"','"+descripcion+"','"+tipo_pago+"','"+banco+"','"+no_cuenta+"','"+no_tarjeta+"','"+status+"')");    
        }  
     
     public List listaProveedores() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.ProveedoresList("SELECT * FROM \"proveedores\"");
        System.out.println("Proveedoreslist: "+lst);
        return lst;
    } 
     
     public static void main(String[] args) throws ClassNotFoundException {
         
        ProveedoresValidations obj = new ProveedoresValidations(); 
        obj.listaProveedores();
    }

}
