/*
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
 * Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Modified by P. Balraj 2026
 *
 * Balraj, P. (2026). CIS 505 Intermediate Java Programming.
 * Bellevue University.
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* Account class represents a bank account with a default balance of $200.
 * Supports deposit, withdrawal, menu display, and transaction date retrieval. */
public class Account {

    // Private class-level field for the account balance, defaulted to $200.
    private double balance;

    /* No-argument constructor. Initializes the account with a default balance of $200.
     * Parameters: none
     * Returns: an Account object with balance set to 200.0 */
    public Account() {
        this.balance = 200.0;
    }

    /* Accessor method for the balance field.
     * Parameters: none
     * Returns: balance (double) - the current account balance */
    public double getBalance() {
        return balance;
    }

    /* Deposit method. Increases the account balance by the given amount.
     * Parameters: amt (double) - the amount to deposit
     * Returns: void */
    public void deposit(double amt) {
        balance += amt;
    }

    /* Withdraw method. Decreases the account balance by the given amount,
     * only if the balance is greater than or equal to the requested amount.
     * Parameters: amt (double) - the amount to withdraw
     * Returns: void */
    public void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
        }
    }

    /* Display menu method. Prints the account menu options to the console.
     * Parameters: none
     * Returns: void */
    public void displayMenu() {
        System.out.println("----------------------------");
        System.out.println("       Account Menu         ");
        System.out.println("----------------------------");
        System.out.println("1. View Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transaction Date");
        System.out.println("----------------------------");
        System.out.print("Enter selection: ");
    }

    /* Transaction date method. Returns the current date formatted as MM-dd-yyyy.
     * Parameters: none
     * Returns: formatted date string (String) */
    public String getTransactionDate() {
        // Local variable for today's date.
        LocalDate lToday = LocalDate.now();

        // Local variable for the date formatter using MM-dd-yyyy pattern.
        DateTimeFormatter lFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        return lToday.format(lFormatter);
    }
}
