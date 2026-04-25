/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import java.util.ArrayList;
import java.util.List;

/*
 * In-memory DAO implementation for Composer objects
 */
public class MemComposerDao implements IComposerDao {

    // Global list of composers
    private List<Composer> composers;

    /*
     * Constructor
     * Purpose: Initializes list with default composers
     */
    public MemComposerDao() {
        composers = new ArrayList<>();

        composers.add(new Composer(1, "Ludwig van Beethoven", "Classical"));
        composers.add(new Composer(2, "Johann Sebastian Bach", "Classical"));
        composers.add(new Composer(3, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(4, "Pyotr Ilyich Tchaikovsky", "Romantic"));
        composers.add(new Composer(5, "Frederic Chopin", "Romantic"));
    }

    /*
     * Returns all composers
     */
    @Override
    public List<Composer> findAll() {
        return composers;
    }

    /*
     * Finds composer by ID
     */
    @Override
    public Composer findBy(Integer id) {

        for (Composer composer : composers) {
            if (composer.getId() == id) {
                return composer;
            }
        }

        return null;
    }

    /*
     * Inserts a new composer
     */
    @Override
    public void insert(Composer composer) {
        composers.add(composer);
    }
}