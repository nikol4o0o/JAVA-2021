package com;

import services.Computable;

import java.util.Scanner;

public class Tabulate {
    private Computable callback;

    public Tabulate(Computable callback) {
        setCallback(callback);
    }

    public Computable getCallback() {
        return callback;
    }

    public void setCallback(Computable callback) {
        this.callback = callback;
    }

    public void tabulate(double a, double b, int steps) {
        tabulateFunction(a, b, steps, callback);
    }

    public static void tabulateFunction(double a, double b, int steps, Computable computable) {
        if (a > b) {
            System.out.println("Please enter a valid interval.");
            return;
        }

        if (steps <= 0) {
            System.out.println("Please enter a positive number of steps.");
            return;
        }

        if (computable == null) {
            System.out.println("Invalid computable reference.");
            return;
        }

        // [a,b]
        // n steps
        // x f(x)
        Scanner input = new Scanner(System.in);
        double step = (b - a) / steps;
        int iterations = 0;
        System.out.printf("%-20s%-20s\n", "X", "F(X)");
        for (double x = a; x <= b; x += step) {
            if (iterations > 0 && iterations % 20 == 0) {
                System.out.println("Press Enter to continue...");
                input.nextLine();
            }
            System.out.printf("%-20.2f%-20.2f\n", x, computable.function(x));
            iterations++;
        }
    }
}

