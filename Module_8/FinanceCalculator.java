/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

/*
This class performs financial calculations for future value.
It calculates the future value of a series of monthly payments.
*/
public class FinanceCalculator {

    // Constant representing the number of months in one year
    private static final int MONTHS_IN_YEAR = 12;

    /*
    This method calculates the future value.

    Parameters:
    monthlyPayment (double) - the monthly investment amount
    rate (double) - annual interest rate
    years (int) - number of years

    Returns:
    double - calculated future value
    */
    public static double calculateFutureValue(double monthlyPayment,
                                              double rate,
                                              int years) {

        // Calculate total number of months
        int months = years * MONTHS_IN_YEAR;

        // Convert interest rate to growth factor
        double interestRate = (1 + (rate / 100));

        // Calculate total invested amount
        double presentValue = monthlyPayment * months;

        // Calculate future value
        double futureValue =
                presentValue * Math.pow(interestRate, months);

        return futureValue;
    }
}