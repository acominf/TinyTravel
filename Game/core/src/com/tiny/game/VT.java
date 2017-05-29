package com.tiny.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.GdxRuntimeException;


public class VT extends Virus {
    private Animation animacion;
    private float tiempo;
    private TextureRegion[] regionMovimiento;
    private TextureRegion frameActual;
    private Texture imagen;
    public VT(int x, int y){
        this.x=x;
        this.y=y;
        try{
            imagen = new Texture(Gdx.files.internal("virust.png"));
            TextureRegion[][] tmp = TextureRegion.split(imagen,imagen.getWidth()/2,imagen.getHeight());
            regionMovimiento = new TextureRegion[2];
            for(int i = 0;i < 2 ; i++) {
                regionMovimiento[i] = tmp[0][i];
            }
            animacion = new Animation(1/5f,regionMovimiento);
            tiempo = 0f;
        }catch (GdxRuntimeException e){
            System.out.println("ERROR..."+ e.getMessage());
        }
    }
    public void dibuja(SpriteBatch batch){
        tiempo+= Gdx.graphics.getDeltaTime(); //El tiempo que paso desde el utlimo render()
        frameActual = (TextureRegion)animacion.getKeyFrame(tiempo,true);
        batch.draw(frameActual,x,y);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y=y;
    }

    public void ataque(){

    }
    public void move(){
        this.setY(this.getY()+1);
    }
}