package chessapplication;

public abstract class Peice {
    
    /* Member Variables */
    //Team Chosen
    public static enum Color{White, Black};
    
    //Contains the position of the peice
    private int x, y;
    private Color team;
    //The Placeholder for the peice
    protected String peice;

    /* Getters */ 
    //Gets X & Y position
    public final int getX() {
        return x;
    }
    public final int getY() {
        return y;
    }
    public final Color getTeam(){
        return team;
    }
    //Returns Placeholder
    public final String getPeice(){
        return peice;
    }
    
    /* Constructor */
    public Peice(int x_, int y_, Color team_){
        set(x_, y_, team_);
    }
    
    
    /* Abstract Methods */
    //Check if the piece can move to that place using rules
    protected abstract boolean isAllowed(int x_, int y_);
    protected abstract boolean canMoveTo(Board b, int x_,int y_);
    
    /* Member Methods */
    //Move to Position if rule applies
    protected void moveTo(String[][] b, int x_, int y_){
        if(isAllowed(x_, y_)){
            x = x_;
            y = y_;
        } else {
            System.out.println("Cannot perform Action, Choose Legal Action pls.");
        }
    }
    
    //This method forcably sets a peices position
    protected final void set(int x_, int y_, Color team_){
        x = x_;
        y = y_;
        team = team_;
    }
    
}
