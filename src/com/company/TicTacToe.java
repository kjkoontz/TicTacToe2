package com.company;

import java.util.Scanner;

public class TicTacToe {
    public Scanner input = new Scanner(System.in);

    //TicTacToe has an instance of Board, the playingBoard, and two instances of Player, playerX and playerO
    public Board playingBoard = new Board();
    public Player playerX = new Player('X');
    public Player playerO = new Player('O');

    //The game has one player making moves, currentPlayer. By default, that's playerX as it traditionally goes first
    Player currentPlayer = playerX;
    static boolean cPlayer = true; //this helps choose when and how to change currentPlayer

    //TicTacToe has a game state, either playing or not
    static boolean isGamePlaying = true;

    //The game has a welcome that lets the humans know how to play and gives the rules
    public void greeting(){
        System.out.println("Hello, Players, and welcome to TicTacToe!");
        System.out.println("Do you want to skip the instructions? (Yes or No)");
        String readInst = input.nextLine();
        if(readInst.equals("No")){
            System.out.println("The Rules: The objective of the game is to get three of your characters in a row. " +
                    "You will be assigned your character type at random. On your turn, choose where to place your " +
                    "character by typing 'row column' when prompted. The updated game board will be printed, and it " +
                    "will be the next player's turn. After someone wins, you will be asked if you want to play again." +
                    " If you do, the game with restart with a blank game board, and the first player will again be " +
                    "randomly assigned.");
            System.out.println("To decide who goes first: choose which one of you will be 'Player 1' and 'Player 2';" +
                    " it doesn't really matter who is who. After you're done, continue, and Player 1 will be assigned" +
                    " either playerX or playerO (Player 2 is, of course, the other player).");
        } else if(readInst.equals("Yes")){
            System.out.println("Okay");
        } else{
            System.out.println("Invalid input; try again");
            greeting();
        }
        System.out.println("Are you ready to continue? (Yes or No)");
        String cont = input.nextLine();
        if(cont.equals("Yes")){
            System.out.println("Excellent!");
        } else{
            greeting();
        }
    }

    //This will randomly assign who goes first.
    public void assignPlayer(){
        double randPlayer = Math.random();
        if(randPlayer <= 0.5){
            System.out.println("Player 1, you are playerX. Player 2, you are playerO.");
        } else{
            System.out.println("Player 1, you are playerO. Player 2, you are playerX.");
        }
    }

    //This is the structure of the game. It loops as long as isGamePlaying = true, and can be called to start new round
    public void gameLoop(){
//        Board playingBoard = new Board();
        printPlayingBoard();
        askPlayer();
        parseInput(giveInput());
        do{
            checkWin();
            printPlayingBoard();
        } while(isGamePlaying);
    }

