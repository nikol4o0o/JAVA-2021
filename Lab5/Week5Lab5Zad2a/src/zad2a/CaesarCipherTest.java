package zad2a;


import java.util.Scanner;

public class CaesarCipherTest {
    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher(3);
        Scanner input = new Scanner(System.in);
        System.out.print("1. Encode\n2. Decode\nChoose an option: ");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            System.out.print("Enter text: ");
            String text = input.nextLine();
            System.out.printf("Encoded text: %s\n", caesarCipher.encode(text));
        } else if (choice == 2) {
            System.out.print("Enter encoded text: ");
            String encodedText = input.nextLine();
            System.out.printf("Decoded text: %s\n", caesarCipher.decode(encodedText));
        } else {
            System.out.println("Unknown option.");
        }
    }
}
