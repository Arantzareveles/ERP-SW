/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

//import conexion.Conexion;
/**
 *
 * @author salvador
 */
public class registerSecurity {
    

            
    public boolean insertUser(String nombre,String apat,String amat, String rol, String usuario, String pass) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        return handler.executeInsert("insert into usuarios (nombre, ap_pat,ap_mat,rol, usuario, password,status) "
                + " values ( '"+nombre+"', '"+apat+"', '"+amat+"', '"+rol+"','"+usuario+"', '"+pass+"', 'true')");
    }
}
