
package chessapplication;

public class Pawn extends Peice{
    private final int direction;

    public Pawn(int _x, int _y, Color _team) {
        super(_x, _y, _team);
        if(getTeam() == Peice.Color.White){
            direction = 1;
        }
        else{
        direction = -1;
        }       
        this.peice = "p";
    }
    
    @Override
    protected boolean isAllowed(int x_, int y_) {
        if(y_ == getY() + direction && x_ == getX() || x_ == getX() + 1 || x_ == getX() - 1){
            return true;
        }else return false;
    }
    
}
