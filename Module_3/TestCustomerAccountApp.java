/*
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
 * Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Modified by P. Balraj 2026
 *
 * Balraj, P. (2026). CIS 505 Intermediate Java Programming.
 * Bellevue University.
 */
import java.util.Scanner;

/* TestCustomerAccountApp class serves as the main entry point for the program.
 * It tests the Customer, CustomerDB, and Account classes by prompting the user
 * for a customer number, displaying an account menu, and handling transactions
 * in a do...while loop. */
public class TestCustomerAccountApp {

    /* Main method. Entry point of the program.
     * Parameters: args (String[]) - command-line arguments (not used)
     * Returns: void */
    public static void main(String[] args) {

        // Local variable for reading user input from the console.
        Scanner lScanner = new Scanner(System.in);

        // Local variable for the account object with a default balance of $200.
        Account lAccount = new Account();

        // Prompt the user to enter a customer number and retrieve the matching customer.
        System.out.print("Enter a customer number (1007, 1008, or 1009): ");
        int lCustomerNumber = lScanner.nextInt();
        Customer lCustomer = CustomerDB.getCustomer(lCustomerNumber);

        // Local variable to track whether the user wants to continue using the menu.
        String lContinueChoice;

        // Do...while loop allows the user to make multiple menu selections.
        do {
            // Display the account menu and read the user's selection.
            lAccount.displayMenu();
            int lSelection = lScanner.nextInt();

            // Handle menu selection 1: view current balance.
            if (lSelection == 1) {
                System.out.printf("Current Balance: $%,6.2f%n", lAccount.getBalance());

            // Handle menu selection 2: deposit funds.
            } else if (lSelection == 2) {
                System.out.print("Enter deposit amount: ");
                double lAmt = lScanner.nextDouble();
                lAccount.deposit(lAmt);
                System.out.printf("New Balance: $%,6.2f%n", lAccount.getBalance());

            // Handle menu selection 3: withdraw funds.
            } else if (lSelection == 3) {
                System.out.print("Enter withdrawal amount: ");
                double lAmt = lScanner.nextDouble();
                lAccount.withdraw(lAmt);
                System.out.printf("New Balance: $%,6.2f%n", lAccount.getBalance());

            // Handle menu selection 4: display the transaction date.
            } else if (lSelection == 4) {
                System.out.println("Transaction Date: " + lAccount.getTransactionDate());

            // Handle any invalid menu selection.
            } else {
                System.out.println("Error: Invalid Option.");
            }

            // Ask the user whether to continue or exit the menu.
            System.out.print("Continue? (yes/no): ");
            lContinueChoice = lScanner.next();

        } while (lContinueChoice.equalsIgnoreCase("yes"));

        // Display the customer's details and final account balance after exiting the menu.
        System.out.println("\nCustomer Details:");
        System.out.println(lCustomer.toString());
        System.out.printf("Account Balance: $%,6.2f%n", lAccount.getBalance());

        // Close the scanner to release resources.
        lScanner.close();
    }
}
