'use strict'



/*var userName = false;
var password = false;
var lastName = false;
var correo = false;
var lastNameM = false;*/

var id_usu = false;
var nombre = false;
var password = false;
var usuario = false;
var apat = false;
var amat = false;
var rol = false;

inicio();

function inicio(){
   /* document.getElementById('form-regi:lab-ape').hidden = true;
    document.getElementById('form-regi:lab-apeM').hidden = true;
    document.getElementById('form-regi:lab-name').hidden = true;
    document.getElementById('form-regi:lab-cont').hidden = true;
    document.getElementById('form-regi:lab-cont2').hidden = true;
    document.getElementById('form-regi:lab-correo').hidden = true;*/
    
    document.getElementById('form-regi:lab-apat').hidden = true;
    document.getElementById('form-regi:lab-amat').hidden = true;
    document.getElementById('form-regi:lab-nombre').hidden = true;
    document.getElementById('form-regi:lab-cont').hidden = true;
    document.getElementById('form-regi:lab-cont2').hidden = true;
    document.getElementById('form-regi:lab-usuario').hidden = true;
    document.getElementById('form-regi:lab-rol').hidden = true;
    document.getElementById('form-regi:lab-pass').hidden = true;
   
}

function validatePassword(){ 
    let pass = document.getElementById('form-regi:regi-pass').value;
    
    if (pass.length > 4){
        document.getElementById('form-regi:lab-cont').hidden = true;
    }else{
        document.getElementById('form-regi:lab-cont').hidden = false;
    }
    enabledButton();
}


function confirmPassword(){ 
    let pass = document.getElementById('form-regi:regi-pass').value;
    let pass2 = document.getElementById('form-regi:regi-pass2').value;   
      
    if (pass === pass2){
        password = true;
        document.getElementById('form-regi:lab-cont2').hidden = false;
    }else{
        password = false;
        document.getElementById('form-regi:lab-cont2').hidden = true;
    }
    enabledButton();
}

function validateUser(){
    
    let user = document.getElementById('form-regi:regi-usuario').value;

    if (user.length >= 3){
        usuario = true;
        document.getElementById('form-regi:lab-usuario').hidden = true;
    }else{
        document.getElementById('form-regi:lab-usuario').hidden = false;
        usuario = false;
    }
    enabledButton();
}

function validateApell(){
    
    let user = document.getElementById('form-regi:regi-apat').value;

    if (user.length > 3){
        apat = true;
        document.getElementById('form-regi:lab-apat').hidden = true;
    }else{
        document.getElementById('form-regi:lab-apat').hidden = false;
        apat = false;
    }
    enabledButton();
}

function validateApellM(){
    
    let user = document.getElementById('form-regi:regi-amat').value;

    if (user.length > 3){
        amat = true;
        document.getElementById('form-regi:lab-amat').hidden = true;
    }else{
        document.getElementById('form-regi:lab-amat').hidden = false;
        amat = false;
    }
    enabledButton();
}

function validateNombre(){
    
    let user = document.getElementById('form-regi:regi-nombre').value;

    if (user.length > 4){
        nombre = true;
        document.getElementById('form-regi:lab-nombre').hidden = true;
    }else{
        document.getElementById('form-regi:lab-nombre').hidden = false;
        nombre = false;
    }
    enabledButton();
}
function validateRol(){
    
    let user = document.getElementById('form-regi:regi-rol').value;

    if (user.length > 4){
        rol = true;
        document.getElementById('form-regi:lab-rol').hidden = true;
    }else{
        document.getElementById('form-regi:lab-rol').hidden = false;
        rol = false;
    }
    enabledButton();
}


function enabledButton (){
    console.log(nombre + ',' + apat+ ',' + amat+ ',' + rol+ ',' + usuario +','+password);
    if(nombre && apat && amat && rol && usuario &&password){
      document.getElementById('form-regi:bt-regis').disabled = false;
    }else{
      document.getElementById('form-regi:bt-regis').disabled = true;
    }
}

function finish(){
    
    let user = document.getElementById('form-regi:usuario').value;
    let pass = document.getElementById('form-regi:pass').value;
       
    if (user.length > 4){
        usuario = true;
    }else{
        usuario = false;
    }
    
    if (pass.length > 4){
        password = true;
    }else{
        password = false;
    }
    
    enabledButton();
}


