package org.academiadecodigo.apiores.bravoteam.Intro.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.apiores.bravoteam.Intro.theConfining;

public class Mainmenu implements Screen {

    private theConfining game;
    private Music mainmenu_music;
    public Mainmenu(theConfining game) {
        this.game = game;
    }
        @Override
        public void show() {
            mainmenu_music = Gdx.audio.newMusic(Gdx.files.internal("Music/I Will Survive_intro.mp3"));
            mainmenu_music.setLooping(true);
            mainmenu_music.setVolume(0.10f);
            Gdx.input.setInputProcessor(new InputAdapter(){
                @Override
                public boolean keyDown(int keyCode){
                    if(keyCode == Input.Keys.Y){
                        game.setScreen(new Background(game));
                        mainmenu_music.stop();
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
        game.getBatch().draw(new Texture("Images/introMenu.png"),0,0,1920,1136);
        game.getBatch().end();
        mainmenu_music.play();
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
