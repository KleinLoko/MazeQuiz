package com.proyectofinal.MazeQuiz.dao;

import com.proyectofinal.MazeQuiz.models.Pregunta;
import com.proyectofinal.MazeQuiz.models.Respuesta;

import java.util.List;

/*
 * Esta clase se encarga de administrar los métodos que se tendran para el Modelo Jugador
 * pero no implementa su funcionalidad
 */

public interface PreguntaDAO {

    //método que retornará todas las preguntas de la Base de datos;
    List<Pregunta> getPreguntas();


    //Método que carga una pregunta nueva a la base de datos Enviando un objeto de tipo Pregunta
    void registrarPregunta(Pregunta pregunta);

    //Método que elimina una pregunta de la base de datos si coincide con el ID recibido
    void eliminarPrgunta(int id);

    //Método que busca una pregunta por su ID
    Pregunta getPregunta(int id);

    //Método que actualiza una Pregunta en la Base de datos con los nuevos parametros en un objeto Pregunta
    void actualizarPregunta(Pregunta pregunta);
}
