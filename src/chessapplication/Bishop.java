
package chessapplication;


public class Bishop extends Peice{

    public Bishop(int _x, int _y, Color _team) {
        super(_x, _y, _team);
        this.peice = "B";
    }
    
    @Override
    protected boolean isAllowed(int x_, int y_) {
        if(Math.abs(x_ - getX()) == Math.abs(y_ - getY())){
            return true;
        } else {
            return false;
        }
    }
    
}
