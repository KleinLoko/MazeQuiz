package com.proyectofinal.MazeQuiz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pregunta")
public class Pregunta {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pregID", nullable = false)
    private int pregId;

    @Getter
    @Setter
    @Column(name = "pregDecrip", nullable = false)
    private String pregDescrip;

    @Getter
    @Setter
    @Column(name = "pregValor", nullable = false)
    private int pregValor;

    @Getter
    @Setter
    @OneToMany(mappedBy = "pregunta")
    private List<Quiz> quizzes = new ArrayList<>();


    public Pregunta(int pregId, String pregDescrip, List<Quiz> quizzes, int pregValor) {
        this.pregId = pregId;
        this.pregDescrip = pregDescrip;
        this.quizzes = quizzes;
        this.pregValor = pregValor;
    }

    public Pregunta(int pregId, String predDescrip, int pregValor) {
        this.pregId = pregId;
        this.pregDescrip = predDescrip;
        this.pregValor = pregValor;
    }


    public Pregunta(String pregDescrip, int pregValor, List<Quiz> quizzes) {
        this.pregDescrip = pregDescrip;
        this.pregValor = pregValor;
        this.quizzes = quizzes;
    }

    //constructor vacío
    public Pregunta() {
    }
}
