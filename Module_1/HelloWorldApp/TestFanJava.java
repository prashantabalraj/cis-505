/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

public class TestFanApp {
    public static void main(String[] args) {

        Fan fan1 = new Fan();
        Fan fan2 = new Fan(Fan.MEDIUM, true, 8.0, "Blue");

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}