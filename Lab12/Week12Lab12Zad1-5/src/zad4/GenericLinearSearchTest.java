package zad4;

import java.util.Arrays;

public class GenericLinearSearchTest {

    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5};
        System.out.println(Arrays.toString(numbers));
        System.out.printf("Index of %d: %d\n", 1, linearSearch(numbers, 1));
        System.out.printf("Index of %d: %d\n", 2, linearSearch(numbers, 2));
        System.out.printf("Index of %d: %d\n", 3, linearSearch(numbers, 3));
        System.out.printf("Index of %d: %d\n", 4, linearSearch(numbers, 4));
        System.out.printf("Index of %d: %d\n", 5, linearSearch(numbers, 5));

        System.out.println();

        String[] texts = {"a", "a", "a", "a", "b", "b", "b", "d", "d", "c", "c"};
        System.out.println(Arrays.toString(texts));
        System.out.printf("Index of %s: %d\n", "a", linearSearch(texts, "a"));
        System.out.printf("Index of %s: %d\n", "b", linearSearch(texts, "b"));
        System.out.printf("Index of %s: %d\n", "c", linearSearch(texts, "c"));
        System.out.printf("Index of %s: %d\n", "d", linearSearch(texts, "d"));
    }
}
