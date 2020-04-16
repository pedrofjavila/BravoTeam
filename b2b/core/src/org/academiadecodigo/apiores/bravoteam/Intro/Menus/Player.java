package org.academiadecodigo.apiores.bravoteam.Intro.Menus;

public class Player {

    private int health = 100;
    private int hunger = 100;
    private int thirst = 100;
    private int sanity = 100;



    private int daysCounter = 0;

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

    public void setDaysCounter(int daysCounter) {
        this.daysCounter = daysCounter;
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
    public int getDaysCounter() {
        return daysCounter;
    }

}
