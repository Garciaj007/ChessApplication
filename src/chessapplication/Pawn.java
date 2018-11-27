
package chessapplication;

public class Pawn extends Peice{
    private final int direction;

    public Pawn(int _x, int _y, Color _team, String _path) {
        super(_x, _y, _team, _path);
        if(getTeam() == Peice.Color.White){
            direction = 1;
        }
        else{
        direction = -1;
        }       
        this.peice = "p";
    }
    
    @Override
    // returns true when the change in y is equal to one, ie it moves one space up or down, or if
    // it moves diagonally one space
    protected boolean isAllowed(int x_, int y_) {
        if(y_ == getY() + direction && Game.getGameBoard().getBoard()[y_][x_] == null && x_ == getX() || x_ == getX() + 1 || x_ == getX() - 1){
            return true;
        }else return false;
    }
    
}
