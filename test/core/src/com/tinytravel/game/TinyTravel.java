package com.tinytravel.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TinyTravel extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private OrthographicCamera camera;
	private Insecto insect1;
	private Insecto insect2;
	@Override
	public void create () {
		batch = new SpriteBatch();

		img = new Texture("badlogic.jpg");
		camera = new OrthographicCamera();
		camera.setToOrtho(false,800,480);
		camera.update();

		insect1 = new Insecto(100,100);
		insect2 = new Insecto(120,100);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//insect1.setX(insect1.getX()+1);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		insect1.render(batch);
		//insect2.render(batch);

		//batch.draw(img, 0, 0);
		batch.end();
	}
	
	/*@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}*/
}
