package com.tiny.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.GdxRuntimeException;


public  class Invencibilidad extends Pastilla {
    private Texture imagen;
    public Invencibilidad(int x,int y){
        this.x=x;
        this.y=y;
        try{
            imagen = new Texture(Gdx.files.internal("Pastilla.png"));
        }catch(GdxRuntimeException e){
            System.out.println("ERROR..."+e.getMessage());
        }
    }
    @Override
    public void setX(int x){
        this.x=x;
    }
    @Override
    public void setY(int y){this.y=y;}
    @Override
    public int getX(){
        return x;
    }
    @Override
    public int getY(){return y;}
    @Override
    public void dibuja(final SpriteBatch batch){
        batch.draw(imagen,x,y);
    }
    @Override
    public void move(){
        this.setY(this.getY()+1);
    }
}