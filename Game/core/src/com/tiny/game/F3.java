package com.tiny.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class F3{
    private int x,y;
    private Texture membrana;
    private Texture membrana1;
    private Texture membrana2;
    private Texture membrana3;

    public F3(int x, int y){
        this.x=x;
        this.y=y;
        membrana  = new Texture(Gdx.files.internal("ParedMembrana/P3.jpg"));
        membrana1 = new Texture(Gdx.files.internal("ParedMembrana/R3.jpg"));
        membrana2 = new Texture(Gdx.files.internal("ParedMembrana/L3.jpg"));
        membrana3 = new Texture(Gdx.files.internal("ParedMembrana/S3.jpg"));
    }

    public void setX(int x){
        this.x = x;
    }
    public  void setY(int y){
        this.y=y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public void dibuja(SpriteBatch batch){
        batch.draw(membrana,x,y);
    }
    public void dibuja1(SpriteBatch batch){batch.draw(membrana1,x,y);}
    public void dibuja2(SpriteBatch batch){batch.draw(membrana2,x,y);}
    public void dibuja3(SpriteBatch batch){batch.draw(membrana3,x,y);}
    public void move(){
        this.setY(this.getY()+1);
    }
    public Texture getImage(){
        return membrana;
    }
}

