package com.proyectofinal.MazeQuiz.models;

import com.proyectofinal.MazeQuiz.dao.QuizDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class QuizDaoImp implements QuizDAO {


    @PersistenceContext
    EntityManager entityManager;// se utiliza para realizar operaciones de lectura, escritura, actualización y eliminación en la base de datos.


    /**
     * Consulta HQL que permite obtener todos los quiz de la base de datos
     * @return
     */
    @Override
    public List<Quiz> getQuizs() {
        String query = "SELECT q.idQuiz, q.pregunta.pregId, q.pregunta.pregDescrip, " +
                "q.respuesta.resID, q.respuesta.resDescrip, q.quizValue " +
                "FROM Quiz q JOIN q.pregunta p JOIN q.respuesta r";

        //String query = "From Quiz";
        return entityManager.createQuery(query).getResultList();

        //return entityManager.createQuery(query, Quiz.class).getResultList();
    }

    /**
     * Metodo que permite obtener el Quiz que corresponde a la pregunta
     * @param id
     * @return
     */
    @Override
    public List<Quiz> getQuizsPorPregunta(int id) {
        String query = "SELECT q.idQuiz, q.pregunta.pregId, q.pregunta.pregDescrip, " +
                "q.respuesta.resID, q.respuesta.resDescrip, q.quizValue " +
                "FROM Quiz q " +
                "JOIN q.pregunta p " +
                "JOIN q.respuesta r " +
                "WHERE q.pregunta.pregId = :pregId";

        return entityManager.createQuery(query)
                .setParameter("pregId", id) // Reemplaza "tuPregId" con el ID deseado
                .getResultList();
    }

    /**
     * Consulta HQL que permite obtener un quiz de la base de datos
     * @param id
     * @return
     */
    @Override
    public List<Quiz> getQuiz(int id) {
        String query = "SELECT q.idQuiz, q.pregunta.pregId, q.pregunta.pregDescrip, " +
                "q.respuesta.resID, q.quizValue " +
                "FROM Quiz q JOIN q.pregunta p JOIN q.respuesta r WHERE q.idQuiz = :id";


        return entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();
        //  return entityManager.createQuery(query).getResultList();
    }

    /**
     * método que permite registrar un nuevo quiz en la base de datos
     */
    @Override
    public void registrarQuiz(int pregunta, int respuesta, int value) {
        Quiz miQuiz = new Quiz();
        Pregunta miPregunta = entityManager.find(Pregunta.class, pregunta);
        Respuesta miRespuesta = entityManager.find(Respuesta.class, respuesta);

        miQuiz.setPregunta(miPregunta);
        miQuiz.setRespuesta(miRespuesta);
        miQuiz.setQuizValue(value);

        entityManager.merge(miQuiz);

    }

    /**
     * método que permite eliminar un quiz según su id
     * @param id
     */
    @Override
    public void eliminarQuiz(int id) {
        Quiz quiz = entityManager.find(Quiz.class, id);
        entityManager.remove(quiz);
    }
}
