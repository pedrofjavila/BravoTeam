package org.academiadecodigo.apiores.bravoteam.Intro;


import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Intro implements Screen {

    private SpriteBatch batch;
    private Texture test = new Texture("badlogic.jpg ");
    private OrthographicCamera camera;

    public Intro (OrthographicCamera camera, SpriteBatch batch){
        this.camera = camera;
        this.batch = batch;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(test,0,0);
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
