package unsw.dungeon.controller;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;
import unsw.dungeon.DungeonApplication;
import unsw.dungeon.entity.Player;
import unsw.dungeon.ui.MainMenuScreen;

public class StoreController extends MenuController {

    @FXML
    private Pane menuPane;
    
    @FXML
    private Button backButton;

    @FXML
    private Button buySwordButton;
    
    @FXML
    private Text goldTotal;

    @FXML
    private Text errorText;
    
    @FXML
    private void handleBack(MouseEvent event) {
        MainMenuScreen mainMenu = new MainMenuScreen();
        mainMenu.activate();
    }
    
    @FXML
    private void handleSwordPurchase(MouseEvent event) {
        if (Player.getStartingSword()) {
            displayError("Already Purchased!");
        } else if (DungeonApplication.getGold() < 2) {
            displayError("Not Enough Gold!");
        } else {
            DungeonApplication.giveGold(-2);
            Player.setStartingSword();
            goldTotal.setText(String.valueOf(DungeonApplication.getGold()));
        }
    }

    private void displayError(String text) {
        errorText.setText(text);
    }

    public StoreController() {
        
    }
    
    public void initialize() {
        menuPane.setBackground(background);

        goldTotal.setText(String.valueOf(DungeonApplication.getGold()));
    }
}