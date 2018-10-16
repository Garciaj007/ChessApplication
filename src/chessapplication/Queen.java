
package chessapplication;

public class Queen extends Peices{

    public Queen(int _x, int _y, int _team) {
        Set(_x, _y, _team);
        this.peice = "Queen";
    }
    
    @Override
    protected boolean isAllowed(int x_, int y_) {
        if(x_ != getX() && y_ == getY() || y_ != getY() && x_ == getX() || Math.abs(x_ - getX()) == Math.abs(y_ - getY()))
            return true;
        else return false;
    }
    
}
