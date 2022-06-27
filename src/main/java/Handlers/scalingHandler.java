package Handlers;

import Shapes.shape;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
/**
 * A class that implements a scroll event handler for a shape
 */
public class scalingHandler implements EventHandler<ScrollEvent>
{
    /**
     * The shape for which the scaling will be performed
     */
    private shape s;
    /**
     * A constructor assigning a figure to a class
     * @param s the shape for which the scaling will be performed
     */
    public scalingHandler(shape s)
    {
        this.s = s;
    }
    /**
     * method calling the appropriate method of scaling the figure if it is active
     * @param event scroll event
     */
    @Override
    public void handle(ScrollEvent event) {
        if (event.getEventType() == ScrollEvent.SCROLL && s.isActive())
        {
            s.doScale(event);
        }
    }
}