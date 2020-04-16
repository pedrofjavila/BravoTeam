package org.academiadecodigo.apiores.bravoteam.Intro.Screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.apiores.bravoteam.Intro.B2B;


public class Background implements Screen {

    private B2B game;

    public Background(B2B game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keyCode){
                if(keyCode == Input.Keys.T){
                    game.setScreen(new MyGdxGame(game));
                }

                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        game.getBatch().begin();
        game.getBatch().draw(new Texture("backgrd.jpg"),0f,0f,1920,1136);
        game.getBatch().end();
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
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {

    }
}
