/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

public class Composer {

    // Class variables representing a composer
    private int id;
    private String name;
    private String genre;

    /*
     * Default constructor
     * Purpose: Initializes a composer object with default values
     * Parameters: None
     * Returns: None
     */
    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }

    /*
     * Parameterized constructor
     * Purpose: Initializes a composer object with provided values
     * Parameters: id (int), name (String), genre (String)
     * Returns: None
     */
    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    /*
     * toString method
     * Purpose: Returns a formatted string of composer details
     * Returns: String
     */
    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nGenre: " + genre;
    }
}