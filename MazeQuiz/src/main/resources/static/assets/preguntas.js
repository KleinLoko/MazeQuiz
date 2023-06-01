// Call the dataTables jQuery plugin
$(document).ready(function () {
    cargarPreguntas();
});

async function cargarPreguntas() {
    const request = await fetch('pregunta', {
        method: 'GET',
        headers: getHeaders()
    });

    const preguntaGrup = await request.json();

    let listadoHtml = '';

    for (let preguntaTemp of preguntaGrup) {

        let botonEliminar = '<button onclick="eliminarPregunta(' + preguntaTemp.pregId + ')" type="button" class="btn btn-outline-danger">Borrar</button>';
        let botonModificar = '<button  onclick="cargarPregunta(' + preguntaTemp.pregId + ')" class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasWithBackdrop" aria-controls="offcanvasWithBackdrop">Editar</button>';
        let preguntaHtml = '<tr><td>' + preguntaTemp.pregId + '</td><td>' + preguntaTemp.pregDescrip + '</td><td>' + preguntaTemp.pregValor + '</td> <td>' + botonEliminar + ' ' + botonModificar + '</td></tr>';
        listadoHtml += preguntaHtml;
    }

    document.querySelector("#preguntasTabla tbody").outerHTML = listadoHtml;
    console.log("Si se está llamando al método");

}

async function eliminarPregunta(id) {
    if (!confirm('¿Desea Eliminar la pregunta?')) {
        return;
    }
    const request = await fetch('eliminarpregunta/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });
    location.reload();
    alert("Se eliminó la pregunta");
}

function agregarPregunta() {
    document.getElementById("InID").removeAttribute('readonly');
    document.getElementById("btnActualizar").innerHTML = "Agregar Jugador";

    document.getElementById("InID").value = "";
    document.getElementById("InDescrip").value = "";
    document.getElementById("InValor").value = "";
}

async function cargarPregunta(id) {
    const request = await fetch('pregunta/' + id, {
        method: 'GET',
        headers: getHeaders()
    });

    const PreguntaLoad = await request.json();
    document.getElementById("btnActualizar").innerHTML = "Editar Jugador";
    document.getElementById("InID").setAttribute('readonly', true);
    document.getElementById("InID").value = PreguntaLoad.pregId;
    document.getElementById("InDescrip").value = PreguntaLoad.pregDescrip;
    document.getElementById("InValor").value = PreguntaLoad.pregValor;

    console.log("Si se está llamando al método");
}

async function registrarPregunta() {

    let datos = {};
    datos.pregId = document.getElementById("InID").value;
    datos.pregDescrip = document.getElementById("InDescrip").value;
    datos.pregValor = parseInt(document.getElementById("InValor").value);

    console.log(datos);

    const request = await fetch('actualizarpregunta', {
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