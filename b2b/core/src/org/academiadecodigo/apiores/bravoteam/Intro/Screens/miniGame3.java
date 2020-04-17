package org.academiadecodigo.apiores.bravoteam.Intro.Screens;

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
import org.academiadecodigo.apiores.bravoteam.Intro.theConfining;

import java.util.Iterator;

public class miniGame3 implements Screen {



    private theConfining game;

    public miniGame3(theConfining game) {
        this.game = game;
    }

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture background;
    private Texture playerImage;
    private Texture jojo;
    private Texture rita;
    private Texture soraia;
    private Texture ricardo;
    private Rectangle player;
    private Vector3 touchPos;

    private long dropRate;
    int counter = 0;
    private Sound sound;
    private Music music;
    private boolean kill;
    private Array<Rectangle> jojoDrops;
    private Array<Rectangle> ritaDrops;


    public void create() {

        batch = game.getBatch();
        camera = new OrthographicCamera();
        background = new Texture("Items/relaxingRoadpixel.png");
        playerImage = new Texture("Items/open-person-png-top-view-2000_2022.png");

        player = new Rectangle();
        player.x = 960;
        player.y = 0;
        player.width = 50;
        player.height = 150;


        jojoDrops = new Array<Rectangle>();

        jojo = new Texture("Items/227-2273484_bard-halfling-roll20-token-bard.png");
        jojoDrops = new Array<Rectangle>();

        rita = new Texture("Items/227-2273484_bard-halfling-roll20-token-bard.png");
        ritaDrops = new Array<Rectangle>();

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
        if(player.y>970){
            game.getPlayer().setSanity(game.getPlayer().getSanity()+30);
            game.getPlayer().setDayCounter(game.getPlayer().getDayCounter()+1);
            game.setScreen(new Background(game));
        }
        camera.update();
        moveDrops(jojoDrops);
        moveDrops(ritaDrops);
        createImages();
        userInputs();

    }

    @Override
    public void dispose() {

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


        batch.begin();

        batch.draw(background, 0, 0, 1920, 1136);
        batch.draw(playerImage, player.x, player.y,50,50);

        for (Rectangle drop : ritaDrops) {
            batch.draw(rita, drop.x, drop.y,50,50);
        }

        for (Rectangle drop : jojoDrops) {
            batch.draw(jojo, drop.x, drop.y,50,50);
        }

        batch.end();

    }

    private void spawnDrops() {
        int random = (int) (Math.random() * 4);

        Rectangle jojo;
        jojo = new Rectangle();
        jojo.x = 1925;
        jojo.y = (int) (Math.random() * 800);
        jojo.width = 34;
        jojo.height = 34;


        switch (random) {
            case 0:
                jojoDrops.add(jojo);
                break;
            case 1:
                ritaDrops.add(jojo);
                break;
        }
        dropRate = TimeUtils.nanoTime();
    }

    private void moveDrops(Array<Rectangle> drops) {

        Iterator<Rectangle> iterator = drops.iterator();

        while (iterator.hasNext()) {

            Rectangle drop = iterator.next();
            drop.x -= 900 * Gdx.graphics.getDeltaTime();

            if (drop.x + 64 < 0) {
                iterator.remove();
            }

            if (drop.overlaps(player)) {
                    game.getPlayer().setSanity(game.getPlayer().getSanity()- 30);
                    game.getPlayer().setDayCounter(game.getPlayer().getDayCounter()+1);
                    game.setScreen(new Background(game));

            }
        }
        if (TimeUtils.nanoTime() - dropRate > 100000000) {
            spawnDrops();
        }
        if (TimeUtils.nanoTime() - dropRate > 1000000000) {
            spawnDrops();
        }
    }

    private void userInputs() {

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

        if (player.x > 1850) {
            player.x = 1850;
        }

        if (player.y < 0) {
            player.y = 0;
        }

        if (player.y > 1000) {
            player.y = 1000;
        }
    }

    public Sound getSound() {
        return sound;
    }

    public Music getMusic() {
        return music;
    }
}


