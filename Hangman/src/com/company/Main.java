package com.company;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {

    public static <integer> void main(String[] args) {
	    System.out.println("WELCOME TO HANGMAN");
        boolean TryAgain = true;
	    Scanner kb = new Scanner(System.in);
	    int correctLetter = 0;
	    int score = 0;
	    String name = "";
	    System.out.println("Enter your name: ");
	    name = kb.nextLine();
	    System.out.println("select difficulty : ");
	    System.out.println("(E)asy");
        System.out.println("(M)edium");
        System.out.println("(H)ard");
        System.out.println("(I)mpossible");
        String difficulty = kb.nextLine();
        List wordBank = new ArrayList();
        List scores = new ArrayList();
        try {
            if(difficulty.equals("I")) {
                wordBank = Files.readAllLines(Paths.get("hangman-impossible.txt"));
                correctLetter = 100;
            }
            else if(difficulty.equals("E"))
            {
                wordBank = Files.readAllLines(Paths.get("hangman-easy.txt"));
                correctLetter = 10;
            }
            else if(difficulty.equals("M"))
            {
                wordBank = Files.readAllLines(Paths.get("hangman-medium.txt"));
                correctLetter = 20;
            }
            else if(difficulty.equals("H"))
            {
                wordBank = Files.readAllLines(Paths.get("hangman-hard.txt"));
                correctLetter = 40;
            }
            scores = Files.readAllLines(Paths.get("high-Scores.txt"));
            scores = (List) scores.stream().filter(s -> s.toString().matches("[-+]?\\d*\\.?\\d+")).collect(Collectors.toList());
            scores = (List) scores.stream().map(n -> Integer.parseInt(n.toString())).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Random rand = new Random();
	    while(TryAgain)
        {

            int lives = 4;

            String word = wordBank.get(Math.abs(rand.nextInt() % wordBank.size())).toString();
            System.out.println(word);
            int count = word.length();
            char[] hiddenArr = new char[word.length()];
            Arrays.fill(hiddenArr,'_');

            while(lives > 0)
            {
                String hidden = new String(hiddenArr);
                stagePrint(lives);
                System.out.println("WORD : " + hidden);
                System.out.println("Guess a letter");
                String guess = kb.nextLine();
                guess = guess.toLowerCase();
                boolean correct = false;
                correct = word.contains(guess);
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
                            score = score + correctLetter;
                            hiddenArr[index] = guess.charAt(0);
                        }
                        index++;
                    }


                }
                if(!Arrays.toString(hiddenArr).contains("_"))
                {
                    System.out.println("CONGRATS YOU WIN!");
                    break;
                }
            }


            System.out.println(name + ", your score was " + score);
            Integer i = (Integer) scores.stream().max(Comparator.naturalOrder()).get();
            if(i.intValue() < score)
            {
                System.out.println("you got the high score!");
                try {
                    String S = String.valueOf(score) + "\n" + name + "\n";
                    Files.write(Paths.get("high-Scores.txt"), S.getBytes(),StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            scores.add(score);
            Collections.sort(scores,Collections.reverseOrder());
            System.out.println("Scores: " + Arrays.toString(scores.toArray()));
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
