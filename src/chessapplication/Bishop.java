
package chessapplication;


public class Bishop extends Peice{

    public Bishop(int _x, int _y, Color _team, String _path) {
        super(_x, _y, _team, _path);
        this.peice = "B";
    }
    
    @Override
    // returns true when the change in x and y is equal, meaning the piece moves diagonally
    protected boolean isAllowed(int x_, int y_) {
        if(Math.abs(x_ - getX()) == Math.abs(y_ - getY())){
            return true;
        } else {
            return false;
        }
    }
    
}
