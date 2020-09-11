package unsw.dungeon.ui;

import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class PopUp {
    public static void popText(String text, String color, String size) {
        Stage stage = new Stage();

        Popup popup = new Popup();
        popup.setAutoHide(true);
        popup.setAutoFix(true);
        Label popupLabel = new Label("text");
        popupLabel.setStyle("-fx-background-color:black;"
                + " -fx-text-fill: " + color + ";"
                + " -fx-font-size: " + size + ";"
                + " -fx-padding: 10px;"
                + " -fx-background-radius: 6;");
        popup.getContent().add(popupLabel);

        popup.show(stage);
        stage.show();
    }
}