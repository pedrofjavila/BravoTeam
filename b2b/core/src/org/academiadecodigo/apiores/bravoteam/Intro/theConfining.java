package org.academiadecodigo.apiores.bravoteam.Intro;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import org.academiadecodigo.apiores.bravoteam.Intro.Screens.Diary.DiaryText;
import org.academiadecodigo.apiores.bravoteam.Intro.Screens.Mainmenu;
import org.academiadecodigo.apiores.bravoteam.Intro.Screens.Rules.Rules;


public class theConfining extends Game {

    private Player player = new Player();
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private BitmapFont font;
    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        setScreen(new Rules(this));
    }

    @Override
    public void dispose(){
        batch.dispose();
        shapeRenderer.dispose();
        font.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    public BitmapFont getFont() {
        return font;
    }

    public Player getPlayer() {
        return player;
    }

    }

    //private boolean game = false;


    //private mainMenu menu;
    //private optionsMenu opMenu;
    //private OrthographicCamera camera;
    //private foundWater ff;
    //private BitmapFont font;
    //private Boolean start = false;
    //private Boolean water = false;
    //private Texture background3;
    // Texture /
    //private Texture background;
    //private Texture backgroundWater;
    //private Texture background4;
    //private Texture playerImage;
    //private Texture drop;
   // MiniGameGoOutside myGdxGame;

    // private Rectangle player;
    //private Stage stage;
    // private Vector3 touchPos;
    // private KeyboardProcessor keyboardProcessor;
    // sound and music//
    // private Music bg_music;
    //private Music intro_music;
    // private Sound coughing;
    // private Intro intro;
    //private AssetManager assetManager;
    //private Player player1;
    // private int GoOut = 1;
    //private int GoWalk = 1;
    // private int GoPharma = 1;
    //int counter = 0;

   /* @Override
    public void create() {

        stage = new Stage();
        keyboardProcessor = new KeyboardProcessor(this);

        player1 = new Player();
        font = new BitmapFont();
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        ff = new foundWater(getBatch());
        background4 = new Texture("alcohol1.png");
        background3 = new Texture("1waterGuitar.png");
        background = new Texture("backgrd.jpg");
        playerImage = new Texture("clipart-3-15-16-44-47.png");
        backgroundWater = new Texture("bg1bottle.png");
        player = new Rectangle();
        player.x = 0;
        player.y = 0;
        player.width = 64;
        player.height = 64;
        screen = new Intro(player1, getBatch());
        menu = new mainMenu(getBatch(), getCamera());
        opMenu = new optionsMenu(getBatch());
        touchPos = new Vector3();
        coughing = Gdx.audio.newSound(Gdx.files.internal("503749__strangelandspod__sick-man-coughing-in-mall-food-court.mp3"));
        bg_music = Gdx.audio.newMusic(Gdx.files.internal("512196__legend1060__an-epicenter-and-a-pandemic.mp3"));
        bg_music.setLooping(true);
        bg_music.setVolume(0.10f);
        bg_music.play();
        myGdxGame = new MiniGameGoOutside(getBatch(), getCamera());
        myGdxGame.create();

    }

    @Override
    public void render() {
        camera.update();
        if(game){
            myGdxGame.render(1);
            myGdxGame.show();
            myGdxGame.getMusic().play();
        }
        if (!start) {
            menu.render();
        }

        if (start) {
            createImages();
            userinputBlocked();
        }
        userInputs();
    }

    @Override
    public void dispose() {
        batch.dispose();

        playerImage.dispose();
        drop.dispose();
        screen.dispose();
        coughing.dispose();
        bg_music.dispose();
        backgroundWater.dispose();
        screen.dispose();
        opMenu.dispose();
        ff.dispose();
        myGdxGame.dispose();

    }

    private void createImages() {

        batch.begin();
        batch.draw(background, 0, 0, 1920, 1136);
        batch.end();
    }

    private void userInputs() {


        if (Gdx.input.isKeyPressed(Input.Keys.Y)) {
            start = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            System.exit(1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.M)) {
            opMenu.show();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.T)) {
            game = true;
            bg_music.stop();
           this.setScreen(new MiniGameGoOutside(getBatch(),getCamera()));



        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            game = false;
            myGdxGame.getMusic().stop();
            myGdxGame.getSound().stop();

        }

    }


    public void userinputBlocked() {
        if (Gdx.input.isKeyPressed(Input.Keys.TAB)) {

            screen.show();
            screen.render(2);
        }
        if (Gdx.input.isKeyJustPressed((Input.Keys.NUM_1))) {

            batch.begin();

            background = new Texture("goingOutsideTemp.png");
            player1.getInventory().add(itemFactory.createItem(Items.WATER));
            player1.getInventory().add(itemFactory.createItem(Items.FOOD));
            batch.draw(background, 0, 0, 1920, 1136);
            player1.setWaters(player1.getWaters() + 1);
            player1.setFood(player1.getFood() + 1);
            player1.setSanity(player1.getSanity() - 10);
            player1.setHunger(player1.getHunger() - 20);
            player1.setThirst(player1.getThirst() - 20);
            batch.end();

            setBackground(backgroundWater);

            water = true;

        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {

            batch.begin();
            background = new Texture("goingOutsideTemp.png");
            player1.getInventory().add(itemFactory.createItem(Items.GUITAR));

            batch.draw(background, 0, 0, 1920, 1136);

            player1.setSanity(player1.getSanity() + 50);
            player1.setHunger(player1.getHunger() - 20);
            player1.setThirst(player1.getThirst() - 20);
            batch.end();
            setBackground(background3);


        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
            batch.begin();

            background = new Texture("goingOutsideTemp.png");
            player1.getInventory().add(itemFactory.createItem(Items.SANITIZER));

            batch.draw(background, 0, 0, 1920, 1136);
            player1.setSanity(player1.getSanity() - 10);
            player1.setHunger(player1.getHunger() - 20);
            player1.setThirst(player1.getThirst() - 20);
            batch.end();

            setBackground(background4);

        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_4)) {
            player1.setDayCounter(player1.getDayCounter() + 1);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            player1.setThirst(player1.getThirst() + 20);
            player1.setWaters(player1.getWaters() - 1);
            if (player1.getWaters() >= 0) {
                player1.setWaters(0);
                player1.setThirst(player1.getThirst());
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            teste();

        }


    }
    public void playMini(){

        while (this.game) {
            myGdxGame.show();
            myGdxGame.render(1);
            camera.update();
            myGdxGame.getMusic().play();
        }
        myGdxGame.dispose();
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

    public void setBackground(Texture background) {
        batch.begin();
        ff.render(2);
        this.background = background;
        batch.end();
    }

    public void teste() {
        player1.setHunger(player1.getHunger() + 20);
        player1.setFood(player1.getFood() - 1);
        this.counter = 1;
        if (player1.getFood() <= 0) {
            player1.setFood(0);
            player1.setHunger(player1.getHunger());
            this.counter = 1;
        }


    }


    public boolean isGame() {
        return game;
    }

    public mainMenu getMenu() {
        return menu;
    }

    public optionsMenu getOpMenu() {
        return opMenu;
    }

    public foundWater getFf() {
        return ff;
    }

    public BitmapFont getFont() {
        return font;
    }

    public Boolean getStart() {
        return start;
    }

    public Boolean getWater() {
        return water;
    }

    public Texture getBackground3() {
        return background3;
    }

    public Texture getBackground() {
        return background;
    }

    public Texture getBackgroundWater() {
        return backgroundWater;
    }

    public Texture getBackground4() {
        return background4;
    }

    public Texture getPlayerImage() {
        return playerImage;
    }

    public Texture getDrop() {
        return drop;
    }

    public MiniGameGoOutside getMyGdxGame() {
        return myGdxGame;
    }

    public Rectangle getPlayer() {
        return player;
    }

    public Vector3 getTouchPos() {
        return touchPos;
    }

    public Music getBg_music() {
        return bg_music;
    }

    public Music getIntro_music() {
        return intro_music;
    }

    public Sound getCoughing() {
        return coughing;
    }

    public Intro getIntro() {
        return intro;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public Player getPlayer1() {
        return player1;
    }

    public int getGoOut() {
        return GoOut;
    }

    public int getGoWalk() {
        return GoWalk;
    }

    public int getGoPharma() {
        return GoPharma;
    }

    public int getCounter() {
        return counter;
    }*/


