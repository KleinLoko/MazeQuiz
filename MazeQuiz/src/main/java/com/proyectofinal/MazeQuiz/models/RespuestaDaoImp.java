package com.proyectofinal.MazeQuiz.models;

import com.proyectofinal.MazeQuiz.dao.RespuestaDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RespuestaDaoImp implements RespuestaDAO {

    @PersistenceContext
    EntityManager entityManager;// se utiliza para realizar operaciones de lectura, escritura, actualización y eliminación en la base de datos.

    /**
     * Consulta HQL que permite obtener todas las respuestas de la base de datos
     * @return
     */
    @Override
    public List<Respuesta> getRespuestas() {
        String query = "SELECT new Respuesta(r.resID, r.resDescrip ) FROM Respuesta r";
        List<Respuesta> re = entityManager.createQuery(query, Respuesta.class).getResultList();
        return re;
    }

    /**
     * Retorna un objeto Respuesta
     * @param id
     * @return
     */
    @Override
    public Respuesta getRespuesta(int id) {
        Respuesta respuesta = entityManager.find(Respuesta.class, id);
        respuesta.setQuizzes(null);
        return respuesta;
    }

    /**
     * Permite agregar una nueva respuesta
     * @param respuesta
     */
    @Override
    public void registrarRespuesta(Respuesta respuesta) {
        entityManager.merge(respuesta);
    }

    /**
     * método que permite eliminar una respuesta según su id
     * @param id
     */
    @Override
    public void eliminarRespuesta(int id) {
        Respuesta respuesta = entityManager.find(Respuesta.class, id);
        entityManager.remove(respuesta);
    }

    /**
     * Permite actualizar una respuesta
     * @param respuesta
     */
    @Override
    public void actualizarRespuesta(Respuesta respuesta) {
        entityManager.merge(respuesta);
    }

}
