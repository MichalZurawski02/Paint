package Shapes;

import Handlers.drawingHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
/**A class which specifies the circle shape */
public final class circle extends shape
{
    /**A variable which stores drawn circle */
    private Circle circ;
    /**
     * A constructor which sets drawing Handler to the Pane
     * @param board Pane on which circle will be drawn and edited
     */
    public circle(Pane board)
    {
        super(board);
        board.setOnMouseClicked(new drawingHandler(this, board));
    }
    @Override
    public void doDraw(Pane board, MouseEvent event)
    {
        Point2D firstPoint = new Point2D(event.getSceneX(), event.getSceneY());
        if(massCentre == null)
            massCentre = firstPoint;
        else
        {
            circ = new Circle(massCentre.getX(), massCentre.getY(), massCentre.distance(firstPoint));
            initShape(circ);
            board.setOnMouseClicked(null);
        }
    }
    @Override
    public Shape getShape()
    {
        return circ;
    }
}