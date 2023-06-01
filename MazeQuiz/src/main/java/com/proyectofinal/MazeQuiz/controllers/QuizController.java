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

    @Autowired
    QuizDAO quizDAO;

    /**
     *
     * @return
     */
    @Override
    @RequestMapping( value = "quiz", method = RequestMethod.GET)
    public List<Quiz> getQuizs() { return quizDAO.getQuizs(); }

    /**
     *
     * @param id
     * @return
     */
    @Override
    @RequestMapping( value = "quiz/{id}", method = RequestMethod.GET)
    public  List<Quiz> getQuiz(@PathVariable int id) { return quizDAO.getQuiz(id);}

    /**
     *
     */
    @Override
    @RequestMapping(value = "guardarquiz/{pregunta}/{respuesta}/{value}", method = RequestMethod.POST)
    public void registrarQuiz(@PathVariable int pregunta,@PathVariable int respuesta,@PathVariable int value) { quizDAO.registrarQuiz(  pregunta, respuesta, value);}

    /**
     *
     * @param id
     */
    @Override
    @RequestMapping(value = "eliminarquiz/{id}", method = RequestMethod.DELETE)
    public void eliminarQuiz(@PathVariable int id) {quizDAO.eliminarQuiz(id);}
}
