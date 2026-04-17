/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Payne, D. (2021). CSD 405 Intermediate Java Programming. Bellevue University.
Modified by P. Balraj 2026

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Main driver class for the Expense Tracker application.
// Provides a menu-driven interface for viewing, adding, and totaling transactions.
public class TestExpenseTracker {

    // Displays the main menu options to the console.
    public static void displayMenu() {
        System.out.println("  Welcome to the Expense Tracker\n");
        System.out.println("  Menu Options");
        System.out.println("  1. View Transactions");
        System.out.println("  2. Add Transaction");
        System.out.println("  3. View Total Expenses");
        System.out.println("  x. Exit\n");
    }

    // Entry point of the application.
    // Runs the main menu loop until the user chooses to exit.
    // Throws: IOException if file read/write operations fail.
    public static void main(String[] args) throws IOException {

        Scanner lScanner = new Scanner(System.in);
        String lChoice;

        // Continue displaying the menu until the user selects 'x' to exit.
        do {
            displayMenu();
            System.out.print("  Enter your choice: ");
            lChoice = lScanner.nextLine();

            switch (lChoice) {

                case "1":
                    // Retrieve all saved transactions and display them to the console.
                    System.out.println("\n  Transaction List\n");

                    ArrayList<Transaction> lTransactions = TransactionIO.findAll();

                    for (Transaction transaction : lTransactions) {
                        System.out.println(transaction);
                    }
                    break;

                case "2":
                    // Collect one or more new transactions from the user and save them to file.
                    ArrayList<Transaction> lNewTransactions = new ArrayList<>();
                    String lContinueInput;

                    do {
                        // Prompt the user to enter the details for each transaction.
                        String lDate = ValidatorIO.getString(lScanner, "Enter transaction date (MM-dd-yyyy): ");
                        String lDesc = ValidatorIO.getString(lScanner, "Enter description: ");
                        double lAmount = ValidatorIO.getDouble(lScanner, "Enter amount: ");

                        lNewTransactions.add(new Transaction(lDate, lDesc, lAmount));

                        // Ask the user if they want to add another transaction.
                        lContinueInput = ValidatorIO.getString(lScanner, "Add another transaction? (y/n): ");

                    } while (lContinueInput.equalsIgnoreCase("y"));

                    // Write all newly entered transactions to the expenses file.
                    TransactionIO.bulkInsert(lNewTransactions);
                    break;

                case "3":
                    // Calculate and display the sum of all transaction amounts.
                    double lTotal = 0;
                    ArrayList<Transaction> lAll = TransactionIO.findAll();

                    for (Transaction transaction : lAll) {
                        lTotal += transaction.getAmount();
                    }

                    System.out.println("\n  Total Expenses: " + String.format("$%,6.2f", lTotal));
                    break;
            }

            // After a valid menu action, ask if the user wants to continue or return to the menu.
            if (!lChoice.equalsIgnoreCase("x")) {
                System.out.print("\n  Continue? (y/n): ");
                String lCont = lScanner.nextLine();
                if (lCont.equalsIgnoreCase("n")) {
                    break;
                }
            }

        } while (!lChoice.equalsIgnoreCase("x"));

        System.out.println("\n  Goodbye.");
        lScanner.close();
    }
}
