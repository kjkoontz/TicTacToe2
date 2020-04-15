# TicTacToe2
This is TicTacToe written in Java on the command line.
This is my first ever programming project. 


### Installation
+ No install required, just run TicTacToe.java

### What I learned
+ I spent a lot of time learning how to program in Java.
  + Java syntax
  + Object-oriented-programming principles:
    + Classes
    + Instances
    + Static modifier
  + How to use 
    + operators on Strings, 2-dimensional arrays, integers, doubles, and chars
    + for, for each, while, and do while loops
    + if else statements, switch statements
    
### Methodology
+ Three classes: TicTacToe (the main class), Board, and Player
  + Board and Player only store attributes associated with that class
  + TicTacToe holds all of the methods
+ TicTacToe holds all the elements necessary to make the game
  + It has an instance of Board and two instances of Player to use in the game
  + There is a greeting at the very start to welcome players and give them instructions if they want them
  + assignPlayer will randomly choose who goes first
  + The major methods are parseInput and checkWin
    + parseInput takes the input given and determines what should be done with it
    + checkWin checks the game board to see if anyone has won
  + There is a game loop that runs as long as the game is playing
  
Right now, there is one small bug with input, but otherwise it works. 
Counting the time spent learning the principles, as well as actually coding, this project took about 18 - 20 hours total.
