package org.academiadecodigo.apiores.bravoteam.Intro.miniGames;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import org.academiadecodigo.apiores.bravoteam.Intro.B2B;

import java.util.Iterator;

public class MyGdxGame implements Screen {


    public MyGdxGame(SpriteBatch batch,OrthographicCamera camera) {
        this.batch = batch;
      this.camera = camera;
    }

    private SpriteBatch batch;

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
        background = new Texture("minigame1/background.jpg");
        playerImage = new Texture("minigame1/flip2.png");

        player = new Rectangle();
        player.x = 0;
        player.y = 0;
        player.width = 50;
        player.height = 150;

        touchPos = new Vector3();

		sound = Gdx.audio.newSound(Gdx.files.internal("minigame1/sound.mp3"));
		music = Gdx.audio.newMusic(Gdx.files.internal("minigame1/music.mp3"));
		music.setLooping(true);

		music.setVolume(0.1f);


        jojoDrops = new Array<Rectangle>();

        jojo = new Texture("minigame1/jojo.png");
        jojoDrops = new Array<Rectangle>();

        rita = new Texture("minigame1/rita.png");
        ritaDrops = new Array<Rectangle>();

        soraia = new Texture("minigame1/soraia.png");
        soraiaDrops = new Array<Rectangle>();

        ricardo = new Texture("minigame1/ricardo.png");
        ricardoDrops = new Array<Rectangle>();

        spawnDrops();
    }

    @Override
    public void show() {

    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void render(float delta) {

        camera.update();
        moveDrops(ricardoDrops);
        moveDrops(jojoDrops);
        moveDrops(ritaDrops);
        moveDrops(soraiaDrops);
        createImages();
        userInputs();

    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        playerImage.dispose();
        jojo.dispose();
        rita.dispose();
        ricardo.dispose();
        soraia.dispose();

		sound.dispose();
		music.dispose();

    }

    private void createImages() {

        int counter = 0;

        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        batch.draw(background, 0, 0,1920,1136);
        batch.draw(playerImage, player.x, player.y);

        for (Rectangle drop : ritaDrops) {
            batch.draw(soraia, drop.x, drop.y);
        }

        for (Rectangle drop : jojoDrops) {
            batch.draw(jojo, drop.x, drop.y);
        }

        for (Rectangle drop : soraiaDrops) {
            batch.draw(rita, drop.x, drop.y);
        }

        for (Rectangle drop : ricardoDrops) {
            batch.draw(ricardo, drop.x, drop.y);
        }

        batch.end();

    }

    private void spawnDrops() {
        int random = (int) (Math.random() * 4);

        Rectangle jojo;
        jojo = new Rectangle();
        jojo.x = 972;
        jojo.y = (int) (Math.random() * 400);
        jojo.width = 34;
        jojo.height = 34;



        switch (random) {
            case 0:
                jojoDrops.add(jojo);
                break;
            case 1:
                ritaDrops.add(jojo);
                break;
            case 2:
                ricardoDrops.add(jojo);
                break;
            default:
                soraiaDrops.add(jojo);
        }
        dropRate = TimeUtils.nanoTime();
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

				sound.play();
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

            playerImage = new Texture("minigame1/flip3.png");
            kill = true;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {

            double delay = 0.2; // seconds

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    playerImage = new Texture("minigame1/flip2.png");
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

    public Sound getSound() {
        return sound;
    }

    public Music getMusic() {
        return music;
    }
}
