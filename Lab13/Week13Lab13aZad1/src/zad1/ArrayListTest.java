package zad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListTest {

    public static <E extends Comparable<E>> E max(E[][] list) {
        E maxElement = null;
        for (int i = 0; i < list.length; i++) {
            if (maxElement == null) {
                maxElement = Collections.max(Arrays.asList(list[i]));
            } else {
                E newMaxElement = Collections.max(Arrays.asList(list[i]));
                if (newMaxElement.compareTo(maxElement) > 0) {
                    maxElement = newMaxElement;
                }
            }
        }
        return maxElement;
    }

    public static <E> void shuffle(ArrayList<E> list) {
        Collections.shuffle(list);
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        return Collections.max(list);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniques = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (Collections.frequency(list, list.get(i)) == 1) {
                uniques.add(list.get(i));
            } else {
                list.remove(i);
                i--;
            }
        }
        return uniques;
    }

    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][]{
                {1,2,4,56,7,3},
                {3,6,45,7,23,34}
        };
        System.out.printf("Max element: %d\n", max(matrix));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.printf("List: %s\n", list);
        shuffle(list);
        System.out.printf("Shuffled List: %s\n", list);
        System.out.printf("Max element: %d\n", max(list));

        ArrayList<Integer> duplicates = new ArrayList<>(Arrays.asList(1,2,3,1,2,3,1,2,3,4,5));
        System.out.printf("Uniques List: %s\n", removeDuplicates(duplicates));
    }
}

