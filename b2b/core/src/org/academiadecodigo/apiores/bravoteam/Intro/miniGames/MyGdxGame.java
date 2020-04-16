package org.academiadecodigo.apiores.bravoteam.Intro.miniGames;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

import java.util.Iterator;

public class MyGdxGame extends Stage {

    private SpriteBatch batch;
    private Stage stage = new Stage();

    private OrthographicCamera camera;

    private Texture background;
    private Texture playerImage;
    private Texture jojo;
    private Texture rita;
    private Texture soraia;
    private Texture ricardo;

    private Rectangle player;
    private Vector3 touchPos;

    private long dropRate;

    private Sound sound;
    private Music music;
    private boolean kill;
    private Array<Rectangle> jojoDrops;
    private Array<Rectangle> ritaDrops;
    private Array<Rectangle> soraiaDrops;
    private Array<Rectangle> ricardoDrops;


    public void create() {

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        background = new Texture("backgrd.jpg");
        playerImage = new Texture("oldman.png");

        player = new Rectangle();
        player.x = 0;
        player.y = 0;
        player.width = 50;
        player.height = 150;

        touchPos = new Vector3();






        spawnDrops();
    }

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


		sound.dispose();
		music.dispose();

    }

    private void createImages() {

        int counter = 0;

        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        batch.draw(background, 0, 0);
        batch.draw(playerImage, player.x, player.y);



        batch.end();

    }

    private void spawnDrops() {
        int random = (int) (Math.random() * 4);





    }

    private void moveDrops(Array<Rectangle> drops) {

        Iterator<Rectangle> iterator = drops.iterator();

        while (iterator.hasNext()) {

            Rectangle drop = iterator.next();
            drop.x -= 200 * Gdx.graphics.getDeltaTime();

            if (drop.x + 64 < 0) {
                iterator.remove();
            }

            if (drop.overlaps(player) && kill) {


                iterator.remove();
            }
        }
        if (TimeUtils.nanoTime() - dropRate > 1000000000) {
            spawnDrops();
        }
    }

    private void userInputs() {

        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            player.x = touchPos.x - 25;
            player.y = touchPos.y;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {

            playerImage = new Texture("flip3.png");
            kill = true;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {

            double delay = 0.2; // seconds

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    playerImage = new Texture("flip2.png");
                    kill = false;
                }
            }, (float) delay);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.x -= 400 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.x += 400 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.y += 400 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.y -= 400 * Gdx.graphics.getDeltaTime();
        }

        if (player.x < 0) {
            player.x = 0;
        }

        if (player.x > 750) {
            player.x = 750;
        }

        if (player.y < 0) {
            player.y = 0;
        }

        if (player.y > 750) {
            player.y = 750;
        }
    }
}
