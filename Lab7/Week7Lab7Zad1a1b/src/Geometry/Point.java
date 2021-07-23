package Geometry;

public class Point
{
    private double[] coordinates;

    public Point(double[] coordinates)
    {
        setCoordinates(coordinates);
    }

    public Point()
    {
        setCoordinates(null);
    }

    public Point(Point p)
    {
        this(p.coordinates);
    }
    public double[] getCoordinates()
    {
        double[] copyToReturn = new double[coordinates.length];
        for (int i = 0; i < coordinates.length; i++)
        {
            copyToReturn[i] = coordinates[i];
        }
        return copyToReturn;
    }

    public void setCoordinates(double[] coordinates)
    {
        if (coordinates != null && coordinates.length == 2)
        {
            this.coordinates = new double[coordinates.length];
            for (int i = 0; i < coordinates.length; i++)
            {
                this.coordinates[i] = coordinates[i];
            }
        } else
        {
            this.coordinates = new double[]{0.0, 0.0};
        }
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", coordinates[0], coordinates[1]);
    }
}
