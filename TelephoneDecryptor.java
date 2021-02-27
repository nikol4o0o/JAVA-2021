package zad3;

import java.util.Scanner;

public class TelephoneDecryptor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a four digit number ");
        String userInput = input.nextLine();
        int number = Integer.parseInt(userInput);

        if (isFourDigit(userInput)) {
            System.out.println("Decrypting... \n");
            int fourthDigit = number % 10;
            number /= 10;
            int thirdDigit = number % 10;
            number /= 10;
            int secondDigit = number % 10;
            number /= 10;
            int firstDigit = number % 10;

            firstDigit = (firstDigit + 3) % 10;
            secondDigit = (secondDigit + 3) % 10;
            thirdDigit = (thirdDigit + 3) % 10;
            fourthDigit = (fourthDigit + 3) % 10;

            int temp = firstDigit;
            firstDigit = thirdDigit;
            thirdDigit = temp;

            temp = secondDigit;
            secondDigit = fourthDigit;
            fourthDigit = temp;

            System.out.printf("Decrypted number: %d%d%d%d", firstDigit, secondDigit, thirdDigit, fourthDigit);
        } else {
            System.out.println("It is not a four digit number\n");
        }


    }


    public static boolean isFourDigit(String number) {
        return (number.length() == 5 && number.startsWith("-") || (number.length() == 4 && !number.startsWith("-")));
    }
}