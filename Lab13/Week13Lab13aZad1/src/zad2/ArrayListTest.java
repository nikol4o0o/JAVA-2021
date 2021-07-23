package zad2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListTest {
    private ArrayList<String> list;

    public ArrayListTest() {
        this.list = new ArrayList<>(Arrays.asList("Лили", "Мария", "Георги", "Илия", "Цвета", "Георги"));
    }

    public static void main(String[] args) {
        // d)
        ArrayList<String> aList = new ArrayList<>(Arrays.asList("Лили", "Мария", "Георги", "Илия", "Цвета", "Георги"));
        ArrayList<String> bList = new ArrayList<>(Arrays.asList("s", "a", "b", "e", "Цвета", "Илия"));

        Iterator<String> aIterator = aList.iterator();
        Iterator<String> bIterator;

        String aElement;
        String bElement;

        while (aIterator.hasNext()) {
            aElement = aIterator.next();

            bIterator = bList.iterator();
            while (bIterator.hasNext()) {
                bElement = bIterator.next();

                if (aElement.equals(bElement)) {
                    System.out.printf("Found common element: %s\n", aElement);
                    break;
                }
            }
        }

        // e)
        ArrayListTest test = new ArrayListTest();
        ListIterator<String> nameIterator = test.list.listIterator();
        while (nameIterator.hasNext()) {
            if (nameIterator.next().equals("Георги")) {
                nameIterator.add("Симеон");
                break;
            }
        }
        System.out.printf("Result after e): %s\n", test.list);
    }
}
