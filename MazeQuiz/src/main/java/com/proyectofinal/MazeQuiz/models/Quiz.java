package com.proyectofinal.MazeQuiz.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quiz")
public class Quiz implements Serializable {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quiz")
    private int idQuiz; //ID del quiz

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregid")
    private Pregunta pregunta; //Pregunta que relaciona

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resid")
    private Respuesta respuesta; //Respuesta que relaciona

    @Getter
    @Setter
    @Column(name = "quizValue", nullable = false)
    private int quizValue; //Indica si está cuenta como solucion correcta en al relacion pregunta - respuesta

    /**
     * Constructor completo
     *
     * @param idQuiz
     * @param pregunta
     * @param respuesta
     * @param quizValue
     */
    public Quiz(int idQuiz, Pregunta pregunta, Respuesta respuesta, int quizValue) {
        this.idQuiz = idQuiz;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.quizValue = quizValue;
    }

    /**
     * Constructor sin ID
     *
     * @param pregunta
     * @param respuesta
     * @param quizValue
     */
    public Quiz(Pregunta pregunta, Respuesta respuesta, int quizValue) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.quizValue = quizValue;
    }

    /**
     * Constructor vació
     */
    public Quiz() {
    }
}
