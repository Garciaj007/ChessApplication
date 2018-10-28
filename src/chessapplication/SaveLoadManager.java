package chessapplication;

import java.io.*;

public class SaveLoadManager {
    
    //File path where the file will be saved and loaded from
    private final File filepath;
    
    //Constructor: creates new File Object
    public SaveLoadManager(){
        filepath = new File("ChessSaveData.ser");
    }
    
    //Checks if the game can be loaded
    public boolean canLoadGame(){
        //If the file can be exists 
        if(filepath.exists())
            return true;
        return false;
    }

    //Loads the board array
    public Peice[][] loadGame(){
            //Retrieve Peice[][] 
            try(ObjectInputStream in = new ObjectInputStream(
            new BufferedInputStream(
            new FileInputStream(filepath)))){
                //DEBUG ONLY, CHANGE PLS
                //try to get input into Peice[][] 
                
                String str = (String)in.readObject();
                System.out.println(str);
            } catch (IOException | ClassNotFoundException e){
                System.err.println(e.getMessage());
            }
        return null;
    }
    
    //Saves the current Board Array of Peices as an object
    public void saveGame(Peice[][] board){
        try(ObjectOutputStream out = new ObjectOutputStream(
                                     new BufferedOutputStream(
                                     new FileOutputStream(filepath)))){
            
            out.writeObject(board);
        }catch (IOException e){
            System.err.println(e.getMessage());
        } 
    }
 
}
