
package chessapplication;

public class King extends Peice{

    public King(int _x, int _y, Color _team) {
        super(_x, _y, _team);
        this.peice = "K";
    }
    
    @Override
    protected boolean isAllowed(int x_, int y_) {
        if(Math.abs(x_ - getX()) == 1 || Math.abs(y_ - getY()) == 1 || Math.abs(x_ - getX()) == 1 && Math.abs(y_ - getY()) == 1)
            return true;
        else return false;
    }
}
