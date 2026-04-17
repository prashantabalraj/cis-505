/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Payne, D. (2021). CSD 405 Intermediate Java Programming. Bellevue University.
Modified by P. Balraj 2026

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import java.util.Scanner;

// Provides reusable input validation methods for reading user input from the console.
public class ValidatorIO {

    // Prompts the user for an integer value and re-prompts until a valid integer is entered.
    // Parameters: sc (Scanner) - the active Scanner instance; prompt (String) - the message shown to the user.
    // Returns: int - the validated integer entered by the user.
    public static int getInt(Scanner sc, String prompt) {
        int lInput = 0;
        boolean lIsValid = false;

        // Loop until a valid integer is provided.
        while (!lIsValid) {
            System.out.print("  " + prompt);

            if (sc.hasNextInt()) {
                // Read the integer and consume the remaining newline character.
                lInput = sc.nextInt();
                sc.nextLine();
                lIsValid = true;
            } else {
                // Notify the user of invalid input and clear the bad token.
                System.out.println("  Error! Invalid integer value.");
                sc.nextLine();
            }
        }
        return lInput;
    }

    // Prompts the user for a double value and re-prompts until a valid double is entered.
    // Parameters: sc (Scanner) - the active Scanner instance; prompt (String) - the message shown to the user.
    // Returns: double - the validated double entered by the user.
    public static double getDouble(Scanner sc, String prompt) {
        double lInput = 0;
        boolean lIsValid = false;

        // Loop until a valid double is provided.
        while (!lIsValid) {
            System.out.print("  " + prompt);

            if (sc.hasNextDouble()) {
                // Read the double and consume the remaining newline character.
                lInput = sc.nextDouble();
                sc.nextLine();
                lIsValid = true;
            } else {
                // Notify the user of invalid input and clear the bad token.
                System.out.println("  Error! Invalid double value.");
                sc.nextLine();
            }
        }
        return lInput;
    }

    // Prompts the user for a String value and returns whatever they enter (no validation required).
    // Parameters: sc (Scanner) - the active Scanner instance; prompt (String) - the message shown to the user.
    // Returns: String - the text entered by the user.
    public static String getString(Scanner sc, String prompt) {
        System.out.print("  " + prompt);
        return sc.nextLine();
    }
}
