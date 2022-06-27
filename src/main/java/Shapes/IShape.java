package Shapes;

import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
/**An interface that force implementing app features */
public interface IShape
{
    /**
     * Method that creates and draws figure on pane based on clicks
     * @param board Pane to draw on
     * @param event Event which provides clicked points
     */
    public void doDraw(Pane board, MouseEvent event);
    /**
     * Method sets initial (0,0) point in the relative coordinate system
     * @param x The X coordinate of relative coordinate system in absolute coordinate system
     * @param y The Y coordinate of relative coordinate system in absolute coordinate system
     */
    public void startingCoordinates(double x, double y);
    /**
     * Method that moves shape to event-specified point
     * @param event provides a point to move onto
     */
    public void doMove(MouseEvent event);
    /**
     * Method that scale shape on the basis of ScrollEvent
     * @param event A ScrollEvent to make scaling possible
     */
    public void doScale(ScrollEvent event);
    /**
     * Method which returns type of Shape e.g. Circle, Polygon
     * @return The specific Shape used in class
     */
    public Shape getShape();
    /**Removes shape from a pane it was added to */
    public void removeShape();
    /**
     * Methods that rotate figure around the center of mass
     * @param angle The angle of rotate
     */
    public void doRotate(double angle);
}