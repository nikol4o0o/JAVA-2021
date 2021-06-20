package Zad1a;

public class Rectangle {
    private double width;
    private double height;
    private String color;

    public Rectangle() {
        setWidth(1);
        setHeight(1);
        setColor("yellow");
    }

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
        setColor("yellow");
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        if(width > 0)
        {
            this.width = width;
        }
        else
        {
            width = 1;
        }
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        if(height > 0)
        {
            this.height = height;
        }
        else
        {
            height = 1;
        }
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        if(color != null)
        {
            this.color = color;
        }
        else
        {
            this.color = "yellow";
        }

    }

    public double getArea() {
        return width*height;
    }

    public double getPerimeter() {
        return 2*(width+height);
    }

}
