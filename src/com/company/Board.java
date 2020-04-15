package com.company;

public class Board {

    //This array stores the layout of the game board. The current board (playingBoard) is an instance of this class
    //Board with the attribute of gameBoard
    public static char[][] gameBoard = {
            {' ', 'X', ' ', '|', ' ', 'X', ' ', '|', ' ', 'O', ' '}, // place (columns 1, 5, 9)
            {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
            {' ', ' ', ' ', '|', ' ', 'O', ' ', '|', ' ', ' ', ' '}, // place (rows 0, 2, 4)
            {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
            {' ', ' ', ' ', '|', ' ', 'X', ' ', '|', ' ', 'X', ' '}  // place
    };

    //The gameBoard has different positions in the array (i.e. top row is [0][], middle center is [2][5])
    //These never change, and never should change, hence the "final" modifier
    static final int top = 0;
    static final int middle = 2;
    static final int bottom = 4;

    static final int left = 1;
    static final int center = 5;
    static final int right = 9;

    //This will add three indexes in the array together
    public static String addSpaces(int row1, int column1, int row2, int column2, int row3, int column3){
        char firstSpace = gameBoard [row1][column1];
        char secondSpace = gameBoard [row2][column2];
        char thirdSpace = gameBoard [row3][column3];
        String total = "" + firstSpace + secondSpace + thirdSpace;
        return total;
    }

    //This will check the playingBoard to see if there is a win. Three X's (XXX) or O's (OOO) is a win. If there is a
    //win, then isGamePlaying is set to false
    public static void checkWin() {
        for(int t=0; t<=8; t++){
            for(int i=0; i<=4; i=i+2){
                String rowTotal = addSpaces(i,1,i,5,i,9);
                if(rowTotal.equals("XXX")){
                    System.out.println("Player X has won! Congratulations!");
                    TicTacToe.isGamePlaying = false;
                    askPlayer();
                    break;
                }
                else if(rowTotal.equals("OOO")){
                    System.out.println("Player O had won! Congratulations!");
                    TicTacToe.isGamePlaying = false;
                    askPlayer();
                    break;
                }
            }
            for(int i=1; i<=9; i=i+4){
                String columnTotal = addSpaces(0,i,2,i,4,i);
                if(columnTotal.equals("XXX")){
                    System.out.println("Player X has won! Congratulations!");
                    TicTacToe.isGamePlaying = false;
                    askPlayer();
                    break;
                }
                else if(columnTotal.equals("OOO")){
                    System.out.println("Player O has won! Congratulations!");
                    TicTacToe.isGamePlaying = false;
                    askPlayer();
                    break;
                }
            }
            String diagUp = addSpaces(4,1,2,5,0,9);
            if(diagUp.equals("XXX")){
                System.out.println("Player X has won! Congratulations!");
                TicTacToe.isGamePlaying = false;
                askPlayer();
                break;
            }
            else if(diagUp.equals("OOO")){
                System.out.println("Player O has won! Congratulations!");
                TicTacToe.isGamePlaying = false;
                askPlayer();
                break;
            }
            String diagDown = addSpaces(0,1,2,5,4,9);
            if(diagDown.equals("XXX")) {
                System.out.println("Player X has won! Congratulations!");
                TicTacToe.isGamePlaying = false;
                askPlayer();
                break;
            }
            else if(diagDown.equals("OOO")){
                System.out.println("Player O has won! Congratulations!");
                TicTacToe.isGamePlaying = false;
                askPlayer();
                break;
            }
        }
        askPlayer();
    }


    //This will ask the player to give input. It can either ask for the next move or if the players would like to play
    //again. It does not look for the input or decide if the input was valid
    public static void askPlayer() {
        if(TicTacToe.isGamePlaying){
            //ask for next position
            System.out.println(TicTacToe.currentPlayer + ", it's your turn! Enter your next position:");
        }
        else{
            System.out.println("That was a good game. Do you want to play again?");
        }
        Player.parseInput(Player.giveInput());
    }
}
