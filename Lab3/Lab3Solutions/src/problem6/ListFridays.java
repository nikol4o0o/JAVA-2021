package problem6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class ListFridays {
    private static void printListOfAllFriday13(int year){
        Locale bgLocal  = new Locale("bg", "BG");
        Locale.setDefault(bgLocal);

        //pick date format
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy");
        // printout date in BG style
        for (int i = 0; i < 12; i++) {//go through the months of a year
            LocalDate date =  LocalDate.of(year, i + 1, 13 );
            if(date.getDayOfWeek() == DayOfWeek.FRIDAY){
                System.out.println(formattedDate.format(date));
            }
        }
    }

    public static void main(String[] args) {
        // declare and initialize
        int year; // year to print Fridays
        Random rand = new Random();

        //pick random year in interval [1900; 2020]
        year = rand.nextInt(121) + 1900; //pick a random number from 0 to 120 then add 1900 to it to get to [1900; 2020]

        // processing and output results of processing
        System.out.printf("All Friday 13ths in the year: %d %n",  year);
        printListOfAllFriday13(year);
    }
}
