package com.tiny.game;

import java.io.Serializable;

public class Jugador implements Serializable {
    private int score;
    private String nom;
    public Jugador(String nom){
        this.score = 0;
        this.nom =nom;
    }
    public void setScore(int score){
        this.score=score;
    }
    public int getScore(){
        return  this.score;

    }
}
