package com.tiny.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;


public class tiny extends ApplicationAdapter {
	private SpriteBatch batch;
	private Juego juego;
	private Jugador player;
	private BitmapFont font;
	private  Texture menu;
	private Texture ayuda;
	private Texture creditos;
	private Texture puntuaje;
	private Sound sound;
	private Music musicMenu;
	private boolean isGamming;
	private boolean isHelp;
	private boolean isCredits;
	private boolean isPuntuaje;
	@Override
	public void create () {
		try{
			batch = new SpriteBatch();
			sound = Gdx.audio.newSound(Gdx.files.internal("Sonido/Moneda de Mario.mp3"));
			menu = new Texture(Gdx.files.internal("menu.jpg"));
			musicMenu = Gdx.audio.newMusic(Gdx.files.internal("Sonido/Musica Alegre 2.mp3"));
			font = new BitmapFont();
			ayuda = new Texture(Gdx.files.internal("Ayuda.jpg"));
			creditos = new Texture(Gdx.files.internal("Creditos.jpg"));
			puntuaje = new Texture(Gdx.files.internal("Puntos.jpg"));
			isGamming = false;
			isCredits = false;
			isHelp = false;
			isPuntuaje = false;
			juego = new Juego();
			juego.create();
		}catch(GdxRuntimeException e){
			System.out.println("ERROR..."+ e.getMessage());
		}

	}

	@Override
	public void render () {
		//Juego
		if(isGamming==true){
			juego.render(batch);
			if(juego.isPlaying()==false){
				juego.resetGame();
				isGamming=false;
			}
			//Sirve para regresarse al menu, haciendo todas las demas opciones en falso
			//Si presiona R el juego se queda donde esta, y simplemente lo regresa al menu...
			//Si se presiona P para ingresar al juego, se renaudara el juego...
			if(Gdx.input.isKeyPressed(Input.Keys.R)){
				sound.play();
				if(juego.getJugador().getScore()>juego.leerJugador().getScore()){
					juego.guardarJugador();
				}
				juego.resetGame();
				isGamming = false; //Solo va al menu, con su partida en pausa
				isHelp=false;//...
				isCredits=false;//...
				isPuntuaje=false;
			}
		//Ayuda
		}else if(isHelp==true){
			batch.begin();
			batch.draw(ayuda,0,0);
			batch.end();

			//Sirve para regresarse al menu, haciendo todas las demas opciones en falso
			if(Gdx.input.isKeyPressed(Input.Keys.R)){
				sound.play();
				isGamming = false; //Solo va al menu
				isHelp=false;//...
				isCredits=false;//...
				isPuntuaje=false;
			}
		//Creditos
		}else if(isCredits==true){
			batch.begin();
			batch.draw(creditos,0,0);
			batch.end();

			//Sirve para regresarse al menu, haciendo todas las demas opciones en falso
			if(Gdx.input.isKeyPressed(Input.Keys.R)){
				sound.play();
				isGamming = false; //Solo va al menu
				isHelp=false;//...
				isCredits=false;//...
				isPuntuaje=false;
			}
		//Puntuaje
		}else if(isPuntuaje==true){
			batch.begin();
			batch.draw(puntuaje,0,0);
			font.draw(batch,Integer.toString(this.juego.leerJugador().getScore()),170,400);
			batch.end();
			if(Gdx.input.isKeyPressed(Input.Keys.R)){
				sound.play();
				isGamming = false; //Solo va al menu
				isHelp=false;//...
				isCredits=false;//...
				isPuntuaje = false;
			}
		//Default
		} else{
			//Si el juego sigue reproduciendo musica entonces se detiene
			//Para visualizar el menu
			Music musicGame = juego.getMusic();
			if(musicGame.isPlaying()==true){
				musicGame.stop();
			}
			musicMenu.play();
			musicMenu.setLooping(true);
			batch.begin();
			batch.draw(menu,0,0);
			batch.end();
			//Opciones del menu...
			//P=Play, H=Help, C= Credits...
			if(Gdx.input.isKeyPressed(Input.Keys.J)){ //Play
				if(musicMenu.isPlaying()==true){
					musicMenu.stop();
				}
				sound.play();
				isGamming = true; //Se va al juego
				isHelp=false;
				isCredits=false;
				isPuntuaje = false;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.C)){ //Credits
				if(musicMenu.isPlaying()==true){
					musicMenu.stop();
				}
				sound.play();
				isCredits = true; //Solo va a los creditos
				isGamming=false;
				isHelp=false;
				isPuntuaje = false;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.A)){ //Help
				if(musicMenu.isPlaying()==true){
					musicMenu.stop();
				}
				sound.play();
				isHelp = true; //Se va a la ayuda
				isGamming=false;
				isCredits=false;
				isPuntuaje = false;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.P)){ //Score
				if(musicMenu.isPlaying()==true){
					musicMenu.stop();
				}
				sound.play();
				isPuntuaje = true; //Se ve el puntuaje
				isGamming= false;
				isCredits = false;
				isHelp = false;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
				player = juego.leerJugador();
				if(this.juego.getJugador().getScore()>player.getScore()){
					this.juego.guardarJugador();
				}
				System.exit(0);
			}
		}
	}
	@Override
	public void dispose () {
		batch.dispose();
		sound.dispose();
		musicMenu.dispose();
		font.dispose();
		juego.dispose();
	}
}
