package unsw.dungeon.ui;
import unsw.dungeon.DungeonApplication;
import unsw.dungeon.controller.LevelSelectController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class LevelSelectScreen {
    private Scene scene;
    public LevelSelectScreen() {
        
        LevelSelectController controller = new LevelSelectController();
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelSelect.fxml"));
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            this.scene = scene;
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, e.toString(), ButtonType.OK);
        alert.showAndWait();
        
        if (alert.getResult() == ButtonType.OK) {
            Platform.exit();
        }
       } 
        
    }

    public void activate() {
        DungeonApplication.getPrimaryStage().setScene(scene);
    }
}