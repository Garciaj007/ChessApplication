package chessapplication;

public abstract class Peice implements java.io.Serializable {

    /* Member Variables */
    //Team Chosen
    public static enum Color {
        White, Black
    };

    //Contains the position of the peice
    private int x, y;
    //Contains the teams color
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

    public final Color getTeam() {
        return team;
    }

    //Returns Placeholder
    public final String getPeice() {
        String temp;
        if(team == Color.White)
            temp = "W" + peice;
        else 
            temp = "B" + peice;
        return temp;
    }

    /* Constructor */
    public Peice(int x_, int y_, Color team_) {
        set(x_, y_, team_);
    }

    /* Abstract Methods */
    //Check if the piece can move to that place using rules
    protected abstract boolean isAllowed(int x_, int y_);

    //Checks if space is available
    protected boolean canMoveTo(int x_, int y_){
        if(Game.getGameBoard().getBoard()[y_][x_] == null && x_ < 8 && y_ < 8)
            return true;
        else if (Game.getGameBoard().getBoard()[y_][x_] != null && Game.getGameBoard().getBoard()[y_][x_].team != team){
            Game.getGameBoard().getBoard()[y_][x_] = null;
            return true;
        }
        else return false;
    }

    /* Member Methods */
    //Move to Position if rule applies
    protected void moveTo(int x_, int y_) {
        if (isAllowed(x_, y_) && canMoveTo(x_, y_)) {
            x = x_;
            y = y_;
        } else {
            System.out.println("Cannot perform Action, Choose Legal Action pls.");
        }
    }

    //This method forcably sets a peices position
    protected final void set(int x_, int y_, Color team_) {
        x = x_;
        y = y_;
        team = team_;
    }
}
