package zad1;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Fahrenheit to Celsius\n2. Celsius to Fahrenheint\n");
        int choice = input.nextInt();
        if(choice == 1)
        {
            convertFahrenheitToCelsius(input);
        }
        else if(choice == 2)
        {
            convertCelsiusToFahrenHeit(input);
        }

    }

    private static void convertCelsiusToFahrenHeit(Scanner input)
    {
        System.out.println("Enter Celsius: ");
        double celsiusInput  = input.nextDouble();
        double fahrenheitOutput;
        fahrenheitOutput =  9.0 / 5.0 * celsiusInput + 32;
        System.out.printf("%.2f",fahrenheitOutput);
    }

    private static void convertFahrenheitToCelsius(Scanner input)
    {
        System.out.println("Enter FahrenHeit: ");
        double fahrenheitInput = input.nextDouble();
        double celsiusOutput;
        celsiusOutput = 5.0 / 9.0 * ( fahrenheitInput - 32 );
        System.out.printf("%.2f" ,celsiusOutput);
    }
}
