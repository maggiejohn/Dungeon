package unsw.dungeon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import unsw.dungeon.DungeonApplication;
import unsw.dungeon.ui.DungeonScreen;
import unsw.dungeon.ui.MainMenuScreen;


public class LevelSelectController extends MenuController {

    @FXML
    private Pane menuPane;
    
    @FXML
    private Button backButton;
    
    @FXML
    private Button storeButton;

    @FXML
    private Button playButton;

    @FXML
    private Button levelOne;
    
    @FXML
    private Button levelTwo;

    @FXML
    private Button levelThree;

    @FXML
    private Button levelFour;

    @FXML
    private Button levelFive;

    @FXML
    private Button levelSix;

    
    @FXML
    private void levelMouseEnter(MouseEvent event) {
        if (DungeonApplication.getLevelStatus(getDungeonNumber(event.getSource()))) {
            Button button = (Button) event.getSource();
            button.setStyle("-fx-background-color: #8aacb8; ");
        }
    }
    
    @FXML
    private void levelMouseLeave(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setStyle("-fx-background-color: #ADD8E6; ");
    }
    
    @FXML
    private void handleBack(MouseEvent event) {
        MainMenuScreen mainMenu = new MainMenuScreen();
        mainMenu.activate();
    }
    
    @FXML
    private void handleDungeonPress(MouseEvent event) {
        if (DungeonApplication.getLevelStatus(getDungeonNumber(event.getSource()))) {
            int dungeon = getDungeonNumber(event.getSource());
            DungeonScreen dungeonScreen = new DungeonScreen(dungeon);
        }
    }

    public LevelSelectController() {
        
    }
    
    public void initialize() {
        menuPane.setBackground(background);
        
        
        
    }
    

    private int getDungeonNumber(Object button) {
        if (button.equals(levelOne)) {
            return 0;
        } else if (button.equals(levelTwo)){
            return 1;
        } else if (button.equals(levelThree)){
            return 2;
        } else if (button.equals(levelFour)){
            return 3;
        } else if (button.equals(levelFive)){
            return 4;
        } else if (button.equals(levelSix)){
            return 5;
        }
        return -1;
    } 
}