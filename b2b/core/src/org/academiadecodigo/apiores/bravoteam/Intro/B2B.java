package org.academiadecodigo.apiores.bravoteam.Intro;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.apiores.bravoteam.Diary.DiaryText;
import org.academiadecodigo.apiores.bravoteam.Intro.Menus.Player;
import org.academiadecodigo.apiores.bravoteam.Intro.Menus.mainMenu;
import org.academiadecodigo.apiores.bravoteam.Intro.Menus.optionsMenu;
import org.academiadecodigo.apiores.bravoteam.Util.Messages;

public class B2B extends Game {

	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Boolean start = false;

	// Screens
	private mainMenu menu;
	private optionsMenu opMenu;
	private DiaryText diary;
	// Texture /
	private Texture background;
	private Texture playerImage;
	private Texture drop;

	private Rectangle playerHitbox;

	private Vector3 touchPos;

	// sound and music//
	private Music bg_music;
	private Music intro_music;
	private Sound coughing;
	private Intro intro;
	private AssetManager assetManager;
	private Player player;


	@Override
	public void create() {
		assetManager = new AssetManager();

		// set the loaders for the generator and the fonts themselves
		FileHandleResolver resolver = new InternalFileHandleResolver();
		assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		assetManager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));



		// load to fonts via the generator (implicitely done by the FreetypeFontLoader).
		// Note: you MUST specify a FreetypeFontGenerator defining the ttf font file name and the size
		// of the font to be generated. The names of the fonts are arbitrary and are not pointing
		// to a file on disk (but must end with the font's file format '.ttf')!

		FreetypeFontLoader.FreeTypeFontLoaderParameter handFont = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
		handFont.fontFileName = "Font/IndieFlower-Regular.ttf";
		handFont.fontParameters.size = 30;
		handFont.fontParameters.color = Color.BLACK;
		assetManager.load("hwsize30_black.ttf", BitmapFont.class, handFont);

		FreetypeFontLoader.FreeTypeFontLoaderParameter handFont2 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
		handFont2.fontFileName = "Font/IndieFlower-Regular.ttf";
		handFont2.fontParameters.size = 40;
		handFont2.fontParameters.color = Color.RED;
		assetManager.load("hwsize40_red.ttf", BitmapFont.class, handFont2);

		FreetypeFontLoader.FreeTypeFontLoaderParameter handFont3 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
		handFont3.fontFileName = "Font/IndieFlower-Regular.ttf";
		handFont3.fontParameters.size = 40;
		handFont3.fontParameters.color = Color.BLACK;
		assetManager.load("hwsize40_black.ttf", BitmapFont.class, handFont3);


		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		background = new Texture("Images/background.jpg");
		player = new Player();
		playerImage = new Texture("Images/clipart-3-15-16-44-47.png");

		playerHitbox = new Rectangle();
		playerHitbox.x = 0;
		playerHitbox.y = 0;
		playerHitbox.width = 64;
		playerHitbox.height = 64;
		screen = new Intro(player,getBatch());
		menu = new mainMenu(getBatch(),getCamera());
		opMenu = new optionsMenu(getBatch());
		diary = new DiaryText(getBatch(), getCamera(), getAssetManager());
		touchPos = new Vector3();
		coughing = Gdx.audio.newSound(Gdx.files.internal("Sounds/503749__strangelandspod__sick-man-coughing-in-mall-food-court.mp3"));
		bg_music = Gdx.audio.newMusic(Gdx.files.internal("Music/background_music.mp3"));
		bg_music.setLooping(true);
		bg_music.setVolume(0.50f);
		intro_music = Gdx.audio.newMusic(Gdx.files.internal("Music/I Will Survive_intro.mp3"));
		intro_music.setLooping(true);
		intro_music.setVolume(0.50f);
		diary.setPlayer(player);

	}

	@Override
	public void render() {
		camera.update();
		assetManager.update();
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
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			diary.render();
			setDiaryMessage();
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

	public AssetManager getAssetManager() {
		return assetManager;
	}


	public void setDiaryMessage( ){

		//diary.setDaycounter(player.getDaysCounter());
		diary.setEvent(Messages.EVENT_DAY_ZERO);
	}


}


