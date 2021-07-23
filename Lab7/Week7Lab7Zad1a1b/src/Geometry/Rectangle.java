package Geometry;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Rectangle {
    private Point uPoint;
    private double width;
    private double height;

    public Rectangle(Point uPoint, double width, double height) {
        setUPoint(uPoint);
        setWidth(width);
        setHeight(height);
    }

    public Rectangle()
    {
        this(new Point(), 1.0, 1.0);
    }

    public Rectangle(Rectangle r)
    {
        this(r.uPoint, r.width, r.height);
    }

    public Point getUPoint()
    {
        return new Point(uPoint);
    }

    public void setUPoint(Point uPoint)
    {
        if(uPoint != null)
        {
            this.uPoint = uPoint;
        }
        else
        {
            this.uPoint = new Point(uPoint);
        }
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        if(width > 0)
        {
            this.width = width;
        }
        else
        {
            this.width = 1.0;
        }
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        if(height > 0)
        {
            this.height = height;
        }
        else
        {
            this.height = 1.0;
        }
    }

    public void draw(Group pane)
    {
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(
                uPoint.getCoordinates()[0], uPoint.getCoordinates()[1], width, height);
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        pane.getChildren().add(rectangle);
    }

    @Override
    public String toString()
    {
        return String.format("uPoint: %s, width: %.2f, height: %.2f", uPoint, width, height);
    }
}


