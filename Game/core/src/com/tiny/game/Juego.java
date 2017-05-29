package com.tiny.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alval on 26/05/2017.
 */
public class Juego {
    private Random random;
    private Celula celula;
    private Jugador jugador;
    private Jugador player;
    private int pAuxH;
    private int pAuxT;
    private ArrayList<Globulo> arrayGlobulo;
    private ArrayList<Virus> arrayVirus;
    private ArrayList<VH> arrayVH;
    private ArrayList<VT> arrayVT;
    private ArrayList<Pastilla> arrayPastilla;
    private OrthographicCamera camera;
    private Music music;
    private Sound sound;
    private Sound sound1;
    private BitmapFont font;
    private CharSequence score;
    private CharSequence puntos;
    private Texture membrana;
    private Texture membrana1;
    private Texture membrana2;
    private Texture membrana3;

    private boolean isPlaying;
    private F1 P1;
    private F2 P2;
    private F3 P3;
    private F4 P4;
    private F5 P5;
    private F6 P6;
    public void create () {
        try{
            //Se inicializa la camara
            camera = new OrthographicCamera(400,600);
            membrana = new Texture(Gdx.files.internal("ParedMembrana/Membrana.jpg"));
            membrana1 = new Texture(Gdx.files.internal("ParedMembrana/Membrana1.jpg"));
            membrana2 = new Texture(Gdx.files.internal("ParedMembrana/Membrana2.jpg"));
            membrana3 = new Texture(Gdx.files.internal("ParedMembrana/Membrana3.jpg"));
            music = Gdx.audio.newMusic(Gdx.files.internal("Sonido/MusicaDivertida.mp3"));
            sound = Gdx.audio.newSound(Gdx.files.internal("Sonido/Moneda de Mario.mp3"));
            sound1 = Gdx.audio.newSound(Gdx.files.internal("Sonido/Alerta.mp3"));
            font = new BitmapFont();
            score = "SCORE";
            puntos = "0";
            pAuxH = 0;
            pAuxT =0;
            isPlaying = true;
            random = new Random();
            //Se crean los arreglos
            arrayGlobulo = new ArrayList<Globulo>();
            arrayPastilla = new ArrayList<Pastilla>();
            arrayVirus = new ArrayList<Virus>();
            arrayVH = new ArrayList<VH>();
            arrayVT = new ArrayList<VT>();
            jugador = new Jugador("Jugador1");
            //Se añaden los objetos fondo
            //En sus posiciones correspondientes
            P1 = new F1(0,0);
            P2 = new F2(0,100);
            P3 = new F3(0,200);
            P4 = new F4(0,300);
            P5 = new F5(0,400);
            P6 = new F6(0,500);
            //
            //Se añaden los objetos Globulo
            int randomx = random.nextInt(400) +1;
            int randomy = random.nextInt(90)+1;
            arrayGlobulo.add( new Globulo(randomx,randomy));
            randomx = random.nextInt(400)+1;
            randomy=random.nextInt(90)+1;
            arrayGlobulo.add(new Globulo(randomx,randomy));
            randomx = random.nextInt(400)+1;
            randomy= random.nextInt(90)+1;
            arrayGlobulo.add(new Globulo(randomx,randomy));

            //Se añaden los objetos Invencibilidad
            randomx=random.nextInt(350)+1;
            randomy=random.nextInt(80)+1;
            arrayPastilla.add( new Invencibilidad(randomx,randomy));

            //Se añaden los objetos virus H
            randomx=random.nextInt(350)+1;
            randomy=random.nextInt(80)+1;
            arrayVH.add( new VH(randomx,randomy));
            randomx = random.nextInt(350)+1;
            randomy=random.nextInt(80)+1;
            arrayVH.add(new VH(randomx,randomy));
            randomx = random.nextInt(350)+1;
            randomy= random.nextInt(80)+1;
            arrayVH.add(new VH(randomx,randomy));

            //Se añaden los objetos virus T
            randomx=random.nextInt(350)+1;
            randomy=random.nextInt(80)+1;
            arrayVT.add( new VT(randomx,randomy));
            //

            celula = new Celula(172,380);
        }catch(GdxRuntimeException e){
            System.out.println("ERROR..."+ e.getMessage());
        }

    }

