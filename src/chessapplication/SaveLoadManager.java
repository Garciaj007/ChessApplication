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

    //Loads the pieces
    public SaveObject loadGame(){
            //Retrieve Peice[][] 
            try(ObjectInputStream in = new ObjectInputStream(
            new BufferedInputStream(
            new FileInputStream(filepath)))){ 
                //try to get input into Peice[]
                
                SaveObject saveObject = (SaveObject)in.readObject();
                return saveObject;
            } catch (IOException | ClassNotFoundException e){
                System.err.println(e.getMessage());
            }
            return null;
    }
    
    //Saves the current Array of Peices as an object
    public void saveGame(SaveObject saveObject){
            if(filepath.exists()){
               filepath.delete();
            }
        
        try(ObjectOutputStream out = new ObjectOutputStream(
                                     new BufferedOutputStream(
                                     new FileOutputStream(filepath)))){
            out.writeObject(saveObject);
            
        }catch (IOException e){
            System.err.println(e.getMessage());
        } 
    }
 
}
