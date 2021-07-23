package zad5;

import java.util.Arrays;

public class GenericMaxElementTest {
    public static <E extends Comparable<E>> E max(E[][] list) {
        E maxElement = list[0][0];

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j].compareTo(maxElement) > 0) {
                    maxElement = list[i][j];
                }
            }
        }
        return maxElement;
    }

    public static void main(String[] args) {
        Integer[][] integerMatrix = new Integer[][]{
                {1,2,3,4,5},
                {50,20,31,23,54}
        };
        System.out.println("Matrix:");
        for (int i = 0; i < integerMatrix.length; i++) {
            System.out.println(Arrays.toString(integerMatrix[i]));
        }
        System.out.printf("Max element: %d\n", max(integerMatrix));

        System.out.println();

        String[][] textMatrix = new String[][]{
                {"a", "b", "c", "d"},
                {"dc", "a", "b", "e"}
        };
        System.out.println("Matrix:");
        for (int i = 0; i < textMatrix.length; i++) {
            System.out.println(Arrays.toString(textMatrix[i]));
        }
        System.out.printf("Max element: %s\n", max(textMatrix));
    }
}
