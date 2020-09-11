package unsw.dungeon.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import unsw.dungeon.ui.PauseScreen;
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 
import javafx.scene.text.TextAlignment; 
import javafx.scene.text.TextFlow; 

public class PauseController {

    @FXML
    private Button resumeButton;

    @FXML
    private TextFlow goalsText;

    private PauseScreen screen;

    public PauseController(PauseScreen pScreen) {
        this.screen = pScreen;
    }

    @FXML
    void handleResumeButton(ActionEvent event) {
        screen.hidePauseScreen();
        screen.getDungeonController().togglePause();
    }

    @FXML
    public void initialize() {
        Text text1 = new Text("Goals\n"); 
        text1.setFont(new Font(35));
        text1.setTextAlignment(TextAlignment.CENTER);
        String goal = screen.getDungeonController().getDungeon().getGoal().toString();
        String[] goalStrings = goal.split("\\s");
        Text goalType = new Text("Complete the goal below: \n");
        goalType.setFont(new Font(20));
        goalType.setTextAlignment(TextAlignment.CENTER);
        Text goalEnemies = new Text();
        goalEnemies.setFont(new Font(20));
        goalEnemies.setTextAlignment(TextAlignment.CENTER);
        Text goalTreasure = new Text();
        goalTreasure.setFont(new Font(20));
        goalTreasure.setTextAlignment(TextAlignment.CENTER);
        Text goalBoulders = new Text();
        goalBoulders.setFont(new Font(20));
        goalBoulders.setTextAlignment(TextAlignment.CENTER);
        Text goalExit = new Text();
        goalExit.setFont(new Font(20));
        goalExit.setTextAlignment(TextAlignment.CENTER);
        for (String temp : goalStrings) {
            if (temp.equals("and")) {
                goalType.setText("Complete ALL of the below: \n");
            } else if (temp.equals("or")) {
                goalType.setText("Complete ONE of the below: \n");
            } else if (temp.equals("boulders")) {
                goalBoulders.setText("Push a boulder onto all pressure plates\n");
            } else if (temp.equals("treasure")) {
                goalTreasure.setText("Collect all the treasure\n");
            } else if (temp.equals("enemies")) {
                goalEnemies.setText("Kill all the enemies\n");
            } else if (temp.equals("exit")) {
                goalExit.setText("Reach the exit\n");
            }
        }
        goalsText.getChildren().addAll(text1, goalType, goalEnemies, goalTreasure, goalBoulders, goalExit);
        
    }
}
