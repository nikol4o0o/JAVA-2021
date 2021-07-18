package com;

import java.util.Scanner;

public class StockTest
{
    public static void main(String[] args)
    {
        Stock stockTesla = new Stock("$", "Tesla");//creates random member of the class Stock
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the previous closing price: ");
        double previousClosingPrice = input.nextDouble();
        System.out.println("Enter the current price: ");
        double currentPrice = input.nextDouble();

        stockTesla.setPreviousClosingPrice(previousClosingPrice);//sets the previous price
        stockTesla.setCurrentPrice(currentPrice);// sets the current price
        System.out.printf("The symbol is: %s %n", stockTesla.getSymbol());
        System.out.printf("The name is %s %n", stockTesla.getName());
        System.out.printf("The Tesla's last price is: %.3f%n", stockTesla.getPreviousClosingPrice());
        System.out.printf("The Tesla's current price is: %.3f%n", stockTesla.getCurrentPrice());
        System.out.printf("The difference is: %.3f%s ", stockTesla.changePercent(), "%");
    }
}
