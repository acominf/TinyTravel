package com.tinytravel.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.tinytravel.game.TinyTravel;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="Tiny Travel";
		config.height=600;
		config.width=400;
		config.initialBackgroundColor= Color.WHITE;
		new LwjglApplication(new TinyTravel(), config);
	}
}
