package zad2;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a five digit number ");
        String userInput = input.nextLine();
        int number = Integer.parseInt(userInput);
        if(isFiveDigitNum(userInput))
        {
            int originalNumber = number;
            int fifthDigit = number % 10;
            number /= 10;
            int fourthDigit = number % 10;
            number /= 10;
            int thirdDigit = number % 10;
            number /= 10;
            int secondDigit = number % 10;
            number /= 10;
            int firstDigit = number % 10;
            number /= 10;

            String stringOutput;
            if(firstDigit == fifthDigit && secondDigit == fourthDigit)
            {
                stringOutput = "It is a palindrome\n";
            }
            else
            {
                stringOutput = "It in not a palindrome\n";
            }

            System.out.println(stringOutput);

        }

    }

    private static boolean isFiveDigitNum(String number)
    {
        return (number.length() != 5  && number.startsWith("-") || (number.length() == 5 && !number.startsWith("-")));
    }

}
