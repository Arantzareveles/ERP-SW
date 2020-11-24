/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import com.ittol.beans.DBHandler;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arantza Reveles 1
 */
public class ClientesValidations {
     public void InsertClient(int id_cliente,String nombre,String apellido_pat,String apellido_mat,String direccion,String status) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeInsert("INSERT INTO public.\"clientes\"(id_cliente,nombre,ap_pat,ap_mat,direccion,status) "+ "VALUES('"+id_cliente+"','"+nombre+"','"+apellido_pat+"','"+apellido_mat+"','"+direccion+"','"+status+"')");    
        }  
     
     public List listaClientes() throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List lst = handler.ClientesList("SELECT * FROM \"clientes\"");
        System.out.println("Clienteslist: "+lst);
        return lst;
    } 
     
     public static void main(String[] args) throws ClassNotFoundException {
         
        ClientesValidations obj = new ClientesValidations(); 
        obj.listaClientes();
    }

}
