package com.proyectofinal.MazeQuiz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "respuesta")
public class Respuesta {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resID")// ID de la respuesta
    private int resID;

    @Getter
    @Setter
    @OneToMany(mappedBy = "respuesta")
    private List<Quiz> quizzes = new ArrayList<>(); //Quiz relacionados

    @Getter
    @Setter
    @Column(name = "resDescript", nullable = false)
    private String resDescrip; // Desarrollo o descripción de la respuesta

    /**
     * Constructor completo
     * @param resID
     * @param resDescrip
     * @param quizzes
     */
    public Respuesta(int resID, String resDescrip, List<Quiz> quizzes) {
        this.resID = resID;
        this.resDescrip = resDescrip;
        this.quizzes = quizzes;
    }

    /**
     * Constructor sin lo quizzes relacionados
     * @param resID
     * @param resDescrip
     */
    public Respuesta(int resID, String resDescrip) {
        this.resID = resID;
        this.resDescrip = resDescrip;
    }

    /**
     * Constructores vacío
     */
    public Respuesta() {
    }
}