    public void render (SpriteBatch batch) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.setToOrtho(false,400,600);
        batch.setProjectionMatrix(camera.combined);
        //Loop
        //Fondo Inicial
        music.play();
        music.setLooping(true);
        batch.begin();
        //Se pintan
        if(this.jugador.getScore()>= 0 && this.jugador.getScore()<=100){
            P1.dibuja(batch);
            P2.dibuja(batch);
            P3.dibuja(batch);
            P4.dibuja(batch);
            P5.dibuja(batch);
            P6.dibuja(batch);
        }else if(this.jugador.getScore()>100 && this.jugador.getScore()<=200){
            P1.dibuja1(batch);
            P2.dibuja1(batch);
            P3.dibuja1(batch);
            P4.dibuja1(batch);
            P5.dibuja1(batch);
            P6.dibuja1(batch);
        }else if(this.jugador.getScore()>200 && this.jugador.getScore()<=300){
            P1.dibuja2(batch);
            P2.dibuja2(batch);
            P3.dibuja2(batch);
            P4.dibuja2(batch);
            P5.dibuja2(batch);
            P6.dibuja2(batch);
        }else if(this.jugador.getScore()>300){
            P1.dibuja3(batch);
            P2.dibuja3(batch);
            P3.dibuja3(batch);
            P4.dibuja3(batch);
            P5.dibuja3(batch);
            P6.dibuja3(batch);
        }
        //Se mueven
        P1.move(); //Se incrementa la pos de y en 1
        P2.move();//...
        P3.move();
        P4.move();
        P5.move();
        P6.move();
        //Restricciones...
        if(P1.getY()>=Gdx.graphics.getHeight()){
            P1.setY(0);
        }
        if(P2.getY()>=Gdx.graphics.getHeight()){
            P2.setY(0);
        }
        if(P3.getY()>=Gdx.graphics.getHeight()){
            P3.setY(0);
        }
        if(P4.getY()>=Gdx.graphics.getHeight()){
            P4.setY(0);
        }
        if(P5.getY()>=Gdx.graphics.getHeight()){
            P5.setY(0);
        }
        if(P6.getY()>=Gdx.graphics.getHeight()){
            P6.setY(0);
        }
        batch.end();
      //Para crear mas globulos
        if(arrayGlobulo.size()==2){
            int randomx = random.nextInt(350) +1;
            int randomy = random.nextInt(80) +1;
            arrayGlobulo.add( new Globulo(randomx,randomy));
        }
        //Se dibujan y mueven los glbulos
        for(int j = 0;j<arrayGlobulo.size();j++){
            batch.begin();
            arrayGlobulo.get(j).dibuja(batch);
            arrayGlobulo.get(j).move();
            if(arrayGlobulo.get(j).getY()>=Gdx.graphics.getHeight()){
                int randx = random.nextInt(350)+1;
                int randy = random.nextInt(80)+1;
                arrayGlobulo.remove(j);
                arrayGlobulo.add(new Globulo(randx,randy));
            }
            if(celula.isColliding(arrayGlobulo.get(j))){
                sound.play();
                arrayGlobulo.remove(j);
                this.jugador.setScore(jugador.getScore()+10);
                puntos=Integer.toString(this.jugador.getScore());
                System.out.println("Puntuaje: "+ this.jugador.getScore());
            }
            batch.end();
        }
        //Para crear mas Pastillas
        if(arrayPastilla.size()== 0){
            int randomx = random.nextInt(350)+1;
            int randomy = random.nextInt(80)+1;
            arrayPastilla.add( new Invencibilidad(randomx,randomy));
        }
        for(int i = 0;i<arrayPastilla.size();i++){
            batch.begin();
            arrayPastilla.get(i).dibuja(batch);
            arrayPastilla.get(i).move();
            if(arrayPastilla.get(i).getY()>=Gdx.graphics.getHeight()){
                int randx = random.nextInt(350)+1;
                int randy = random.nextInt(80)+1;
                arrayPastilla.remove(i);
                arrayPastilla.add(new Invencibilidad(randx,randy));
            }
            if(celula.isColliding(arrayPastilla.get(i))){
                sound.play();
                arrayPastilla.remove(i);
                this.jugador.setScore(this.jugador.getScore()+20);
                this.puntos=Integer.toString(this.jugador.getScore());
                System.out.println("Puntuaje: "+ this.jugador.getScore());
            }
            batch.end();
        }

        //Para crear mas VH
        if(arrayVH.size()<=2){
            int randx = random.nextInt(350)+1;
            int randy = random.nextInt(80)+1;
            arrayVH.add(new VH(randx,randy));
        }

