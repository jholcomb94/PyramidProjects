package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        boolean win = false;
        int number = (rand.nextInt()%19)+1;
        if(number < 0)
        {
            number = number*-1;
        }
        int tries = 0;
        String name;
        Scanner kb = new Scanner(System.in);
        System.out.println("hello what is your name?");
        name = kb.nextLine();
        System.out.println("Hello " + name + " guess the number im thinking of between 1 and 20");
        while (tries <= 6 && !win)
        {
            int guess;
            System.out.println("what is your guess? ");
            guess = kb.nextInt();
            if(guess > number)
            {
                System.out.println("too high");
            }
            else if(guess < number)
            {
                System.out.println("too low");
            }
            else if(guess == number)
            {
                System.out.println("THATS IT!");
                win = true;
            }
            tries++;
        }
        if(win)
        {
            System.out.println("you win!");
        }
        else
        {
            System.out.println("you lose");
        }
        System.out.println("Thanks for playing");
    }
}