    //This prints the playingBoard
    public void printPlayingBoard() {
        for(char[] row : playingBoard.gameBoard) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    //This looks for input from the human to give to parseInput
    String giveInput(){
        String playerInput = input.nextLine();
        return playerInput;
    }

    //This decides if the input was for a move, continuing playing, for quiting, or if it was invalid
    void parseInput(String input) {
        String[] inputArray = input.split(" ");
        if(inputArray.length == 2){
            String rowInput = inputArray[0];
            int row = 1; // = Integer.parseInt(null); //this assigns the variable without giving it a usable value
            String columnInput = inputArray[1];
            int column = 1; // = Integer.parseInt(null);
            switch(rowInput){ //this will check that row input is valid
                case "top": case "Top":
                    row = playingBoard.top;
                    break;
                case "middle": case "Middle":
                    row = playingBoard.middle;
                    break;
                case "bottom": case "Bottom":
                    row = playingBoard.bottom;
                    break;
                default:
                    System.out.println("Invalid input; try again. Format is 'row column'. Possible rows are top/middle/bottom, possible columns are left, center, right.");
                    parseInput(giveInput());
            }
            switch(columnInput){ //this will check that the column input is valid
                case "left": case"Left":
                    column = playingBoard.left;
                    break;
                case "center": case "Center":
                    column = playingBoard.center;
                    break;
                case "right": case "Right":
                    column = playingBoard.right;
                    break;
                default:
                    System.out.println("Invalid input; try again. Format is 'row column'. Possible rows are top/middle/bottom, possible columns are left, center, right.");
                    parseInput(giveInput());
            }
            placeMark(row, column);
            changePlayer();
        } else if(inputArray.length == 1){
            String cmdInput = inputArray [0];
            switch(cmdInput){ //decides whether or not to leave the program
                case "Yes": case "yes":
                    TicTacToe.isGamePlaying = true;
                    gameLoop();
                    break;
                case "No": case "no": case "Quit":
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input; try again");
                    parseInput(giveInput());
            }
        } else{
            System.out.println("Invalid input; try again");
            parseInput(giveInput());
        }
    }

    //This checks that the move indicated by parseInput is valid and makes that move
    void placeMark(int row, int column){
        if(playingBoard.gameBoard[row][column] == ' '){
//            System.out.println("AAAAAAAAAA" + playingBoard.gameBoard[row][column] + "AAAA");
            playingBoard.gameBoard[row][column] = currentPlayer.playerType;
        } else{
            System.out.println("Invalid input; try again. That space is taken.");
            parseInput(giveInput());
        }
    }

    //This changes whose turn it is
    void changePlayer(){
        if(cPlayer){
            currentPlayer = playerO;
            cPlayer = false;
        } else{
            currentPlayer = playerX;
            cPlayer = true;
        }
    }

    //This will add three indexes in the array together
    public String addSpaces(int row1, int column1, int row2, int column2, int row3, int column3){
        char firstSpace = playingBoard.gameBoard [row1][column1];
        char secondSpace = playingBoard.gameBoard [row2][column2];
        char thirdSpace = playingBoard.gameBoard [row3][column3];
        String total = "" + firstSpace + secondSpace + thirdSpace;
        return total;
    }

    //This will check the playingBoard to see if there is a win. If there is a win, then isGamePlaying is set to false
    public void checkWin() {
        for(int t=0; t<=8; t++){
            for(int i=0; i<=4; i=i+2){
                String rowTotal = addSpaces(i,1,i,5,i,9);
                if(rowTotal.equals("XXX")){
                    printXWin();
                    isGamePlaying = false;
                    askPlayer();
                    break;
                } else if(rowTotal.equals("OOO")){
                    printOWin();
                    isGamePlaying = false;
                    askPlayer();
                    break;
                }
            }
            for(int i=1; i<=9; i=i+4){
                String columnTotal = addSpaces(0,i,2,i,4,i);
                if(columnTotal.equals("XXX")){
                    printXWin();
                    isGamePlaying = false;
                    askPlayer();
                    break;
                } else if(columnTotal.equals("OOO")){
                    printOWin();
                    isGamePlaying = false;
                    askPlayer();
                    break;
                }
            }
            String diagUp = addSpaces(4,1,2,5,0,9);
            if(diagUp.equals("XXX")){
                printXWin();
                isGamePlaying = false;
                askPlayer();
                break;
            } else if(diagUp.equals("OOO")){
                printOWin();
                isGamePlaying = false;
                askPlayer();
                break;
            }
            String diagDown = addSpaces(0,1,2,5,4,9);
            if(diagDown.equals("XXX")) {
                printXWin();
                isGamePlaying = false;
                askPlayer();
                break;
            } else if(diagDown.equals("OOO")){
                printOWin();
                isGamePlaying = false;
                askPlayer();
                break;
            }
        }
        askPlayer();
    }

    public void printXWin(){
        System.out.println("Player X has won! Congratulations!");
    }
    public void printOWin(){
        System.out.println("Player O has won! Congratulations!");
    }

    //This will ask the player to give input
    public void askPlayer() {
        if(isGamePlaying){
            if(cPlayer){
                System.out.println("PlayerX, it's your turn! Enter your next position:");
            } else {
                System.out.println("PlayerO, it's your turn! Enter your next position:");
            }
        } else{
            System.out.println("That was a good game. Do you want to play again?");
        }
        parseInput(giveInput());
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.greeting();
        game.assignPlayer();
        game.gameLoop();
    }
}
