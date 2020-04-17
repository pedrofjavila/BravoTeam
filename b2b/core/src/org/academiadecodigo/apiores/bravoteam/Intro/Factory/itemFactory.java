package org.academiadecodigo.apiores.bravoteam.Intro.Factory;

import com.badlogic.gdx.math.MathUtils;
import org.academiadecodigo.apiores.bravoteam.Intro.Item.*;

public class itemFactory {

    public static Item createItem(itens itens) {

        switch (itens) {
            case FOOD:
                return new food();
            case WATER:
                return new water();

            case GUITAR:
                return new Guitar();

            case BASEBALL_BAT:
                return new baseballBat();
            case SANITIZER:
                return new sanitizer();
            case RADIO:
                return new radio();
            case FLASHLIGHT:
                return new flashlight();

        }
        return null;

    }

    public static Item RandomcreateItem() {
        int random = (int)(Math.random()*7);
        switch (random) {
            case 1:
                return new food();

            case 2:
                return new water();

            case 3:
                return new Guitar();

            case 4:
                return new baseballBat();

            case 5:
                return new sanitizer();

            case 6:
                return new radio();

            default:
                return new flashlight();
        }
    }
}