package org.academiadecodigo.apiores.bravoteam.Intro;


import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import org.academiadecodigo.apiores.bravoteam.Intro.Menus.Player;

public class Intro implements Screen {

    BitmapFont font = new BitmapFont();
    private Player player;
    private SpriteBatch batch;
    private Texture test = new Texture("Images/badlogic.jpg ");

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
        font.draw(batch,"Days: "+ player.getDaysCounter(),10,250);
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
        test.dispose();
    }
}
