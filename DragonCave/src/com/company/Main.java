package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        int correct = (r.nextInt()%2 )+ 1;
        String input = "";
        boolean goodInput = false;
        while(!goodInput) {
            System.out.println("welcome to the dragon's cave\n " +
                    "You are in a land full of dragons. In front of you,\n" +
                    "\n" +
                    "you see two caves. In one cave, the dragon is friendly\n" +
                    "\n" +
                    "and will share his treasure with you. The other dragon\n" +
                    "\n" +
                    "is greedy and hungry and will eat you on sight.\n" +
                    "\n" +
                    "Which cave will you go into? (1 or 2)");
            Scanner kb = new Scanner(System.in);
            input = kb.nextLine();
            if(input.equals("1") || input.equals("2"))
            {
                goodInput = true;
            }
            else {
                System.out.println("bad input, try again");
            }
        }
        System.out.println("You approach the cave...\n" +

        "It is dark and spooky...\n" +

        "A large dragon jumps out in front of you! He opens his jaws and...\n");
        if(Integer.parseInt(input) == correct)
        {
            System.out.println("lets out a yawn....\n");
            System.out.println("he says 'you are welcome to take some treasure, im happy to share it' \n");
        }
        else {
            System.out.println("Gobbles you down in one bite!\n");
        }

        System.out.println("THANKS FOR PLAYING\n");


    }
}
