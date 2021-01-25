package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Dungeon {
    private Room [][] dungeonRooms;
    private Room heroRoom;
    ArrayList<Goblin> enemies = new ArrayList<>();
    public Dungeon(Hero h)
    {
        this.dungeonRooms = new Room[5][5];
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                dungeonRooms[i][j] = new Room(i,j);
            }
        }
        setGoblins();
        setHero(h);
    }
    public Room getRoom(int y, int x)
    {
        return dungeonRooms[y][x];
    }
    private void setHero(Hero player)
    {
        Random rand = new Random();
        int x,y;
        while(true)
        {
            y = Math.abs(rand.nextInt()%4);
            x = Math.abs(rand.nextInt()%4);
            if(!dungeonRooms[y][x].HasGoblin())
            {
                break;
            }
        }
        player.setPosition(new Room(y,x));
        heroRoom = player.getRoom();
        dungeonRooms[y][x] = player.getRoom();

    }

    private void setGoblins() {
        Random rand = new Random();
        int x,y,count = 0;
        while(count < 3)
        {
            while(true) {
                y = Math.abs(rand.nextInt() % 4);
                x = Math.abs(rand.nextInt() % 4);
                if (!dungeonRooms[y][x].HasHero()) {
                    break;
                }
            }
            Goblin g = new Goblin(y,x);
            dungeonRooms[g.ypos()][g.xpos()] = g.getRoom();
            enemies.add(g);
            count++;
        }
    }

    @Override
    public  String toString()
    {
        String dungeon = "";
        int i =0;
        int j =0;
        while(i < 5)
        {
            j =0;
            while(j < 5)
            {
                dungeon += dungeonRooms[i][j].stringTop();
                j++;
            }
            dungeon += "\n";
            j =0;
            while(j < 5)
            {
                dungeon += dungeonRooms[i][j].stringMid();
                j++;
            }
            dungeon += "\n";
            j =0;
            while(j < 5)
            {
                dungeon += dungeonRooms[i][j].stringBottom();
                j++;
            }
            dungeon += "\n";
            i++;

        }
        return dungeon;

    }
    public void updateHero(Room r,int y,int x)
    {
        heroRoom = r;
        dungeonRooms[y][x] = r;
    }
    public int numGoblins()
    {
        return enemies.size();
    }
    public Goblin getEnemy()
    {
        Random r = new Random();
        return enemies.get(Math.abs(r.nextInt()%(enemies.size())));
    }
    public void defeatedgoblin()
    {
        enemies.remove(0);
    }
}
