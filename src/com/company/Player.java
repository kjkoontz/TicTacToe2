package com.company;

public class Player {
    //Each player is a specific type represented by a character (i.e. X or O)
    char playerType;

    //Creates a Player with the parameter of type; i.e. using X or O. This will create Player-X and
    //Player-O to be used for deciding whose turn it is and what character to place
    public Player(char type) {
        this.playerType = type;
    }
}

