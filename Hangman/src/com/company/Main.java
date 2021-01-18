package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    System.out.println("WELCOME TO HANGMAN");
	    boolean TryAgain = true;
	    Scanner kb = new Scanner(System.in);
	    String [] wordBank = {"test","cat","dog","water","television","cereal","donut","sock"};
        Random rand = new Random();
	    while(TryAgain)
        {

            int lives = 4;

            String word = wordBank[Math.abs(rand.nextInt()%8)];
            int count = word.length();
            String hidden = "";
            while (count > 0) {
                hidden += "_";
                count--;
            }
            while(lives > 0)
            {
                stagePrint(lives);
                System.out.println("WORD : " + hidden);
                System.out.println("Guess a letter");
                String guess = kb.nextLine();
                guess = guess.toLowerCase();
                boolean correct = false;
                for(char letter : word.toCharArray())
                {
                    if(guess.charAt(0) == letter)
                    {
                        correct = true;
                        break;
                    }
                }
                if(!correct)
                {
                    lives--;
                }
                else
                {
                    System.out.println("Correct!");
                    int index = 0;
                    for(char letter : word.toCharArray())
                    {
                        if(letter == guess.charAt(0))
                        {
                            char[] temp = hidden.toCharArray();
                            temp[index] = guess.charAt(0);
                            hidden = String.valueOf(temp);
                        }
                        index++;
                    }


                }
                if(!hidden.contains("_"))
                {
                    System.out.println("CONGRATS YOU WIN!");
                    break;
                }
            }
            System.out.println("would you like to play again? Y/N");
            String answer = kb.nextLine();
            if(answer.equals("N") || answer.equals("n"))
            {
                TryAgain = false;
            }
        }
    }

    private static void stagePrint(int lives) {
        if(lives == 4)
        {
            System.out.println("+-----+");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println(" ======");
        }
        else if(lives == 3)
        {
            System.out.println("+-----+");
            System.out.println("   O  |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println(" ======");
        }
        if(lives == 2)
        {
            System.out.println("+-----+");
            System.out.println("   O  |");
            System.out.println("   |  |");
            System.out.println("      |");
            System.out.println(" ======");
        }
        if(lives == 1)
        {
            System.out.println("+-----+");
            System.out.println("   O  |");
            System.out.println("   |  |");
            System.out.println("   |  |");
            System.out.println(" ======");
        }
    }
}
