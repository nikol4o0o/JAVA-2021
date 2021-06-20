import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;

public class Friday13Finder
{
    public  static void printListOfAllFiday13() {
        Random random = new Random();
        int year = 1900 + random.nextInt(121);


        for (int i = 0; i < 12; i++)
        {
            LocalDate date = LocalDate.of(year, i + 1, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY)
                System.out.println(date);
        }

    }

    public static void main(String[] args)
    {
        printListOfAllFiday13();
    }
}
