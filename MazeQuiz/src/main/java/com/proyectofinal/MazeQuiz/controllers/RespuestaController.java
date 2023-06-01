package com.proyectofinal.MazeQuiz.controllers;

import com.proyectofinal.MazeQuiz.dao.RespuestaDAO;
import com.proyectofinal.MazeQuiz.models.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *  Clase RespuestaController
 *  Esta clase implementa los métodos de RespuestaController especificando en cada uno el token que funge como
 *  enlace para redireccionar al endpoint el cual hace solicitudes HTTP a la base de datos.
 */

@CrossOrigin
@RestController
public class RespuestaController implements RespuestaDAO{

    @Autowired
    private RespuestaDAO respestaDAO;

    /**
     * Método que retorna una lista de tipo Respuesta, con todas las respuestas
     * extraidos de la Base de datos, haciendo uso de la instruccion GET.
     *
     * @return
     */
    @Override
    @RequestMapping( value = "respuesta", method = RequestMethod.GET)
    public List<Respuesta> getRespuestas() {
        return respestaDAO.getRespuestas();
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping( value = "respuesta/{id}", method = RequestMethod.GET)
    public Respuesta getRespuesta(@PathVariable int id) {
        return respestaDAO.getRespuesta(id);
    }

    /**
     *
     * @param jugador
     */
    @RequestMapping(value = "guardarrespuesta", method = RequestMethod.POST)
    public void registrarRespuesta(@RequestBody Respuesta jugador) {
        respestaDAO.registrarRespuesta(jugador);
    }

    /**
     *
     * @param respuesta
     */
    @RequestMapping(value = "actualizarrespuesta", method = RequestMethod.POST)
    public void actualizarRespuesta(@RequestBody Respuesta respuesta) {respestaDAO.actualizarRespuesta(respuesta);}

    /**
     *
     * @param id
     */
    @RequestMapping(value = "eliminarrespuesta/{id}", method = RequestMethod.DELETE)
    public void eliminarRespuesta(@PathVariable int id){
        respestaDAO.eliminarRespuesta(id);
    }

}
