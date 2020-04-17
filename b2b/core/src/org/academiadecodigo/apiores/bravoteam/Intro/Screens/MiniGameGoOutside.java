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
import org.academiadecodigo.apiores.bravoteam.Intro.Factory.itemFactory;
import org.academiadecodigo.apiores.bravoteam.Intro.Factory.itens;
import org.academiadecodigo.apiores.bravoteam.Intro.theConfining;

import java.util.Iterator;

public class MiniGameGoOutside implements Screen {

    private theConfining game;

    public MiniGameGoOutside(theConfining game) {
        this.game = game;
    }

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture background;
    private Texture playerImage;
    private Texture food;
    private Texture water;
    private Texture sanitizer;
    private Texture baseball;
    private Texture guitar;
    private Texture flashlight;
    private Texture radio;
    private Texture virus;

    private Rectangle player;
    private Vector3 touchPos;

    private long dropRate;
    int counter = 0;
    private Sound sound;
    private Music music;
    private boolean kill;
    private Array<Rectangle> foodDrops;
    private Array<Rectangle> waterDrops;
    private Array<Rectangle> sanitizerDrops;
    private Array<Rectangle> baseballDrops;
    private Array<Rectangle> radioDrops;
    private Array<Rectangle> flashlightDrops;
    private Array<Rectangle> virusDrops;
    private Array<Rectangle> guitarDrops;

    public void create() {

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1136);
        background = new Texture("Items/pixelRoad.png");
        playerImage = new Texture("Items/backpack_PNG6350.png");

        player = new Rectangle();
        player.x = 0;
        player.y = 0;
        player.width = 50;
        player.height = 150;

        touchPos = new Vector3();


        foodDrops = new Array<Rectangle>();

        food = new Texture("Items/food.png");
        foodDrops = new Array<Rectangle>();

        water = new Texture("Items/bottle2.png");
        waterDrops = new Array<Rectangle>();

        sanitizer = new Texture("Items/alcool.png");
        sanitizerDrops = new Array<Rectangle>();

        radio = new Texture("Items/radiopix.png");
        radioDrops = new Array<Rectangle>();

        flashlight = new Texture("Items/flashlightpix.png");
        flashlightDrops = new Array<Rectangle>();

        baseball = new Texture("Items/baseballbat.png");
        baseballDrops = new Array<Rectangle>();

        guitar = new Texture("Items/accguitar.png");
        guitarDrops = new Array<Rectangle>();

