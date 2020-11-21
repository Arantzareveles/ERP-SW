/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Arantza Reveles 1
 */
@Named("appLogin")
@SessionScoped
public class Login implements Serializable {
     private String usuario;
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
   // *******Cambio de Login****************
   public String process() throws ClassNotFoundException {
        
        if (new LoginValidations().validate(usuario, password)) {
           
            if (new LoginValidations().obtUser(usuario, password).equals("user")) {
                return "Clientes/clientes.xhtml";
                //return "user/agr_user.xhtml";
            }else {
             return "Administrador/administrador.xhtml";
            }
            
        } else {
            FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario o contraseña incorrectos", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "../index.xhtml";
        }
        
    }
}
