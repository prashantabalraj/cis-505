/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Payne, D. (2021). CSD 405 Intermediate Java Programming. Bellevue University.
Modified by P. Balraj 2026

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import java.text.SimpleDateFormat;
import java.util.Date;

// Represents a single financial transaction with a date, description, and amount.
public class Transaction {

    // Class properties for storing transaction data.
    private String date;
    private String description = "";
    private double amount = 0;

    // Default constructor: sets the transaction date to today's date using MM-dd-yyyy format.
    public Transaction() {
        SimpleDateFormat lFormatter = new SimpleDateFormat("MM-dd-yyyy");
        this.date = lFormatter.format(new Date());
    }

    // Parameterized constructor: creates a Transaction with a specified date, description, and amount.
    // Parameters: date (String), description (String), amount (double)
    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    // Returns the transaction date as a String.
    public String getDate() { return date; }

    // Sets the transaction date.
    // Parameter: date (String) - the new date value in MM-dd-yyyy format.
    public void setDate(String date) { this.date = date; }

    // Returns the transaction description as a String.
    public String getDescription() { return description; }

    // Sets the transaction description.
    // Parameter: description (String) - a short label for the transaction.
    public void setDescription(String description) { this.description = description; }

    // Returns the transaction amount as a double.
    public double getAmount() { return amount; }

    // Sets the transaction amount.
    // Parameter: amount (double) - the monetary value of the transaction.
    public void setAmount(double amount) { this.amount = amount; }

    // Returns a formatted String representation of the transaction showing date, description, and amount.
    @Override
    public String toString() {
        return "    Date: " + date + "\n" +
               "    Description: " + description + "\n" +
               String.format("    Amount: $%,6.2f\n", amount);
    }
}
