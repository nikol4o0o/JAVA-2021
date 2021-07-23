package zad1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaDemo {
    public static void main(String[] args) {
        Predicate<SalesPerson> predicate1 = (salesperson) -> salesperson.getNumSales() > 1200;
// да се инициализира
        Predicate<SalesPerson> predicate2 = (salesperson) -> salesperson.getSalary() > 900;
// да се инициализира
        Predicate<SalesPerson> predicate = (salesperson) -> predicate1.test(salesperson) || predicate2.test(salesperson);
// да се инициализира
        Consumer<SalesPerson> consumer1 = (salesperson) -> {
            salesperson.addBonus(salesperson.getSalary() * 5.0/100);
            System.out.println(salesperson);
        };
// да се инициализира
        Consumer<SalesPerson> consumer2 = (salesperson) -> {
            if (predicate1.test(salesperson)) {
                salesperson.addBonus(salesperson.getSalary() * 2.0/100);
            } else {
                salesperson.addBonus(salesperson.getSalary() * -2.0/100);
            }
            System.out.println(salesperson);
        };
// да се инициализира
        Comparator<SalesPerson> comparator1 = (salesperson1, salesperson2) -> {
            return ((int) ((salesperson2.getSalary() - salesperson1.getSalary()) * 100)) / 100;
        };
// да се инициализира
        Comparator<SalesPerson> comparator2 = (salesperson1, salesperson2) -> {
            int result = ((int) ((salesperson2.getSalary() - salesperson1.getSalary()) * 100)) / 100;
            if (result == 0) {
                return salesperson1.getNumSales() - salesperson2.getNumSales();
            }
            return result;
        };
// да се инициализира
        Random random = new Random();
        SalesPerson[] salespersons =
                {
                        new SalesPerson("John Doe", 2000, 949),
                        new SalesPerson("Jane Doe", 3900, 1500),
                        // да се добавят още 10 обекти от тип Salesperson
                        // или да се инициализират с Random стойности
                        new SalesPerson(String.format("John Doe %d", random.nextInt(10)),
                                1000 + random.nextInt(3001), 900 + random.nextInt(701)),
                        new SalesPerson(String.format("John Doe %d", random.nextInt(10)),
                                1000 + random.nextInt(3001), 900 + random.nextInt(701)),
                        new SalesPerson(String.format("John Doe %d", random.nextInt(10)),
                                1000 + random.nextInt(3001), 900 + random.nextInt(701)),
                        new SalesPerson(String.format("John Doe %d", random.nextInt(10)),
                                1000 + random.nextInt(3001), 900 + random.nextInt(701)),
                        new SalesPerson(String.format("John Doe %d", random.nextInt(10)),
                                1000 + random.nextInt(3001), 900 + random.nextInt(701)),
                        new SalesPerson(String.format("John Doe %d", random.nextInt(10)),
                                1000 + random.nextInt(3001), 900 + random.nextInt(701)),
                        new SalesPerson(String.format("John Doe %d", random.nextInt(10)),
                                1000 + random.nextInt(3001), 900 + random.nextInt(701)),
                        new SalesPerson(String.format("John Doe %d", random.nextInt(10)),
                                1000 + random.nextInt(3001), 900 + random.nextInt(701)),
                        new SalesPerson(String.format("John Doe %d", random.nextInt(10)),
                                1000 + random.nextInt(3001), 900 + random.nextInt(701)),
                        new SalesPerson(String.format("John Doe %d", random.nextInt(10)),
                                1000 + random.nextInt(3001), 900 + random.nextInt(701))
                };
        List<SalesPerson> listOfSalespersons = new
                ArrayList<>();
        // обектите на salespersons да се запишат в listOfSalespersons
        for (SalesPerson salesperson : salespersons) {
            applyBonus(salesperson, predicate1,
                    consumer1);
            System.out.println(salesperson);
            salesperson.printNumSales(salesperson);
            listOfSalespersons.add(salesperson);
        }
        for (SalesPerson salesperson : salespersons) {
            applyBonus(salesperson, predicate2, consumer2);
            System.out.println(salesperson);
        }
        sort(listOfSalespersons, comparator1);
        System.out.println(listOfSalespersons);
        sort(listOfSalespersons, comparator2);
        System.out.println(listOfSalespersons);

        System.out.println();

        group(listOfSalespersons);
    }

    public static void applyBonus(SalesPerson salesperson, Predicate<SalesPerson> predicate,
                                  Consumer<SalesPerson> consumer) {
// Напишете if команда, където използвайте predicate
// за да определите дали да изпълните consumer
// Изпълнете consumer, когато условието на if командата е изпълнено
        if (predicate.test(salesperson)) {
            consumer.accept(salesperson);
        }
    }

    public static void applyBonus(List<SalesPerson> salespersons, Predicate<SalesPerson> predicate,
                                  Consumer<SalesPerson> consumer) {
// Напишете if команда, където използвайте predicate
// за да определите дали да изпълните consumer
// Изпълнете consumer, когато условието на if командата е изпълнено
        for (SalesPerson salesperson : salespersons) {
            if (predicate.test(salesperson)) {
                consumer.accept(salesperson);
            }
        }
    }

    public static void sort(List<SalesPerson> salespersons, Comparator<SalesPerson> comparator) {
// Сортирайте salespersons като използвате comparator
        salespersons.sort(comparator);
    }

    public static void group(List<SalesPerson> salespersons) {
// Групирайте имената на salespersons по първата буква в
// името изведете отделните групи на стандартен изход
        Map<String, List<String>> names = new HashMap<>();
        for (SalesPerson salesperson : salespersons) {
            String nameGroup = String.valueOf(salesperson.getName().charAt(0));
            if (names.containsKey(nameGroup)) {
                names.get(nameGroup).add(salesperson.getName());
            } else {
                names.put(nameGroup, new ArrayList<>(Collections.singletonList(salesperson.getName())));
            }
        }

        for (String nameGroup : names.keySet()) {
            System.out.printf("%s => %s\n", nameGroup, names.get(nameGroup));
        }
    }
}


