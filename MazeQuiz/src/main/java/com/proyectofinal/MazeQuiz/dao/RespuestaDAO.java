package com.proyectofinal.MazeQuiz.dao;

import com.proyectofinal.MazeQuiz.models.Respuesta;

import java.util.List;

/*
 * Esta clase se encarga de administrar los métodos que se tendran para el Modelo Respuesta
 * pero no implementa su funcionalidad
 */

public interface RespuestaDAO {

    //Método que retornará todas las respuestas de la base de datos;
    List<Respuesta> getRespuestas();

    //Método que retorna una respuesta con el id indicado;
    Respuesta getRespuesta(int id);

    //Resgistra una nueva respuesta en la base de datos, a travez de un objeto Repuesta;
    void registrarRespuesta(Respuesta respuesta);

    //Método que elmina una respuesta de la base de datos según su ID;
    void eliminarRespuesta(int id);

    //Método que actualiza un Jugador en la base de datos con los nuevos parametros en un objeto Respuesta
    void actualizarRespuesta(Respuesta respuesta);
}
