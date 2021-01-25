package com.company;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    static Scanner kb = new Scanner(System.in);
    public static  void main(String[] args) {
	// write your code here
      System.out.println("welcome to heros VS goblins");
        do
        {
            play();

        } while (playAgain());

    }

    private static boolean playAgain() {
        String again;
        System.out.println("Play again (y/n)?");
        again = kb.next();
        return (again.equals("Y") || again.equals("y"));
    }

    private static void play() {
        Hero player = new Hero(0,0);
        Dungeon map = new Dungeon(player);
        System.out.println(map.toString());
        gameLoop(player, map);

    }
    private static void gameLoop(Hero player, Dungeon map)
    {
        while(true) {
            movement(player, map);
            if(player.getHP() < 0 || map.numGoblins() == 0)
            {
                break;
            }
            System.out.println(map.toString());
        }
    }
    private static void movement(Hero theHero, Dungeon dungeon) {
        int x = theHero.getX();
        int y = theHero.getY();
        boolean success = false;
        while(!success)
        {
            System.out.println("enter a movement N,E,S or W");
            String movement = kb.nextLine();
            if(movement.equals("N")|| movement.equals("n"))
            {
                y--;
                if(y >= 0)
                {
                    success = true;
                }
            }
            else if(movement.equals("E")|| movement.equals("e"))
            {
                x++;
                if(x < 4)
                {
                    success = true;
                }
            }
            else if(movement.equals("S")|| movement.equals("s"))
            {
                y++;
                if(y < 4)
                {
                    success = true;
                }
            }
            else if(movement.equals("W")|| movement.equals("w"))
            {
                x--;
                if(x>=0)
                {
                    success = true;
                }

            }
            else
            {
                System.out.print("try again!");
                x = theHero.getX();
                y = theHero.getY();

            }
        }
        if(dungeon.getRoom(y,x).HasGoblin())
        {
            Random r = new Random();
            battle(Math.abs((r.nextInt()%20 )+ 1), Math.abs((r.nextInt()%20 )+ 1),theHero,dungeon);
        }
        theHero.setPosition(new Room(y,x));
        dungeon.updateHero(theHero.getRoom(), y,x);

    }

    private static void battle(int gob,int hero,Hero h,Dungeon map) {

        System.out.println("a goblin jumps out!");
        Goblin enemy = map.getEnemy();
        Random r = new Random();
        if(gob > hero)
        {
            System.out.println("The goblin gets first attack!");
            while(h.getHP() > 0 && enemy.getHP() > 0)
            {
                System.out.println("Hero's HP : " + h.getHP());
                System.out.println("Goblins HP: " + enemy.getHP());
                int dammage =  abs(r.nextInt()%19 + 1);
                System.out.println("the goblin  attacks the hero for " + dammage + " HP");
                h.takeDammage(dammage);
                dammage = abs(r.nextInt()%19 + 1);
                System.out.println("the hero attacks the goblin for " + dammage +" HP");
                enemy.takeDammage(dammage);

            }
            if(h.getHP() < 0)
            {
                System.out.println("the hero was defeated!");
            }
            else if(enemy.getHP() < 0)
            {
                System.out.println("the hero defeated the goblin");
                map.defeatedgoblin();
            }

        }
        else
        {
            System.out.println("you get first attack!");

            while(h.getHP() > 0 && enemy.getHP() > 0)
            {
                System.out.println("Hero's HP : " + h.getHP());
                System.out.println("Goblins HP: " + enemy.getHP());
                int dammage =  abs(r.nextInt()%19 + 1);
                System.out.println("the hero attacks the goblin for " + dammage +" HP");
                enemy.takeDammage(dammage);
                dammage = abs(r.nextInt()%19 + 1);
                System.out.println("the goblin  attacks the hero for " + dammage + " HP");
                h.takeDammage(dammage);

            }
            if(h.getHP() <= 0)
            {
                System.out.println("the hero was defeated!");
            }
            else if(enemy.getHP() <= 0)
            {
                System.out.println("the hero defeated the goblin");
                map.defeatedgoblin();
            }

        }
    }
}
