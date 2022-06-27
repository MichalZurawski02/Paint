package Shapes;

import Handlers.*;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
/**An abstract class which represent every shape in the app */
public abstract class shape extends Shape implements IShape
{
    /**Stores current activity of shape */
    protected boolean active;
    /**Stores a cordinate x = 0 in current baseline  */
    protected double startingX;
    /**Stores a cordinate y = 0 in current baseline  */
    protected double startingY;
    /**Stores the main pane where all shapes' actions will be performed */
    protected Pane board;
    /**Stores the center of the shapes' mass */
    protected Point2D massCentre;
    /**Stores current scale of shape */
    private double scale;
    /**
     * A method witch changes activity and stroke color of figure
     * @param value A parameter to which activity will change
     */
    final public void setActive(boolean value)
    {
        invertStrokeColor(getShape());
        active = value;
    }
    /**
     * An activity getter
     * @return activity of shape
     */
    final public boolean isActive()
    {
        return active;
    }
    /**
     * An abstract constructor for initializing scale and main pane in extended classes
     * @param board A pane to make actions on
     */
    public shape(Pane board)
    {
        this.board = board;
        scale = 1;
    }
    @Override
    final public void doMove(MouseEvent event)
    {
        double dx = event.getSceneX() - startingX;
        double dy = event.getSceneY() - startingY;
        getShape().setLayoutX(getShape().getLayoutX() + dx);
        getShape().setLayoutY(getShape().getLayoutY() + dy);
        startingX += dx;
        startingY += dy;
    }
    @Override
    final public void doScale(ScrollEvent event)
    {
        scale += event.getDeltaY() * 0.001;
        getShape().setScaleX(scale);
        getShape().setScaleY(scale);
    }
    @Override
    final public void doRotate(double angle)
    {
        Rotate rotate = new Rotate();
        rotate.setAngle(angle);
        rotate.setPivotX(massCentre.getX());
        rotate.setPivotY(massCentre.getY());
        getShape().getTransforms().add(rotate);
    }
    @Override
    final public void removeShape()
    {
        board.getChildren().remove(getShape());
    }
    @Override
    final public void startingCoordinates(double x, double y)
    {
        startingX = x;
        startingY = y;
    }
    /**
     * Initializes a shape with new handlers
     * @param shape A shape to intialize
     */
    final public void initShape(Shape shape)
    {
        shape.setFill(Color.GREEN);
        shape.setStroke(Color.GREEN);
        mouseHandler mh = new mouseHandler(this);
        shape.setOnMouseClicked(mh);
        shape.setOnMouseDragged(mh);
        shape.setOnMousePressed(mh);
        shape.setOnScroll(new scalingHandler(this));
        shape.setViewOrder(1.0);
        board.getChildren().add(shape);
    }
    /**
     * Sets a stroke color of a Shape to inverted
     * @param shape A shape to invert stroke
     */
    final public void invertStrokeColor(Shape shape)
    {
        Color color = (Color) getShape().getStroke();
        shape.setStroke(color.invert());
        shape.setStrokeWidth(2);
    }
}