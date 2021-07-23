package zad4;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomDice {
    public static void main(String[] args) {
        System.out.printf("%-10s%-10s\n", "Face", "Frequency");
        Random random = new Random();
        IntStream.range(0, 6_000_000)
                .mapToObj(i -> 1 + random.nextInt(6))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(entry -> System.out.printf("%-10d%-10d\n", entry.getKey(), entry.getValue()));
    }
}
