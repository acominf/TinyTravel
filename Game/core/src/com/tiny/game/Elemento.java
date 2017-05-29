package com.tiny.game;


public abstract class Elemento {
    public int x,y;
    public abstract void setX(int x);
    public abstract void setY(int y);
    public abstract int getX();
    public  abstract int getY();
    public abstract void move();
}