/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import java.util.List;

/*
 * Interface representing generic DAO operations
 * T = Object type
 * ID = Identifier type
 */
public interface IGenericDao<T, ID> {

    /*
     * Returns all objects
     */
    List<T> findAll();

    /*
     * Finds an object by ID
     */
    T findBy(ID id);

    /*
     * Inserts a new object
     */
    void insert(T entity);
}