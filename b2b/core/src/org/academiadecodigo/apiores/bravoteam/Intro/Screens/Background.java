package org.academiadecodigo.apiores.bravoteam.Intro.Screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.apiores.bravoteam.Intro.Factory.itens;
import org.academiadecodigo.apiores.bravoteam.Intro.Item.Item;
import org.academiadecodigo.apiores.bravoteam.Intro.theConfining;

import java.util.Iterator;


public class Background implements Screen {

    private theConfining game;

    public Background(theConfining game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keyCode){
                MiniGameGoOutside miniGameGoOutside = new MiniGameGoOutside(game);
                miniGame3 miniGame3 = new miniGame3(game);
                if(keyCode == Input.Keys.NUM_1){
                    miniGameGoOutside.create();
                    game.setScreen(miniGameGoOutside);

                }if(keyCode == Input.Keys.NUM_2){
                           miniGame3.create();
                           game.setScreen(miniGame3);

                }if(keyCode == Input.Keys.E){
                    Iterator<Item> invent = game.getPlayer().getInventory().iterator();
                    while(invent.hasNext()) {
                        if (invent.next().equals(itens.FOOD)) {
                            game.getPlayer().setHunger(game.getPlayer().getHunger() + 25);
                            invent.remove();
                        }
                    }
                }if(keyCode == Input.Keys.Q){
                    Iterator<Item> invent = game.getPlayer().getInventory().iterator();
                    while (invent.hasNext()) {
                        if (invent.next().equals(itens.WATER)) {
                            game.getPlayer().setThirst(game.getPlayer().getThirst() + 25);
                            invent.remove();
                        }
                    }
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
