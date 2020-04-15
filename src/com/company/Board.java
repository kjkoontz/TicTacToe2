package com.company;

public class Board {
    //This array stores the layout of the game board. The current board (playingBoard) is an instance of this class
    public char[][] gameBoard = {
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '}, // place (columns 1, 5, 9)
            {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '}, // place (rows 0, 2, 4)
            {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '}  // place
    };

    //The gameBoard has different positions in the array (i.e. top row is [0][], middle center is [2][5])
    //These never change, and never should change, hence the "final" modifier
    final int top = 0;
    final int middle = 2;
    final int bottom = 4;

    final int left = 1;
    final int center = 5;
    final int right = 9;

    public Board() {
    }
}
