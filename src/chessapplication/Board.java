package chessapplication;

public class Board {
    /* Member Variables */
    private final String[][] s_board = new String[8][8];
    
    public String[][] getBoard(){
        return s_board;
    }
    
    /* Constuctor */ 
    //Creates a blank board
    public Board(){
        for(int i = 0; i < s_board.length; i++){
            for(int j = 0; j < s_board[i].length; j++){
                s_board[i][j] = " |" + i + "| ";
            }
        }
    }

    /* Member Methods */
    //Inserts peices on the board || this should be called on the update loop
    public void Insert(Peices peice){
        s_board[peice.getX()][peice.getY()] = peice.getPeice();
    }
    
    //Prints the board out to console 
    public void PrintBoard(){
        for(String[] s : s_board){
            for(String a : s){
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
