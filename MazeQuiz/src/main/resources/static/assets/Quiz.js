// Call the dataTables jQuery plugin
$(document).ready(function () {
    cargarquiz();
});

async function cargarquiz() {
    const request = await fetch('quiz', {
        method: 'GET',
        headers: getHeaders()
    });
    const JugadorGruop = await request.json();

    console.log(JugadorGruop);
    let listadoHtml = '';
    JugadorGruop.forEach(item => {

        var id = item[0];
        var preguntaID = item[1];
        var pregunta = item[2];
        var respuestaID = item[3];
        var respuesta = item[4];
        var esCorrecta = item[5]

        let botonEliminar = '<button onclick="eliminarQuiz(' + id + ')" type="button" class="btn btn-outline-danger">Borrar</button>';
        let botonModificar = '<button  onclick="cargarQuiz(' + id + ')" class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasWithBackdrop" aria-controls="offcanvasWithBackdrop">Editar</button>';
        let preguntaHtml = '<tr><td>' + preguntaID + '</td><td>' + pregunta + '</td><td>' + respuestaID + '</td> <td>' + respuesta + '</td> <td>' + esCorrecta + '</td> <td>' + botonEliminar + ' ' + botonModificar + '</td></tr>';
        listadoHtml += preguntaHtml;
    });
    document.querySelector("#preguntasTabla tbody").outerHTML = listadoHtml;
}

async function eliminarQuiz(id) {

    if (!confirm('¿Desea Eliminar El Quiz?')) {
        return;
    }
    const request = await fetch('eliminarquiz/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });
    alert("Se eliminó el quiz");
    location.reload();
}

async function cargarQuiz(id) {


}

async function agregarQuiz() {
    document.getElementById("slctPregunta").options.length=0;
    document.getElementById("slctRespuesta").options.length=0;

    const request = await fetch('pregunta', {
        method: 'GET',
        headers: getHeaders()
    });
    const request2 = await fetch('respuesta', {
        method: 'GET',
        headers: getHeaders()
    });

    const RespuestasGruop = await request.json();
    const RespuestasGruop2 = await request2.json();

    let selectPregunta = document.getElementById("slctPregunta");
    let selectRespuesta = document.getElementById("slctRespuesta");

    for (let pregunta of RespuestasGruop) {
        let option = document.createElement("option");
        option.text = pregunta.pregId + " - " + pregunta.pregDescrip;
        option.value = pregunta.pregId;
        selectPregunta.add(option);
    }

    for (let respuesta of RespuestasGruop2) {
        let option = document.createElement("option");
        option.text = respuesta.resID + " - " + respuesta.resDescrip;
        option.value = respuesta.resID;
        selectRespuesta.add(option);
    }
}

async function registrarQuiz() {


    //datos.idQuiz = document.getElementById("InID").value;
    let pregId = document.getElementById("slctPregunta").value;
    let resID = document.getElementById("slctRespuesta").value;
    let quizValue = 0;
    if(document.getElementById("defaultCheck1").checked) {
        quizValue = 1;
    } else {
        quizValue = 0;
    }

    const request = await fetch('guardarquiz/' + pregId + '/' + resID + '/' + quizValue   , {
        method: 'POST',
        headers: getHeaders(),
    });

    location.reload();
    alert("Se registró el jugador");

}


function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}



