package com.company;

public abstract class Ship {
    private String type;
    private int size;
    private  int HP;
    protected Ship (String type, int size)
    {
        this.HP = size;
        this.type = type;
        this.size = size;
    }
    public void hit()
    {
        HP--;
    }
    public int getHP()
    {
        return this.HP;
    }
    public String getType() {
        return type;
    }
    public int getSize()
    {
        return size;
    }
}
