package com;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol, String name)
    {
        this.symbol = symbol;//sets symbol
        this.name = name;//sets name
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }

    public double getPreviousClosingPrice()
    {
        return this.previousClosingPrice;
    }

    public double getCurrentPrice()
    {
        return this.currentPrice;
    }

    public void setPreviousClosingPrice(double price)
    {
        if(price > 0)//checks if the price is appropriate
        {
            this.previousClosingPrice = price;
        }
        else
        {
            previousClosingPrice = 1;//sets appropriate value
        }
    }

    public void setCurrentPrice(double price)
    {
        if(price > 0)//checks if the price is appropriate
        {
            this.currentPrice = price;
        }
        else
        {
            currentPrice = 1;//sets appropriate value
        }
    }

    public double changePercent()
    {
        return  ((currentPrice - previousClosingPrice)*100) / previousClosingPrice;//returns the difference between the current
                                                                          //and the last in percentages
    }

}
