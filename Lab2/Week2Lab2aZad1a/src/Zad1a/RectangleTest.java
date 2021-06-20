package Zad1a;

import java.util.Scanner;

public class RectangleTest
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the width: ");
        double width = input.nextDouble();;
        System.out.println("Enter the height: ");
        double height = input.nextDouble();

        Rectangle rectangle = new Rectangle(width,height);
        System.out.printf("The area is: %.2f", rectangle.getArea());
        System.out.printf("The perimeter is: %.2f", rectangle.getPerimeter());

    }
}
