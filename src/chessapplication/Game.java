package chessapplication;

import java.util.*;

public class Game {

    /* Member Variables */
    //Board Object
    private final Board board;
    //Check if the game is still running & the game is still continuing
    private boolean isRunning, isGameContinuing;
    //Scanner
    private final Scanner scanner;
    //Player objects
    private Player p1, p2;
    //Peices
    private Peice[] peices = new Peice[32];

    /* Getters */
    public boolean getIsRunning() {
        return isRunning;
    }

    public Board getBoard() {
        return board;
    }

    /* Constructor */
    //Initalize Variables ETC...
    public Game() {
        scanner = new Scanner(System.in);
        board = new Board();
        isRunning = true;
        isGameContinuing = true;
    }

    /* Member Methods */
    public void create() {
        //Player 1
        System.out.println("Player 1 please choose name");
        String name = scanner.nextLine();
        System.out.println("Player 1 please choose color| WHITE / BLACK");
        String color = scanner.nextLine();

        //Checks Decision
        if (color.equals("WHITE") || color.equals("white")) {
            p1 = new Player(Player.Color.White, name);
        } else {
            p1 = new Player(Player.Color.Black, name);
        }

        //Player 2
        System.out.println();
        System.out.println("Player 2 please choose name");
        name = scanner.nextLine();

        //Checks P1 Decision
        if (p1.getColor() == Player.Color.White) {
            p2 = new Player(Player.Color.Black, name);
        } else {
            p2 = new Player(Player.Color.White, name);
        }
    }

    //Game loop Here
    public void run() {
        if (isGameContinuing) {
            board.clear();
            for (Peice i : peices) {
                //if not taken
                board.place(i);
            }
            board.printBoard();
            update();
        } else {
            destroy();
        }
    }

    //Update the board here
    private void update() {
        //checks if the player has made a proper selection
        boolean turn = true;

        //Player 1s Turn
        while (turn) {
            System.out.println("Player 1 please select a peice");
            String p = scanner.nextLine();
            System.out.println("Player 1 please select an empty space");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            //get peices
            //check if the space is available
            //check if the peice can move there via the rules
            //if all conditions above are satisfied 
            //move peice
            turn = false;

        }

        //Player 2s Turn
        turn = true;
        while (turn) {
            System.out.println("Player 2 please select a peice");
            String p = scanner.nextLine();
            System.out.println("Player 2 please select an empty space");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            //get peices
            //check if the space is available
            //check if the peice can move there via the rules
            //if all conditions above are satisfied 
            //move peice
            turn = false;

        }

        //Check Game pls
        checkGame();
    }

    //Destroys the Game
    private void destroy() {
        isRunning = false;
        scanner.close();
    }

    //Once game is over
    private void gameOver() {
        //Check who won
        if (p1.getWon()) {
            System.out.println("Player 1 has won!");
        } else {
            System.out.println("Player 2 has won!");
        }

        //Setting Game Continuing to false
        isGameContinuing = false;
    }

    //
    public void setup() {
        peices[0] = new Rook(0, 0, Peice.Color.White);
        peices[1] = new Knight(1, 0, Peice.Color.White);
        peices[2] = new Bishop(2, 0, Peice.Color.White);
        peices[3] = new King(3, 0, Peice.Color.White);
        peices[4] = new Queen(4, 0, Peice.Color.White);
        peices[5] = new Bishop(5, 0, Peice.Color.White);
        peices[6] = new Knight(6, 0, Peice.Color.White);
        peices[7] = new Rook(7, 0, Peice.Color.White);
        for (int i = 8; i < 16; i++) {
            peices[i] = new Pawn(i - 8, 1, Peice.Color.White);
        }
        for (int i = 16; i < 24; i++) {
            peices[i] = new Pawn(i - 16, 6, Peice.Color.Black);
        }
        peices[24] = new Rook(0, 7, Peice.Color.Black);
        peices[25] = new Knight(1, 7, Peice.Color.Black);
        peices[26] = new Bishop(2, 7, Peice.Color.Black);
        peices[27] = new King(3, 7, Peice.Color.Black);
        peices[28] = new Queen(4, 7, Peice.Color.Black);
        peices[29] = new Bishop(5, 7, Peice.Color.Black);
        peices[30] = new Knight(6, 7, Peice.Color.Black);
        peices[31] = new Rook(7, 7, Peice.Color.Black);
    }

    //Does multiple checks & Prints out who contains # peice of Peices
    private void checkGame() {
        //print out how many peices p1 & p2 has

        //print out how many peices are on board
        //check if the game is over
        //if true
        //GameOver();
    }
}
