package org.academiadecodigo.apiores.bravoteam.Intro.Screens;


import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.apiores.bravoteam.Intro.Player;

public class Intro implements Screen {

    BitmapFont font = new BitmapFont();
    private Player player;
    private SpriteBatch batch;
    public Intro (Player player, SpriteBatch batch){
        this.player = player;
        this.batch = batch;
    }

    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {
        batch.begin();
        font.getData().setScale(2.5f,2.5f);
        font.draw(batch,"Day: "+player.getDayCounter(),10,250);
        font.draw(batch,"Health: " + player.getHealth(),10,200);
        font.draw(batch,"Hunger: "+ player.getHunger(),10,150);
        font.draw(batch,"Thirst: "+ player.getThirst(),10,100);
        font.draw(batch,"Sanity: "+ player.getSanity(),10,50);
        batch.end();
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
    public void dispose() {
        batch.dispose();

    }
}
