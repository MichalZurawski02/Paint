package Menu;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.VBox;

/**
 * A class that customizes the dialog to provide informations on author and purpose of app
 */
public class info extends Dialog<String> {

    public info() {

        VBox vbox = new VBox(5);
        vbox.setPadding(new Insets(10,20,10,20));
        setTitle("Help");

        Label Drawing = new Label("Author: Michal Zurawski");
        Label DrawingInfo = new Label("This app can be used for drawing, resizing, rotating and colouring shapes");

        vbox.getChildren().addAll(Drawing,DrawingInfo);
        getDialogPane().setContent(vbox);
        getDialogPane().getButtonTypes().add(new ButtonType("Close", ButtonData.OK_DONE));
        getDialogPane().getStylesheets().add(getClass().getResource("myDialogs.css").toExternalForm());
        getDialogPane().getStyleClass().add("myDialog");
    }
}