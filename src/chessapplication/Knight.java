
package chessapplication;


public class Knight extends Peice{

    public Knight(int _x, int _y, Color _team) {
        super(_x, _y, _team);
        this.peice = "H";
    }
    
    @Override
    // returns true when the change in spaces is equal to 3, but not when it moves in a straight line
    protected boolean isAllowed(int x_, int y_) {
        if(Math.abs(x_ - getX()) + Math.abs(y_ - getY()) == 3 && Math.abs(x_ - getX()) != 3 && Math.abs(y_ - getY()) != 3)
            return true;
        else return false;
    }
    
}
