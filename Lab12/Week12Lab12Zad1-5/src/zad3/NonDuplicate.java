package zad3;

import java.util.ArrayList;
import java.util.Arrays;

public class NonDuplicate {

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniques = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (!uniques.contains(list.get(i))) {
                uniques.add(list.get(i));
            }
        }
        return uniques;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5));

        System.out.printf("Array: %s\n", numbers);
        System.out.printf("Unique elements: %s\n", removeDuplicates(numbers));

        System.out.println();

        ArrayList<String> texts = new ArrayList<>(Arrays.asList("a", "a", "a", "a", "b", "b", "b", "d", "d", "c", "c"));
        System.out.printf("Array: %s\n", texts);
        System.out.printf("Unique elements: %s\n", removeDuplicates(texts));
    }
}