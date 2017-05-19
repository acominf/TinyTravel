package com.tinytravel.game;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by alval on 11/05/2017.
 */
public class Celula extends Personaje implements ApplicationListener{
    private Animation animacion;
    private float tiempo;
    private TextureRegion[] regionMovimiento;
    private Texture imagen;
    private TextureRegion frameActual;

    public Celula(int x,int y){
        this.x=x;
        this.y=y;
        imagen = new Texture(Gdx.files.internal("tiny.png"));
        TextureRegion[][] tmp = TextureRegion.split(imagen,imagen.getWidth()/2,imagen.getHeight());
        regionMovimiento = new TextureRegion[2];
        for(int i = 0;i < 2 ; i++) {
            regionMovimiento[i] = tmp[0][i];
        }
        animacion = new Animation(1/5f,regionMovimiento);
        tiempo = 0f;
        //sprite = new Sprite(new Texture(Gdx.files.internal("insecto.png")),64,64);
    }
    @Override
    public void setX(int x){
        this.x=x;
    }
    @Override
    public void setY(int y){
        this.y=y;
    }
    @Override
    public int getX(){
        return x;
    }
    @Override
    public int getY(){
        return y;
    }
    @Override
    public void dibuja(final SpriteBatch batch){
        tiempo+= Gdx.graphics.getDeltaTime(); //El tiempo que paso desde el utlimo render()
        frameActual = (TextureRegion)animacion.getKeyFrame(tiempo,true);
        batch.draw(frameActual,x,y);
    }
    public boolean isColliding(Elemento personaje){
        if(this.getX()+32>=personaje.getX() && this.getX()+32<=personaje.getX()+64 && this.getY()+32>=personaje.getY() && this.getY()+32<=personaje.getY()+64){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void move(){
        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            this.setX(this.getX()-2);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            this.setX(this.getX()+2);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            this.setY(this.getY()-2);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            this.setY(this.getY()+2);
        }
        //Restriccion
        if(this.getX()>=w-60){
            this.setX(this.getX()-2);
        }
        if(this.getX()<=0){
            this.setX(this.getX()+2);
        }
        if(this.getY()>=h-60){
            this.setY(this.getY()-2);
        }
        if(this.getY()<=100){
            this.setY(this.getY()+2);
        }
    }
    @Override
    public void create(){

    }
    @Override
    public void render(){

    }
    @Override
    public void dispose(){

    }
    @Override
    public void pause(){

    }
    @Override
    public void resume(){

    }
    @Override
    public void resize(int x, int y){

    }
}
