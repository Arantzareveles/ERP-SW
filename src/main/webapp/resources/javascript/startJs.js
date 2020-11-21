'use strict'

var ram = 'jsf/ram.jpg';
var proc = 'jsf/procesador.png';
var discos = 'jsf/discos_duros.jpg';


function useRam() {
    document.getElementById('name-produc').innerHTML = 'RAM';
    let image = document.getElementById('img-prd').src = ram;
}

function useProcesador() {
    document.getElementById('name-produc').innerHTML = 'Procesador';
    let image = document.getElementById('img-prd').src = proc;
}

function useDiscos() {
    document.getElementById('name-produc').innerHTML = 'Discos duros';
    let image = document.getElementById('img-prd').src = discos;
}

function getVars() {
    var nombre = document.getElementById('name-produc').innerHTML;
    document.getElementById("formId:nombre").value = nombre;
}

