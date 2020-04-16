package org.academiadecodigo.apiores.bravoteam.Intro.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class foundWater implements Screen {

    private SpriteBatch batch;
    BitmapFont font2 = new BitmapFont();
    public foundWater(SpriteBatch batch){
        this.batch = batch;
    }
    @Override
    public void show() {
        batch.begin();
        font2.setColor(234,34,156,78);
        font2.draw(batch,"You have found: Water",150,150);
        batch.end();
    }

    @Override
    public void render(float delta) {

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

    }
}
