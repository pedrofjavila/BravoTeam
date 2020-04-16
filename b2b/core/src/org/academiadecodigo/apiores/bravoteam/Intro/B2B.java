package org.academiadecodigo.apiores.bravoteam.Intro;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.apiores.bravoteam.Intro.Factory.itemFactory;
import org.academiadecodigo.apiores.bravoteam.Intro.Factory.itens;
import org.academiadecodigo.apiores.bravoteam.Intro.Menus.mainMenu;
import org.academiadecodigo.apiores.bravoteam.Intro.Menus.optionsMenu;
import org.academiadecodigo.apiores.bravoteam.Intro.Screens.Intro;
import org.academiadecodigo.apiores.bravoteam.Intro.Screens.foundWater;

public class B2B extends Game {

    private SpriteBatch batch;
    private mainMenu menu;
    private optionsMenu opMenu;
    private OrthographicCamera camera;
    private foundWater ff;
    private BitmapFont font;
    private Boolean start = false;
    private Boolean water = false;
    private Texture background3;
    // Texture /
    private Texture background;
    private Texture backgroundWater;
    private Texture background4;
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
    private Player player1;
    private int GoOut = 1;
    private int GoWalk = 1;
    private int GoPharma = 1;
    @Override
    public void create() {
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

    }

    @Override
    public void render() {
        camera.update();

        if (!start) {
            menu.render();
        }
        if (water) {
            batch.begin();
            font.draw(batch, "hello", 250, 250);
            batch.end();
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
        background.dispose();
        playerImage.dispose();
        drop.dispose();
        screen.dispose();
        coughing.dispose();
        bg_music.dispose();
        backgroundWater.dispose();
        screen.dispose();
        opMenu.dispose();
        ff.dispose();


    }

    private void createImages() {

        batch.begin();
        batch.draw(background, 0, 0, 1920, 1136);
        //batch.draw(playerImage, player.x, player.y);
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

    }


    public void userinputBlocked() {
        if (Gdx.input.isKeyPressed(Input.Keys.TAB)) {

            screen.show();
            screen.render(2);
        }
        if (Gdx.input.isKeyPressed((Input.Keys.NUM_1))) {

            batch.begin();

            background = new Texture("goingOutsideTemp.png");
            player1.getInventory().add(itemFactory.createItem(itens.WATER));
            player1.getInventory().add(itemFactory.createItem(itens.FOOD));
            batch.draw(background, 0, 0, 1920, 1136);
            player1.setWaters(player1.getWaters()+1);
            player1.setFood(player1.getFood()+1);
            player1.setSanity(player1.getSanity() - 10);
            player1.setHunger(player1.getHunger() - 20);
            player1.setThirst(player1.getThirst() - 20);
            batch.end();

            setBackground(backgroundWater);

            water = true;

        }

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
            batch.begin();
            background = new Texture("goingOutsideTemp.png");
            player1.getInventory().add(itemFactory.createItem(itens.GUITAR));
            batch.draw(background, 0, 0, 1920, 1136);
            player1.setSanity(player1.getSanity() + 50);
            player1.setHunger(player1.getHunger() - 20);
            player1.setThirst(player1.getThirst() - 20);
            batch.end();

            setBackground(background3);


        }
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_3)){
            batch.begin();

            background = new Texture("goingOutsideTemp.png");
            player1.getInventory().add(itemFactory.createItem(itens.SANITIZER));

            batch.draw(background, 0, 0, 1920, 1136);
            player1.setSanity(player1.getSanity() - 10);
            player1.setHunger(player1.getHunger() - 20);
            player1.setThirst(player1.getThirst() - 20);
            batch.end();

            setBackground(background4);

        }
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_4)){
            player1.setDayCounter(player1.getDayCounter()+1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            player1.setThirst(player1.getThirst()+20);
            player1.setWaters(player1.getWaters()-1);
            if(player1.getWaters() >= 0){
                player1.setWaters(0);
                player1.setThirst(player1.getThirst());
            }
        }if(Gdx.input.isKeyPressed(Input.Keys.E)){
            player1.setHunger(player1.getHunger()+20);
            player1.setFood(player1.getFood()-1);
            if(player1.getFood() >= 0){
                player1.setFood(0);
                player1.setHunger(player1.getHunger());
            }
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

    public void setBackground(Texture background) {
        batch.begin();
        ff.render(2);
        this.background = background;
        batch.end();
    }
}


