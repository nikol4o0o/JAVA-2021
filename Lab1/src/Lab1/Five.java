package Lab1;// Lab 3: Five.java
// Program breaks apart a five-digit number


import java.util.Scanner;

public class Five
{

   public static void main( String args[] )
   {
      int originalNumber;
      int number;
      String inputString;

      // read five-digit number from standard input and store in var originalNumber
       Scanner input = new Scanner(System.in);
       originalNumber = input.nextInt();
  

      // determine the 5 digits
      int digit1; // first digit of number
      int digit2; // second digit of number
      int digit3; // third digit of number
      int digit4; // fourth digit of number 
      int digit5; // fifth digit of number

     digit1 = originalNumber % 10;
     originalNumber /= 10;
      digit2 = originalNumber % 10;
      originalNumber /= 10;
      digit3 = originalNumber % 10;
      originalNumber /= 10;
      digit4 = originalNumber % 10;
      originalNumber /= 10;
      digit5 = originalNumber % 10;
      originalNumber /= 10;




      // create the result string
      /* write a statement that creates a string that displays each digit 
         separated by three spaces. Name this string resultString for use in
         the call to showMessageDialog in lines 38-39 of the template code */

      String resultString = String.valueOf(digit5) +"   " +  String.valueOf(digit4) + "   " + String.valueOf(digit3) + "   "
              + String.valueOf(digit2) + "   " + String.valueOf(digit1);
      System.out.println(resultString);

      // output  results on standard output




}
}

