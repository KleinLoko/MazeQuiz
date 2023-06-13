package com.proyectofinal.MazeQuiz.models;

import com.proyectofinal.MazeQuiz.dao.JugadorDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Clase que
 */
@Repository
@Transactional
public class JugadorDaoImp implements JugadorDAO {


    @PersistenceContext
    EntityManager entityManager; // se utiliza para realizar operaciones de lectura, escritura, actualización y eliminación en la base de datos.

    /**
     * Consulta HQL que permite obtener todos los jugadores de la base de datos
     * @return
     */
    @Override
    public List<Jugador> getJugadores() {
        String query = "FROM Jugador";
        return entityManager.createQuery(query).getResultList();
    }

    /**
     * Metodo que permite aumentar el puntaje de un jugador
     * @param jugadorid
     */
    @Override
    public void AumentarPuntaje(int jugadorid) {
        Jugador jugador = entityManager.find(Jugador.class, jugadorid);
        if (jugador != null) {
            jugador.setJugPuntaje(jugador.getJugPuntaje() + 1);
            entityManager.merge(jugador);

        }
    }

    /**
     * método que permite obtener un solo jugador de la base de datos
     * @param id
     * @return
     */
    @Override
    public Jugador getJugador(int id) {
        Jugador jugador = entityManager.find(Jugador.class, id);
        return jugador;
    }

    /**
     * Metodo que permite registrar un nuevo jugador
     * @param jugador
     */
    @Override
    public void registrarJugador(Jugador jugador) {
        entityManager.merge(jugador);
    }

    /**
     * método que permite eliminar un jugador según su id
     * @param id
     */
    @Override
    public void eliminar(int id) {
        Jugador jugador = entityManager.find(Jugador.class, id);
        entityManager.remove(jugador);
    }

    /**
     * Este metodo esta deshabilitado
     * @param jugador
     * @return
     */
    @Override
    public boolean verificarCredenciales(Jugador jugador) {
        String query = "FROM Jugador WHERE jugid = :matricula AND jugPassword = :password ";
        List<Jugador> lista = entityManager.createQuery(query)
                .setParameter("matricula", jugador.getJugid()).
                setParameter("password", jugador.getJugPassword())
                .getResultList();

        return !lista.isEmpty();
    }

    /**
     * Este metodo permite actualizar las caracteristicas de un jugador
     * @param jugador
     */
    @Override
    public void actualizarJugador(Jugador jugador) {
        entityManager.merge(jugador);
    }
}
