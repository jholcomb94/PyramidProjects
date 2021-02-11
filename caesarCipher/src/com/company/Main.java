package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args){
	// write your code here
        Scanner kb = new Scanner(System.in);
        if(!Files.exists(Paths.get("caesar.txt")))
        {
            try{
                Files.createFile(Paths.get("caesar.txt"));
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("do you wish to (E)ncrypt or (D)ecrypt a message?");
        if (kb.nextLine().equals("E"))
        {
            System.out.println("What is the message you would like to encrypt");
            String message = kb.nextLine();
            System.out.println("what is the key?");
            int key = kb.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (char c :message.toCharArray()) {
                list.add(Character.getNumericValue(c));
            }
            String encoded = "";
            for (int i : list) {
                i = (((i-10) + key)%26)+10;
               encoded += Character.forDigit(i,36);
            }
            System.out.println("encoded message is: " + encoded);
            try {
                Files.write(Paths.get("caesar.txt"),encoded.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else
        {
            System.out.println("What is the key?");
            int key = kb.nextInt();
            String message = "";
            try {
                 message = Files.readAllLines(Paths.get("caesar.txt")).get(0).toString();
                 System.out.println("encoded messagae is: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (char c :message.toCharArray()) {
                list.add(Character.getNumericValue(c));
            }
            String decoded = "";
            for (int i : list) {
                i = ((i-10) - key);
                if(i < 0)
                {
                    i = 26 + i;
                }
                i = i + 10;
                decoded += Character.forDigit(i,36);
            }
            decoded = decoded.replaceAll("p"," ");
            System.out.println("the decoded message is: " + decoded);



        }

    }
}
