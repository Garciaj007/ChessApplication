
package chessapplication;

public class Rook extends Peice{

    public Rook(int _x, int _y, Color _team) {
        super(_x, _y, _team);
        this.peice = "R";
    }
    
    @Override
    protected boolean isAllowed(int x_, int y_) {
        if(x_ != getX() && y_ == getY() || y_ != getY() && x_ == getX())
            return true;
        else return false;
    }
    
}
