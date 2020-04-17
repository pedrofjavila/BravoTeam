package org.academiadecodigo.apiores.bravoteam.Intro.Menus;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class optionsMenu implements Screen {

    private SpriteBatch batch;
    private Texture optionMenu = new Texture("Images/optionsTemp.png");
    public optionsMenu (SpriteBatch batch){
        this.batch = batch;
    }

    @Override
    public void show() {
        batch.begin();
        batch.draw(optionMenu,250,250);
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
