package com.company;

import java.util.Scanner;


public class Player {
    //Each player is a specific type represented by a character (i.e. X or O)
    char playerType;
    boolean isCurrent = false;

    //Creates a Player with the parameter of type; i.e. using X or O. This will create Player-X and
    //Player-O to be used for deciding whose turn it is and what character to place
    public Player(char type) {
        this.playerType = type;
        isCurrent = playerType == 'X';
    }

    public Boolean getCurrent() {
        return this.isCurrent;
    }

    //The board asks for input, then the human gives input to player
    String giveInput(){
        Scanner playerInput = new Scanner(System.in);
        String input = playerInput.nextLine();
        return input;
    }

    //The player decides what kind of input was given. This decides if the input was for a move, continuing playing, for
    //quiting, or if it was invalid
    void parseInput(String input) {
        String[] inputArray = input.split(" ");
        if(inputArray.length == 2){
            String rowInput = inputArray[0];
            int row = Integer.parseInt(null);
            String columnInput = inputArray[1];
            int column = Integer.parseInt(null);
            switch(rowInput){ //this will check that row input is valid
                case "top":
                    row = Board.top;
                    break;
                case "middle":
                    row = Board.middle;
                    break;
                case "bottom":
                    row = Board.bottom;
                    break;
                default:
                    System.out.println("Invalid input; try again. Format is 'row column'");
                    parseInput(giveInput());
            }
            switch(columnInput){ //this will check that the column input is valid
                case "left":
                    column = Board.left;
                    break;
                case "center":
                    column = Board.center;
                    break;
                case "right":
                    column = Board.right;
                    break;
                default:
                    System.out.println("Invalid input; try again. Format is 'row column'");
                    parseInput(giveInput());
            }
            placeMark(row, column);
            changePlayer();
        }
        else if(inputArray.length == 1){
            String cmdInput = inputArray [0];
            switch(cmdInput){ //decides whether or not to leave the program
                case "Yes":
                case "yes":
                    TicTacToe.isGamePlaying = true;
                    TicTacToe.gameLoop();
                    break;
                case "No":
                case "no":
                case "Quit":
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input; try again");
                    parseInput(giveInput());
            }
        }
        else{
            System.out.println("Invalid input; try again");
            parseInput(giveInput());
        }
    }

    //The player places their mark on the board, changing the playingBoard. This checks that the move was valid and
    //makes that move.
    void placeMark(int row, int column){
        if(TicTacToe.playingBoard.gameBoard[row][column] == ' '){
            TicTacToe.playingBoard.gameBoard[row][column] = playerType;
        }
        else{
            System.out.println("Invalid input; try again. That space is taken.");
            parseInput(giveInput());
        }
    }

    //After the player makes their move, they need to take turns. This changes whose turn it is.
    void changePlayer(){
        if(TicTacToe.cPlayer){
            TicTacToe.currentPlayer = playerO;
            TicTacToe.cPlayer = false;
        }
        else{
            TicTacToe.currentPlayer = playerX;
            TicTacToe.cPlayer = true;
        }
    }


}

