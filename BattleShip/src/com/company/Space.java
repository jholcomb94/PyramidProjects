package com.company;

public class Space {
   private char s;
   private int x;
   private int y;
   private Ship ship;
   public Space(int y, int x)
   {
        s = '~';
        this.x = x;
        this.y = y;
   }
   public void addShip(Ship ship)
   {
       this.ship = ship;
       if(ship.getType().equals("Cruiser"))
       {
           s = 'r';
       }
       else {
           s = ship.getType().charAt(0);
       }
   }
   public Ship getShip() {
        return ship;
   }

   public void hit()
   {
       s = 'x';
   }
    public void miss()
    {
        s = 'm';
    }
   public void setS(char c)
   {
       c = s;
   }
   @Override
   public String toString()
   {
       return String.valueOf(s);
   }
}
