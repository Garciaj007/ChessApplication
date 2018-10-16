package chessapplication;

//Final
public class Board {
    /* Member Variables */
    private final String[][] s_board = new String[8][8];
    
    public String[][] getBoard(){
        return s_board;
    }
    
    /* Constuctor */ 
    //Creates a blank board
    public Board(){
        //Where i = x; & j = y; to get space coords are [j][i] or [y][x]
        for(int i = 0; i < s_board.length; i++){
            for(int j = 0; j < s_board[i].length; j++){
                //Signal for empty space
                s_board[j][i] = "##";
            }
        }
    }

    /* Member Methods */
    //Inserts peices on the board || this should be called on the update loop
    public void place(Peice peice){
        //If peice was not taken then print on board;
        s_board[peice.getY()][peice.getX()] = peice.getPeice() + peice.getTeam();
    }
    
    //Resets board to ##
    public void clear(){
        for(int i = 0; i < s_board.length; i++){
            for(int j = 0; j < s_board[i].length; j++){
                //Signal for empty space
                s_board[j][i] = "##";
            }
        }
    }
    
    //Prints the board out to console 
    public void printBoard(){
        for(int i = 0; i < 8; i++){
            System.out.print("   --   ");
        }
        System.out.println();
        for(String[] s : s_board){
            for(String a : s){
                System.out.print(" | " + a + " | ");
            }
            System.out.println();
            for(String a : s){
                System.out.print("   --   ");
            }
            System.out.println();
        }
    }
}
