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

import java.util.ArrayList;

public class TinyTravel extends ApplicationAdapter {
	SpriteBatch batch;
	private Celula celula;
	private ArrayList<Globulo> arrayGlobulo;
	private ArrayList<Virus> arrayVirus;
	private ArrayList<Pastilla> arrayPastilla;
	private Globulo globulo;
	private Pastilla pastilla;
	@Override
	public void create () {
		batch = new SpriteBatch();
		arrayGlobulo = new ArrayList<Globulo>();
		arrayPastilla = new ArrayList<Pastilla>();
		arrayGlobulo.add(globulo = new Globulo(200,420));
		arrayPastilla.add(pastilla = new Invencibilidad(100,100));
		celula = new Celula(400,420);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    celula.move();
		//Objects Colliding
		if(celula.isColliding(globulo)){
			System.out.println("Objects Colliding at "+celula.getX()+" "+celula.getY());
		}
		batch.begin();
		celula.dibuja(batch);
		arrayGlobulo.get(0).dibuja(batch);
		arrayPastilla.get(0).dibuja(batch);
		batch.end();
	}
	@Override
	public void dispose () {
		batch.dispose();
	}
}
