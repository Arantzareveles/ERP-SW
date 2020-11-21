/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

/*
 */
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("appregister")
@SessionScoped
public class register implements Serializable {

    /**
     * @return the id_usu
     */
    public String getId_usu() {
        return id_usu;
    }

    /**
     * @param id_usu the id_usu to set
     */
    public void setId_usu(String id_usu) {
        this.id_usu = id_usu;
    }

    /**
     * @return the apat
     */
    public String getApat() {
        return apat;
    }

    /**
     * @param apat the apat to set
     */
    public void setApat(String apat) {
        this.apat = apat;
    }

    /**
     * @return the amat
     */
    public String getAmat() {
        return amat;
    }

    /**
     * @param amat the amat to set
     */
    public void setAmat(String amat) {
        this.amat = amat;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the apellidoP
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * @param apellidoP the apellidoP to set
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @return the invalid
     */
    public String getInvalid() {
        return invalid;
    }

    /**
     * @param invalid the invalid to set
     */
    public void setInvalid(String invalid) {
        this.invalid = invalid;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the apellido
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * @param apellidoM the apellidoM to set
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    
    public void inserta() throws ClassNotFoundException{
        
        registerSecurity re = new registerSecurity();
        
        if(!re.insertUser(nombre,apat,amat,rol,usuario,pass)){
            tag = "Datos Incorrectos";
            invalid = "btn-outline-danger";
        } else{
            tag = "Datos Ingresados";
            invalid = "btn-outline-success";
        }

    }
    
    private String contraseña;
   // private String nombre;
    private String correo;
    private String apellidoM;
    private String apellidoP;
    
    
    
    private String id_usu;
    private String nombre;
    private String apat;
    private String amat;
    private String rol;
    private String usuario;
    private String pass;
    private String tag = "Registrar";
    private String invalid = "btn-outline-primary";
    
}
