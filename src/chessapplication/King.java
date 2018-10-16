
package chessapplication;

public class King extends Peices{

    public King(int _x, int _y, int _team) {
        Set(_x, _y, _team);
        this.peice = "King";
    }
    
    @Override
    protected boolean isAllowed(int x_, int y_) {
        if(Math.abs(x_ - getX()) == 1 || Math.abs(y_ - getY()) == 1 || Math.abs(x_ - getX()) == 1 && Math.abs(y_ - getY()) == 1)
            return true;
        else return false;
    }
    
}
