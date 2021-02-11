package com.example.demo.entities;

public class Transaction {
    private double ammount;
    private int id;

    public Transaction() {
    }

    public Transaction(double ammount, int id) {
        this.ammount = ammount;
        this.id = id;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "ammount=" + ammount +
                ", id=" + id +
                '}';
    }
}
