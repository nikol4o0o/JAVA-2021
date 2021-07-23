package zad2;

public class Signleton
{
    private Object data;
    public static Signleton singleton = new Signleton("data");

    private Signleton(Object data)
    {
        this.data = data;
    }

    public static Signleton getInstance()
    {
        return singleton;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
