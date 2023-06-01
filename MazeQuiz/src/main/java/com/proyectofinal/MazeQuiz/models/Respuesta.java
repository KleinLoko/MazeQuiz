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
    @Column(name = "resID")
    private int resID;

    @Getter
    @Setter
    @OneToMany(mappedBy = "respuesta")
    private List<Quiz> quizzes = new ArrayList<>();

    @Getter
    @Setter
    @Column(name = "resDescript", nullable = false)
    private String resDescrip;

    public Respuesta(int resID, String resDescrip, List<Quiz> quizzes) {
        this.resID = resID;
        this.resDescrip = resDescrip;
        this.quizzes = quizzes;
    }

    public Respuesta(int resID, String resDescrip) {
        this.resID = resID;
        this.resDescrip = resDescrip;
    }

    public Respuesta() {
    }
}
