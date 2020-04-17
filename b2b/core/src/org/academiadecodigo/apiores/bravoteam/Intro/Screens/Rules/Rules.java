package org.academiadecodigo.apiores.bravoteam.Intro.Screens.Rules;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.academiadecodigo.apiores.bravoteam.Intro.Player;
import org.academiadecodigo.apiores.bravoteam.Intro.Screens.Background;
import org.academiadecodigo.apiores.bravoteam.Intro.Screens.Mainmenu;
import org.academiadecodigo.apiores.bravoteam.Intro.Screens.MiniGameGoOutside;
import org.academiadecodigo.apiores.bravoteam.Intro.Screens.miniGame3;
import org.academiadecodigo.apiores.bravoteam.Intro.Util.Messages;
import org.academiadecodigo.apiores.bravoteam.Intro.theConfining;


public class Rules implements Screen {



        private SpriteBatch batch;
        private Texture rules_book = new Texture("Images/rules_diary_1920.png");
        private theConfining game;
        private BitmapFont font;

        private String intro = Messages.INTRO;
        private String rules = Messages.Rules;





        public Rules (theConfining game ){

            this.game = game;
             font = game.getFont();
            batch = new SpriteBatch();
        }
        public void create(){

        }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {


                if (keyCode == Input.Keys.ENTER) {
                    game.setScreen(new Mainmenu(game));


                }return true;

        }
    });
    }
    @Override
        public void render(float delta)  {

            batch.begin();
            batch.draw(rules_book,300,200,1350,700);

            font.getData().setScale(2,2);
            font.draw(batch,Messages.INTRO_TITLE,600,750);

            font.getData().setScale(1.4f,1.4f);
            font.draw(batch,intro,450,680);
            font.setColor(Color.BLACK);

            font.getData().setScale(2,2);
            font.draw(batch,Messages.RULES_TITLE,1150,750);

            font.getData().setScale(1.4f,1.4f);
            font.draw(batch,rules,1025, 680);
            font.setColor(Color.BLACK);


            font.getData().setScale(2,2);
            font.draw(batch,Messages.PRESS_ENTER,1050, 350);








            batch.end();
        }


        public void hide() {
            Gdx.input.setInputProcessor(null);

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
        public void dispose() {

        }

    }


