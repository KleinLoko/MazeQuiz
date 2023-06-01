package com.proyectofinal.MazeQuiz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "jugador")
public class Jugador {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jugID")
    private int jugid;

    @Getter
    @Setter
    @Column(name = "jugNombre", nullable = false)
    private String jugNombre;

    @Getter
    @Setter
    @Column(name = "jugApellidoPat", nullable = false)
    private String jugApellidoPat;

    @Getter
    @Setter
    @Column(name = "jugApellidoMat", nullable = false)
    private String jugApellidoMat;

    @Getter
    @Setter
    @Column(name = "jugCarrera", nullable = false)
    private String jugCarrera;

    @Getter
    @Setter
    @Column(name = "jugPuntaje", nullable = false)
    private int jugPuntaje;

    @Getter
    @Setter
    @Column(name = "jugPassword", nullable = false)
    private String jugPassword;


    public Jugador(int jugid, String jugNombre, String jugApellidoPat, String jugApellidoMat, String jugCarrera, int jugPuntaje, String jugPassword) {
        this.jugid = jugid;
        this.jugNombre = jugNombre;
        this.jugApellidoPat = jugApellidoPat;
        this.jugApellidoMat = jugApellidoMat;
        this.jugCarrera = jugCarrera;
        this.jugPuntaje = jugPuntaje;
        this.jugPassword = jugPassword;
    }

    public Jugador() {
    }
}
