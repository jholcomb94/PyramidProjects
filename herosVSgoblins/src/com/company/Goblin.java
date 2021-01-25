package com.company;

import java.util.Random;

public class Goblin {
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

    public Goblin(int y, int x) {
        this.y = y;
        this.x = x;
        Random rand = new Random();
        this.HP = Math.abs(rand.nextInt()%50)+1;
        position = new Room(y,x);
        position.setHasGoblin(true);
    }

    public int ypos() {
        return y;
    }

    public int xpos() {
        return x;
    }

    public Room getRoom() {
        return position;
    }
    public void takeDammage(int num)
    {
        this.HP = HP - num;
    }
}
