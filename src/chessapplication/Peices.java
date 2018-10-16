package chessapplication;

public abstract class Peices {
    
    /* Member Variables */
    //Contains the position of the peice
    private int x, y;
    private int team;
    //The Placeholder for the peice
    protected String peice;

    /* Getters */ 
    //Gets X & Y position
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getTeam(){
        return team;
    }
    //Returns Placeholder
    public String getPeice(){
        return peice;
    }
    
    /* Abstract Methods */
    //Check if the piece can move to that place using rules
    protected abstract boolean isAllowed(int x_, int y_);
    
    /* Member Methods */
    //Check If the board is available
    protected boolean canMoveTo(int x_, int y_){
        //Check if blank space is available
        
        return true;
    }
    
    //Move to Position if rule applies
    protected void moveTo(Board b, int x_, int y_){
        if(isAllowed(x_, y_)){
            x = x_;
            y = y_;
        } else {
            System.out.println("Cannot perform Action, Choose Legal Action pls.");
        }
    }
    
    //This method forcably sets a peices position
    protected void Set(int x_, int y_, int team_){
        x = x_;
        y = y_;
        team = team_;
    }
    
}
