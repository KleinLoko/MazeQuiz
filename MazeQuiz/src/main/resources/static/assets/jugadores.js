$(document).ready(function () {
    cargarJugadores();
});

async function cargarJugadores() {
    const request = await fetch('jugador', {
        method: 'GET',
        headers: getHeaders()
    });
    const JugadorGruop = await request.json();

    let listadoHtml = '';
    for (let JugadorTemp of JugadorGruop) {

        let botonEliminar = '<button onclick="eliminarJugador(' + JugadorTemp.jugid + ')" type="button" class="btn btn-outline-danger" >Borrar</button>';
        let botonModificar = '<button  onclick="cargarJugador(' + JugadorTemp.jugid + ')" class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasWithBackdrop" aria-controls="offcanvasWithBackdrop">Editar</button>';
        let jugadorHtml = '<tr><td>' + JugadorTemp.jugid + '</td><td>' + JugadorTemp.jugNombre + ' ' + JugadorTemp.jugApellidoPat + ' ' + JugadorTemp.jugApellidoMat + '</td><td>'
            + JugadorTemp.jugCarrera + '</td><td>' + JugadorTemp.jugPuntaje + '</td> <td> ' + botonEliminar + '  ' + botonModificar + '</td></tr>';
        listadoHtml += jugadorHtml;
    }
    document.querySelector("#preguntasTabla tbody").outerHTML = listadoHtml;
}

async function eliminarJugador(id) {
    if (!confirm('¿Desea Eliminar El usuario?')) {
        return;
    }
    const request = await fetch('eliminarjugador/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });

    location.reload();
}

function agregarJugador(id) {
    document.getElementById("InID").removeAttribute('readonly');
    document.getElementById("btnActualizar").innerHTML = "Agregar Jugador";
    document.getElementById("InID").value = "";
    document.getElementById("InNombre").value = "";
    document.getElementById("InApellidoPat").value = "";
    document.getElementById("InApellidoMat").value = "";
    document.getElementById("InPuntaje").value = "";
    document.getElementById("InCarrera").value = "";
    document.getElementById("InPassword").value = "";
}

async function cargarJugador(id) {
    const request = await fetch('jugador/' + id, {
        method: 'GET',
        headers: getHeaders()
    });

    const JugadorLoad = await request.json();
    document.getElementById("btnActualizar").innerHTML = "Editar Jugador";
    document.getElementById("InID").setAttribute('readonly', true);
    document.getElementById("InID").value = JugadorLoad.jugid;
    document.getElementById("InNombre").value = JugadorLoad.jugNombre;
    document.getElementById("InApellidoPat").value = JugadorLoad.jugApellidoPat;
    document.getElementById("InApellidoMat").value = JugadorLoad.jugApellidoMat;
    document.getElementById("InPuntaje").value = JugadorLoad.jugPuntaje;
    document.getElementById("InCarrera").value = JugadorLoad.jugCarrera;
    document.getElementById("InPassword").value = JugadorLoad.jugPassword;
    console.log("Si se está llamando al método");
}

async function registrarJugador() {

    let datos = {};
    datos.jugid = document.getElementById("InID").value;
    datos.jugNombre = document.getElementById("InNombre").value;
    datos.jugApellidoPat = document.getElementById("InApellidoPat").value;
    datos.jugApellidoMat = document.getElementById("InApellidoMat").value;
    datos.jugPuntaje = document.getElementById("InPuntaje").value;
    datos.jugCarrera = document.getElementById("InCarrera").value;
    datos.jugPassword = document.getElementById("InPassword").value;

    const request = await fetch('actualizarjugador', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    });

    location.reload();
    alert("Se actualizó el jugador");
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}


