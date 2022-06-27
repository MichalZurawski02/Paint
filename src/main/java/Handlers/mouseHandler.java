package Handlers;

import Menu.contextMenu;
import Shapes.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
/**A class which implements MouseEvent Handler to the shape */
final public class mouseHandler implements EventHandler<MouseEvent>
{
    /**A shape on which MouseEvent Handler is applied*/
    private final shape s;
    /**A ContextMenu which provides features to shape */
    private final contextMenu cm;
    /**
     * A constructor which initialize shape and adds ContextMenu
     * @param s A shape on which MouseEvent Handler will be applied
     */
    public mouseHandler(shape s)
    {
        this.s = s;
        this.cm = new contextMenu(s);

    }
    /**
     * A method to activate and deactivate, moving and showing context menu
     * @param event A MouseEvent that provides a mouse input
     */
    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED && event.getButton().equals(MouseButton.PRIMARY))
        {
            s.setActive(!s.isActive());
            s.startingCoordinates(event.getSceneX(), event.getSceneY());
            cm.hide();
        }
        if (event.getEventType() == MouseEvent.MOUSE_PRESSED && s.isActive() && event.getButton().equals(MouseButton.PRIMARY))
        {
            s.startingCoordinates(event.getSceneX(), event.getSceneY());
        }
        if (event.getEventType() == MouseEvent.MOUSE_DRAGGED && s.isActive() && event.getButton().equals(MouseButton.PRIMARY))
        {
            s.doMove(event);
            cm.hide();
        }
        if(event.getEventType() == MouseEvent.MOUSE_CLICKED && event.getButton().equals(MouseButton.SECONDARY) && s.isActive())
        {
            cm.show(s.getShape() ,event.getScreenX(), event.getScreenY());
        }
    }
}