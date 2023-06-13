package com.proyectofinal.MazeQuiz.controllers;

import com.proyectofinal.MazeQuiz.dao.RespuestaDAO;
import com.proyectofinal.MazeQuiz.models.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/*
 *  Clase RespuestaController
 *  Esta clase implementa los métodos de RespuestaController especificando en cada uno el token que funge como
 *  enlace para redireccionar al endpoint el cual hace solicitudes HTTP a la base de datos.
 */

@CrossOrigin
@RestController
public class RespuestaController implements RespuestaDAO {

    @Autowired
    private RespuestaDAO respestaDAO;

    /**
     * Método que retorna una lista de tipo Respuesta, con todas las respuestas
     * extraidos de la Base de datos, haciendo uso de la instruccion GET.
     *
     * @return
     */
    @Override
    @RequestMapping(value = "respuesta", method = RequestMethod.GET)
    public List<Respuesta> getRespuestas() {
        return respestaDAO.getRespuestas();
    }

    /**
     * Método que retorna una sola respuesta, si se encuentra alguna con el ID
     * especificado, haciendo uso de la instruccion GET.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "respuesta/{id}", method = RequestMethod.GET)
    public Respuesta getRespuesta(@PathVariable int id) {
        return respestaDAO.getRespuesta(id);
    }

    /**
     * Manda un objeto de tipo Respuesta que no existe en la base datos para que sea
     * registrado, haciendo uso de la instrucción POST.
     *
     * @param respuesta
     */
    @RequestMapping(value = "guardarrespuesta", method = RequestMethod.POST)
    public void registrarRespuesta(@RequestBody Respuesta respuesta) {
        respestaDAO.registrarRespuesta(respuesta);
    }

    /**
     * Médoto que mandá que a travéz de la instruccion POST, un objeto de tipo
     * Respuesta, con un ID ya existente, que sobreescribirá el resto de los campos
     * con el que se les haya reasignado.
     *
     * @param respuesta
     */
    @RequestMapping(value = "actualizarrespuesta", method = RequestMethod.POST)
    public void actualizarRespuesta(@RequestBody Respuesta respuesta) {
        respestaDAO.actualizarRespuesta(respuesta);
    }

    /**
     * Método que con el uso de la instruccion DELETE para eliminar una respuesta de la Base de datos
     * que coincida con el ID enviado en el end point.
     *
     * @param id
     */
    @RequestMapping(value = "eliminarrespuesta/{id}", method = RequestMethod.DELETE)
    public void eliminarRespuesta(@PathVariable int id) {
        respestaDAO.eliminarRespuesta(id);
    }

}
