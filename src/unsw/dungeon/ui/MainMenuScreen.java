package unsw.dungeon.ui;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import unsw.dungeon.DungeonApplication;
import unsw.dungeon.controller.MainMenuController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;
import javafx.scene.control.ButtonType;

public class MainMenuScreen {
    private Scene scene;
    public MainMenuScreen() {
       try {
           MainMenuController controller = new MainMenuController();
   
           FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
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