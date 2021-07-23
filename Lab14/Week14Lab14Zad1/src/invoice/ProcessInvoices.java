package invoice;

// Exercise 17.11: ProcessInvoices.java
// Processing Invoices with lambdas and streams.

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessInvoices {
    public static void main(String[] args) {
        Invoice[] invoices = {
                new Invoice(83, "Electric sander", 7, 57.98),
                new Invoice(24, "Power saw", 18, 99.99),
                new Invoice(7, "Sledge hammer", 11, 21.50),
                new Invoice(77, "Hammer", 76, 11.99),
                new Invoice(39, "Lawn mower", 3, 79.50),
                new Invoice(68, "Screwdriver", 106, 6.99),
                new Invoice(56, "Jig saw", 21, 11.00),
                new Invoice(3, "Wrench", 34, 7.50)
        };

        System.out.println("Invoices sorted by part description:");
        Stream.of(invoices)
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);

        System.out.printf("%nInvoices sorted by price:%n");
        Stream.of(invoices)
                .sorted(Comparator.comparing(Invoice::getPrice))
                .forEach(System.out::println);

        System.out.printf("%nInvoices mapped to description and quantity:%n");
//        Stream.of(invoices)
//                .sorted(Comparator.comparing(Invoice::getQuantity))
//                .map(invoice -> String.format("Description: %-15s  Quantity: %-4d",
//                        invoice.getPartDescription(), invoice.getQuantity()))
//                .forEach(System.out::println);

        Stream.of(invoices)
                .collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getQuantity))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.printf("Description: %-15s  Quantity: %-4d\n",
                        entry.getKey(), entry.getValue()));

        System.out.printf("%nInvoices mapped to description and invoice amount:%n");

//        Stream.of(invoices)
//                .sorted((invoice1, invoice2) -> Double.compare(invoice1.getQuantity() * invoice1.getPrice(),
//                        invoice2.getQuantity() * invoice2.getPrice()))
//                .map(invoice -> String.format("Description: %-15s  Value: %-4.2f",
//                        invoice.getPartDescription(), invoice.getQuantity() * invoice.getPrice()))
//                .forEach(System.out::println);

//        Stream.of(invoices)
//                .sorted(Comparator.comparingDouble(invoice -> invoice.getQuantity() * invoice.getPrice()))
//                .map(invoice -> String.format("Description: %-15s  Value: %-4.2f",
//                        invoice.getPartDescription(), invoice.getQuantity() * invoice.getPrice()))
//                .forEach(System.out::println);

        Stream.of(invoices)
                .collect(Collectors.toMap(Invoice::getPartDescription, invoice -> invoice.getQuantity() * invoice.getPrice()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.printf("Description: %-15s  Value: %-4.2f\n",
                        entry.getKey(), entry.getValue()));

        System.out.printf("%nInvoices mapped to description and invoice amount for invoices in the range 200-500:%n");
//        Stream.of(invoices)
//                .filter(invoice -> invoice.getQuantity() * invoice.getPrice() >= 200 &&
//                        invoice.getQuantity() * invoice.getPrice() <= 500)
//                .sorted(Comparator.comparingDouble(invoice -> invoice.getQuantity() * invoice.getPrice()))
//                .map(invoice -> String.format("Description: %-15s  Value: %-4.2f",
//                        invoice.getPartDescription(), invoice.getQuantity() * invoice.getPrice()))
//                .forEach(System.out::println);

        Stream.of(invoices)
                .collect(Collectors.toMap(Invoice::getPartDescription, invoice -> invoice.getQuantity() * invoice.getPrice()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 200 && entry.getValue() <= 500)
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.printf("Description: %-15s  Value: %-4.2f\n",
                        entry.getKey(), entry.getValue()));

        System.out.printf("%nInvoices with amount below or equal to 300:%n");
        Set<Invoice> belowOrEqual300 = Stream.of(invoices)
                .filter(invoice -> invoice.getQuantity() * invoice.getPrice() <= 300)
                .collect(Collectors.toSet());
        belowOrEqual300.stream()
                .forEach(invoice -> System.out.printf("Description: %-15s  Value: %-4.2f\n",
                        invoice.getPartDescription(), invoice.getQuantity() * invoice.getPrice()));

        System.out.printf("%nInvoices with amount above 300:%n");
        Set<Invoice> above300 = Stream.of(invoices)
                .filter(invoice -> invoice.getQuantity() * invoice.getPrice() > 300)
                .collect(Collectors.toSet());
        above300.stream()
                .forEach(invoice -> System.out.printf("Description: %-15s  Value: %-4.2f\n",
                        invoice.getPartDescription(), invoice.getQuantity() * invoice.getPrice()));

        System.out.printf("%nInvoices grouped by hashcode and sorted by price descending:%n");
        Map<String, Invoice> invoiceMap = Stream.of(invoices)
                .collect(Collectors.toMap(invoice -> String.valueOf(invoice.hashCode()), Function.identity()));
        invoiceMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Invoice::getPrice).reversed()))
                .forEach(entry -> System.out.printf("Hashcode: %-10s Value: %-10s\n", entry.getKey(), entry.getValue()));
    }
}
