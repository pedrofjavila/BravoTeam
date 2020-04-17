package org.academiadecodigo.apiores.bravoteam.Intro.Item;

public class water implements Item {
    private String string= "Bottle of Water";
    @Override
           public String toString() {
            return string;
    }


    @Override
    public String getString() {
        return string;
    }
}
