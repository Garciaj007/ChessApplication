package chessapplication;

/**
 * @author Juriel Garcia, Kevin Tang, Violet Leong
 * @version 1.0.0
 */
public class ChessApplication {

    public static void main(String[] args) {
        Game g = new Game();
        g.startMenu();    
        while(g.getIsRunning()){
            g.run();
        }
        g.exitMenu();
    }
    
}
