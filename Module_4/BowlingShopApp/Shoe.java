/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modified by P. Balraj 2026

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

public class Shoe extends Product {

    private double size = 0;

    public Shoe() {}

    public double getSize() { return size; }
    public void setSize(double size) { this.size = size; }

    @Override
    public String toString() {
        return super.toString() + "Size: " + size + "\n";
    }
}