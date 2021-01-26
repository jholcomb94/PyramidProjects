package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String p1,p2;
        Board p1board = new Board(),p2board = new Board();
	    System.out.println("Battleship Multiplayer");
	    System.out.println("Player 1 enter your name: ");
	    p1 = kb.nextLine();
	    System.out.println("Player 2 enter your name: ");
	    p2 = kb.nextLine();
        //playGame(p1,p2,p1board,p2board);
	    System.out.println(p1 + ",Add your fleet");
        p1board.printBoard();

	    //player one creates their fleet
        //player one adds their carrier
        System.out.println("Add your Carrier");
        createFleet(new Carrier(),p1board);
        p1board.printBoard();

        //player one adds their Battleship
        System.out.println("Add your Battleship");
        createFleet(new Battleship(),p1board);
        p1board.printBoard();

        //player one adds their cruiser
        System.out.println("Add your Cruiser");
        createFleet(new Cruiser(),p1board);
        p1board.printBoard();

        //player one adds their submarine
        System.out.println("Add your Submarine");
        createFleet(new Submarine(),p1board);
        p1board.printBoard();

        //player one adds their destroyer
        System.out.println("Add your Destroyer");
        createFleet(new Destroyer(),p1board);
        p1board.printBoard();

        System.out.println(p2 + ",Add your fleet");
        p2board.printBoard();
        //player two creates their fleet

        //player two adds their carrier
        System.out.println("Add your Carrier");
        createFleet(new Carrier(),p2board);
        p2board.printBoard();

        //player two adds their Battleship
        System.out.println("Add your Battleship");
        createFleet(new Battleship(),p2board);
        p2board.printBoard();

        //player two adds their cruiser
        System.out.println("Add your Patrol boat");
        createFleet(new Patrol(),p2board);
        p2board.printBoard();

        //player two adds their submarine
        System.out.println("Add your Submarine");
        createFleet(new Submarine(),p2board);
        p2board.printBoard();

        //player two adds their destroyer
        System.out.println("Add your Destroyer");
        createFleet(new Destroyer(),p2board);
        p2board.printBoard();

        playGame(p1,p2,p1board,p2board);




    }

    private static void playGame(String p1, String p2, Board p1board, Board p2board) {
        Scanner kb = new Scanner(System.in);
        Board p1Blank = new Board(), p2Blank = new Board();
        System.out.println(p1 + "goes first");
        while(p1board.fleetSize() > 0 && p2board.fleetSize() >0)
        {
            p1Blank.printBoard();
            p1board.printBoard();

            while(true) {
                System.out.println(p1 + " Choose the Y coordinate you would like to attack");
                int y = kb.nextInt() ;
                System.out.println(p1 + " choose the x coordinate you would like to attack");
                int x = kb.nextInt();
                if (x <= 9 && x > 0 && y <= 9 && y > 0) {
                    if(p1Blank.getSpace(y-1,x-1).toString().equals("~"))
                    {
                        p2board.hit(y-1,x-1,p1Blank);
                        break;
                    }
                }
                System.out.println("try again!");
            }
            p2Blank.printBoard();
            p2board.printBoard();
            while(true) {
                System.out.println(p2 + " Choose the Y coordinate you would like to attack");
                int y = kb.nextInt();
                System.out.println(p2 + "choose the x coordinate you would like to attack");
                int x = kb.nextInt();
                if (x <= 9 && x > 0 && y <= 9 && y > 0) {
                    if(p2Blank.getSpace(y-1,x-1).toString().equals("~"))
                    {
                        p1board.hit(y-1,x-1,p2Blank);
                        break;
                    }
                }
                System.out.println("try again!");
            }


        }
        if(p1board.fleetSize() == 0)
        {
            System.out.println(p2 + " WINS!");
        }
        else if(p2board.fleetSize() == 0)
        {
            System.out.println(p1 + " WINS!");
        }
    }

    public static void createFleet(Ship s, Board b)
    {
        while(true) {
            Scanner kb = new Scanner(System.in);
            System.out.println("Choose the Y coordinate");
            int y = kb.nextInt() - 1;
            System.out.println("Choose the X coordinate");
            int x = kb.nextInt() - 1;
            System.out.println("choose the orientation");
            kb.nextLine();
            String orientation = kb.nextLine();
            if (b.verify(s, y, x, orientation)) {
                b.addShip(s, y, x, orientation);
                break;
            }
            System.out.println("Try Again!");
        }
    }

}
