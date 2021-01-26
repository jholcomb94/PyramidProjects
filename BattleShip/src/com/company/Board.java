package com.company;

import java.util.ArrayList;

public class Board {
    Space[][] spaces;
    private ArrayList<Ship> fleet;
    public Board()
    {
        spaces = new Space[9][9];
        fleet = new ArrayList<Ship>();
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                spaces[i][j] = new Space(i,j);
            }
        }
    }
    public void printBoard()
    {
        System.out.println("   1 2 3 4 5 6 7 8 9");
        int row = 1;
        for (Space [] sAra: spaces) {
            System.out.print(row + "  ");
            for (Space s: sAra) {
                System.out.print(s.toString() + " ");
            }
            System.out.println();
            row++;
        }
    }
    public int fleetSize()
    {
        return fleet.size();
    }
    public boolean hit(int y, int x, Board Blank)
    {
        if(!spaces[y][x].toString().equals("~") && !spaces.toString().equals("x"))
        {
            spaces[y][x].hit();
            Blank.getSpace(y,x).hit();
            spaces[y][x].getShip().hit();
            if(spaces[y][x].getShip().getHP() == 0)
            {
                fleet.remove(spaces[y][x].getShip());
            }
            System.out.println("Direct Hit!");
            return true;
        }
        spaces[y][x].miss();
        Blank.getSpace(y,x).miss();
        System.out.println("Miss!");
        return false;
    }
    public boolean verify(Ship s, int y, int x, String Orientation)
    {
        if(Orientation.equals("v")) {
            if(y + s.getSize() <= 9)
            {
                String prev = spaces[y][x].toString();
                if (prev.equals("~")) {
                    int z = 0;
                    while(z < s.getSize())
                    {
                        if(!(spaces[y + z][x].toString().equals("~")))
                        {
                            return false;
                        }
                        z++;
                    }
                    return true;
                }

            }
            return false;
        }
        if(Orientation.equals("h")) {
            if(x + s.getSize() <= 9)
            {
                String prev = spaces[y][x].toString();
                if (prev.equals("~")) {
                    int z = 0;
                    while(z < s.getSize())
                    {
                        if(!(spaces[y][x + z].toString().equals("~")))
                        {
                            return false;
                        }
                        z++;
                    }
                    return true;
                }

            }
            return false;
        }
        return false;
    }
    public Space getSpace(int y, int x)
    {
        return spaces[y][x];
    }
    public void  addShip(Ship s, int y, int x, String Orientation)
    {
        spaces[y][x].addShip(s);
        fleet.add(s);
        if(Orientation.equals("v"))
        {
            int z = 1;
            while(z <= s.getSize()-1)
            {
                spaces[y + z][x].addShip(s);
                z++;
            }
        }
        if(Orientation.equals("h"))
        {
            int z = 1;
            while(z <= s.getSize()-1)
            {
                spaces[y][x + z].addShip(s);
                z++;
            }
        }
    }
}
