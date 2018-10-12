package chessapplication;

/**
 * @author Juriel Garcia, Kevin [LastName], Violet[LastName]
 * @version 1.0.0
 */
public class ChessApplication {

    public static void main(String[] args) {
        Game g = new Game();
        
        while(g.getIsRunning()){
            g.Run();
        }
    }
    
}
