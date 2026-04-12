/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modified by P. Balraj 2026

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import java.util.Scanner;

public class TestBowlingShopApp {

    public static void displayMenu() {
        System.out.println("Welcome to the Bowling Shop");
        System.out.println();
        System.out.println("Menu Options");
        System.out.println("a. View Bags");
        System.out.println("b. View Balls");
        System.out.println("s. View Shoes");
        System.out.println("x. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            displayMenu();
            choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("x")) {

                GenericQueue<Product> products = ProductDB.getProducts(choice);

                if (products.size() == 0) {
                    System.out.println("No products found.");
                }

                while (products.size() > 0) {
                    System.out.println(products.dequeue());
                }
            }

        } while (!choice.equalsIgnoreCase("x"));

        System.out.println("Goodbye.");
        scanner.close();
    }
}