        //Crear Virus por puntuaciones
        if(this.jugador.getScore()-pAuxH>=50 && arrayVH.size()<=10){
            int randx = random.nextInt(350)+1;
            int randy = random.nextInt(80)+1;
            arrayVH.add(new VH(randx,randy));
            pAuxH=this.jugador.getScore();
        }
        for(int i = 0;i<arrayVH.size();i++){
            batch.begin();
            arrayVH.get(i).dibuja(batch);
            arrayVH.get(i).move();
            if(arrayVH.get(i).getY()>=Gdx.graphics.getHeight()){
                int randx = random.nextInt(350)+1;
                int randy = random.nextInt(80)+1;
                arrayVH.remove(i);
                arrayVH.add(new VH(randx,randy));
            }
            if(celula.isColliding(arrayVH.get(i))){
                sound1.play();
                arrayVH.remove(i);
                this.jugador.setScore(this.jugador.getScore()-100);
                if(this.jugador.getScore()<0){
                    if(this.jugador.getScore()>this.leerJugador().getScore()){
                        this.guardarJugador();
                    }
                    isPlaying = false;
                }
                this.puntos=Integer.toString(this.jugador.getScore());
                System.out.println("Puntuaje: "+ this.jugador.getScore());
            }
            batch.end();
        }
        //Crear mas virus VT
        if(arrayVT.size()<1){
            int randx=random.nextInt(350)+1;
            int randy = random.nextInt(80)+1;
            arrayVT.add(new VT(randx,randy));
        }

        //Crear mas virus VT por puntuaciones
        if(this.jugador.getScore()-pAuxT>=50 && arrayVT.size()<=4){
            int randx = random.nextInt(350)+1;
            int randy = random.nextInt(80)+1;
            arrayVT.add(new VT(randx,randy));
            pAuxT=this.jugador.getScore();
        }

        for(int i = 0;i<arrayVT.size();i++){
            batch.begin();
            arrayVT.get(i).dibuja(batch);
            arrayVT.get(i).move();
            if(arrayVT.get(i).getY()>=Gdx.graphics.getHeight()){
                int randx = random.nextInt(350)+1;
                int randy = random.nextInt(80)+1;
                arrayVT.remove(i);
                arrayVT.add(new VT(randx,randy));
            }
            if(celula.isColliding(arrayVT.get(i))){
                sound1.play();
                arrayVT.remove(i);
                if(this.jugador.getScore()>this.leerJugador().getScore()){
                    this.guardarJugador();
                }
                isPlaying=false;
                System.out.println("Puntuaje: "+ this.jugador.getScore());
            }
            batch.end();
        }
        batch.begin();
        celula.dibuja(batch);
        celula.move();
        //Condiciones de fondo, para simular niveles
        if(this.jugador.getScore()>= 0 && this.jugador.getScore()<=100){
            batch.draw(membrana,0,0);
        }else if(this.jugador.getScore()>100 && this.jugador.getScore()<=200){
            batch.draw(membrana1,0,0);
        }else if(this.jugador.getScore()>200 && this.jugador.getScore()<=300){
            batch.draw(membrana2,0,0);
        }else if(this.jugador.getScore()>300){
            batch.draw(membrana3,0,0);
        }
        font.draw(batch,score,170,100);
        font.draw(batch,puntos,190,80);
        batch.end();

    }

    public void dispose(){
        music.dispose();
    }

    public Music getMusic(){
        return music;
    }

    public void guardarJugador(){
        try{
            File archivo = new File("Jugador");
            FileOutputStream flujoSalida = new FileOutputStream(archivo);
            ObjectOutputStream objeto = new ObjectOutputStream(flujoSalida);
            Jugador player = this.jugador;
            objeto.writeObject(player);
            objeto.close();
            System.out.println("SAVED SUCCESFULLY...");
        }catch(FileNotFoundException e){
            System.out.println("ERROR..."+ e.getMessage());
        }catch(IOException e){
            System.out.println("ERROR..."+e.getMessage());
        }
    }
    public Jugador leerJugador(){
        File archivo = new File("Jugador");
        try{
            FileInputStream flujoEntrada = new FileInputStream(archivo);
            ObjectInputStream objeto = new ObjectInputStream(flujoEntrada);
            player = (Jugador)objeto.readObject();
            //System.out.println("READ SUCCESFULLY...");
        }catch(FileNotFoundException e){
            System.out.println("ERROR..."+e.getMessage());
        }catch(IOException e){
            System.out.println("ERROR..."+e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("ERROR..."+e.getMessage());
        }
        return player;
    }

    public boolean isPlaying(){
        return isPlaying;
    }

    public void resetGame(){
        this.jugador.setScore(0);
        this.isPlaying=true;
        for(int i = 0;i<arrayVirus.size();i++){
            arrayVirus.remove(i);
        }
        arrayVirus.add(new VH(200,30));
        arrayVirus.add(new VT(150,70));
        arrayVirus.add(new VT(300,10));

    }

    public Jugador getJugador(){
        return this.jugador;
    }
}
