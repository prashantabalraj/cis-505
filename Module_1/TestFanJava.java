/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

public class TestFanApp {

    /**
     * Main method used to test the Fan class
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Create a fan using the default constructor
        Fan fan1 = new Fan();

        // Create a fan using the parameterized constructor
        Fan fan2 = new Fan(Fan.MEDIUM, true, 8.0, "Blue");

        // Display the fan objects using the toString method
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}