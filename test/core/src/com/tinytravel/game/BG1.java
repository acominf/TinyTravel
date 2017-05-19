package com.tinytravel.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by alval on 18/05/2017.
 */
public class BG1 {
    private int x,y;
    private Texture imagen;
    public BG1(int x, int y){
        this.x=x;
        this.y=y;
        imagen = new Texture(Gdx.files.internal("bg1.png"));
    }

    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){this.y=y;}
    public int getX(){
        return x;
    }
    public int getY(){return y;}
    public void dibuja(final SpriteBatch batch){
        batch.draw(imagen,x,y);
    }
    public void move(){
        this.setY(this.getY()+1);
    }

}
