package zad3;

import java.util.Scanner;

public class TelephoneEncryptor
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a four digit number ");
        String userInput = input.nextLine();
        int number = Integer.parseInt(userInput);

        if(isFourDigit(userInput))
        {
            System.out.println("Encrypting... \n");
            int fourthDigit = number % 10;
            number /= 10;
            int thirdDigit = number % 10;
            number /= 10;
            int secondDigit = number % 10;
            number /= 10;
            int firstDigit = number % 10;

            firstDigit = (firstDigit + 7) % 10;
            secondDigit = (secondDigit + 7) % 10;
            thirdDigit = (thirdDigit + 7) % 10;
            fourthDigit = (fourthDigit + 7) % 10;

            int temp = firstDigit;
            firstDigit = thirdDigit;
            thirdDigit = temp;

            temp = secondDigit;
            secondDigit = fourthDigit;
            fourthDigit = temp;

            System.out.printf("Encrypted number: %d%d%d%d", firstDigit, secondDigit, thirdDigit, fourthDigit);
        }
        else
        {
            System.out.println("It is not a four digit number\n");
        }


    }


    public static boolean isFourDigit(String number)
    {
        return (number.length() == 5 && number.startsWith("-") || (number.length() == 4 && !number.startsWith("-")));
    }
}
