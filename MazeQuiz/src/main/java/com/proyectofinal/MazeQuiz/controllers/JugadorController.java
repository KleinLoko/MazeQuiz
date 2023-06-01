package com.proyectofinal.MazeQuiz.controllers;

import com.proyectofinal.MazeQuiz.dao.JugadorDAO;
import com.proyectofinal.MazeQuiz.models.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *  Clase JugadorController
 *  Esta clase implementa los métodos de JugadorDao especificando en cada uno el token que funge como
 *  enlace para redireccionar al endpoint el cual hace solicitudes HTTP a la base de datos.
 */

@CrossOrigin
@RestController
public class JugadorController implements JugadorDAO {

    @Autowired
    private JugadorDAO jugadorDAO;

    /**
     * Método que retorna una lista de tipo Jugador, con todos lo jugadores
     * extraidos de la Base de datos, haciendo uso de la instruccion GET.
     *
     * @return
     */
    @Override
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "jugador", method = RequestMethod.GET)
    public List<Jugador> getJugadores() {
        return jugadorDAO.getJugadores();
    }

    /**
     * Método que retorna un solo jugador, si se encuentra alguno con el ID
     * especificado, haciendo uso de la instruccion GET.
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "jugador/{id}", method = RequestMethod.GET)
    public Jugador getJugador(@PathVariable int id) {
        return jugadorDAO.getJugador(id);
    }

    /**
     * Médoto que mandá que a travéz de la instruccion POST, un objeto de tipo
     * Jugador, con un ID ya existente, que sobreescribira el resto de los campos
     * con el que se les haya reasignado.
     *
     * @param jugador
     */
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "actualizarjugador", method = RequestMethod.POST)
    public void actualizarJugador(@RequestBody Jugador jugador) {
        jugadorDAO.actualizarJugador(jugador);
    }

    /**
     * Manda un objeto de tipo Jugador que no existe en la base datos para que sea
     * registrado, haciendo uso de la instrucción POST.
     *
     * @param jugador
     */
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "guardarjugador", method = RequestMethod.POST)
    public void registrarJugador(@RequestBody Jugador jugador) {
        jugadorDAO.registrarJugador(jugador);
    }

    /**
     * Método que con el uso de la instruccion DELETE para eliminar un jugador de la Base de datos
     * que coincida con el ID enviado en el end point.
     *
     * @param id
     */
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "eliminarjugador/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int id) {
        jugadorDAO.eliminar(id);
    }

    /**
     * Método desahibilidado
     * Método que se usaba para comparar las credenciales enviadas en un login obsoleto
     *
     * @param jugador
     * @return
     */
    @Override
    public boolean verificarCredenciales(Jugador jugador) {
        return false;
    }

}
