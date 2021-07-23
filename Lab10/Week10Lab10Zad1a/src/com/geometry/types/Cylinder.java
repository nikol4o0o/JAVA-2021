package com.geometry.types;

public class Cylinder extends Circle {
    private int height;

    public Cylinder(Circle circle, int height) {
        super(circle);
        setHeight(height);
    }

    public Cylinder() {
        this(new Circle(), 1);
    }

    public Cylinder(Cylinder cylinder) {
        this(cylinder.getCircle(), cylinder.height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height > 0 ? height : 1;
    }

    public Circle getCircle() {
        return new Circle(getCenter(), getRadius());
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return 1;
        }

        if (!(o instanceof Cylinder)) {
            return 1;
        }

        Cylinder cylinder = (Cylinder) o;

        int result = super.compareTo(o);

        if (result != 0) {
            return result;
        }

        return height - cylinder.height;
    }

    @Override
    public String toString() {
        return String.format("Circle: %s, Height: %d", super.toString(), height);
    }
}
