package com.tiny.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.util.ArrayList;

public class tiny extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite fondo,bgw;
	private Celula celula;
	private ArrayList<Globulo> arrayGlobulo;
	private ArrayList<Virus> arrayVirus;
	private ArrayList<Pastilla> arrayPastilla;
	private OrthographicCamera camera;
	private ArrayList<BG1> arrayFondo;
	@Override
	public void create () {

		try{
			camera = new OrthographicCamera(400,600);
			fondo = new Sprite(new Texture(Gdx.files.internal("bg.png")),400,600);
			bgw = new Sprite(new Texture(Gdx.files.internal("bgw.png")));
			batch = new SpriteBatch();
			arrayGlobulo = new ArrayList<Globulo>();
			arrayPastilla = new ArrayList<Pastilla>();
			arrayFondo = new ArrayList<BG1>();
			int var=0;
			for(int i = 0;i<12;i++){
				arrayFondo.add(new BG1(0,var));
				var+=50;
			}
			arrayGlobulo.add( new Globulo(200,420));
			arrayGlobulo.add(new Globulo(200,130));
			arrayGlobulo.add(new Globulo(300,170));
			arrayPastilla.add( new Invencibilidad(100,200));
			arrayPastilla.add(new Invencibilidad(50,180));
			arrayPastilla.add(new Invencibilidad(120,210));
			celula = new Celula(172,380);
		}catch(GdxRuntimeException e){
			System.out.println("ERROR..."+ e.getMessage());
		}

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int h =Gdx.graphics.getHeight();
		float x =camera.position.x; //200
		float y = camera.position.y; //300
		camera.setToOrtho(false,400,600);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		fondo.draw(batch);
		//Loop
		for(int i = 0;i<12;i++){
			arrayFondo.get(i).dibuja(batch);
			arrayFondo.get(i).move();
			if(arrayFondo.get(i).getY()>=Gdx.graphics.getHeight()){
				arrayFondo.get(i).setY(0);
			}
		}
		batch.end();
		//Se dibujan y mueven los glbulos
		for(int j = 0;j<arrayGlobulo.size();j++){
			batch.begin();
			arrayGlobulo.get(j).dibuja(batch);
			arrayGlobulo.get(j).move();
			if(arrayGlobulo.get(j).getY()>=Gdx.graphics.getHeight()){
				arrayGlobulo.get(j).setY(0);
			}
			if(celula.isColliding(arrayGlobulo.get(j))){
				System.out.println("Objects Colliding at "+celula.getX()+" "+celula.getY());
			}
			batch.end();
		}
		for(int i = 0;i<arrayPastilla.size();i++){
			batch.begin();
			arrayPastilla.get(i).dibuja(batch);
			arrayPastilla.get(i).move();
			if(arrayPastilla.get(i).getY()>=Gdx.graphics.getHeight()){
				arrayPastilla.get(i).setY(0);
			}
			if(celula.isColliding(arrayPastilla.get(i))){
				System.out.println("Objects Colliding at "+celula.getX()+" "+celula.getY());
			}
			batch.end();
		}
		batch.begin();
		celula.dibuja(batch);
		celula.move();
		batch.draw(bgw,0,0);
		batch.end();

	}
	@Override
	public void dispose () {
		batch.dispose();
	}
}
