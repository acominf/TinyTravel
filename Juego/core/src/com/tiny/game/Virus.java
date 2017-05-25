package com.tiny.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Virus extends Personaje {
    @Override
    public abstract void setX(int x);
    @Override
    public abstract void setY(int y);
    @Override
    public abstract int getX();
    @Override
    public  abstract int getY();
    @Override
    public abstract void move();
    @Override
    public abstract void dibuja(SpriteBatch batch);
    public abstract void ataque();
}