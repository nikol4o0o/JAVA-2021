package com.geometry.utils;

import com.geometry.types.*;

import java.util.Random;

public class SelectionSortTest {

    private static Comparable[] arrComparable = new Comparable[9];

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            arrComparable[i] = new Point(10 + random.nextInt(41), 10 + random.nextInt(41));
        }

        for (int i = 3; i < 6; i++) {
            arrComparable[i] = new Circle((Point) arrComparable[i - 3], 10 + random.nextInt(21));
        }

        for (int i = 6; i < 9; i++) {
            arrComparable[i] = new Cylinder((Circle) arrComparable[i - 3], 10 + random.nextInt(51));
        }

        System.out.println("Unsorted:");
        for (Comparable comparable : arrComparable) {
            System.out.println(comparable);
        }

        SelectionSort.sortArray(arrComparable);

        System.out.printf("\nSorted:\n");
        for (Comparable comparable : arrComparable) {
            System.out.println(comparable);
        }
    }
}
