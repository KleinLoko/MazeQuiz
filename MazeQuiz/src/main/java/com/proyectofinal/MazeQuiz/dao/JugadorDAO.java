package com.proyectofinal.MazeQuiz.dao;

import com.proyectofinal.MazeQuiz.models.Jugador;

import java.util.List;

/*
 * Esta clase se encarga de administrar los métodos que se tendran para el Modelo Jugador
 * pero no implementa su funcionalidad
 */

public interface JugadorDAO {

    //método que retornará todas los Jugadores de la bd;
    List<Jugador> getJugadores();

    //Método que busca un Jugador por su ID
    Jugador getJugador(int id);

    //Método que carga un jugador nuevo a la base de datos Enviando un objeto de tipo Jugador
    void registrarJugador(Jugador jugador);

    //Método que elimina un jugador de la base de datos si coincide con el ID recibido
    void eliminar(int id);

    //Método para verificar crendeciales (Actualmente desahabilitado)
    boolean verificarCredenciales(Jugador jugador);

    //Método que actualiza un Jugador en la base de datos con los nuevos parametros en un objeto Jugador
    void actualizarJugador(Jugador jugador);

    void AumentarPuntaje(int jugadorid);
}
 