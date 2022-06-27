package Shapes;

import Handlers.drawingHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
/**A class which specifies the rectangle shape */
public final class rectangle extends shape
{
    /**A variable which stores the rectangle as Shape */
    private Rectangle rect;
    /**A variable which stores the first vertex of rectangle */
    private Point2D savedPoint;
    /**
     * A constructor which sets drawing Handler to the Pane
     * @param board Pane on which rectangle will be drawn and edited
     */
    public rectangle(Pane board)
    {
        super(board);
        board.setOnMouseClicked(new drawingHandler(this, board));
    }
    @Override
    public void doDraw(Pane board, MouseEvent event)
    {
        Point2D clickedPoint = new Point2D(event.getSceneX(), event.getSceneY());
        if(savedPoint == null)
            savedPoint = clickedPoint;
        else
        {
            double width = Math.abs(clickedPoint.getX() - savedPoint.getX());
            double height = Math.abs(clickedPoint.getY() - savedPoint.getY());
            double x = Math.min(clickedPoint.getX(), savedPoint.getX());
            double y = Math.min(clickedPoint.getY(), savedPoint.getY());

            rect = new Rectangle(x, y, width, height);
            massCentre = new Point2D(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);
            initShape(rect);
            board.setOnMouseClicked(null);
        }
    }
    @Override
    public Shape getShape()
    {
        return rect;
    }
}