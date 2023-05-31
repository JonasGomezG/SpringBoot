$(document).ready(function() {
    cargarFrutas();
});

async function cargarFrutas(){
    const request = await fetch('/listar', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    const frutas = await request.json();

    let listadoHTML = '';

    for(let fruta of frutas){
        let fila = '<tr><td> ' + fruta.id + '</td><td>' + fruta.fruta + '</td><td><button onclick="eliminar('+ fruta.id +')">Eliminar</button></td></tr>';
        listadoHTML = listadoHTML + fila;
    }

    document.querySelector("#frutas tbody").outerHTML = listadoHTML;
}

async function eliminar(id){
    const request = await fetch('/eliminar/' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    location.reload();
}

async function add(){
    let datos = {}
    datos.fruta = document.getElementById('txtFruta').value;
    const request = await fetch('/añadir', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    location.reload();
}

async function editar(){
    let datos = {}
    datos.old_fruta = document.getElementById('old_txtFruta').value;
    datos.new_fruta = document.getElementById('new_txtFruta').value;
    const request = await fetch('/editar/' + datos.old_fruta + '/' + datos.new_fruta, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    location.reload();
}