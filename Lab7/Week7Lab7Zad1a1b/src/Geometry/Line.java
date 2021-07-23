package Geometry;


import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Line
{
    private Point sPoint;
    private Point ePoint;

    public Line(Point sPoint, Point ePoint)
    {
        setSPoint(sPoint);
        setEPoint(ePoint);
    }

    public Line()
    {
        this(new Point(), new Point(new double[]{1.0, 1.0}));
    }

    public Line(Line l)
    {
        this(l.sPoint, l.ePoint);
    }

    public Point getSPoint()
    {
        return new Point(sPoint);
    }

    public void setSPoint(Point sPoint)
    {
        this.sPoint = sPoint != null ? new Point(sPoint) : new Point();
    }

    public Point getEPoint()
    {
        return new Point(ePoint);
    }

    public void setEPoint(Point ePoint)
    {
        this.ePoint = ePoint != null ? new Point(ePoint) : new Point();
    }

    public void draw(Group pane)
    {
        javafx.scene.shape.Line line = new javafx.scene.shape.Line(sPoint.getCoordinates()[0],
                sPoint.getCoordinates()[1], ePoint.getCoordinates()[0], ePoint.getCoordinates()[1]);
        line.setStroke(Color.RED);
        pane.getChildren().add(line);
    }

    @Override
    public String toString()
    {
        return String.format("sPoint: %s, ePoint: %s", sPoint, ePoint);
    }
}


