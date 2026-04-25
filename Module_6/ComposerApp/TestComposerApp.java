/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import java.util.List;
import java.util.Scanner;

/*
 * Test application for Composer DAO
 */
public class TestComposerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MemComposerDao dao = new MemComposerDao();

        int lChoice;

        do {
            // Display menu
            System.out.println("\n MENU");
            System.out.println("1. View Composers");
            System.out.println("2. Find Composer by ID");
            System.out.println("3. Add Composer");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            lChoice = scanner.nextInt();

            switch (lChoice) {

                case 1:
                    // Display all composers
                    List<Composer> lComposers = dao.findAll();

                    for (Composer composer : lComposers) {
                        System.out.println("\n" + composer);
                    }
                    break;

                case 2:
                    // Find composer by ID
                    System.out.print("Enter composer ID: ");
                    int lId = scanner.nextInt();

                    Composer lFoundComposer = dao.findBy(lId);

                    if (lFoundComposer != null) {
                        System.out.println("\n" + lFoundComposer);
                    } else {
                        System.out.println("Composer not found.");
                    }
                    break;

                case 3:
                    // Add new composer
                    scanner.nextLine(); // clear buffer

                    System.out.print("Enter ID: ");
                    int lNewId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String lName = scanner.nextLine();

                    System.out.print("Enter Genre: ");
                    String lGenre = scanner.nextLine();

                    Composer lNewComposer = new Composer(lNewId, lName, lGenre);
                    dao.insert(lNewComposer);

                    System.out.println("Composer added.");
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (lChoice != 4);

        scanner.close();
    }
}