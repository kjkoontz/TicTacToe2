package com.company;

import java.util.Scanner;

public class TicTacToe {
    //TicTacToe has an instance of Board, the playingBoard
    static Board playingBoard = new Board();

    //TicTacToe has two instances of Player, playerX and playerO
    static Player playerX = new Player('X');
    static Player playerO = new Player('O');

    static Player currentPlayer = playerX;
    //true when currentPlayer is playerX
    static boolean cPlayer = true;

    //TicTacToe has a game state, either playing or not
    static boolean isGamePlaying = true;

    //The game has a welcome that lets the humans know how to play and gives the rules
    public void greeting(){
        System.out.println("Hello, Players, and welcome to TicTacToe!");
        System.out.println("Do you want to skip the instructions? (Yes or No)");
        Scanner greetInput = new Scanner(System.in);
        String readInst = greetInput.nextLine();
        if(readInst.equals("No")){
            System.out.println("The Rules: The objective of the game is to get three of your characters in a row. " +
                    "You will be assigned your character type at random. On your turn, choose where to place your " +
                    "character by typing 'row column' when prompted. The updated game board will be printed, and it " +
                    "will be the next player's turn. After someone wins, you will be asked if you want to play again." +
                    " If you do, the game with restart with a blank game board, and the first player will again be " +
                    "randomly assigned.");
            System.out.println("To decide who goes first: choose which one of you will be 'Player 1' and 'Player 2'; it " +
                    "doesn't really matter who is who. After you're done, continue, and Player 1 will be assigned " +
                    "either playerX or playerO (Player 2 is, of course, the other player).");
        }
        else if(readInst.equals("Yes")){
            System.out.println("Okay");
        }
        else{
            System.out.println("Invalid input; try again");
            greeting();
        }
        System.out.println("Are you ready to continue? (Yes or No)");
        Scanner contInput = new Scanner(System.in);
        String cont = contInput.nextLine();
        if(cont.equals("Yes")){
            System.out.println("Excellent!");
        }
        else{
            greeting();
        }
    }

    //This will randomly assign who goes first.
    public void assignPlayer(){
        double randPlayer = Math.random();
        if(randPlayer <= 0.5){
            System.out.println("Player 1, you are playerX. Player 2, you are playerO.");
        }
        else{
            System.out.println("Player 1, you are playerO. Player 2, you are playerX.");
        }
    }

    static void gameLoop(){
        Board.askPlayer();
        Player.parseInput(Player.giveInput());
        do{
            Board.checkWin();
        }
        while(isGamePlaying);
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe;
    }
}
