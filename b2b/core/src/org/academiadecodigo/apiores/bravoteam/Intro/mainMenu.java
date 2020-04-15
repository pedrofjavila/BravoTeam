package org.academiadecodigo.apiores.bravoteam.Intro;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class mainMenu {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture menu;

    public mainMenu(SpriteBatch batch,OrthographicCamera camera){
        this.camera = camera;
        this.batch = batch;

    }



    public void show(){
        menu = new Texture("menu temp.png");
        batch.begin();
        batch.draw(menu,0,0);
        batch.end();
    }

    public  void dispose(){
        batch.dispose();
        menu.dispose();
    }







}
