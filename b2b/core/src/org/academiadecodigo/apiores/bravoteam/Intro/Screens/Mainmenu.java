package org.academiadecodigo.apiores.bravoteam.Intro.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.apiores.bravoteam.Intro.B2B;

public class Mainmenu implements Screen {

    private B2B game;

    public Mainmenu(B2B game) {
        this.game = game;
    }
        @Override
        public void show() {
            Gdx.input.setInputProcessor(new InputAdapter(){
                @Override
                public boolean keyDown(int keyCode){
                    if(keyCode == Input.Keys.Y){
                        game.setScreen(new Background(game));
                    }
                    if(keyCode == Input.Keys.ESCAPE){
                        System.exit(1);
                    }
                    return true;
                }
            });
        }

    @Override
    public void render(float delta) {
        game.getBatch().begin();
        game.getBatch().draw(new Texture("menuImage7.png"),0,0,1920,1136);
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

    }

    @Override
    public void dispose() {

    }
}
