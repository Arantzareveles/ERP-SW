/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arantza Reveles 1
 */
public class LoginValidations {

   public boolean validate(String usuario, String password) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List l = handler.executeQuery("SELECT * FROM usuarios where usuario='"+ usuario +"' AND password='"+password+"'");
        System.out.println("validate: "+l);
        return !l.isEmpty();
    }
     
    public String obtUser(String usuario, String password) throws ClassNotFoundException{
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List l = handler.executeQuery("SELECT * FROM usuarios where usuario='"+ usuario +"' AND password='"+password+"'");
        String tipo=(String) l.get(2);
        System.out.println("tipo: "+tipo);
        return tipo;
    }

    public static void main(String[] args) throws ClassNotFoundException {
       /* LoginValidations obj = new LoginValidations();
        obj.validate("ara", "ara");
       obj.obtUser("ara", "ara");*/
    }

}
