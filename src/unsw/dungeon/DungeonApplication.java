package unsw.dungeon;

import javafx.application.Application;
import javafx.stage.Stage;

import unsw.dungeon.ui.MainMenuScreen;

import java.io.IOException;

public class DungeonApplication extends Application {
    private static Stage primaryStage;
    private static boolean[] levelStatus;
    private static int gold;
    private static String[] dungeons;

    @Override
    public void start(Stage primaryStage) throws IOException {

        DungeonApplication.primaryStage = primaryStage;
        DungeonApplication.levelStatus = new boolean[6];
        DungeonApplication.levelStatus[0] = true;
        String[] dunBuff = {"level1.json", "level2.json", "level3.json", "arean.json", "advanced.json", "advanced.json"};
        DungeonApplication.dungeons = dunBuff;
        DungeonApplication.gold = 5;

        primaryStage.setTitle("C-Dungeons");    
        
        MainMenuScreen mainMenu = new MainMenuScreen();
        mainMenu.activate();
        primaryStage.show();
    } 
    
    /**
     * Allows access to the primary stage via dungeonapplication class.
     * 
     * @return static primaryStage variable
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Returns the value of gold player currently has.
     * @return value stored in static variable gold.
     */
    public static int getGold() {
        return gold;
    }
    
    /**
     * Changes the value of gold the player currently has.
     * @param value value to increse the gold ammount buy.
     */
    public static void giveGold(int value) {
        DungeonApplication.gold = DungeonApplication.gold + value;
    }

    /**
     * Checks if a level is unlocked yet.
     * 
     * @param index the index of the level we are checking.
     * @return the value stored in the levelStatus array at the sepcified index.
     */
    public static boolean getLevelStatus(int index) {
        return levelStatus[index];
    }

     /**
     * Unlocks level.
     * 
     * @param index the index of the level we are changing.
     * @param status the status that we are changing the level to.
     */
    public static void setLevelStatus(int index, boolean status) {
        DungeonApplication.levelStatus[index] = status;
    }

    /**
     * Retreives the filepath to the dungeon json file
     * 
     * @param index of dungeon file string to retreive.
     * @return dungeon file string stored at location of index.
     */
    public static String getDungeon(int index) {
        return dungeons[index];
    }

    public static void main(String[] args) {
        launch(args);
    }

}
