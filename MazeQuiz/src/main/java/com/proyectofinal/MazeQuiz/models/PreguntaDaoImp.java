package com.proyectofinal.MazeQuiz.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectofinal.MazeQuiz.dao.PreguntaDAO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@Transactional
public class PreguntaDaoImp implements PreguntaDAO {

    @PersistenceContext
    EntityManager entityManager;// se utiliza para realizar operaciones de lectura, escritura, actualización y eliminación en la base de datos.

    /**
     * Consulta HQL que permite obtener todas las preguntas de la base de datos
     * @return
     */
    @Override
    public List<Pregunta> getPreguntas() {
        String query = "SELECT new Pregunta(p.pregId, p.pregDescrip, p.pregValor) FROM Pregunta p";
        List<Pregunta> preguntas = entityManager.createQuery(query, Pregunta.class).getResultList();

        return preguntas;
    }

    /**
     * método que permite obtener una sola pregunta de la base de datos
     * @param id
     * @return
     */
    @Override
    public Pregunta getPregunta(int id) {
        Pregunta pregunta = entityManager.find(Pregunta.class, id);
        return pregunta;
    }

    /**
     * Metodo para actualizar una pregunta
     * @param pregunta
     */
    @Override
    public void actualizarPregunta(Pregunta pregunta) {
        entityManager.merge(pregunta);
    }

    /**
     *  Metodo para registrar una nueva pregunta
     * @param pregunta
     */
    @Override
    public void registrarPregunta(Pregunta pregunta) {
        entityManager.merge(pregunta);
    }

    /**
     * método que permite eliminar una pregunta según su id
     * @param id
     */
    @Override
    public void eliminarPrgunta(int id) {
        Pregunta pregunta = entityManager.find(Pregunta.class, id);
        entityManager.remove(pregunta);
    }

}
