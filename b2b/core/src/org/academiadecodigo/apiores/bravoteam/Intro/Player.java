package org.academiadecodigo.apiores.bravoteam.Intro;

import org.academiadecodigo.apiores.bravoteam.Intro.Item.Item;

import java.util.LinkedList;
import java.util.List;

public class Player {

    private int health = 100;
    private int hunger = 100;
    private int thirst = 100;
    private int sanity = 100;
    private int dayCounter = 0;
    private int waters = 10;
    private int food = 10;

    private List<Item> Inventory = new LinkedList<>();

    public void setHealth(int health) {
        this.health = health;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void setSanity(int sanity) {
        this.sanity = sanity;
    }

    public int getHealth() {
        return health;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getSanity() {
        return sanity;
    }

    public int getDayCounter() {
        return dayCounter;
    }

    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }

    public int getWaters() {
        return waters;
    }

    public void setWaters(int waters) {
        this.waters = waters;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }


    public List<Item> getInventory() {
        return Inventory;
    }
}
