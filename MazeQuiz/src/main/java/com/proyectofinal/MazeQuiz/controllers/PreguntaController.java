package com.proyectofinal.MazeQuiz.controllers;

import com.proyectofinal.MazeQuiz.dao.PreguntaDAO;
import com.proyectofinal.MazeQuiz.models.Pregunta;
import com.proyectofinal.MazeQuiz.models.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *  Clase Pregunta Controller
 *  Esta clase implementa los métodos de PreguntaDao especificando en cada uno el token que funge como
 *  enlace para redireccionar al endpoint el cual hace solicitudes HTTP a la base de datos.
 */

@CrossOrigin
@RestController
public class PreguntaController implements PreguntaDAO {

    @Autowired
    private PreguntaDAO preguntaDAO;


    /**
     * Método que retorna una lista de tipo Pregunta, con todos lo jugadores
     * extraidos de la Base de datos, haciendo uso de la instruccion GET.
     *
     * @return
     */
    @Override
    @RequestMapping(value = "pregunta", method = RequestMethod.GET)
    public List<Pregunta> getPreguntas() {
        return preguntaDAO.getPreguntas();
    }

    /**
     * Método que retorna una sola pregunta, si se encuentra alguna con el ID
     * especificado, haciendo uso de la instruccion GET.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "pregunta/{id}", method = RequestMethod.GET)
    public Pregunta getPregunta(@PathVariable int id) {
        return preguntaDAO.getPregunta(id);
    }

    /**
     * Médoto que mandá que a travéz de la instruccion POST, un objeto de tipo
     * Pregunta, con un ID ya existente, que sobreescribira el resto de los campos
     * con el que se les haya reasignado.
     *
     * @param pregunta
     */
    @RequestMapping(value = "actualizarpregunta", method = RequestMethod.POST)
    public void actualizarPregunta(@RequestBody Pregunta pregunta) {
        preguntaDAO.actualizarPregunta(pregunta);
    }

    /**
     * Manda un objeto de tipo Pregunta que no existe en la base datos para que sea
     * registrado, haciendo uso de la instrucción POST.
     *
     * @param pregunta
     */
    @RequestMapping(value = "guardarpregunta", method = RequestMethod.POST)
    public void registrarPregunta(@RequestBody Pregunta pregunta) {
        preguntaDAO.registrarPregunta(pregunta);
    }

    /**
     * Método que con el uso de la instruccion DELETE para eliminar un jugador de la Base de datos
     * que coincida con el ID enviado en el end point.
     *
     * @param id
     */
    @RequestMapping(value = "eliminarpregunta/{id}", method = RequestMethod.DELETE)
    public void eliminarPrgunta(@PathVariable int id) {
        preguntaDAO.eliminarPrgunta(id);

    }
}
