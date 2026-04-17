/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Payne, D. (2021). CSD 405 Intermediate Java Programming. Bellevue University.
Modified by P. Balraj 2026

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Handles reading and writing Transaction records to a flat text file (expenses.txt).
public class TransactionIO {

    // The name of the file used for persistent transaction storage.
    private static final String FILE_NAME = "expenses.txt";

    // Global reference to the expenses file used by both read and write operations.
    private static File gFile = new File(FILE_NAME);

    // Writes a list of Transaction objects to the expenses file.
    // Appends to the file if it already exists; creates a new file otherwise.
    // Parameter: transactions (ArrayList<Transaction>) - the list of transactions to save.
    // Throws: IOException if the file cannot be written.
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {

        PrintWriter lOutput;

        // Append to the existing file if it exists; otherwise create a new file.
        if (gFile.exists()) {
            lOutput = new PrintWriter(new FileOutputStream(gFile, true));
        } else {
            lOutput = new PrintWriter(gFile);
        }

        // Write each transaction's fields as separate lines in the file.
        for (Transaction transaction : transactions) {
            lOutput.println(transaction.getDate());
            lOutput.println(transaction.getDescription());
            lOutput.println(transaction.getAmount());
        }

        lOutput.close();
    }

    // Reads all Transaction records from the expenses file and returns them as a list.
    // Returns an empty list if the file does not yet exist.
    // Returns: ArrayList<Transaction> - all stored transactions.
    // Throws: IOException if the file cannot be read.
    public static ArrayList<Transaction> findAll() throws IOException {

        ArrayList<Transaction> lTransactions = new ArrayList<>();

        // Return an empty list if no file exists yet.
        if (!gFile.exists()) {
            return lTransactions;
        }

        Scanner lInput = new Scanner(gFile);

        // Read each transaction record (3 lines: date, description, amount) until end of file.
        while (lInput.hasNext()) {
            String lDate = lInput.nextLine();
            String lDescription = lInput.nextLine();
            double lAmount = Double.parseDouble(lInput.nextLine());

            lTransactions.add(new Transaction(lDate, lDescription, lAmount));
        }

        lInput.close();
        return lTransactions;
    }
}
