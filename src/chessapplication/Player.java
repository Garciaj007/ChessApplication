package chessapplication;

public class Player {
    /* Member Variables */
    //Enum for player Color
    public static enum Color{White, Black};
    
    //# of Peices the player has on the board, *NOTE* Can be change later to the actual peices
    private int piecesOnBoard;
    //# of Peices the player has taken, *NOTE* Can be change later to the actual peices
    private int piecesTaken;
    //Name of the player, optional
    private String name;
    //Color of the player
    private final Color color;
    //check if the player is checkmate, and if the player has won
    private boolean checkmate, won;
    
    /* Getters & Setters */
    //Gets name
    public String getName(){
        return name;
    }
    //Gets Color
    public Color getColor(){
        return color;
    }
    //Gets Checkmate
    public boolean getCheck(){
        return checkmate;
    }
    //Sets Checkmate
    public void setCheck(boolean value){
        checkmate = value;
    }
    //Gets Won
    public boolean getWon(){
        return won;
    }
    //Sets Won
    public void setWon(boolean value){
        won = value;
    }
    
    /* Constructor */
    public Player(Color color_, String name_){
       name = name_;
       color = color_;
       piecesOnBoard = 16;
       piecesTaken = 0;
    }
    
    /* Member Methods */
    //When a player loses a peice, *NOTE* can be replaced later by actual peices
    public void lostPeice(){
        piecesOnBoard--;
    }
    
    //When a player has taken a peice, *NOTE* can be replace later by actual peices
    public void takenPeice(){
        piecesTaken++;
    }
}
