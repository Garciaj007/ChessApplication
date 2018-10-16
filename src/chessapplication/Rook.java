
package chessapplication;

public class Rook extends Peices{

    public Rook(int _x, int _y, int _team) {
        Set(_x, _y, _team);
        this.peice = "Rook";
    }
    
    @Override
    protected boolean isAllowed(int x_, int y_) {
        if(x_ != getX() && y_ == getY() || y_ != getY() && x_ == getX())
            return true;
        else return false;
    }
    
}
