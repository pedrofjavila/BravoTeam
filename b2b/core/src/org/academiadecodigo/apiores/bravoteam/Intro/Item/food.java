package org.academiadecodigo.apiores.bravoteam.Intro.Item;

public class food implements Item {


    private String food = "Food";

    public String getString() {
        return food;
    }

    @Override
    public String toString() {
        return food;
    }
}
