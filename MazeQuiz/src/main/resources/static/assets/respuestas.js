// Call the dataTables jQuery plugin
$(document).ready(function () {
    cargarRepuestas();
});

async function cargarRepuestas() {
    const request = await fetch('respuesta', {
        method: 'GET',
        headers: getHeaders()
    });
    const RespuestasGruop = await request.json();

    let listadoHtml = '';
    for (let respuestaTemp of RespuestasGruop) {

        let botonEliminar = '<button onclick="eliminarRespuesta(' + respuestaTemp.resID + ')" type="button" class="btn btn-outline-danger">Borrar</button>';
        let botonModificar = '<button  onclick="cargarRespuesta(' + respuestaTemp.resID + ')" class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasWithBackdrop" aria-controls="offcanvasWithBackdrop">Editar</button>';
        let respuestaHTML = '<tr><td>' + respuestaTemp.resID + '</td><td>' + respuestaTemp.resDescrip +
            '</td> <td> ' + botonEliminar + '  ' + botonModificar + '</td></tr>';
        listadoHtml += respuestaHTML;
    }
    document.querySelector("#respuestasTabla tbody").outerHTML = listadoHtml;
}

async function eliminarRespuesta(id) {
    if (!confirm('¿Desea eliminar la respuesta?')) {
        return;
    }
    const request = await fetch('eliminarrespuesta/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });
    location.reload();
    alert("Se eliminó la respuesta");
}

async function cargarRespuesta(id) {
    document.getElementById("btnActualizar").innerHTML = "Actualizar Respuesta";
    const request = await fetch('respuesta/' + id, {
        method: 'GET',
        headers: getHeaders()
    });
    const RespuestaLoad = await request.json();
    document.getElementById("InID").value = RespuestaLoad.resId;
    document.getElementById("InDescrip").value = RespuestaLoad.resDescrip;
}

function agregarRespuesta() {
    document.getElementById("btnActualizar").innerHTML = "Agregar Respuesta";
    document.getElementById("InDescrip").value = "";
}

async function registrarPregunta() {

    let datos = {};
    datos.resId = document.getElementById("InID").value;
    datos.resDescrip = document.getElementById("InDescrip").value;

    console.log(datos);

    const request = await fetch('actualizarpregunta', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    });

    location.reload();
    alert("Se actualizó la respuesta");
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}



