import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLetters
{
    public static void main(String[] args) {
        Random random = new Random();
        List<Character> randomLetters = IntStream.range(0, 30)
                .mapToObj(i -> (char) (65 + random.nextInt(26)))
                .collect(Collectors.toList());

        randomLetters.stream()
                .sorted()
                .forEach(letter -> System.out.printf("%c ", letter));

        System.out.println();

        randomLetters.stream()
                .sorted(Collections.reverseOrder())
                .forEach(letter -> System.out.printf("%c ", letter));

        System.out.println();

        randomLetters.stream()
                .distinct()
                .sorted()
                .forEach(letter -> System.out.printf("%c ", letter));
    }
}
