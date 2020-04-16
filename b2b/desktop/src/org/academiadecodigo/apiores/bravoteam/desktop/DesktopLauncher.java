package org.academiadecodigo.apiores.bravoteam.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.apiores.bravoteam.Intro.B2B;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1920;
		config.height = 1136;
		config.fullscreen = false;
		config.title = "The Confining";

		new LwjglApplication(new B2B(), config);
	}
}
