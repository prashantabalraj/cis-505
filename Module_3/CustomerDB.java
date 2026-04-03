/*
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
 * Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Modified by P. Balraj 2026
 *
 * Balraj, P. (2026). CIS 505 Intermediate Java Programming.
 * Bellevue University.
 */

/* CustomerDB class serves as a data source for Customer objects.
 * It uses a static method to retrieve a Customer based on a given ID. */
public class CustomerDB {

    /* Static method that retrieves a Customer object based on the provided ID.
     * Uses an if...else if...else statement to match the ID to a known customer.
     * Parameters: id (Integer) - the customer ID to look up (1007, 1008, or 1009)
     * Returns: a Customer object matching the given ID, or a default Customer if no match */
    public static Customer getCustomer(Integer id) {

        // Return customer for ID 1007.
        if (id == 1007) {
            return new Customer("Alice Johnson", "123 Maple Street", "Springfield", "62701");

        // Return customer for ID 1008.
        } else if (id == 1008) {
            return new Customer("Bob Martinez", "456 Oak Avenue", "Shelbyville", "62565");

        // Return customer for ID 1009.
        } else if (id == 1009) {
            return new Customer("Carol Williams", "789 Pine Road", "Capital City", "62702");

        // Return a default customer if no matching ID is found.
        } else {
            return new Customer();
        }
    }
}
