package com.company;

public class Room {
    private int x,y;
    private boolean hasHero;
    private boolean hasGoblin;

    public Room(int y, int x) {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    @Override
    public String toString()
    {
        String room = null;

        if(this.x ==  0)
        {
            if(this.y == 4)
            {
                room = "* - *\n*   |\n* * *";
            }
            else if(this.y == 0)
            {
                room = "* * *\n*   |\n* - *";
            }
            else
            {
                room = "* - *\n*   |\n* - *";
            }

        }

        else if(this.y == 0)
        {
            if(this.x == 4)
            {
                room = "* * *\n|   *\n* - *";
            }
            else
            {
                room = "* * *\n|   |\n* - *";
            }
        }
        else if(this.y == 4)
        {
            if(this.x == 4)
            {
                room = "* - *\n|   *\n* * *";
            }
            else
            {
                room = "* - *\n|   |\n* * *";
            }
        }
        else if(this.x == 4)
        {
            room = "* - *\n|   *\n* - *";
        }

        else
        {
            room = "* - *\n|   |\n* - *";
        }


        return room;
    }
    public boolean HasGoblin() {
        return hasGoblin;
    }

    public void setHasGoblin(boolean hasGoblin) {
        this.hasGoblin = hasGoblin;
    }
    public boolean HasHero() {
        return hasHero;
    }

    public void setHasHero(boolean hasHero) {
        this.hasHero = hasHero;
    }

    public String stringTop() {
        return this.toString().substring(0,5);
    }

    public String stringMid() {
        String mid = this.toString().substring(6,7);
        if(hasHero)
        {
            return mid + " H" + this.toString().substring(9,11);
        }
        else if(hasGoblin)
        {
            return mid + " G" + this.toString().substring(9,11);
        }

        return this.toString().substring(6,11);

    }

    public String stringBottom() {
        return this.toString().substring(12);
    }
    public void emptyRoom() {
        this.hasHero = false;
        this.hasGoblin = false;
    }

}
