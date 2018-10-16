
package chessapplication;


public class Knight extends Peices{

    public Knight(int _x, int _y, int _team) {
        Set(_x, _y, _team);
        this.peice = "Knight";
    }
    
    @Override
    protected boolean isAllowed(int x_, int y_) {
        if(Math.abs(x_ - getX()) + Math.abs(y_ - getY()) == 3 && Math.abs(x_ - getX()) != 3 && Math.abs(y_ - getY()) != 3)
            return true;
        else return false;
    }
    
}
