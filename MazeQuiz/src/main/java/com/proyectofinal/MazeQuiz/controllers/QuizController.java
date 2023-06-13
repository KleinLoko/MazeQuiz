package com.proyectofinal.MazeQuiz.controllers;

import com.proyectofinal.MazeQuiz.dao.QuizDAO;
import com.proyectofinal.MazeQuiz.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *  Clase QuizController
 *  Esta clase implementa los métodos de QuizController especificando en cada uno el token que funge como
 *  enlace para redireccionar al endpoint el cual hace solicitudes HTTP a la base de datos.
 */

@CrossOrigin
@RestController
public class QuizController implements QuizDAO {

    //declaracion de objeto QuizDAO
    @Autowired
    QuizDAO quizDAO;

    /**
     * Método que retorna una lista de tipo Quizz, con todas las respuestas
     * extraidos de la Base de datos, haciendo uso de la instruccion GET.
     *
     * @return
     */
    @Override
    @RequestMapping(value = "quiz", method = RequestMethod.GET)
    public List<Quiz> getQuizs() {
        return quizDAO.getQuizs();
    }

    @Override
    @RequestMapping(value = "quizpregunta/{id}", method = RequestMethod.GET)
    public List<Quiz> getQuizsPorPregunta(@PathVariable int id) {
        return quizDAO.getQuizsPorPregunta(id);
    }


    /**
     * Método que retorna un solo quiz, si se encuentra alguna con el ID
     * especificado, haciendo uso de la instruccion GET.
     *
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "quiz/{id}", method = RequestMethod.GET)
    public List<Quiz> getQuiz(@PathVariable int id) {
        return quizDAO.getQuiz(id);
    }

    /**
     * Manda un objeto de tipo Respuesta que no existe en la base datos para que sea
     * registrado, haciendo uso de la instrucción POST.
     *
     * @param pregunta
     * @param respuesta
     * @param value
     */
    @Override
    @RequestMapping(value = "guardarquiz/{pregunta}/{respuesta}/{value}", method = RequestMethod.POST)
    public void registrarQuiz(@PathVariable int pregunta, @PathVariable int respuesta, @PathVariable int value) {
        quizDAO.registrarQuiz(pregunta, respuesta, value);
    }

    /**
     * Método que con el uso de la instruccion DELETE para eliminar un quizz de la Base de datos
     * que coincida con el ID enviado en el end point.
     *
     * @param id
     */
    @Override
    @RequestMapping(value = "eliminarquiz/{id}", method = RequestMethod.DELETE)
    public void eliminarQuiz(@PathVariable int id) {
        quizDAO.eliminarQuiz(id);
    }
}
