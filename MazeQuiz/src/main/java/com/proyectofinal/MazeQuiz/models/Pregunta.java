package com.proyectofinal.MazeQuiz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de los objetos Pregunta
 */
@Entity
@Table(name = "pregunta")
public class Pregunta {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pregID", nullable = false)
    private int pregId; //ID de la pregunta

    @Getter
    @Setter
    @Column(name = "pregDecrip", nullable = false)
    private String pregDescrip; //Descripcion o desarollo de la pregunta

    @Getter
    @Setter
    @Column(name = "pregValor", nullable = false)
    private int pregValor; //Valor en puntaje que se le establece a la pregunta

    @Getter
    @Setter
    @OneToMany(mappedBy = "pregunta")
    private List<Quiz> quizzes = new ArrayList<>();


    /**
     * Constructor completo
     * @param pregId
     * @param pregDescrip
     * @param quizzes
     * @param pregValor
     */
    public Pregunta(int pregId, String pregDescrip, List<Quiz> quizzes, int pregValor) {
        this.pregId = pregId;
        this.pregDescrip = pregDescrip;
        this.quizzes = quizzes;
        this.pregValor = pregValor;
    }

    /**
     * Constructor de sin el campo Quiz
     * @param pregId
     * @param predDescrip
     * @param pregValor
     */
    public Pregunta(int pregId, String predDescrip, int pregValor) {
        this.pregId = pregId;
        this.pregDescrip = predDescrip;
        this.pregValor = pregValor;
    }


    /**
     * Constructor sin ID
     * @param pregDescrip
     * @param pregValor
     * @param quizzes
     */
    public Pregunta(String pregDescrip, int pregValor, List<Quiz> quizzes) {
        this.pregDescrip = pregDescrip;
        this.pregValor = pregValor;
        this.quizzes = quizzes;
    }


    /**
     * Constructor vacío
     */
    public Pregunta() {
    }
}
