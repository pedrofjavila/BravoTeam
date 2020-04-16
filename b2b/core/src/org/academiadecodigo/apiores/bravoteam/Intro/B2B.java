package org.academiadecodigo.apiores.bravoteam.Intro;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.apiores.bravoteam.Intro.Menus.mainMenu;
import org.academiadecodigo.apiores.bravoteam.Intro.Menus.optionsMenu;

public class B2B extends Game {

	private SpriteBatch batch;
	private mainMenu menu;
	private optionsMenu opMenu;
	private OrthographicCamera camera;
	private Boolean start = false;

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
	private AssetManager assetManager;


	@Override
	public void create() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		background = new Texture("Images/background.jpg");
		playerImage = new Texture("Images/clipart-3-15-16-44-47.png");

		player = new Rectangle();
		player.x = 0;
		player.y = 0;
		player.width = 64;
		player.height = 64;
		screen = new Intro(getCamera(),getBatch());
		menu = new mainMenu(getBatch(),getCamera());
		opMenu = new optionsMenu(getBatch());
		touchPos = new Vector3();
		coughing = Gdx.audio.newSound(Gdx.files.internal("Sounds/503749__strangelandspod__sick-man-coughing-in-mall-food-court.mp3"));
		bg_music = Gdx.audio.newMusic(Gdx.files.internal("Music/background_music.mp3"));
		bg_music.setLooping(true);
		bg_music.setVolume(0.50f);
		intro_music = Gdx.audio.newMusic(Gdx.files.internal("Music/I Will Survive_intro.mp3"));
		intro_music.setLooping(true);
		intro_music.setVolume(0.50f);


	}

	@Override
	public void render() {
		camera.update();
		System.gc();
		if(!start){
			intro_music.play();
			menu.render();

		}
		if(start){
			intro_music.pause();
			createImages();
			userinputBlocked();
			bg_music.play();
		}
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
		intro_music.dispose();

	}

	private void createImages() {


		batch.begin();
		batch.draw(background, 0, 0,1920,1136);
		//batch.draw(playerImage, player.x, player.y);
		batch.end();
	}

	private void userInputs() {


		if(Gdx.input.isKeyPressed(Input.Keys.Y)){
			start = true;


		}
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){

			System.exit(1);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.M)){

			opMenu.show();
			opMenu.render(1);
		}

		}
		public void userinputBlocked(){
			if(Gdx.input.isKeyPressed(Input.Keys.TAB)){

				screen.show();
				screen.render(1);
			}
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


