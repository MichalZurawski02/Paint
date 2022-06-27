package Menu;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.VBox;

import java.util.Objects;

/**
 * Class that customizes the dialog to inform about program usage
 */
public class guide extends Dialog<String> {

    public guide() {

        VBox vbox = new VBox(5);
        vbox.setPadding(new Insets(10,20,10,20));
        setTitle("Help");

        Label Drawing = new Label("Drawing:");
        Label DrawingInfo = new Label("Choose a shape then click unique spot: two times for circle and rectangle or three times for triangle");

        Label Moving = new Label("Moving:");
        Label MovingInfo = new Label("Click the figure and drag it to the desired position");

        Label Scaling = new Label("Scaling:");
        Label ScalingInfo = new Label("Click the figure and scroll with the mouse");

        Label Editing = new Label("Color changing, rotating and removing:");
        Label EditingInfo = new Label("Right-click the figure and choose an option");

        vbox.getChildren().addAll(Drawing,DrawingInfo,Moving,MovingInfo,Scaling,ScalingInfo,Editing,EditingInfo);
        getDialogPane().setContent(vbox);
        getDialogPane().getButtonTypes().add(new ButtonType("Close", ButtonData.OK_DONE));
        getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/myDialogs.css")).toExternalForm());
        getDialogPane().getStyleClass().add("myDialog");
    }
}