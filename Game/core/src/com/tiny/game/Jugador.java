package com.tiny.game;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String nom;
    private int score;

    public Jugador(String nom){
        this.nom=nom;
        this.score = 0;
    }
    public void setScore(int score){
        this.score=score;
    }
    public int getScore(){
        return  this.score;

    }
}
