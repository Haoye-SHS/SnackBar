/**
 * @author Haoye
 */

/*
   This class implements a vendor that sells one kind of items.
   A vendor carries out sales transactions.
*/

public class Vendor
{
    // Fields:
    private int stock;
    private int price;
    private int deposited;
    private int changeDue;
    private static double totalSales = 0;

    //  Constructor
    //  Parameters:
    //      int price of a single item in cents
    //      int number of items to place in stock
    public Vendor(int newPrice, int newStock) {
        stock = newStock;
        price = newPrice;
        deposited = 0;
        changeDue = 0;
    }

    //  Sets the quantity of items in stock.
    //  Parameters:
    //    int number of items to place in stock
    //  Return:
    //    None
    public void setStock(int stockToSet) {
       stock = stockToSet;
    }

    //  Returns the number of items currently in stock.
    //  Parameters:
    //    None
    //  Return:
    //    int number of items currently in stock
    public int getStock() {
        return stock;
    }

    //  Adds a specified amount (in cents) to the deposited amount.
    //  Parameters:
    //    int number of cents to add to the deposit
    //  Return:
    //    None
    public void addMoney(int cents) {
        deposited = deposited + cents;
    }

    //  Returns the currently deposited amount (in cents).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current deposit
    public int getDeposit() {
        return deposited;
    }

    //  Implements a sale.  If there are items in stock and
    //  the deposited amount is greater than or equal to
    //  the single item price, then adjusts the stock
    //  and calculates and sets change and returns true;
    //  otherwise refunds the whole deposit (moves it into change)
    //  and returns false.
    //  Parameters:
    //    None
    //  Return:
    //    boolean successful sale (true) or failure (false)
    public boolean makeSale() {
        if (stock <= 0) {
            changeDue = deposited;
            deposited = 0;
            return false;
        }
        if (deposited < price) {
            changeDue = deposited;
            deposited = 0;
            return false;
        }

        totalSales += price / 100.00;
        changeDue = deposited - price;
        deposited -= price;
        stock -=1;
        return true;
    }

    //  Returns and zeroes out the amount of change (from the last
    //  sale or refund).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current change
    public int getChange() {
        return changeDue;
    }

    public static double getTotalSales() {
        double a = totalSales;
        totalSales = 0;
        return a;
    }
}