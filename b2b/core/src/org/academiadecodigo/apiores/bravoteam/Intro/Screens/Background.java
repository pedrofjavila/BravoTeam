package org.academiadecodigo.apiores.bravoteam.Intro.Screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.math.MathUtils;
import org.academiadecodigo.apiores.bravoteam.Intro.Factory.itemFactory;
import org.academiadecodigo.apiores.bravoteam.Intro.Player;
import org.academiadecodigo.apiores.bravoteam.Intro.Screens.Diary.DiaryText;
import org.academiadecodigo.apiores.bravoteam.Intro.Util.Messages;
import org.academiadecodigo.apiores.bravoteam.Intro.Factory.itens;
import org.academiadecodigo.apiores.bravoteam.Intro.Item.Item;
import org.academiadecodigo.apiores.bravoteam.Intro.theConfining;

import java.util.Iterator;


public class Background implements Screen {

    private theConfining game;
    private Player player;
   // private AssetManager assetManager;
    private Boolean isDpressed = false;
    private DiaryText diary;
    private Music bg_music;



    public Background(theConfining game) {
        this.game = game;
        player = game.getPlayer();

     //   assetManager = new AssetManager();
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


                }

                if(keyCode == Input.Keys.D){
                   diary = new DiaryText(game);
                    diary.create();
                    setDiaryMessage();
                    setDiaryEvent();
                    diary.setPlayer(player);
                   game.setScreen(diary);
                    //diary.render(1);
                    //isDpressed= true;

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






        bg_music = Gdx.audio.newMusic(Gdx.files.internal("Music/background_music.mp3"));
        bg_music.setLooping(true);
        bg_music.setVolume(0.10f);
    }


    @Override
    public void render(float delta) {
        game.getBatch().begin();
        game.getBatch().draw(new Texture("Images/background.jpg"),0f,0f,1920,1136);
        game.getBatch().end();
        bg_music.play();
       /* if (isDpressed){
            diary.render(1);
            setDiaryMessage();
        }*/
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



    public void setDiaryMessage( ){

        switch(player.getDayCounter()){
            case 0:
                diary.setEvent(Messages.EVENT_DAY_ZERO);
                break;
            case 1:
                diary.setEvent(Messages.EVENT_DAY_ONE);

                break;
            case 2:
                diary.setEvent(Messages.EVENT_DAY_TWO);
                break;
            case 3:
                diary.setEvent(Messages.EVENT_DAY_THREE);
                break;
            case 4:
                diary.setEvent(Messages.EVENT_DAY_FOUR);
                break;
            case 5:
                diary.setEvent(Messages.EVENT_DAY_FIVE);
                break;
            case 6:
                diary.setEvent(Messages.EVENT_DAY_SIX);
            default:
                diary.setEvent(Messages.EVENT_DAYS_LOST);
        }

    }
    public void setDiaryEvent( ) {
        int random = MathUtils.random(1, 7);
        switch (random) {
            case 1:
                diary.setRandom_event(Messages.GET_OUT_1);
                break;
            case 2:
                game.getPlayer().getInventory().add(itemFactory.RandomcreateItem());
                diary.setRandom_event(Messages.GET_OUT_2+" Let me look at my inventory");
                break;
            case 3:
                diary.setRandom_event(Messages.GET_OUT_3);
                break;
            case 4:
                diary.setRandom_event(Messages.GET_OUT_4);
                break;
            case 5:
                diary.setRandom_event(Messages.GET_OUT_5);
                break;
            case 6:
                diary.setRandom_event(Messages.GET_OUT_6);
                break;
            default:
                diary.setRandom_event(Messages.GET_OUT_7);
        }
    }



}
