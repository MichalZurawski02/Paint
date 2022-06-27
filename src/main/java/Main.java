import Shapes.*;
import Menu.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{
    /**
     * A method creating the GUI, which includes a menu bar with options for showing dialogs and drawing figures,
     * and a panel on which the figures will be displayed
     * @param mainStage The Main Stage where everything is assigned
     */
    @Override
    public void start(Stage mainStage)
    {
        Pane root = new Pane();

        Menu shapeDrawing = new Menu("Draw Shape");
        MenuItem rectangleDrawingMenu = new MenuItem("Rectangle");
        MenuItem triangleDrawingMenu = new MenuItem("Triangle");
        MenuItem circleDrawingMenu = new MenuItem("Circle");
        shapeDrawing.getItems().addAll(rectangleDrawingMenu, triangleDrawingMenu, circleDrawingMenu);

        Menu help = new Menu("Help");
        MenuItem guide = new MenuItem("Guide");
        MenuItem info = new MenuItem("Info");
        help.getItems().addAll(guide, info);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(shapeDrawing, help);

        Dialog<String> dialog = new info();
        Dialog<String> dialog1 = new guide();

        info.setOnAction(infoHandler -> dialog.showAndWait());
        guide.setOnAction(guideHandler -> dialog1.showAndWait());
        rectangleDrawingMenu.setOnAction(event -> {shape s = new rectangle(root);});
        circleDrawingMenu.setOnAction(event -> {shape s = new circle(root);});
        triangleDrawingMenu.setOnAction(event -> {shape s = new triangle(root);});

        Scene mainScene = new Scene(root, 1280, 720);
        root.getChildren().add(menuBar);
        root.getStylesheets().add(getClass().getResource("/apperance.css").toExternalForm());
        menuBar.prefWidthProperty().bind(mainStage.widthProperty());
        menuBar.setViewOrder(0.0);
        mainStage.setScene(mainScene);
        mainStage.show();
    }
}