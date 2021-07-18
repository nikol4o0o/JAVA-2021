package zad1;
import java.util.Scanner;

public class RouteCipherTest
{
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plainText;
        int key, choice;
        System.out.println("Enter text");
        plainText = scanner.nextLine();
        System.out.println("Would you like to encode/decode?\n" + "Choose 1 for encoding and 2 decoding");
        choice = scanner.nextInt();
        System.out.println("Enter the key positive/negative number");
        key = scanner.nextInt();

        RouteCipher cipher = new RouteCipher(key);
        if(choice ==1)
        {
            System.out.printf("The encoded text is: %s",cipher.encrypt(plainText));
        }
        else if(choice == 2)
        {
            System.out.printf("The decoded text is: %s",cipher.decrypt(plainText));
        }
        else
        {
            System.out.println("Invalid choice!!!\n");
            System.exit(0);
        }



        //String decryption = cipher.encrypt(plainText);
        //System.out.printf("Successfully encrypted:" + decryption + "\n");
        //System.out.println(cipher.dectrypt(decryption));
    }


}

