package org.academiadecodigo.apiores.bravoteam.Intro;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import org.academiadecodigo.apiores.bravoteam.Intro.Intro;

public class B2B extends Game {

	private SpriteBatch batch;

	private OrthographicCamera camera;

	// Texture /
	private Texture background;
	private Texture playerImage;
	private Texture drop;

	private Rectangle player;

	private Vector3 touchPos;

	// sound and music//
	private Music bg_music;
	private Music intro_music;
	private Sound coughing;
	private Intro intro;

	@Override
	public void create() {
		batch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		background = new Texture("livingroom.png");
		playerImage = new Texture("clipart-3-15-16-44-47.png");

		player = new Rectangle();
		player.x = 0;
		player.y = 0;
		player.width = 64;
		player.height = 64;
		screen = new Intro(getCamera(),getBatch());
		touchPos = new Vector3();

		coughing = Gdx.audio.newSound(Gdx.files.internal("503749__strangelandspod__sick-man-coughing-in-mall-food-court.mp3"));
		bg_music = Gdx.audio.newMusic(Gdx.files.internal("512196__legend1060__an-epicenter-and-a-pandemic.mp3"));

		bg_music.setLooping(true);

		bg_music.setVolume(0.50f);
		bg_music.play();


	}

	@Override
	public void render() {

		camera.update();
		createImages();
		userInputs();
	}

	@Override
	public void dispose() {
		batch.dispose();
		background.dispose();
		playerImage.dispose();
		drop.dispose();
		screen.dispose();
		coughing.dispose();
		bg_music.dispose();
	}

	private void createImages() {

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background, 0, 0);
		batch.draw(playerImage, player.x, player.y);

		batch.end();
	}

	private void userInputs() {

		if (Gdx.input.isTouched()) {
			//touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			//camera.unproject(touchPos);
			//player.x = touchPos.x - 25;

		}
		if(Gdx.input.isTouched()){
				setScreen(screen);
				screen.show();
				screen.render(1);
		}


		/*if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.x -= 400 * Gdx.graphics.getDeltaTime();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.x += 400 * Gdx.graphics.getDeltaTime();
		}

		if (player.x < 0) {
			player.x = 0;
		}

		if (player.x > 750) {
			player.x = 750;

		 */
		}

	public SpriteBatch getBatch() {
		return batch;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	@Override
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
}


