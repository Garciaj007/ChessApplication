
package chessapplication;

public class Rook extends Peice{

    public Rook(int _x, int _y, Color _team, String _path) {
        super(_x, _y, _team, _path);
        this.peice = "R";
    }
    
    @Override
    // returns true when the x and y move the piece left/right or up/down
    protected boolean isAllowed(int x_, int y_) {
        if(x_ != getX() && y_ == getY() || y_ != getY() && x_ == getX())
            return true;
        else return false;
    }
    
}
