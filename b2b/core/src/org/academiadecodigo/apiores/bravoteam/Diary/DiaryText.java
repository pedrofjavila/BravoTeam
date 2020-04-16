package org.academiadecodigo.apiores.bravoteam.Diary;


import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.apiores.bravoteam.Util.Messages;
import org.w3c.dom.ls.LSOutput;


public class DiaryText  {


    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture diary = new Texture("Images/diary1.png");
    private AssetManager assetManager;
    private int daycounter;
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
        batch.draw(diary,600,200,650,600);
        if (assetManager.isLoaded("hwsize20.ttf")){
            result_event =  days +"\n" +"\n"+ event;
            assetManager.get("hwsize20.ttf", BitmapFont.class).draw(batch, result_event, 700, 750);


        }


        batch.end();
    }


    public void hide() {

    }


    public void setDaycounter(int daycounter) {
        this.daycounter = daycounter;
    }



    public void setEvent(String event) {
        this.event = event;
        System.out.println(event);
    }


}

