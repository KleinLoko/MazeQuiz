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
    private int idQuiz;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregid")
    private Pregunta pregunta;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resid")
    private Respuesta respuesta;

    @Getter
    @Setter
    @Column(name = "quizValue", nullable = false)
    private int quizValue;

    public Quiz(int idQuiz, Pregunta pregunta, Respuesta respuesta, int quizValue) {
        this.idQuiz = idQuiz;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.quizValue = quizValue;
    }

    public Quiz(Pregunta pregunta, Respuesta respuesta, int quizValue) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.quizValue = quizValue;
    }

    public Quiz() {
    }
}
