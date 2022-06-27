package Shapes;

import Handlers.drawingHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
/**A class which specifies the triangle shape */
public final class triangle extends shape
{
    /**A variable which stores the first vertex of triangle */
    private Point2D firstPoint;
    /**A variable which stores the second vertex of triangle */
    private Point2D secondPoint;
    /**A variable which stores the whole triangle as polygon*/
    private Polygon triangle;
    /**
     * A constructor which sets drawing Handler to the Pane
     * @param board Pane on which triangle will be drawn and edited
     */
    public triangle(Pane board)
    {
        super(board);
        board.setOnMouseClicked(new drawingHandler(this, board));
    }
    @Override
    public void doDraw(Pane board, MouseEvent event)
    {
        Point2D clickedPoint = new Point2D(event.getSceneX(), event.getSceneY());
        if(firstPoint == null)
            firstPoint = clickedPoint;
        else if(secondPoint == null)
            secondPoint = clickedPoint;
        else
        {
            triangle = createTriangle(firstPoint, secondPoint, clickedPoint);
            initShape(triangle);
            board.setOnMouseClicked(null);
        }
    }
    /**
     * A method to create a tringle
     * @param p1 First vertex of triangle
     * @param p2 Second vertex of triangle
     * @param p3 Third vertex of triangle
     * @return Polygon which is triangle
     */
    Polygon createTriangle(Point2D p1, Point2D p2, Point2D p3){
        Point2D centre = new Point2D((p1.getX() + p2.getX() + p3.getX())/3, (p1.getY() + p2.getY() + p3.getY())/3);
        Point2D p1Corrected = p1.subtract(centre);
        Point2D p2Corrected = p2.subtract(centre);
        Point2D p3Corrected = p3.subtract(centre);
        Polygon polygon = new Polygon(
                p1Corrected.getX(), p1Corrected.getY(),
                p2Corrected.getX(), p2Corrected.getY(),
                p3Corrected.getX(), p3Corrected.getY()
        );
        polygon.setLayoutX(centre.getX());
        polygon.setLayoutY(centre.getY());
        massCentre = new Point2D(0, 0);
        return polygon;
    }
    @Override
    public Shape getShape()
    {
        return triangle;
    }
}