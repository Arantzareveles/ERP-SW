/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

import java.util.List;

/**
 *
 * @author Arantza Reveles 1
 */
public class LoginValidations {

    public boolean validate(String usuario, String password) throws ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List list = handler.executeQuery("SELECT * FROM usuarios where usuario='"
                + usuario + "' AND password='" + password + "'");
        System.out.println("list: " + list);
        return !list.isEmpty();
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
        LoginValidations obj = new LoginValidations();
      obj.validate("erp", "12345");
      obj.obtUser("erp", "12345");
    }

}
