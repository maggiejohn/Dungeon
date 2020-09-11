package unsw.dungeon.ui;
import unsw.dungeon.DungeonApplication;
import unsw.dungeon.controller.StoreController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class StoreScreen {
    private Scene scene;
    public StoreScreen() {
        
        StoreController controller = new StoreController();
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Store.fxml"));
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