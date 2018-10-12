package chessapplication;

public class Game {
    /* Member Variables */
    //Board Object
    private final Board board;
    //Check if the game is still running
    private boolean isRunning;
    
    /* Getters */
    public boolean getIsRunning(){
        return isRunning;
    }
    
    /* Constructor */
    //Initalize Variables ETC...
    public Game(){
        board = new Board();
        isRunning = true;
    }
    
    /* Member Methods */
    //Game loop Here
    public void Run(){
        board.PrintBoard();
        Update();
        isRunning = false;
    }
    
    private void Update(){
        //Update the board here
        System.out.println("Update Called...");
    }
}
