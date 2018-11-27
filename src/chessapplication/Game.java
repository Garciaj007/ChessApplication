package chessapplication;

import java.util.*;

public class Game {

    /* Member Variables */
    
    //Window Object
    private Window window;
    //Board Object
    private static Board board;
    //Check if the game is still running & the game is still continuing
    private boolean isRunning, isGameContinuing;
    //Scanner
    private final Scanner scanner;
    //Player objects
    private static Player p1, p2, currentPlayer;
    //Used for initialization
    private static Peice[] peices;
    //Used for saving and loading the game
    private static SaveLoadManager manager;
    
    public boolean turn = true;

    /* Getters */
    
    public boolean getIsRunning() {
        return isRunning;
    }

    public static Board getGameBoard() {
        return board;
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    /* Constructor */
    
    //Initalize Variables ETC...
    public Game() {
        scanner = new Scanner(System.in);
        board = new Board();
        window = new Window(this);
        isRunning = true;
        isGameContinuing = true;
        peices = new Peice[32];
    }
    
    /* Primary Member Methods*/
    
    //This is only run once
    public void Init(){
        //setup();
        window.setVisible(true); //Display JFrame
    }
    
    //Game loop Here
    public void Run() {
        if (isGameContinuing) {
            updateAndDisplayBoard();
            window.UpdateAndDisplayGUI(board);
            update();
        } else {
            destroy();
        }
    }
    
    //Destroys the Game
    private void destroy() {
        isRunning = false;
        scanner.close();
    }

    /*Secondary Member Methods */
    public void create() {
        //Player 1
        String name = window.DisplayPopupInput("Player 1 please choose name");
        String color = window.DisplayPopupInput("Player 1 please choose color| WHITE / BLACK");

        //Checks Decision
        if (color.equals("WHITE") || color.equals("white") || color.equals("White")) {
            p1 = new Player(Player.Color.White, name);
        } else {
            p1 = new Player(Player.Color.Black, name);
        }

        //Player 2
        name = window.DisplayPopupInput("Player 2 please choose name");

        //Checks P1 Decision
        if (p1.getColor() == Player.Color.White) {
            p2 = new Player(Player.Color.Black, name);
        } else {
            p2 = new Player(Player.Color.White, name);
        }

        //Print out players and thier associated color
        window.setMsg("Player 1: " + p1.getName() + " : " + p1.getColor().name() + " | Player 2: " + p2.getName() + " : " + p2.getColor().name());
    }

    private void updateAndDisplayBoard() {
        //Clears the board
        board.clear();
        for (Peice p : peices) {
            if (p != null && !p.isIsDead()) {
                board.place(p);
            }
        }
        //Print the board
        board.printBoard();
    }

    //Update the board here
    private void update() {
        updateAndDisplayBoard();

        //Player 1s Turn
        while (turn) {
            Peice peiceSelected = null;
            window.setMsg("Player 1 please select a peice.");
            currentPlayer = p1;
            if(scanner.hasNextInt()){
                int x = scanner.nextInt() - 1;
                System.out.print("PosY: ");
                int y = scanner.nextInt() - 1;
                if (x < 8 && y < 8) {
                    peiceSelected = board.getBoard()[y][x];
                }
                if (peiceSelected != null && peiceSelected.getTeam().name().equals(p1.getColor().name()) && !peiceSelected.isIsDead()) {
                    System.out.println("Player 1 please select an destination");
                    System.out.print("PosX: ");
                    x = scanner.nextInt() - 1;
                    System.out.print("PosY: ");
                    y = scanner.nextInt() - 1;
                    //check if the space is available
                    if (peiceSelected.canMoveTo(x, y)) {
                        peiceSelected.moveTo(x, y);
                        turn = false;
                    } else {
                        System.out.println("\nInvalid Selection/Move made, please select again\n");
                    }
                } else {
                    window.setMsg("Invalid Selection made, please select again");
                }
            }
        }
        if(isGameContinuing)
            updateAndDisplayBoard();
        checkGame();
        //Player 2s Turn
        turn = true;
        while (turn && isGameContinuing) {
            Peice peiceSelected = null;
            System.out.println("Player 2 please select a peice using X & Y values or enter pause.");
            System.out.print("PosX: ");
            if(scanner.hasNextInt()){
                int x = scanner.nextInt() - 1;
                System.out.print("PosY: ");
                int y = scanner.nextInt() - 1;
                if (x < 8 && y < 8) {
                    peiceSelected = board.getBoard()[y][x];
                }
                if (peiceSelected != null && peiceSelected.getTeam().name().equals(p2.getColor().name()) && !peiceSelected.isIsDead()) {
                    System.out.println("Player 2 please select an destination space");
                    System.out.print("PosX: ");
                    x = scanner.nextInt() - 1;
                    System.out.print("PosY: ");
                    y = scanner.nextInt() - 1;
                    //check if the space is available
                    if (peiceSelected.canMoveTo(x, y)) {
                        peiceSelected.moveTo(x, y);
                        turn = false;
                    } else {
                        System.out.println("\nInvalid Selection/Move made, please select again\n");
                    }
                } else {
                    System.out.println("\nInvalid Selection made, please select again\n");
                }
            }
        }
        if(isGameContinuing)
            updateAndDisplayBoard();
        //Checks Game
        checkGame();
    }

    
    //Once game is over
    private void gameOver() {
        //Check who won
        if (p1.getWon()) {
            window.setMsg("Player " + p1.getName() + " has won!");
        } else if (p2.getWon()){
            window.setMsg("Player " + p2.getName() + " has won!");
        }
        int decision = window.DisplayPopupDecision("Play Again, or quit?");
        //Setting Game Continuing to false
        if(decision == 0){
        isRunning = false;
        isGameContinuing = false;
        } else {
            setup();
        }
    }
    
    public void LoadGame(){
        SaveObject s;
        s = manager.loadGame();
        loadPieces(s.peices);
        loadPlayers(s.players);
        
        System.out.println("Game Loaded Successfully...");
    }
    
    public void SaveGame(){
        //Load existing game from stored file
        SaveObject s = new SaveObject();
        s.peices = peices;
        Player[] p = new Player[2];
        p[0] = p1;
        p[1] = p2;
        s.players = p;
        manager.saveGame(s);
    }

    //This creates peices for the board manually
    public void setup() {
        peices[0] = new Rook(0, 0, Peice.Color.White, "/ChessImages/WhiteRook.png");
        peices[1] = new Knight(1, 0, Peice.Color.White, "/ChessImages/WhiteKnight.png");
        peices[2] = new Bishop(2, 0, Peice.Color.White, "/ChessImages/WhiteBishop.png");
        peices[3] = new Queen(3, 0, Peice.Color.White, "/ChessImages/WhiteQueen.png");
        peices[4] = new King(4, 0, Peice.Color.White, "/ChessImages/WhiteKing.png");
        peices[5] = new Bishop(5, 0, Peice.Color.White, "/ChessImages/WhiteBishop.png");
        peices[6] = new Knight(6, 0, Peice.Color.White, "/ChessImages/WhiteKnight.png");
        peices[7] = new Rook(7, 0, Peice.Color.White, "/ChessImages/WhiteRook.png") ;
        for (int i = 8; i < 16; i++) {
            peices[i] = new Pawn(i - 8, 1, Peice.Color.White, "/ChessImages/WhitePawn.png");
        }
        for (int i = 16; i < 24; i++) {
            peices[i] = new Pawn(i - 16, 6, Peice.Color.Black, "/ChessImages/BlackPawn.png");
        }
        peices[24] = new Rook(0, 7, Peice.Color.Black, "/ChessImages/BlackRook.png");
        peices[25] = new Knight(1, 7, Peice.Color.Black, "/ChessImages/BlackKnight.png");
        peices[26] = new Bishop(2, 7, Peice.Color.Black, "/ChessImages/BlackBishop.png");
        peices[27] = new King(3, 7, Peice.Color.Black, "/ChessImages/BlackKing.png");
        peices[28] = new Queen(4, 7, Peice.Color.Black, "/ChessImages/BlackQueen.png");
        peices[29] = new Bishop(5, 7, Peice.Color.Black, "/ChessImages/BlackBishop.png");
        peices[30] = new Knight(6, 7, Peice.Color.Black, "/ChessImages/BlackKnight.png");
        peices[31] = new Rook(7, 7, Peice.Color.Black, "/ChessImages/BlackRook.png");
    }
    
    //This loads the pieces from a file
    public static void loadPieces(Peice[] _pieces){
        peices = _pieces;
    }
    
    public static void loadPlayers(Player[] players){
        p1 = players[0];
        p2 = players[1];
    }
    
    //Start menu which will need to run once the game starts
    public void startMenu() {
        window.setVisible(true);
        //creates a SaveLoadManager object
        manager = new SaveLoadManager();
        boolean temp = true;
        //Print output options asking to load the saved game or start a new one
        window.setMsg("Welcome to Chess! Click an option. Load or New");
        
        while (temp) {
            //read player input option
            String input = window.DisplayPopupInput("Load or New");
            if (input.equalsIgnoreCase("Load")) {
                //Load existing game from stored file
                //Check if manager can load game
                if (manager.canLoadGame()) {
                    //set the board to the data in the manager
                    LoadGame();
                    temp = false;
                } else {
                    window.DisplayPopup("Cannot load Game, no such file exists");
                }
            } else if (input.equalsIgnoreCase("New")) {
                //Create new brand new game
                setup();
                create();
                temp = false;
            } else {
                window.setMsg("Please enter a valid option.");
            }
        }
    }

    //exitMenu triggered once when players enters exit
    public void exitMenu() {
        System.out.println("Enter an option.");
        System.out.println("Save or Quit");

        boolean temp = true;

        while (temp) {
            //read player input option
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Save")) {
                //Save existing game from stored file
                SaveGame();
                temp = false;
            } else if (input.equalsIgnoreCase("Quit")) {
                //Close the application
                temp = false;
            } else {
                System.out.println("Please enter a valid option.");
            }
        }
    }

    //Does multiple checks & Prints out who contains # peice of Peices
    private void checkGame() {
        for(Peice a : peices){
            if(a != null && a.isIsDead()){
                a = null;
            }
        }
        if(peices[4].isIsDead()){
            p2.setWon(true);
            gameOver();
        }else if(peices[27].isIsDead()){
            p1.setWon(true);
            gameOver();
        }
    }
}
