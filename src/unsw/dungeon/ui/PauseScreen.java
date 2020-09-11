package unsw.dungeon.ui;
import unsw.dungeon.DungeonApplication;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import unsw.dungeon.controller.DungeonController;
import unsw.dungeon.controller.PauseController;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Modality;
import javafx.scene.text.Text; 
import javafx.scene.text.TextAlignment; 
import javafx.scene.text.TextFlow; 


public class PauseScreen {
    private Scene scene;
    DungeonController dungeonController;
    protected Stage stage;

    public PauseScreen(DungeonController dungeonController) {
        
        try {
            PauseController controller = new PauseController(this);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PauseScreen.fxml"));
            loader.setController(controller);
            this.dungeonController = dungeonController;
            Parent root = loader.load();
            this.scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            root.requestFocus();
        } catch (Exception e) {
            Platform.exit();
        }
        
    }

    public Stage getStage() {
        return DungeonApplication.getPrimaryStage();
    }

    public DungeonController getDungeonController() {
        return this.dungeonController;
    }

    public void start() {
        Stage popUpStage = new Stage(StageStyle.TRANSPARENT);
        popUpStage.initOwner(getStage());
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.setTitle("pause");
        popUpStage.setScene(scene);
        double centerXPosition = getStage().getX() + getStage().getWidth()/2;
        double centerYPosition = getStage().getY() + getStage().getWidth()/2;
        popUpStage.setOnShowing(e -> popUpStage.hide());
        popUpStage.setOnShown(e -> {
            popUpStage.setX(centerXPosition - popUpStage.getWidth()/2);
            popUpStage.setY(centerYPosition - popUpStage.getHeight()/2);
            popUpStage.show();
        });
        this.stage = popUpStage;
        popUpStage.show();
    }

    public void hidePauseScreen() {
        this.stage.hide();
    }


}