package zad6;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ArrayUtils
{
    public static void filterNumbers(Predicate<Integer> condition, int[] array) {
        Arrays.stream(array)
                .filter(condition::test)
                .forEach(number -> System.out.printf("%d ", number));
        System.out.println();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = IntStream.range(0, 20)
                .map(i -> 10 + random.nextInt(41))
                .toArray();

        Predicate<Integer> evenNumber = number -> number % 2 == 0;
        filterNumbers(evenNumber, numbers);

        Predicate<Integer> numberInRange = number -> number >= 30 && number <= 40;
        filterNumbers(numberInRange, numbers);

        Predicate<Integer> primeNumber = number -> number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
        filterNumbers(primeNumber, numbers);
    }
}
