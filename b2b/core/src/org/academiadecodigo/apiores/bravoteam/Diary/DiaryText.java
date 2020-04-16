package org.academiadecodigo.apiores.bravoteam.Diary;


import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.apiores.bravoteam.Intro.Menus.Player;
import org.academiadecodigo.apiores.bravoteam.Util.Messages;
import org.w3c.dom.ls.LSOutput;


public class DiaryText  {


    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Player player;
    private Texture diary = new Texture("Images/diary.png");
    private AssetManager assetManager;
    private int daycounter;
    private String playerStats;


    private String event;
    private String days = Messages.DAY_COUNT_DIARY + daycounter;
    private String result_event;





    public DiaryText (SpriteBatch batch, OrthographicCamera camera, AssetManager assetManager){
        this.camera = camera;
        this.batch = batch;
        this.assetManager = assetManager;

    }



    public void render() {
        batch.begin();
        batch.draw(diary,300,200,1350,700);

        if (assetManager.isLoaded("hwsize30_black.ttf")){

            playerStats=  player.getHealth() +"\n" +
                    player.getHunger()+"\n" + player.getThirst()  + "\n" + player.getSanity();
            result_event =  days +"\n" +"\n"+ event;
            assetManager.get("hwsize30_black.ttf", BitmapFont.class).draw(batch, result_event, 400, 800);
            if(assetManager.isLoaded("hwsize40_red.ttf")){
            assetManager.get("hwsize40_red.ttf", BitmapFont.class).draw(batch, playerStats, 1300, 800);
            if(assetManager.isLoaded("hwsize40_black.ttf"))
            assetManager.get("hwsize40_black.ttf", BitmapFont.class).draw(batch,Messages.PLAYERSTATS , 1100, 800);
            }

        }


        batch.end();
    }


    public void hide() {

    }




    public void setEvent(String event) {
        this.event = event;
        System.out.println(event);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}

