package com.proyectofinal.MazeQuiz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Modelo del jugador
 */
@Entity
@Table(name = "jugador")
public class Jugador {

    //declaracion de variables
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jugID")
    private int jugid; /// ID de jugador

    @Getter
    @Setter
    @Column(name = "jugNombre", nullable = false)
    private String jugNombre; //Nombre del jugador

    @Getter
    @Setter
    @Column(name = "jugApellidoPat", nullable = false)
    private String jugApellidoPat; //Apellido paterno del jugador

    @Getter
    @Setter
    @Column(name = "jugApellidoMat", nullable = false)
    private String jugApellidoMat;  //Apellido Materno del jugador

    @Getter
    @Setter
    @Column(name = "jugCarrera", nullable = false)
    private String jugCarrera;  //Carrera del jugador

    @Getter
    @Setter
    @Column(name = "jugPuntaje", nullable = false)
    private int jugPuntaje; //Piso del jugador

    @Getter
    @Setter
    @Column(name = "jugPassword", nullable = false)
    private String jugPassword; //Contraseña del jugador


    /**
     * Constructor completo
     * @param jugid
     * @param jugNombre
     * @param jugApellidoPat
     * @param jugApellidoMat
     * @param jugCarrera
     * @param jugPuntaje
     * @param jugPassword
     */
    public Jugador(int jugid, String jugNombre, String jugApellidoPat, String jugApellidoMat, String jugCarrera, int jugPuntaje, String jugPassword) {
        this.jugid = jugid;
        this.jugNombre = jugNombre;
        this.jugApellidoPat = jugApellidoPat;
        this.jugApellidoMat = jugApellidoMat;
        this.jugCarrera = jugCarrera;
        this.jugPuntaje = jugPuntaje;
        this.jugPassword = jugPassword;
    }

    /**
     * Constructor vacío
     */
    public Jugador() {
    }
}
