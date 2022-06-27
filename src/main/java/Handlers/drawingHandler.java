package Handlers;

import Shapes.shape;
import Shapes.triangle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
/**
 * A class that implements a mouse event handler for shape drawing
 */
public class drawingHandler implements EventHandler<MouseEvent>
{
    /**
     * The shape which will be drawn
     */
    private final shape s;
    /**
     * The Pane where the drawing will be set on
     */
    private final Pane currentPane;
    /**
     * A constructor assigning a shape to a class and a pane to the board
     * @param s the shape for which the scaling will be performed
     */
    public drawingHandler(triangle s, Pane p)
    {
        this.s = s;
        this.currentPane = p;
    }
    /**
     * method calling the appropriate method of drawing a shape onto the board
     * @param event mouse event
     */
    @Override
    public void handle(MouseEvent event)
    {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED && event.getButton().equals(MouseButton.PRIMARY))
            s.doDraw(currentPane, event);
    }
}