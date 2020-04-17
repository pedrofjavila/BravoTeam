package org.academiadecodigo.apiores.bravoteam.Intro.Menus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Disposable;


public class mainMenu {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture menu = new Texture("Images/menuImage7.png");
    //Animation<TextureRegion> animation;


    public mainMenu(SpriteBatch batch,OrthographicCamera camera){
        this.camera = camera;
        this.batch = batch;
    }



    public void render() {
        batch.begin();
        batch.draw(menu, 0,0,1920,1134);
        batch.end();

    }





}
