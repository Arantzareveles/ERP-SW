'use strict'

var nombre = false;
var descripcion = false;
var propiedades = false;
var stock = false;
var precio = false;


function validateNombre(){ 
    let pass = document.getElementById('form-new:nuevo_nombre').value;
    
    if (pass.length > 1){
        nombre = true;
    }else{
        nombre = false;
    }
    enabledButton();
}

function validateDescripcion(){ 
    let pass = document.getElementById('form-new:nuevo_descripcion').value;
    
    if (pass.length > 1){
        descripcion = true;
    }else{
        descripcion = false;
    }
    enabledButton();
}


function prueba(){
    console.log(document.getElementById('form-new:categoria').value);
}

function validatePropiedades(){ 
    let pass = document.getElementById('form-new:nuevo_propiedades').value;
    
    if (pass.length > 1){
        propiedades = true;
    }else{
        propiedades = false;
    }
    enabledButton();
}


function validateStock(){ 
    let pass = document.getElementById('form-new:nuevo_stock').value;
    
    if (pass.length > 0){
        stock = true;
    }else{
        stock = false;
    }
    enabledButton();
}

function validatePrecio(){ 
    let pass = document.getElementById('form-new:nuevo_precio').value;
    console.log(pass.length);
    if (pass.length > 1){
        precio = true;
    }else{
        precio = false;
    }
    enabledButton();
}

function pushCategoria(){
    console.log(document.getElementById('form-new:categoria').value);
}

function enabledButton (){
  
    console.log(nombre+','+precio+','+propiedades+','+descripcion+','+stock);
    if(nombre && precio && propiedades && stock && descripcion){
      document.getElementById('form-new:ingresar').disabled = false;
    }else{
      document.getElementById('form-new:ingresar').disabled = true;
    }
}
