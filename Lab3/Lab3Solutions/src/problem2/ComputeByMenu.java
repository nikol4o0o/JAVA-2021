package problem2;

import java.util.Scanner;

public class ComputeByMenu {

    private Scanner kbd;
    private double x;
    private int userChoice;

    public ComputeByMenu(double x) {
        kbd = new Scanner(System.in);
        setX(x);
    }

    public double getX() {
        return x;
    }
    // Validate! x is defined from Double.MIN_VALUE, DOUBLE.MAX_VALUE
    public void setX(double x) {
        this.x = x <= Double.MAX_VALUE && x >= Double.MIN_VALUE? x: 0.0 ;
    }

    public void doSelection(int choice) {
        switch (choice) {
            case 1:
                inputX();
                break;
            case 2:
                computeExp();
                break;
            case 3:
                computeSin();
                break;
            case 4:
                computeFloor();
                break;
            case 5:
                System.exit(0);
        }
        displayMenu();
    }

    public void getUserChoice() {
        while (true) {
            displayMenu();
            System.out.println("Select a menu option: ");
            do {
                userChoice = kbd.nextInt();
            } while (userChoice < 1 || userChoice > 5);
            doSelection(userChoice);
        }
    }

    private void pressAnyKey() {
        System.out.println("Press any key to continue");
        kbd.nextLine(); //read Return entry
        kbd.nextLine();
    }

    private void inputX() {
        System.out.print("Enter x: "); // issue prompt text
        x = kbd.nextDouble();          // enter new value for x
        pressAnyKey(); // ask user to continue by pressing Enter
    }

    private void computeSin() {
        double result = Math.sin(x);
        System.out.printf("Sin(%.4f) = %.4f %n", x, result); // issue prompt text
        pressAnyKey(); // ask user to continue by pressing Enter
    }

    private void computeFloor() {
        double result = Math.floor(x);
        System.out.printf("Floor(%.4f) = %.4f %n", x, result); // issue prompt text
        pressAnyKey(); // ask user to continue by pressing Enter
    }

    private void computeExp() {
        double result = Math.exp(x);
        System.out.printf("Exp(%.4f) = %.4f %n", x, result); // issue prompt text
        pressAnyKey(); // ask user to continue by pressing Enter
    }

    public void displayMenu() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("1. Update the floating point number");
        System.out.println("2. Compute and display exp(x)");
        System.out.println("3. Compute and display sin(x)");
        System.out.println("4. Compute and display floor(x)");
        System.out.println("5. Exit");

    }
}
