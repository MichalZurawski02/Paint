package Menu;

import Shapes.shape;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

/**
 * A class customizing context menu and calling methods to edit the shape
 */
public final class contextMenu extends ContextMenu
{
    /**
     * A constructor creating color picker, slider and item menu
     * and assigning them event handlers, which will evoke appropriate methods
     * @param s A shape that will be edited
     */
    public contextMenu(shape s)
    {
        ColorPicker ColorPicker = new ColorPicker();
        ColorPicker.setValue((Color)s.getShape().getFill());
        Slider slider = new Slider(0, 360, 0);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(360);
        slider.setOnMouseReleased(event ->
        {
            this.hide();
            s.setActive(false);
        });
        slider.valueProperty().addListener(
                (observable, oldValue, newValue) -> s.doRotate((double) newValue - (double) oldValue));
        MenuItem menuItem1 = new MenuItem(null, ColorPicker);
        MenuItem menuItem2 = new MenuItem(null, slider);
        MenuItem menuItem3 = new MenuItem(null, new Label("Remove"));
        menuItem1.setOnAction(event ->
        {
            s.getShape().setFill(ColorPicker.getValue());
            s.getShape().setStroke(ColorPicker.getValue());
            s.setActive(false);
            s.invertStrokeColor(s.getShape());
        });
        menuItem3.setOnAction(event -> s.removeShape());
        this.getItems().addAll(menuItem1, menuItem2, menuItem3);
    }

}