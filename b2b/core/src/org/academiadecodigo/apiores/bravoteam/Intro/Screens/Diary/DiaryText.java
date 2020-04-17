package org.academiadecodigo.apiores.bravoteam.Intro.Screens.Diary;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import org.academiadecodigo.apiores.bravoteam.Intro.Player;
import org.academiadecodigo.apiores.bravoteam.Intro.Screens.Background;
import org.academiadecodigo.apiores.bravoteam.Intro.Screens.MiniGameGoOutside;
import org.academiadecodigo.apiores.bravoteam.Intro.Util.Messages;
import org.academiadecodigo.apiores.bravoteam.Intro.theConfining;


public class DiaryText implements Screen {


    private SpriteBatch batch;
    private Texture diary = new Texture("Images/diary.png");
    private AssetManager assetManager;
    private int daycounter;
    private String playerStats;
    private theConfining game;
    private Player player;
    private String event;
    private String days = Messages.DAY_COUNT_DIARY + daycounter;
    private String result_event;





    public DiaryText(theConfining game ){

        this.game = game;
        this.player = game.getPlayer();
        daycounter  = player.getDayCounter();
        batch = new SpriteBatch();
    }
    public void create(){
        assetManager = new AssetManager();

        // set the loaders for the generator and the fonts themselves
        FileHandleResolver resolver = new InternalFileHandleResolver();
        assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        assetManager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));



        // load to fonts via the generator (implicitely done by the FreetypeFontLoader).
        // Note: you MUST specify a FreetypeFontGenerator defining the ttf font file name and the size
        // of the font to be generated. The names of the fonts are arbitrary and are not pointing
        // to a file on disk (but must end with the font's file format '.ttf')!

        FreetypeFontLoader.FreeTypeFontLoaderParameter handFont = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        handFont.fontFileName = "Font/IndieFlower-Regular.ttf";
        handFont.fontParameters.size = 30;
        handFont.fontParameters.color = Color.BLACK;
        assetManager.load("hwsize30_black.ttf", BitmapFont.class, handFont);

        FreetypeFontLoader.FreeTypeFontLoaderParameter handFont2 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        handFont2.fontFileName = "Font/IndieFlower-Regular.ttf";
        handFont2.fontParameters.size = 40;
        handFont2.fontParameters.color = Color.RED;
        assetManager.load("hwsize40_red.ttf", BitmapFont.class, handFont2);

        FreetypeFontLoader.FreeTypeFontLoaderParameter handFont3 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        handFont3.fontFileName = "Font/IndieFlower-Regular.ttf";
        handFont3.fontParameters.size = 40;
        handFont3.fontParameters.color = Color.BLACK;
        assetManager.load("hwsize40_black.ttf", BitmapFont.class, handFont3);

    }


    @Override
    public void render(float delta)  {
        assetManager.update();
        batch.begin();
        batch.draw(diary,300,200,1350,700);


           if (assetManager.isLoaded("hwsize30_black.ttf")) {
               System.out.println("assetmanager did the load of hwsize30:black");
               playerStats = player.getHealth() + "\n" +
                       player.getHunger() + "\n" + player.getThirst() + "\n" + player.getSanity();
               result_event = days + "\n" + "\n" + event;
               assetManager.get("hwsize30_black.ttf", BitmapFont.class).draw(batch, result_event, 400, 800);
               if (assetManager.isLoaded("hwsize40_red.ttf")) {
                   assetManager.get("hwsize40_red.ttf", BitmapFont.class).draw(batch, playerStats, 1300, 800);
                   if (assetManager.isLoaded("hwsize40_black.ttf"))
                       assetManager.get("hwsize40_black.ttf", BitmapFont.class).draw(batch, Messages.PLAYERSTATS, 1100, 800);
               }

           }
        batch.end();
    }


    public void hide() {
        Gdx.input.setInputProcessor(null);

    }




    public void setEvent(String event) {
        this.event = event;
        System.out.println(event);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keyCode){
                if(keyCode == Input.Keys.D){
                  game.setScreen(new Background(game));


                }

                               return true;
            }
        });

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

