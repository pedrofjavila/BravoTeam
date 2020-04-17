package org.academiadecodigo.apiores.bravoteam.Intro.Factory;

import org.academiadecodigo.apiores.bravoteam.Intro.Item.*;

public class itemFactory {

    public static Item createItem(itens itens){

        switch (itens){
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
}
