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
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class TinyTravel extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite fondo;
	private Celula celula;
	private ArrayList<Globulo> arrayGlobulo;
	private ArrayList<Virus> arrayVirus;
	private ArrayList<Pastilla> arrayPastilla;
	private OrthographicCamera camera;
	private BG1 bg1,bg2,bg3,bg4,bg5,bg6,bg7,bg8,bg9,bg10,bg11,bg12,bg13;
	@Override
	public void create () {
		camera = new OrthographicCamera(400,600);
		fondo = new Sprite(new Texture(Gdx.files.internal("bg.png")),400,600);
		bg1 = new BG1(0,0);
		bg2 = new BG1(0,50);
		bg3 = new BG1(0,100);
		bg4 = new BG1(0,150);
		bg5 = new BG1(0,200);
		bg6 = new BG1(0,250);
		bg7 = new BG1(0,300);
		bg8 = new BG1(0,350);
		bg9 = new BG1(0,400);
		bg10 = new BG1(0,450);
		bg11 = new BG1(0,500);
		bg12 = new BG1(0,550);
		bg13 = new BG1(0,600);
		batch = new SpriteBatch();
		arrayGlobulo = new ArrayList<Globulo>();
		arrayPastilla = new ArrayList<Pastilla>();
		arrayGlobulo.add( new Globulo(200,420));
		arrayGlobulo.add(new Globulo(200,130));
		arrayGlobulo.add(new Globulo(300,170));
		arrayPastilla.add( new Invencibilidad(100,200));
		arrayPastilla.add(new Invencibilidad(50,180));
		arrayPastilla.add(new Invencibilidad(120,210));
		celula = new Celula(300,420);
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
		bg1.dibuja(batch);
		bg2.dibuja(batch);
		bg3.dibuja(batch);
		bg4.dibuja(batch);
		bg5.dibuja(batch);
		bg6.dibuja(batch);
		bg7.dibuja(batch);
		bg8.dibuja(batch);
		bg9.dibuja(batch);
		bg10.dibuja(batch);
		bg11.dibuja(batch);
		bg12.dibuja(batch);
		bg13.dibuja(batch);
		bg1.move();
		bg2.move();
		bg3.move();
		bg4.move();
		bg5.move();
		bg6.move();
		bg7.move();
		bg8.move();
		bg9.move();
		bg10.move();
		bg11.move();
		bg12.move();
		//bg13.move();
		if(bg1.getY()>=Gdx.graphics.getHeight()){
			bg1.setY(0);
		}
		if(bg2.getY()>=Gdx.graphics.getHeight()){
			bg2.setY(0);
		}
		if(bg3.getY()>=Gdx.graphics.getHeight()){
			bg3.setY(0);
		}
		if(bg4.getY()>=Gdx.graphics.getHeight()){
			bg4.setY(0);
		}
		if(bg5.getY()>=Gdx.graphics.getHeight()){
			bg5.setY(0);
		}
		if(bg6.getY()>=Gdx.graphics.getHeight()){
			bg6.setY(0);
		}
		if(bg7.getY()>=Gdx.graphics.getHeight()){
			bg7.setY(0);
		}
		if(bg8.getY()>=Gdx.graphics.getHeight()){
			bg8.setY(0);
		}
		if(bg9.getY()>=Gdx.graphics.getHeight()){
			bg9.setY(0);
		}
		if(bg10.getY()>=Gdx.graphics.getHeight()){
			bg10.setY(0);
		}
		if(bg11.getY()>=Gdx.graphics.getHeight()){
			bg11.setY(0);
		}
		if(bg12.getY()>=Gdx.graphics.getHeight()){
			bg12.setY(0);
		}
		if(bg13.getY()>=Gdx.graphics.getHeight()){
			bg13.setY(0);
		}
		batch.end();
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
		batch.end();

	}
	@Override
	public void dispose () {
		batch.dispose();
	}
}
