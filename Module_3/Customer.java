/*
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
 * Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Modified by P. Balraj 2026
 *
 * Balraj, P. (2026). CIS 505 Intermediate Java Programming.
 * Bellevue University.
 */

/* Customer class represents a customer with four data fields:
 * name, address, city, and zip. Provides constructors, accessors,
 * and an overridden toString() method. */
public class Customer {

    // Private class-level fields for customer data.
    private String name;
    private String address;
    private String city;
    private String zip;

    /* No-argument constructor. Creates a default customer with empty fields.
     * Parameters: none
     * Returns: a default Customer object */
    public Customer() {
        this.name = "";
        this.address = "";
        this.city = "";
        this.zip = "";
    }

    /* Argument constructor. Creates a customer using all four data fields.
     * Parameters: name (String), address (String), city (String), zip (String)
     * Returns: a Customer object populated with the provided values */
    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    /* Accessor method for the name field.
     * Parameters: none
     * Returns: name (String) */
    public String getName() {
        return name;
    }

    /* Accessor method for the address field.
     * Parameters: none
     * Returns: address (String) */
    public String getAddress() {
        return address;
    }

    /* Accessor method for the city field.
     * Parameters: none
     * Returns: city (String) */
    public String getCity() {
        return city;
    }

    /* Accessor method for the zip field.
     * Parameters: none
     * Returns: zip (String) */
    public String getZip() {
        return zip;
    }

    /* Overridden toString method. Returns a formatted string
     * displaying all four customer fields, each on a separate line.
     * Parameters: none
     * Returns: formatted customer details (String) */
    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Address: " + address + "\n" +
               "City: " + city + "\n" +
               "Zip: " + zip;
    }
}
