
package chessapplication;

public class Pawn extends Peices{
    private int direction;

    public Pawn(int _x, int _y, int _team) {
        Set(_x, _y, _team);
        if(getTeam() == 0){
            direction = 1;
        }
        else{
            direction = -1;
        }       
        this.peice = "Pawn";
    }
    
    @Override
    protected boolean isAllowed(int x_, int y_) {
        if(y_ == getY() + direction && x_ == getX() || x_ == getX() + 1 || x_ == getX() - 1){
            return true;
        }else return false;
    }
    
}
