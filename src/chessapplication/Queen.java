
package chessapplication;

public class Queen extends Peice{

    public Queen(int _x, int _y, Color _team) {
        super(_x, _y, _team);
        this.peice = "Q";
    }
    
    @Override
    protected boolean isAllowed(int x_, int y_) {
        if(x_ != getX() && y_ == getY() || y_ != getY() && x_ == getX() || Math.abs(x_ - getX()) == Math.abs(y_ - getY()))
            return true;
        else return false;
    }
    
}
