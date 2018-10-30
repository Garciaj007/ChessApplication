package chessapplication;

//Final
public class Board {

    /* Member Variables */
    private Peice[][] board = new Peice[8][8];

    public Peice[][] getBoard() {
        return board;
    }
    
    public void setBoard(Peice[][] _board){
        board = _board;
    }

    /* Constuctor */
    //Creates a blank board
    public Board() {
        //Where i = x; & j = y; to get space coords are [j][i] or [y][x]
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //Signal for empty space
                board[j][i] = null;
            }
        }
    }

    /* Member Methods */
    //Inserts peices on the board || this should be called on the update loop
    public void place(Peice peice) {
        //If peice was not taken then print on board;
        board[peice.getY()][peice.getX()] = peice;
    }

    //Resets board to ##
    public void clear() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //Signal for empty space
                board[j][i] = null;
            }
        }
    }
    
    public void removePiece(int _x, int _y){
        board[_x][_y] = null;
    }
    
    //Prints the board out to console 
    public void printBoard() {
        int c = 1; 
        System.out.println("  X  1       2       3       4       5       6       7       8");
        System.out.print("Y");
        for (int i = 0; i < 8; i++) {
            System.out.print("   --   ");
        }
        System.out.println();
        for (Peice[] p : board) {
            System.out.print(c);
            c++;
            for (Peice a : p) {
                if (a == null) {
                    System.out.print(" | ## | ");
                } else if(!a.isIsDead()) {
                    System.out.print(" | " + a.getPeice() + " | ");
                }
            }
            System.out.println();
            System.out.print(" ");
            for (Peice a : p) {
                System.out.print("   --   ");
            }
            System.out.println();
        }
    }
}
