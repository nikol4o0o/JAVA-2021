package zad4a;

public enum TrafficLight
{
    RED(5000), YELLOW(2000), GREEN(4000);
    private int duration;

    TrafficLight(int duration)
    {
        this.duration = duration;
    }

    public int getDuration()
    {
        return duration;
    }
    public void waitDuration()
    {
        long start = System.currentTimeMillis();
        long currentTime;

        do
        {
        currentTime = System.currentTimeMillis();
        }
        while(currentTime - start < duration);

    }
}

