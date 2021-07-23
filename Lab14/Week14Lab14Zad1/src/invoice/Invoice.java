package invoice;

// Exercise 17.11: Invoice.java
// Invoice class

public class Invoice {
    private final int partNumber;
    private final String partDescription;
    private int quantity;
    private double price;

    // constructor
    public Invoice(int partNumber, String partDescription, int quantity,
                   double price) {
        if (quantity < 0) // validate quantity
            throw new IllegalArgumentException("Quantity must be >= 0");

        if (price < 0.0) // validate price
            throw new IllegalArgumentException(
                    "Price per item must be >= 0");

        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.price = price;
    } // end constructor

    // get part number
    public int getPartNumber() {
        return partNumber; // should validate
    }

    // get description
    public String getPartDescription() {
        return partDescription;
    }

    // set quantity
    public void setQuantity(int quantity) {
        if (quantity < 0) // validate quantity
            throw new IllegalArgumentException("Quantity must be >= 0");

        this.quantity = quantity;
    }

    // get quantity
    public int getQuantity() {
        return quantity;
    }

    // set price per item
    public void setPrice(double price) {
        if (price < 0.0) // validate price
            throw new IllegalArgumentException(
                    "Price per item must be >= 0");

        this.price = price;
    }

    // get price per item
    public double getPrice() {
        return price;
    }

    // return String representation of Invoice object
    @Override
    public String toString() {
        return String.format(
                "Part #: %-2d  Description: %-15s  Quantity: %-4d  Price: $%,6.2f",
                getPartNumber(), getPartDescription(),
                getQuantity(), getPrice());
    }
} // end class Invoice
