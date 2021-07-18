import java.text.NumberFormat;
import java.util.Random;

public class RandomGenerator
{
    public static void main(String[] args)
    {
        drawRandomNumber(10000);//calling the function
        drawRandomNumber(60000);//calling the function
    }

    private static void drawRandomNumber(double times)
    {
        int counter = 0;//initialize the counter

        double frequencyOf1 = 0;
        double frequencyOf2 = 0;
        double frequencyOf3 = 0;
        Random randomNumbers = new Random();

        for(int i =1; i <= times; i++)//loops how many times
        {
            double rand = randomNumbers.nextDouble();
            if (rand < .2) //20% chance
            {
                counter = 1;
            }
            else if (rand < .2 + .3)//30% chance
            {
                counter = 2;
            }
            else //50% chance
                {
                counter = 3;
            }

            //switch case
            switch (counter) {
                case 1 -> frequencyOf1++;//increasing the times when occured
                case 2 -> frequencyOf2++;//increasing the times when occured
                case 3 -> frequencyOf3++;//increasing the times when occured
            }
        }
        frequencyOf1 = frequencyOf1/times;//getting the times occured compared to the all randomly generated numbers
        frequencyOf2 = frequencyOf2/times;//getting the times occured compared to the all randomly generated numbers
        frequencyOf3 = frequencyOf3/times;//getting the times occured compared to the all randomly generated numbers


        NumberFormat defaultFormat = NumberFormat.getPercentInstance();//setting the NumberFormat Class for our exercise
        defaultFormat.setMinimumFractionDigits(2);//setting .2 digits after the number
        System.out.println("Percent of 1: " + defaultFormat.format(frequencyOf1));//print the percentage of 1
        System.out.println("Percent of 2: " + defaultFormat.format(frequencyOf2));//print the percentage of 2
        System.out.println("Percent of 3: " + defaultFormat.format(frequencyOf3));//print the percentage of 3
    }
}