        virus = new Texture("Items/virus_PNG53.png");
        virusDrops = new Array<Rectangle>();

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
        moveDrops(foodDrops,waterDrops,sanitizerDrops,flashlightDrops,baseballDrops,guitarDrops,radioDrops,virusDrops);
        createImages();
        userInputs();

    }

    @Override
    public void dispose() {
        background.dispose();
        playerImage.dispose();
        virus.dispose();
        flashlight.dispose();
        food.dispose();
        water.dispose();
        baseball.dispose();
        radio.dispose();
        sound.dispose();
        music.dispose();
    }

    private void createImages() {

        int counter = 0;


        batch.begin();

        batch.draw(background, 0, 0, 1920, 1136);
        batch.draw(playerImage, player.x, player.y,100,100);

        for (Rectangle drop : radioDrops) {
            batch.draw(radio, drop.x, drop.y, 50, 50);
        }

        for (Rectangle drop : foodDrops) {
            batch.draw(food, drop.x, drop.y, 50, 50);
        }

        for (Rectangle drop : waterDrops) {
            batch.draw(water, drop.x, drop.y, 50, 50);
        }

        for (Rectangle drop : flashlightDrops) {
            batch.draw(flashlight, drop.x, drop.y, 50, 50);
        }

        for (Rectangle drop : baseballDrops) {
            batch.draw(baseball, drop.x, drop.y, 50, 50);
        }

        for (Rectangle drop : sanitizerDrops) {
            batch.draw(sanitizer, drop.x, drop.y, 50, 50);
        }

        for (Rectangle drop : virusDrops) {
            batch.draw(virus, drop.x, drop.y, 50, 50);
        }
        for (Rectangle drop : guitarDrops) {
            batch.draw(guitar, drop.x, drop.y, 50, 50);
        }
        batch.end();

    }

    private void spawnDrops() {
        int random = (int) (Math.random() * 100);

        Rectangle jojo;
        jojo = new Rectangle();
        jojo.x = (int) (Math.random() * 1920);
        jojo.y = 1500;
        jojo.width = 34;
        jojo.height = 34;

        if(random>10){
            virusDrops.add(jojo);
        }

        switch (random) {
            case 0:
                waterDrops.add(jojo);
                break;
            case 1:
                foodDrops.add(jojo);
                break;
            case 2:
                flashlightDrops.add(jojo);
                break;
            case 3:
                baseballDrops.add(jojo);
                break;
            case 4:
                radioDrops.add(jojo);
                break;
            case 5:
                sanitizerDrops.add(jojo);
        }
        dropRate = TimeUtils.nanoTime();
    }

    private void moveDrops(Array<Rectangle> drops, Array<Rectangle> drops2, Array<Rectangle> drops3, Array<Rectangle> drops4,
                           Array<Rectangle> drops5, Array<Rectangle> drops6,Array<Rectangle> drops7,Array<Rectangle> drops8) {


        Iterator<Rectangle> food = drops.iterator();
        Iterator<Rectangle> water = drops2.iterator();
        Iterator<Rectangle> sanitizer = drops3.iterator();
        Iterator<Rectangle> flashlight = drops4.iterator();
        Iterator<Rectangle> baseball = drops5.iterator();
        Iterator<Rectangle> guitar =drops6.iterator();
        Iterator<Rectangle> radio =drops7.iterator();
        Iterator<Rectangle> virus =drops8.iterator();


        while (virus.hasNext()) {

            Rectangle drop = virus.next();
            drop.y -= 100 * Gdx.graphics.getDeltaTime();

            if (drop.y + 64 < 0) {
                virus.remove();
            }

            if (drop.overlaps(player)) {
                game.getPlayer().setHealth(game.getPlayer().getHealth()-20);
                game.getPlayer().setSanity(game.getPlayer().getSanity()-20);
                counter++;
                if (counter == 3) {
                    game.setScreen(new Background(game));
                }
                System.out.println(counter);
                virus.remove();

            }
        }

        while (food.hasNext()) {

            Rectangle drop = food.next();
            drop.y -= 100 * Gdx.graphics.getDeltaTime();

            if (drop.y + 64 < 0) {
                food.remove();
            }

            if (drop.overlaps(player)) {
                game.getPlayer().setHunger(game.getPlayer().getHunger()-5);
                game.getPlayer().setThirst(game.getPlayer().getThirst()-5);
                game.getPlayer().setSanity(game.getPlayer().getSanity()-5);
                game.getPlayer().getInventory().add(itemFactory.createItem(itens.FOOD));
                counter++;
                if (counter == 3) {
                    game.setScreen(new Background(game));
                }
                System.out.println(counter);

                food.remove();

            }
        }

        while (water.hasNext()) {
            int numb = (int) (Math.random()*100);
            Rectangle drop = water.next();
            drop.y -= 100 * Gdx.graphics.getDeltaTime();

            if (drop.y + 64 < 0) {
                water.remove();
            }

            if (drop.overlaps(player)) {
                game.getPlayer().setHunger(game.getPlayer().getHunger()-5);
                game.getPlayer().setThirst(game.getPlayer().getThirst()-5);
                game.getPlayer().setSanity(game.getPlayer().getSanity()-5);
                game.getPlayer().getInventory().add(itemFactory.createItem(itens.WATER));
                counter++;
                if (counter == 3) {
                    game.setScreen(new Background(game));
                }
                System.out.println(counter);

               water.remove();

            }
        }

        while (sanitizer.hasNext()) {

            Rectangle drop = sanitizer.next();
            drop.y -= 100 * Gdx.graphics.getDeltaTime();

            if (drop.y + 64 < 0) {
                sanitizer.remove();
            }

            if (drop.overlaps(player)) {
                game.getPlayer().setHunger(game.getPlayer().getHunger()-5);
                game.getPlayer().setThirst(game.getPlayer().getThirst()-5);
                game.getPlayer().setSanity(game.getPlayer().getSanity()-5);
                game.getPlayer().getInventory().add(itemFactory.createItem(itens.SANITIZER));
                counter++;
                if (counter == 3) {
                    game.setScreen(new Background(game));
                }
                System.out.println(counter);

                sanitizer.remove();

            }
        }
        while (baseball.hasNext()) {

            Rectangle drop = baseball.next();
            drop.y -= 100 * Gdx.graphics.getDeltaTime();

            if (drop.y + 64 < 0) {
                baseball.remove();
            }

            if (drop.overlaps(player)) {
                game.getPlayer().setHunger(game.getPlayer().getHunger()-5);
                game.getPlayer().setThirst(game.getPlayer().getThirst()-5);
                game.getPlayer().setSanity(game.getPlayer().getSanity()-5);
                game.getPlayer().getInventory().add(itemFactory.createItem(itens.BASEBALL_BAT));
                counter++;
                if (counter == 3) {
                    game.setScreen(new Background(game));
                }
                System.out.println(counter);

                baseball.remove();

            }
        }
        while (flashlight.hasNext()) {

            Rectangle drop = flashlight.next();
            drop.y -= 100 * Gdx.graphics.getDeltaTime();

            if (drop.y + 64 < 0) {
                flashlight.remove();
            }

            if (drop.overlaps(player)) {
                game.getPlayer().setHunger(game.getPlayer().getHunger()-5);
                game.getPlayer().setThirst(game.getPlayer().getThirst()-5);
                game.getPlayer().setSanity(game.getPlayer().getSanity()-5);
                game.getPlayer().getInventory().add(itemFactory.createItem(itens.FLASHLIGHT));
                counter++;
                if (counter == 3) {
                    game.setScreen(new Background(game));
                }
                System.out.println(counter);

               flashlight.remove();

            }
        }
        while (radio.hasNext()) {

            Rectangle drop = radio.next();
            drop.y -= 100 * Gdx.graphics.getDeltaTime();

            if (drop.y + 64 < 0) {
                radio.remove();
            }

            if (drop.overlaps(player)) {
                game.getPlayer().setHunger(game.getPlayer().getHunger()-5);
                game.getPlayer().setThirst(game.getPlayer().getThirst()-5);
                game.getPlayer().setSanity(game.getPlayer().getSanity()-5);
                game.getPlayer().getInventory().add(itemFactory.createItem(itens.RADIO));
                counter++;
                if (counter == 3) {
                    game.setScreen(new Background(game));
                }
                System.out.println(counter);

                radio.remove();

            }
        }
        while (guitar.hasNext()) {

            Rectangle drop = guitar.next();
            drop.y -= 100 * Gdx.graphics.getDeltaTime();

            if (drop.y + 64 < 0) {
                guitar.remove();
            }

            if (drop.overlaps(player)) {
                game.getPlayer().setHunger(game.getPlayer().getHunger()-5);
                game.getPlayer().setThirst(game.getPlayer().getThirst()-5);
                game.getPlayer().setSanity(game.getPlayer().getSanity()-5);
                game.getPlayer().getInventory().add(itemFactory.createItem(itens.GUITAR));
                counter++;
                if (counter == 3) {
                    game.setScreen(new Background(game));
                }
                System.out.println(counter);

                guitar.remove();

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

        if (player.x > 1900) {
            player.x = 1900;
        }

        if (player.y < 0) {
            player.y = 0;
        }

        if (player.y > 20) {
            player.y = 20;
        }
    }

}
