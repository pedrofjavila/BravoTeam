package org.academiadecodigo.apiores.bravoteam;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class B2B extends ApplicationAdapter {

	private SpriteBatch batch;

	private OrthographicCamera camera;

	private Texture background;
	private Texture playerImage;
	private Texture drop;

	private Rectangle player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

	}

	@Override
	public void render () {

	}

	@Override
	public void dispose () {
		
	}
}
