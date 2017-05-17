package com.tinytravel.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by alval on 16/05/2017.
 */
public  class Invencibilidad extends Pastilla {
    private Animation animacion;
    private float tiempo;
    private TextureRegion[] regionMovimiento;
    private Texture imagen;
    private TextureRegion frameActual;

    public Invencibilidad(int x,int y){
        this.x=x;
        this.y=y;
        imagen = new Texture(Gdx.files.internal("pastilla.png"));
        TextureRegion[][] tmp = TextureRegion.split(imagen,imagen.getWidth()/3,imagen.getHeight());
        regionMovimiento = new TextureRegion[3];
        for(int i = 0;i < 3 ; i++) {
            regionMovimiento[i] = tmp[0][i];
        }
        animacion = new Animation(1/3f,regionMovimiento);
        tiempo = 0f;
        //sprite = new Sprite(new Texture(Gdx.files.internal("insecto.png")),64,64);
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
        tiempo+= Gdx.graphics.getDeltaTime(); //El tiempo que paso desde el utlimo render()
        frameActual = (TextureRegion)animacion.getKeyFrame(tiempo,true);
        batch.draw(frameActual,x,y);
    }
    @Override
    public void move(){}
}