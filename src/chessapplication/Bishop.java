
package chessapplication;


public class Bishop extends Peices{

    public Bishop(int _x, int _y, int _team) {
        Set(_x, _y, _team);
        this.peice = "Bishop";
    }
    
    @Override
    protected boolean isAllowed(int x_, int y_) {
        if(Math.abs(x_ - getX()) == Math.abs(y_ - getY()))
            return true;
        else return false;
    }
    
}
