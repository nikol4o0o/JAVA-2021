package zad4a;

public class TrafficLightTest
{
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        long currentTime;
        do
        {
            for (TrafficLight trafficLight: TrafficLight.values())
            {
                System.out.println(trafficLight);
                trafficLight.waitDuration();
            }
            currentTime = System.currentTimeMillis();
        }
        while(currentTime - start < 90000);
    }
}
