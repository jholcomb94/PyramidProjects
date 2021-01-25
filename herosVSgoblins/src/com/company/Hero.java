package com.company;

import java.util.Random;

public class Hero {
    private int x;
    private int y;

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    private int HP;
    private Room position;
    public Hero(int y, int x) {
        this.x = x;
        this.y = y;

        this.HP = 100;
        position = new Room(y,x);
        position.setHasHero(true);
    }

    public Room getRoom() {
        return position;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(Room position) {
        this.position.emptyRoom();
        this.position = position;
        position.setHasHero(true);
        this.y = position.getY();
        this.x = position.getX();
    }
    public void takeDammage(int num)
    {
        this.HP = HP - num;
    }
}
