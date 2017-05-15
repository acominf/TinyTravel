package com.tinytravel.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
public class TinyTravel extends ApplicationAdapter implements ApplicationListener{
	SpriteBatch batch;
	private Celula celula;
	@Override
	public void create () {
		batch = new SpriteBatch();
		celula = new Celula(400,420);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int w = Gdx.graphics.getWidth(); //Obtener las dimensiones del graphico en x
		int h = Gdx.graphics.getHeight(); //Obtener las dimensiones del graphico en y

	    if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
	    	celula.setX(celula.getX()-10);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
	    	celula.setX(celula.getX()+10);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			celula.setY(celula.getY()-10);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			celula.setY(celula.getY()+10);
		}
		//Restriccion
		if(celula.getX()>=w-60){
			celula.setX(celula.getX()-10);
		}
		if(celula.getX()<=0){
			celula.setX(celula.getX()+10);
		}
		if(celula.getY()>=h-60){
			celula.setY(celula.getY()-10);
		}
		if(celula.getY()<=0){
			celula.setY(celula.getY()+10);
		}
		batch.begin();
		celula.render(batch);
		batch.end();
	}
	@Override
	public void dispose () {
		batch.dispose();
	}
}
