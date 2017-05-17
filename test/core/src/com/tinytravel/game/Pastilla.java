package com.tinytravel.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Pastilla extends Potenciador{
    @Override
    public abstract void setX(int x);
    @Override
    public abstract void setY(int y);
    @Override
    public abstract int getX();
    @Override
    public abstract int getY();
    @Override
    public abstract void dibuja(final SpriteBatch batch);

}
