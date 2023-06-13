package com.proyectofinal.MazeQuiz.dao;

import com.proyectofinal.MazeQuiz.models.Quiz;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface QuizDAO {

    //método que retornará todas los Quiz de la bd;
    List<Quiz> getQuizs();

    List<Quiz> getQuizsPorPregunta(int id);

    //retorna un Quiz con el id indicado;
    List<Quiz> getQuiz(int id);

    //permite agregar una nueva Quiz
    void registrarQuiz(int pregunta, int respuesta, int value);

    //Elimina una Quiz de la base de datos;
    void eliminarQuiz(int id);

}
